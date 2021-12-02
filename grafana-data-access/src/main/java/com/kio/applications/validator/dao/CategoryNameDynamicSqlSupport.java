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
 * The Class CategoryNameDynamicSqlSupport.
 */
public final class CategoryNameDynamicSqlSupport {

	/** The Constant categoryName. */
	public static final CategoryName categoryName = new CategoryName();

	/** The Constant id. */
	public static final SqlColumn<Integer> id = categoryName.id;

	/** The Constant name. */
	public static final SqlColumn<String> name = categoryName.name;

	/** The Constant descr. */
	public static final SqlColumn<String> descr = categoryName.descr;

	/**
	 * The Class CategoryName.
	 */
	public static final class CategoryName extends SqlTable {

		/** The id. */
		public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

		/** The name. */
		public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

		/** The descr. */
		public final SqlColumn<String> descr = column("descr", JDBCType.VARCHAR);

		/**
		 * Instantiates a new category name.
		 */
		public CategoryName() {
			super("conombrecat");
		}
	}
}