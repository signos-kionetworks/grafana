/*
 * ****************************************************
 * * Grafana *
 * * KIO Networks *
 * * @Author Julio Galindo *
 * ****************************************************
 */
package com.kio.applications.validator.dao;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

/**
 * The Class ClientDynamicSqlSupport.
 */
public final class ClientDynamicSqlSupport {

    /**
     * The Constant client.
     */
    public static final Client client = new Client();
    /**
     * The Constant id.
     */
    public static final SqlColumn<Integer> id = client.id;
    /**
     * The Constant name.
     */
    public static final SqlColumn<String> name = client.name;
    /**
     * The Constant descr.
     */
    public static final SqlColumn<String> descr = client.descr;

    /**
     * The Class Client.
     */
    public static final class Client extends SqlTable {

        /**
         * The id.
         */
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        /**
         * The name.
         */
        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        /**
         * The descr.
         */
        public final SqlColumn<String> descr = column("descr", JDBCType.VARCHAR);

        /**
         * Instantiates a new client.
         */
        public Client() {
            super("cliente");
        }
    }
}