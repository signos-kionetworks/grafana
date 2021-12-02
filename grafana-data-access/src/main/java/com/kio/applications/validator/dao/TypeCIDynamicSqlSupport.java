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
 * The Class TypeCIDynamicSqlSupport.
 */
public final class TypeCIDynamicSqlSupport {

	/** The Constant typeCI. */
	public static final TypeCI typeCI = new TypeCI();

	/** The Constant id. */
	public static final SqlColumn<Integer> id = typeCI.id;

	/** The Constant name. */
	public static final SqlColumn<String> name = typeCI.name;

	/** The Constant descr. */
	public static final SqlColumn<String> descr = typeCI.descr;

	/**
	 * The Class TypeCI.
	 */
	public static final class TypeCI extends SqlTable {

		/** The id. */
		public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

		/** The name. */
		public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

		/** The descr. */
		public final SqlColumn<String> descr = column("descr", JDBCType.VARCHAR);

		/**
		 * Instantiates a new type CI.
		 */
		public TypeCI() {
			super("tipoci");
		}
	}
}