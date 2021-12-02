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
 * The Class ManagementDynamicSqlSupport.
 */
public final class ManagementDynamicSqlSupport {

	/** The Constant management. */
	public static final Management management = new Management();

	/** The Constant id. */
	public static final SqlColumn<Integer> id = management.id;

	/** The Constant name. */
	public static final SqlColumn<String> name = management.name;

	/** The Constant descr. */
	public static final SqlColumn<String> descr = management.descr;

	/** The Constant idUnidadNegocio. */
	public static final SqlColumn<Integer> idUnidadNegocio = management.idUnidadNegocio;

	/**
	 * The Class Management.
	 */
	public static final class Management extends SqlTable {

		/** The id. */
		public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

		/** The name. */
		public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

		/** The descr. */
		public final SqlColumn<String> descr = column("descr", JDBCType.VARCHAR);

		/** The id unidad negocio. */
		public final SqlColumn<Integer> idUnidadNegocio = column("id_unidad_negocio", JDBCType.INTEGER);

		/**
		 * Instantiates a new management.
		 */
		public Management() {
			super("direccion");
		}
	}
}