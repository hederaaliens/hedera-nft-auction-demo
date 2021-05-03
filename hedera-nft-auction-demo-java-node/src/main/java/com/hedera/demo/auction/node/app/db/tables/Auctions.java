/*
 * This file is generated by jOOQ.
 */
package com.hedera.demo.auction.node.app.db.tables;


import com.hedera.demo.auction.node.app.db.Keys;
import com.hedera.demo.auction.node.app.db.Public;
import org.jooq.Record;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import java.util.Arrays;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Auctions extends TableImpl<Record> {

    private static final long serialVersionUID = 1552498190;

    /**
     * The reference instance of <code>public.auctions</code>
     */
    public static final Auctions AUCTIONS = new Auctions();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Record> getRecordType() {
        return Record.class;
    }

    /**
     * The column <code>public.auctions.id</code>.
     */
    public final TableField<Record, Integer> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('auctions_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.auctions.lastconsensustimestamp</code>.
     */
    public final TableField<Record, String> LASTCONSENSUSTIMESTAMP = createField(DSL.name("lastconsensustimestamp"), org.jooq.impl.SQLDataType.CLOB.defaultValue(org.jooq.impl.DSL.field("'0.0'::text", org.jooq.impl.SQLDataType.CLOB)), this, "");

    /**
     * The column <code>public.auctions.winningbid</code>.
     */
    public final TableField<Record, Long> WINNINGBID = createField(DSL.name("winningbid"), org.jooq.impl.SQLDataType.BIGINT.defaultValue(org.jooq.impl.DSL.field("0", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.auctions.winningaccount</code>.
     */
    public final TableField<Record, String> WINNINGACCOUNT = createField(DSL.name("winningaccount"), org.jooq.impl.SQLDataType.CLOB.defaultValue(org.jooq.impl.DSL.field("''::text", org.jooq.impl.SQLDataType.CLOB)), this, "");

    /**
     * The column <code>public.auctions.winningtimestamp</code>.
     */
    public final TableField<Record, String> WINNINGTIMESTAMP = createField(DSL.name("winningtimestamp"), org.jooq.impl.SQLDataType.CLOB.defaultValue(org.jooq.impl.DSL.field("''::text", org.jooq.impl.SQLDataType.CLOB)), this, "");

    /**
     * The column <code>public.auctions.winningtxid</code>.
     */
    public final TableField<Record, String> WINNINGTXID = createField(DSL.name("winningtxid"), org.jooq.impl.SQLDataType.CLOB.defaultValue(org.jooq.impl.DSL.field("''::text", org.jooq.impl.SQLDataType.CLOB)), this, "");

    /**
     * The column <code>public.auctions.winningtxhash</code>.
     */
    public final TableField<Record, String> WINNINGTXHASH = createField(DSL.name("winningtxhash"), org.jooq.impl.SQLDataType.CLOB.defaultValue(org.jooq.impl.DSL.field("''::text", org.jooq.impl.SQLDataType.CLOB)), this, "");

    /**
     * The column <code>public.auctions.transfertxid</code>.
     */
    public final TableField<Record, String> TRANSFERTXID = createField(DSL.name("transfertxid"), org.jooq.impl.SQLDataType.CLOB.defaultValue(org.jooq.impl.DSL.field("''::text", org.jooq.impl.SQLDataType.CLOB)), this, "");

    /**
     * The column <code>public.auctions.transfertxhash</code>.
     */
    public final TableField<Record, String> TRANSFERTXHASH = createField(DSL.name("transfertxhash"), org.jooq.impl.SQLDataType.CLOB.defaultValue(org.jooq.impl.DSL.field("''::text", org.jooq.impl.SQLDataType.CLOB)), this, "");

    /**
     * The column <code>public.auctions.tokenid</code>.
     */
    public final TableField<Record, String> TOKENID = createField(DSL.name("tokenid"), org.jooq.impl.SQLDataType.CLOB.defaultValue(org.jooq.impl.DSL.field("''::text", org.jooq.impl.SQLDataType.CLOB)), this, "");

    /**
     * The column <code>public.auctions.auctionaccountid</code>.
     */
    public final TableField<Record, String> AUCTIONACCOUNTID = createField(DSL.name("auctionaccountid"), org.jooq.impl.SQLDataType.CLOB.defaultValue(org.jooq.impl.DSL.field("''::text", org.jooq.impl.SQLDataType.CLOB)), this, "");

    /**
     * The column <code>public.auctions.endtimestamp</code>.
     */
    public final TableField<Record, String> ENDTIMESTAMP = createField(DSL.name("endtimestamp"), org.jooq.impl.SQLDataType.CLOB.defaultValue(org.jooq.impl.DSL.field("''::text", org.jooq.impl.SQLDataType.CLOB)), this, "");

    /**
     * The column <code>public.auctions.reserve</code>.
     */
    public final TableField<Record, Long> RESERVE = createField(DSL.name("reserve"), org.jooq.impl.SQLDataType.BIGINT.defaultValue(org.jooq.impl.DSL.field("0", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.auctions.status</code>.
     */
    public final TableField<Record, String> STATUS = createField(DSL.name("status"), org.jooq.impl.SQLDataType.CLOB.defaultValue(org.jooq.impl.DSL.field("'PENDING'::text", org.jooq.impl.SQLDataType.CLOB)), this, "");

    /**
     * The column <code>public.auctions.winnercanbid</code>.
     */
    public final TableField<Record, Boolean> WINNERCANBID = createField(DSL.name("winnercanbid"), org.jooq.impl.SQLDataType.BOOLEAN.defaultValue(org.jooq.impl.DSL.field("false", org.jooq.impl.SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>public.auctions.tokenimage</code>.
     */
    public final TableField<Record, String> TOKENIMAGE = createField(DSL.name("tokenimage"), org.jooq.impl.SQLDataType.CLOB.defaultValue(org.jooq.impl.DSL.field("''::text", org.jooq.impl.SQLDataType.CLOB)), this, "");

    /**
     * The column <code>public.auctions.minimumbid</code>.
     */
    public final TableField<Record, Long> MINIMUMBID = createField(DSL.name("minimumbid"), org.jooq.impl.SQLDataType.BIGINT.defaultValue(org.jooq.impl.DSL.field("0", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.auctions.starttimestamp</code>.
     */
    public final TableField<Record, String> STARTTIMESTAMP = createField(DSL.name("starttimestamp"), org.jooq.impl.SQLDataType.CLOB.defaultValue(org.jooq.impl.DSL.field("''::text", org.jooq.impl.SQLDataType.CLOB)), this, "");

    /**
     * The column <code>public.auctions.tokenowner</code>.
     */
    public final TableField<Record, String> TOKENOWNER = createField(DSL.name("tokenowner"), org.jooq.impl.SQLDataType.CLOB.defaultValue(org.jooq.impl.DSL.field("''::text", org.jooq.impl.SQLDataType.CLOB)), this, "");

    /**
     * Create a <code>public.auctions</code> table reference
     */
    public Auctions() {
        this(DSL.name("auctions"), null);
    }

    /**
     * Create an aliased <code>public.auctions</code> table reference
     */
    public Auctions(String alias) {
        this(DSL.name(alias), AUCTIONS);
    }

    /**
     * Create an aliased <code>public.auctions</code> table reference
     */
    public Auctions(Name alias) {
        this(alias, AUCTIONS);
    }

    private Auctions(Name alias, Table<Record> aliased) {
        this(alias, aliased, null);
    }

    private Auctions(Name alias, Table<Record> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> Auctions(Table<O> child, ForeignKey<O, Record> key) {
        super(child, key, AUCTIONS);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public Identity<Record, Integer> getIdentity() {
        return Keys.IDENTITY_AUCTIONS;
    }

    @Override
    public UniqueKey<Record> getPrimaryKey() {
        return Keys.AUCTIONS_PKEY;
    }

    @Override
    public List<UniqueKey<Record>> getKeys() {
        return Arrays.<UniqueKey<Record>>asList(Keys.AUCTIONS_PKEY, Keys.AUCTIONS_TOKENID_KEY, Keys.AUCTIONS_AUCTIONACCOUNTID_KEY);
    }

    @Override
    public Auctions as(String alias) {
        return new Auctions(DSL.name(alias), this);
    }

    @Override
    public Auctions as(Name alias) {
        return new Auctions(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Auctions rename(String name) {
        return new Auctions(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Auctions rename(Name name) {
        return new Auctions(name, null);
    }
}
