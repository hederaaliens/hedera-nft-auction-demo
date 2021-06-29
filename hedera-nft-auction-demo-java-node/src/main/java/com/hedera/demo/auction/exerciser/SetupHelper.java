package com.hedera.demo.auction.exerciser;

import com.google.errorprone.annotations.Var;
import com.hedera.demo.auction.app.CreateTopic;
import com.hedera.hashgraph.sdk.AccountId;
import com.hedera.hashgraph.sdk.Client;
import com.hedera.hashgraph.sdk.TokenCreateTransaction;
import com.hedera.hashgraph.sdk.TokenId;
import com.hedera.hashgraph.sdk.TransactionReceipt;
import com.hedera.hashgraph.sdk.TransactionResponse;
import com.hedera.hashgraph.sdk.TransferTransaction;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public final class SetupHelper {

  private SetupHelper() {
  }

  public static void main(String[] args) throws Exception {

    InputStream inputStream = new FileInputStream(new File("./AuctionSetup.yaml"));
    Yaml yaml = new Yaml(new Constructor(SetupProperties.class));
    SetupProperties setupProperties = yaml.load(inputStream);

    Client client = Client.forTestnet();
    client.setOperator(setupProperties.getSetupOperator().accountId(), setupProperties.getSetupOperator().privateKey());
    @Var TransactionResponse response;
    @Var TransactionReceipt receipt;

    // create topic
    if (setupProperties.isCreateTopic()) {
      CreateTopic createTopic = new CreateTopic();
      createTopic.create();

      System.out.println("Topic Created");
      System.out.println("Update .env in environments and restart");
      pressAnyKeyToContinue();
    }

    System.out.println("Creating token");

    response = new TokenCreateTransaction()
            .setDecimals(0)
            .setInitialSupply(1)
            .setTokenName(setupProperties.getToken().getName())
            .setTokenSymbol(setupProperties.getToken().getSymbol())
            .setTreasuryAccountId(setupProperties.getSetupOperator().accountId())
            .execute(client);

    receipt = response.getReceipt(client);

    TokenId tokenId = receipt.tokenId;

    // create auction account
    // Account create JSON

    JsonArray keys = new JsonArray();
    for (String key : setupProperties.getAuctionAccount().getPublicKeys()) {
      JsonObject keyJson = new JsonObject().put("key", key);
      keys.add(keyJson);
    }
    JsonObject keyList = new JsonObject();
    keyList.put("keys", keys);
    keyList.put("threshold", setupProperties.getAuctionAccount().getThreshold());

    JsonObject accountJson = new JsonObject();
    accountJson.put("keyList", keyList);
    accountJson.put("initialBalance", setupProperties.getAuctionAccount().getBalance());

    System.out.println("Creating auction account");

    @Var HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(setupProperties.getAdminApiHost().concat("/v1/admin/auctionaccount")))
            .header("Content-Type", "application/json")
            .POST(BodyPublishers.ofString(accountJson.toString()))
            .build();

    @Var HttpClient httpClient = HttpClient.newHttpClient();
    @Var HttpResponse<String> httpResponse = httpClient.send(request, BodyHandlers.ofString());
    JsonObject jsonResponse = new JsonObject(httpResponse.body());
    AccountId accountId = AccountId.fromString(jsonResponse.getString("accountId"));

    // create auction
    JsonObject auction = new JsonObject();
    auction.put("tokenid", tokenId.toString());
    auction.put("auctionaccountid", accountId.toString());
    auction.put("reserve", setupProperties.getAuction().getReserve());
    auction.put("minimumbid", setupProperties.getAuction().getMinimumbid());
    auction.put("endtimestamp", setupProperties.getAuction().getEndtimestamp());
    auction.put("winnercanbid", setupProperties.getAuction().isWinnercanbid());
    auction.put("title", setupProperties.getAuction().getTitle());
    auction.put("description", setupProperties.getAuction().getDescription());

    request = HttpRequest.newBuilder()
            .uri(URI.create(setupProperties.getAdminApiHost().concat("/v1/admin/auction")))
            .header("Content-Type", "application/json")
            .POST(BodyPublishers.ofString(auction.encode()))
            .build();

    httpClient = HttpClient.newHttpClient();
    httpResponse = httpClient.send(request, BodyHandlers.ofString());

    System.out.println(httpResponse.body());

    // transfer token
    System.out.println("Start the containers so that the auction account associates with the token");
    System.out.println("Check auction has associated with token then");
    System.out.println("Press a key to transfer the token to the auction");
    pressAnyKeyToContinue();


    response = new TransferTransaction()
            .addTokenTransfer(tokenId, setupProperties.getSetupOperator().accountId(), -1)
            .addTokenTransfer(tokenId, accountId, 1)
            .execute(client);

    response.getReceipt(client);
  }

  private static void pressAnyKeyToContinue()
  {
    System.out.println("Press Enter key to continue...");
    try
    {
      System.in.read();
      System.out.println("Continuing...");
    }
    catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }
}


