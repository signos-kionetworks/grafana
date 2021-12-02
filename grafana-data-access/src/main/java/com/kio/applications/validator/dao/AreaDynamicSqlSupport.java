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
 * The Class AreaDynamicSqlSupport.
 */
public final class AreaDynamicSqlSupport {

	/** The Constant area. */
	public static final Area area = new Area();

	/** The Constant id. */
	public static final SqlColumn<Integer> id = area.id;

	/** The Constant name. */
	public static final SqlColumn<String> name = area.name;

	/** The Constant descr. */
	public static final SqlColumn<String> descr = area.descr;

	/** The Constant idDireccion. */
	public static final SqlColumn<Integer> idDireccion = area.idDireccion;

	/**
	 * The Class Area.
	 */
	public static final class Area extends SqlTable {

		/** The id. */
		public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

		/** The name. */
		public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

		/** The descr. */
		public final SqlColumn<String> descr = column("descr", JDBCType.VARCHAR);

		/** The id direccion. */
		public final SqlColumn<Integer> idDireccion = column("id_direccion", JDBCType.INTEGER);

		/**
		 * Instantiates a new area.
		 */
		public Area() {
			super("area");
		}
	}
}