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
 * The Class CreatorDynamicSqlSupport.
 */
public final class CreatorDynamicSqlSupport {

    /**
     * The Constant creator.
     */
    public static final Creator creator = new Creator();
    /**
     * The Constant id.
     */
    public static final SqlColumn<Integer> id = creator.id;
    /**
     * The Constant name.
     */
    public static final SqlColumn<String> name = creator.name;
    /**
     * The Constant descr.
     */
    public static final SqlColumn<String> descr = creator.descr;

    /**
     * The Class Creator.
     */
    public static final class Creator extends SqlTable {

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
         * Instantiates a new creator.
         */
        public Creator() {
            super("creador");
        }
    }
}