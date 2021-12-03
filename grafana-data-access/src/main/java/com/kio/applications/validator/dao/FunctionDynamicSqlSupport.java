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
 * The Class FunctionDynamicSqlSupport.
 */
public final class FunctionDynamicSqlSupport {

	/**
	 * The Class Function.
	 */
	public static final class Function extends SqlTable {
		
		/** The id. */
		public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

		/** The name. */
		public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

		/** The descr. */
		public final SqlColumn<String> descr = column("descr", JDBCType.VARCHAR);

		/**
		 * Instantiates a new function.
		 */
		public Function() {
			super("funcionaut");
		}
	}

	/** The Constant function. */
	public static final Function function = new Function();

	/** The Constant id. */
	public static final SqlColumn<Integer> id = function.id;

	/** The Constant name. */
	public static final SqlColumn<String> name = function.name;

	/** The Constant descr. */
	public static final SqlColumn<String> descr = function.descr;
}