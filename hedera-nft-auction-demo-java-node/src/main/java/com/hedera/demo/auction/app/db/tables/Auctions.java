/*
 * This file is generated by jOOQ.
 */
package com.hedera.demo.auction.app.db.tables;


import com.hedera.demo.auction.app.db.Keys;
import com.hedera.demo.auction.app.db.Public;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Auctions extends TableImpl<Record> {

    private static final long serialVersionUID = 1L;

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
    public final TableField<Record, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.auctions.lastconsensustimestamp</code>.
     */
    public final TableField<Record, String> LASTCONSENSUSTIMESTAMP = createField(DSL.name("lastconsensustimestamp"), SQLDataType.CLOB.defaultValue(DSL.field("'0.0'::text", SQLDataType.CLOB)), this, "");

    /**
     * The column <code>public.auctions.winningbid</code>.
     */
    public final TableField<Record, Long> WINNINGBID = createField(DSL.name("winningbid"), SQLDataType.BIGINT.defaultValue(DSL.field("0", SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.auctions.winningaccount</code>.
     */
    public final TableField<Record, String> WINNINGACCOUNT = createField(DSL.name("winningaccount"), SQLDataType.CLOB.defaultValue(DSL.field("''::text", SQLDataType.CLOB)), this, "");

    /**
     * The column <code>public.auctions.winningtimestamp</code>.
     */
    public final TableField<Record, String> WINNINGTIMESTAMP = createField(DSL.name("winningtimestamp"), SQLDataType.CLOB.defaultValue(DSL.field("''::text", SQLDataType.CLOB)), this, "");

    /**
     * The column <code>public.auctions.winningtxid</code>.
     */
    public final TableField<Record, String> WINNINGTXID = createField(DSL.name("winningtxid"), SQLDataType.CLOB.defaultValue(DSL.field("''::text", SQLDataType.CLOB)), this, "");

    /**
     * The column <code>public.auctions.winningtxhash</code>.
     */
    public final TableField<Record, String> WINNINGTXHASH = createField(DSL.name("winningtxhash"), SQLDataType.CLOB.defaultValue(DSL.field("''::text", SQLDataType.CLOB)), this, "");

    /**
     * The column <code>public.auctions.transfertxid</code>.
     */
    public final TableField<Record, String> TRANSFERTXID = createField(DSL.name("transfertxid"), SQLDataType.CLOB.defaultValue(DSL.field("''::text", SQLDataType.CLOB)), this, "");

    /**
     * The column <code>public.auctions.transfertxhash</code>.
     */
    public final TableField<Record, String> TRANSFERTXHASH = createField(DSL.name("transfertxhash"), SQLDataType.CLOB.defaultValue(DSL.field("''::text", SQLDataType.CLOB)), this, "");

    /**
     * The column <code>public.auctions.tokenid</code>.
     */
    public final TableField<Record, String> TOKENID = createField(DSL.name("tokenid"), SQLDataType.CLOB.defaultValue(DSL.field("''::text", SQLDataType.CLOB)), this, "");

    /**
     * The column <code>public.auctions.auctionaccountid</code>.
     */
    public final TableField<Record, String> AUCTIONACCOUNTID = createField(DSL.name("auctionaccountid"), SQLDataType.CLOB.defaultValue(DSL.field("''::text", SQLDataType.CLOB)), this, "");

    /**
     * The column <code>public.auctions.endtimestamp</code>.
     */
    public final TableField<Record, String> ENDTIMESTAMP = createField(DSL.name("endtimestamp"), SQLDataType.CLOB.defaultValue(DSL.field("''::text", SQLDataType.CLOB)), this, "");

    /**
     * The column <code>public.auctions.reserve</code>.
     */
    public final TableField<Record, Long> RESERVE = createField(DSL.name("reserve"), SQLDataType.BIGINT.defaultValue(DSL.field("0", SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.auctions.status</code>.
     */
    public final TableField<Record, String> STATUS = createField(DSL.name("status"), SQLDataType.CLOB.defaultValue(DSL.field("'PENDING'::text", SQLDataType.CLOB)), this, "");

    /**
     * The column <code>public.auctions.winnercanbid</code>.
     */
    public final TableField<Record, Boolean> WINNERCANBID = createField(DSL.name("winnercanbid"), SQLDataType.BOOLEAN.defaultValue(DSL.field("false", SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>public.auctions.tokenmetadata</code>.
     */
    public final TableField<Record, String> TOKENMETADATA = createField(DSL.name("tokenmetadata"), SQLDataType.CLOB.defaultValue(DSL.field("''::text", SQLDataType.CLOB)), this, "");

    /**
     * The column <code>public.auctions.minimumbid</code>.
     */
    public final TableField<Record, Long> MINIMUMBID = createField(DSL.name("minimumbid"), SQLDataType.BIGINT.defaultValue(DSL.field("0", SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.auctions.starttimestamp</code>.
     */
    public final TableField<Record, String> STARTTIMESTAMP = createField(DSL.name("starttimestamp"), SQLDataType.CLOB.defaultValue(DSL.field("''::text", SQLDataType.CLOB)), this, "");

    /**
     * The column <code>public.auctions.tokenowner</code>.
     */
    public final TableField<Record, String> TOKENOWNER = createField(DSL.name("tokenowner"), SQLDataType.CLOB.defaultValue(DSL.field("''::text", SQLDataType.CLOB)), this, "");

    /**
     * The column <code>public.auctions.transferstatus</code>.
     */
    public final TableField<Record, String> TRANSFERSTATUS = createField(DSL.name("transferstatus"), SQLDataType.CLOB.defaultValue(DSL.field("''::text", SQLDataType.CLOB)), this, "");

    /**
     * The column <code>public.auctions.title</code>.
     */
    public final TableField<Record, String> TITLE = createField(DSL.name("title"), SQLDataType.CLOB.defaultValue(DSL.field("''::text", SQLDataType.CLOB)), this, "");

    /**
     * The column <code>public.auctions.description</code>.
     */
    public final TableField<Record, String> DESCRIPTION = createField(DSL.name("description"), SQLDataType.CLOB.defaultValue(DSL.field("''::text", SQLDataType.CLOB)), this, "");

    /**
     * The column <code>public.auctions.processrefunds</code>.
     */
    public final TableField<Record, Boolean> PROCESSREFUNDS = createField(DSL.name("processrefunds"), SQLDataType.BOOLEAN.defaultValue(DSL.field("false", SQLDataType.BOOLEAN)), this, "");

    private Auctions(Name alias, Table<Record> aliased) {
        this(alias, aliased, null);
    }

    private Auctions(Name alias, Table<Record> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
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

    /**
     * Create a <code>public.auctions</code> table reference
     */
    public Auctions() {
        this(DSL.name("auctions"), null);
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
        return (Identity<Record, Integer>) super.getIdentity();
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
