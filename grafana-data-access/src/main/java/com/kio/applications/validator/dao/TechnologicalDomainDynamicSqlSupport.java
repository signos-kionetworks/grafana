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
 * The Class TechnologicalDomainDynamicSqlSupport.
 */
public final class TechnologicalDomainDynamicSqlSupport {

	/**
	 * The Class TechnologicalDomain.
	 */
	public static final class TechnologicalDomain extends SqlTable {
		
		/** The id. */
		public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

		/** The name. */
		public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

		/** The descr. */
		public final SqlColumn<String> descr = column("descr", JDBCType.VARCHAR);

		/**
		 * Instantiates a new technological domain.
		 */
		public TechnologicalDomain() {
			super("cocatnivel1");
		}
	}

	/** The Constant technologicalDomain. */
	public static final TechnologicalDomain technologicalDomain = new TechnologicalDomain();

	/** The Constant id. */
	public static final SqlColumn<Integer> id = technologicalDomain.id;

	/** The Constant name. */
	public static final SqlColumn<String> name = technologicalDomain.name;

	/** The Constant descr. */
	public static final SqlColumn<String> descr = technologicalDomain.descr;
}