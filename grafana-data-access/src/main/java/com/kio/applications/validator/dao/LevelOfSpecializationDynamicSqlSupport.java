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
 * The Class LevelOfSpecializationDynamicSqlSupport.
 */
public final class LevelOfSpecializationDynamicSqlSupport {

	/**
	 * The Class LevelOfSpecialization.
	 */
	public static final class LevelOfSpecialization extends SqlTable {
		
		/** The id. */
		public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

		/** The name. */
		public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

		/** The descr. */
		public final SqlColumn<String> descr = column("descr", JDBCType.VARCHAR);

		/**
		 * Instantiates a new level of specialization.
		 */
		public LevelOfSpecialization() {
			super("cocatnivel2");
		}
	}

	/** The Constant levelOfSpecialization. */
	public static final LevelOfSpecialization levelOfSpecialization = new LevelOfSpecialization();

	/** The Constant id. */
	public static final SqlColumn<Integer> id = levelOfSpecialization.id;

	/** The Constant name. */
	public static final SqlColumn<String> name = levelOfSpecialization.name;

	/** The Constant descr. */
	public static final SqlColumn<String> descr = levelOfSpecialization.descr;
}