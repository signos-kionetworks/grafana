package com.kio.applications.validator.dao;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

/**
 * The type Token awx dynamic sql support.
 */
public final class TokenAWXDynamicSqlSupport {
    /**
     * The constant tokenAWX.
     */

    public static final TokenAWX tokenAWX = new TokenAWX();

    /**
     * The constant id.
     */
    public static final SqlColumn<Integer> id = tokenAWX.id;

    /**
     * The constant token.
     */
    public static final SqlColumn<String> token = tokenAWX.token;

    /**
     * The constant idArea.
     */
    public static final SqlColumn<Integer> idArea = tokenAWX.idArea;

    /**
     * The constant emailUser.
     */
    public static final SqlColumn<String> emailUser = tokenAWX.emailUser;

    /**
     * The constant idOrigen.
     */
    public static final SqlColumn<Integer> idOrigen = tokenAWX.idOrigen;

    /**
     * The type Token awx.
     */
    public static final class TokenAWX extends SqlTable {
        /**
         * The Id.
         */
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        /**
         * The Token.
         */
        public final SqlColumn<String> token = column("token", JDBCType.VARCHAR);

        /**
         * The Id area.
         */
        public final SqlColumn<Integer> idArea = column("id_area", JDBCType.INTEGER);

        /**
         * The Email user.
         */
        public final SqlColumn<String> emailUser = column("email_user", JDBCType.VARCHAR);

        /**
         * The Id origen.
         */
        public final SqlColumn<Integer> idOrigen = column("id_origen", JDBCType.INTEGER);

        /**
         * Instantiates a new Token awx.
         */
        public TokenAWX() {
            super("token_awx");
        }
    }
}