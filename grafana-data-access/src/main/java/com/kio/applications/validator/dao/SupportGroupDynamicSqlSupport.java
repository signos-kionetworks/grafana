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
 * The Class SupportGroupDynamicSqlSupport.
 */
public final class SupportGroupDynamicSqlSupport {

	/** The Constant supportGroup. */
	public static final SupportGroup supportGroup = new SupportGroup();

	/** The Constant id. */
	public static final SqlColumn<Integer> id = supportGroup.id;

	/** The Constant name. */
	public static final SqlColumn<String> name = supportGroup.name;

	/** The Constant descr. */
	public static final SqlColumn<String> descr = supportGroup.descr;

	/**
	 * The Class SupportGroup.
	 */
	public static final class SupportGroup extends SqlTable {

		/** The id. */
		public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

		/** The name. */
		public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

		/** The descr. */
		public final SqlColumn<String> descr = column("descr", JDBCType.VARCHAR);

		/**
		 * Instantiates a new support group.
		 */
		public SupportGroup() {
			super("suppgroup");
		}
	}
}