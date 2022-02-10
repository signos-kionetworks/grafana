/*
 * ****************************************************
 * * Grafana *
 * * KIO Networks *
 * * @Author Julio Galindo *
 * ****************************************************
 */
package com.kio.applications.validator.dao;

import java.sql.JDBCType;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

/**
 * The Class TokenAWXDynamicSqlSupport.
 */
public final class TokenAWXDynamicSqlSupport {

	/**
	 * The Class TokenAWX.
	 */

	public static final class TokenAWX extends SqlTable {

		/** The id. */
		public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

		/** The token. */
		public final SqlColumn<String> token = column("token", JDBCType.VARCHAR);

		/** The id area. */
		public final SqlColumn<Integer> idArea = column("id_area", JDBCType.INTEGER);

		/**
		 * Instantiates a new token AWX.
		 */
		public TokenAWX() {
			super("token_awx");
		}
	}

	/** The Constant tokenAWX. */

	public static final TokenAWX tokenAWX = new TokenAWX();

	/** The Constant id. */

	public static final SqlColumn<Integer> id = tokenAWX.id;

	/** The Constant token. */

	public static final SqlColumn<String> token = tokenAWX.token;

	/** The Constant idArea. */

	public static final SqlColumn<Integer> idArea = tokenAWX.idArea;
}