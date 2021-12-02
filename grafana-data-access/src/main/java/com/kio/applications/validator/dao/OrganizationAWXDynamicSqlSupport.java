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
 * The Class OrganizationAWXDynamicSqlSupport.
 */
public final class OrganizationAWXDynamicSqlSupport {

	/** The Constant organizationAWX. */
	public static final OrganizationAWX organizationAWX = new OrganizationAWX();

	/** The Constant id. */
	public static final SqlColumn<Integer> id = organizationAWX.id;

	/** The Constant name. */
	public static final SqlColumn<String> name = organizationAWX.name;

	/**
	 * The Class OrganizationAWX.
	 */
	public static final class OrganizationAWX extends SqlTable {

		/** The id. */
		public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

		/** The name. */
		public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

		/**
		 * Instantiates a new organization AWX.
		 */
		public OrganizationAWX() {
			super("organizacion_awx");
		}
	}
}