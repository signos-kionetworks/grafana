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
 * The Class SpecialistDynamicSqlSupport.
 */
public final class SpecialistDynamicSqlSupport {

	/** The Constant specialist. */
	public static final Specialist specialist = new Specialist();

	/** The Constant id. */
	public static final SqlColumn<Integer> id = specialist.id;

	/** The Constant name. */
	public static final SqlColumn<String> name = specialist.name;

	/** The Constant descr. */
	public static final SqlColumn<String> descr = specialist.descr;

	/**
	 * The Class Specialist.
	 */
	public static final class Specialist extends SqlTable {

		/** The id. */
		public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

		/** The name. */
		public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

		/** The descr. */
		public final SqlColumn<String> descr = column("descr", JDBCType.VARCHAR);

		/**
		 * Instantiates a new specialist.
		 */
		public Specialist() {
			super("specialist");
		}
	}
}