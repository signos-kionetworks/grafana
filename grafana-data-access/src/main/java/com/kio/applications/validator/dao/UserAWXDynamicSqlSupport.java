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
 * The Class UserAWXDynamicSqlSupport.
 */
public final class UserAWXDynamicSqlSupport {

	/** The Constant userAWX. */
	public static final UserAWX userAWX = new UserAWX();

	/** The Constant id. */
	public static final SqlColumn<Integer> id = userAWX.id;

	/** The Constant email. */
	public static final SqlColumn<String> email = userAWX.email;

	/** The Constant idArea. */
	public static final SqlColumn<Integer> idArea = userAWX.idArea;

	/**
	 * The Class UserAWX.
	 */
	public static final class UserAWX extends SqlTable {

		/** The id. */
		public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

		/** The email. */
		public final SqlColumn<String> email = column("email", JDBCType.VARCHAR);

		/** The id area. */
		public final SqlColumn<Integer> idArea = column("id_area", JDBCType.INTEGER);

		/**
		 * Instantiates a new user AWX.
		 */
		public UserAWX() {
			super("usuarios_awx");
		}
	}
}