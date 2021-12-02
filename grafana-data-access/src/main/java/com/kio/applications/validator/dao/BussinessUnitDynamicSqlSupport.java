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
 * The Class BussinessUnitDynamicSqlSupport.
 */
public final class BussinessUnitDynamicSqlSupport {

	/** The Constant bussinessUnit. */
	public static final BussinessUnit bussinessUnit = new BussinessUnit();

	/** The Constant id. */
	public static final SqlColumn<Integer> id = bussinessUnit.id;

	/** The Constant name. */
	public static final SqlColumn<String> name = bussinessUnit.name;

	/** The Constant descr. */
	public static final SqlColumn<String> descr = bussinessUnit.descr;

	/**
	 * The Class BussinessUnit.
	 */
	public static final class BussinessUnit extends SqlTable {

		/** The id. */
		public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

		/** The name. */
		public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

		/** The descr. */
		public final SqlColumn<String> descr = column("descr", JDBCType.VARCHAR);

		/**
		 * Instantiates a new bussiness unit.
		 */
		public BussinessUnit() {
			super("unidad_negocio");
		}
	}
}