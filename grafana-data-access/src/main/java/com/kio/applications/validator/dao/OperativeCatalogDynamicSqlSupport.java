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
 * The Class OperativeCatalogDynamicSqlSupport.
 */
public final class OperativeCatalogDynamicSqlSupport {

	/** The Constant operativeCatalog. */
	public static final OperativeCatalog operativeCatalog = new OperativeCatalog();

	/** The Constant id. */
	public static final SqlColumn<Integer> id = operativeCatalog.id;

	/** The Constant catalogo. */
	public static final SqlColumn<Integer> catalogo = operativeCatalog.catalogo;

	/** The Constant catnivel1. */
	public static final SqlColumn<Integer> catnivel1 = operativeCatalog.catnivel1;

	/** The Constant catnivel2. */
	public static final SqlColumn<Integer> catnivel2 = operativeCatalog.catnivel2;

	/** The Constant catnivel3. */
	public static final SqlColumn<Integer> catnivel3 = operativeCatalog.catnivel3;

	/** The Constant producto. */
	public static final SqlColumn<Integer> producto = operativeCatalog.producto;

	/** The Constant tipo. */
	public static final SqlColumn<Integer> tipo = operativeCatalog.tipo;

	/** The Constant automatizable. */
	public static final SqlColumn<Boolean> automatizable = operativeCatalog.automatizable;

	/** The Constant tiempominutos. */
	public static final SqlColumn<Float> tiempominutos = operativeCatalog.tiempominutos;

	/**
	 * The Class OperativeCatalog.
	 */
	public static final class OperativeCatalog extends SqlTable {

		/** The id. */
		public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

		/** The catalogo. */
		public final SqlColumn<Integer> catalogo = column("catalogo", JDBCType.INTEGER);

		/** The catnivel 1. */
		public final SqlColumn<Integer> catnivel1 = column("catnivel1", JDBCType.INTEGER);

		/** The catnivel 2. */
		public final SqlColumn<Integer> catnivel2 = column("catnivel2", JDBCType.INTEGER);

		/** The catnivel 3. */
		public final SqlColumn<Integer> catnivel3 = column("catnivel3", JDBCType.INTEGER);

		/** The producto. */
		public final SqlColumn<Integer> producto = column("producto", JDBCType.INTEGER);

		/** The tipo. */
		public final SqlColumn<Integer> tipo = column("tipo", JDBCType.INTEGER);

		/** The automatizable. */
		public final SqlColumn<Boolean> automatizable = column("automatizable", JDBCType.BIT);

		/** The tiempominutos. */
		public final SqlColumn<Float> tiempominutos = column("tiempominutos", JDBCType.REAL);

		/**
		 * Instantiates a new operative catalog.
		 */
		public OperativeCatalog() {
			super("catalogooperativo");
		}
	}
}