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
 * The Class TypeExecutionDynamicSqlSupport.
 */
public final class TypeExecutionDynamicSqlSupport {

	/**
	 * The Class TypeExecution.
	 */
	public static final class TypeExecution extends SqlTable {
		
		/** The id. */
		public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

		/** The name. */
		public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

		/** The descr. */
		public final SqlColumn<String> descr = column("descr", JDBCType.VARCHAR);

		/**
		 * Instantiates a new type execution.
		 */
		public TypeExecution() {
			super("tipoexec");
		}
	}

	/** The Constant typeExecution. */
	public static final TypeExecution typeExecution = new TypeExecution();

	/** The Constant id. */
	public static final SqlColumn<Integer> id = typeExecution.id;

	/** The Constant name. */
	public static final SqlColumn<String> name = typeExecution.name;

	/** The Constant descr. */
	public static final SqlColumn<String> descr = typeExecution.descr;
}