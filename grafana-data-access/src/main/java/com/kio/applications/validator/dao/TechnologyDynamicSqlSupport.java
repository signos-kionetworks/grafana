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
 * The Class TechnologyDynamicSqlSupport.
 */
public final class TechnologyDynamicSqlSupport {

	/**
	 * The Class Technology.
	 */
	public static final class Technology extends SqlTable {
		
		/** The id. */
		public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

		/** The name. */
		public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

		/** The descr. */
		public final SqlColumn<String> descr = column("descr", JDBCType.VARCHAR);

		/**
		 * Instantiates a new technology.
		 */
		public Technology() {
			super("coproducto");
		}
	}

	/** The Constant technology. */
	public static final Technology technology = new Technology();

	/** The Constant id. */
	public static final SqlColumn<Integer> id = technology.id;

	/** The Constant name. */
	public static final SqlColumn<String> name = technology.name;

	/** The Constant descr. */
	public static final SqlColumn<String> descr = technology.descr;
}