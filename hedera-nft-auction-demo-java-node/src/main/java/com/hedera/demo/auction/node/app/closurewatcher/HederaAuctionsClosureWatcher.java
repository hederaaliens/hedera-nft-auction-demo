package com.hedera.demo.auction.node.app.closurewatcher;

import com.google.errorprone.annotations.Var;
import com.hedera.demo.auction.node.app.repository.AuctionsRepository;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.codec.BodyCodec;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class HederaAuctionsClosureWatcher extends AbstractAuctionsClosureWatcher implements AuctionClosureWatcherInterface {

    public HederaAuctionsClosureWatcher(WebClient webClient, AuctionsRepository auctionsRepository, int mirrorQueryFrequency, boolean transferOnWin) throws Exception {
        super(webClient, auctionsRepository, mirrorQueryFrequency, transferOnWin);
    }

    @Override
    public void watch() {
        var webQuery = webClient
                .get(mirrorURL, "/api/v1/transactions")
                .as(BodyCodec.jsonObject())
                .addQueryParam("limit", "1"); // only need one row (the latest)

        while (true) {
            webQuery.send(response -> {
                if (response.succeeded()) {
                    JsonObject body = response.result().body();
                    JsonArray transactions = body.getJsonArray("transactions");
                    if (transactions != null) {
                        @Var String consensusTimestamp = "";
                        for (Object transactionObject : transactions) {
                            JsonObject transaction = JsonObject.mapFrom(transactionObject);
                            consensusTimestamp = transaction.getString("consensus_timestamp");
                            break;
                        }
                        closeAuctionIfPastEnd(consensusTimestamp);
                    }
                } else {
                    log.error(response.cause().getMessage());
                }
            });

            try {
                Thread.sleep(this.mirrorQueryFrequency);
            } catch (InterruptedException e) {
                e.printStackTrace();
                log.error(e);
            }
        }
    }
}