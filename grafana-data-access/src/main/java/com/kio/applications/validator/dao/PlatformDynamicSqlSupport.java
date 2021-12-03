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
 * The Class PlatformDynamicSqlSupport.
 */
public final class PlatformDynamicSqlSupport {

	/**
	 * The Class Platform.
	 */
	public static final class Platform extends SqlTable {
		
		/** The id. */
		public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

		/** The name. */
		public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

		/** The descr. */
		public final SqlColumn<String> descr = column("descr", JDBCType.VARCHAR);

		/**
		 * Instantiates a new platform.
		 */
		public Platform() {
			super("plataforma");
		}
	}

	/** The Constant platform. */
	public static final Platform platform = new Platform();

	/** The Constant id. */
	public static final SqlColumn<Integer> id = platform.id;

	/** The Constant name. */
	public static final SqlColumn<String> name = platform.name;

	/** The Constant descr. */
	public static final SqlColumn<String> descr = platform.descr;
}