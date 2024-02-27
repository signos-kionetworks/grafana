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
 * The Class TypeDevelopDynamicSqlSupport.
 */
public final class TypeDevelopDynamicSqlSupport {

    /**
     * The Constant typeDevelop.
     */
    public static final TypeDevelop typeDevelop = new TypeDevelop();
    /**
     * The Constant id.
     */
    public static final SqlColumn<Integer> id = typeDevelop.id;
    /**
     * The Constant name.
     */
    public static final SqlColumn<String> name = typeDevelop.name;
    /**
     * The Constant descr.
     */
    public static final SqlColumn<String> descr = typeDevelop.descr;

    /**
     * The Class TypeDevelop.
     */
    public static final class TypeDevelop extends SqlTable {

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
         * Instantiates a new type develop.
         */
        public TypeDevelop() {
            super("develtype");
        }
    }
}