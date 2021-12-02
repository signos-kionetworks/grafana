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
 * The Class TypeTicketDynamicSqlSupport.
 */
public final class TypeTicketDynamicSqlSupport {

	/** The Constant typeTicket. */
	public static final TypeTicket typeTicket = new TypeTicket();

	/** The Constant id. */
	public static final SqlColumn<Integer> id = typeTicket.id;

	/** The Constant name. */
	public static final SqlColumn<String> name = typeTicket.name;

	/** The Constant descr. */
	public static final SqlColumn<String> descr = typeTicket.descr;

	/**
	 * The Class TypeTicket.
	 */
	public static final class TypeTicket extends SqlTable {

		/** The id. */
		public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

		/** The name. */
		public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

		/** The descr. */
		public final SqlColumn<String> descr = column("descr", JDBCType.VARCHAR);

		/**
		 * Instantiates a new type ticket.
		 */
		public TypeTicket() {
			super("cotipoticket");
		}
	}
}