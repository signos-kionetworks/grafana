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
 * The Class TaskTypeDynamicSqlSupport.
 */
public final class TaskTypeDynamicSqlSupport {

	/**
	 * The Class TaskType.
	 */
	public static final class TaskType extends SqlTable {
		
		/** The id. */
		public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

		/** The name. */
		public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

		/** The descr. */
		public final SqlColumn<String> descr = column("descr", JDBCType.VARCHAR);

		/**
		 * Instantiates a new task type.
		 */
		public TaskType() {
			super("cocatnivel3");
		}
	}

	/** The Constant taskType. */
	public static final TaskType taskType = new TaskType();

	/** The Constant id. */
	public static final SqlColumn<Integer> id = taskType.id;

	/** The Constant name. */
	public static final SqlColumn<String> name = taskType.name;

	/** The Constant descr. */
	public static final SqlColumn<String> descr = taskType.descr;
}