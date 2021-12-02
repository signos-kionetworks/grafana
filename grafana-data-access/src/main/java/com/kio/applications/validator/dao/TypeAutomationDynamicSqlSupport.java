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
 * The Class TypeAutomationDynamicSqlSupport.
 */
public final class TypeAutomationDynamicSqlSupport {

	/** The Constant typeAutomation. */
	public static final TypeAutomation typeAutomation = new TypeAutomation();

	/** The Constant id. */
	public static final SqlColumn<Integer> id = typeAutomation.id;

	/** The Constant name. */
	public static final SqlColumn<String> name = typeAutomation.name;

	/** The Constant descr. */
	public static final SqlColumn<String> descr = typeAutomation.descr;

	/**
	 * The Class TypeAutomation.
	 */
	public static final class TypeAutomation extends SqlTable {

		/** The id. */
		public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

		/** The name. */
		public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

		/** The descr. */
		public final SqlColumn<String> descr = column("descr", JDBCType.VARCHAR);

		/**
		 * Instantiates a new type automation.
		 */
		public TypeAutomation() {
			super("tipoaut");
		}
	}
}