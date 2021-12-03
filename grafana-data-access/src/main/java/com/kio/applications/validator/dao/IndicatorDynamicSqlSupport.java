/*
* ****************************************************
* * Grafana *
* * KIO Networks *
* * @Author Julio Galindo *
* ****************************************************
*/
package com.kio.applications.validator.dao;

import java.sql.JDBCType;
import java.util.Date;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

/**
 * The Class IndicatorDynamicSqlSupport.
 */
public final class IndicatorDynamicSqlSupport {

	/**
	 * The Class Indicator.
	 */
	public static final class Indicator extends SqlTable {
		
		/** The id. */
		public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

		/** The time. */
		public final SqlColumn<Date> time = column("time", JDBCType.TIMESTAMP);

		/** The autid. */
		public final SqlColumn<Long> autid = column("autid", JDBCType.BIGINT);

		/** The autotime. */
		public final SqlColumn<Float> autotime = column("autotime", JDBCType.REAL);

		/** The svtime. */
		public final SqlColumn<Float> svtime = column("svtime", JDBCType.REAL);

		/** The transactionid. */
		public final SqlColumn<String> transactionid = column("transactionid", JDBCType.VARCHAR);

		/** The ticketid. */
		public final SqlColumn<String> ticketid = column("ticketid", JDBCType.VARCHAR);

		/** The svfte. */
		public final SqlColumn<Float> svfte = column("svfte", JDBCType.REAL);

		/** The impacted cis. */
		public final SqlColumn<Integer> impactedCis = column("impacted_cis", JDBCType.INTEGER);

		/** The total impacted cis. */
		public final SqlColumn<Integer> totalImpactedCis = column("total_impacted_cis", JDBCType.INTEGER);

		/** The mantime. */
		public final SqlColumn<Float> mantime = column("mantime", JDBCType.REAL);

		/**
		 * Instantiates a new indicator.
		 */
		public Indicator() {
			super("indicadores");
		}
	}

	/** The Constant indicator. */
	public static final Indicator indicator = new Indicator();

	/** The Constant id. */
	public static final SqlColumn<Long> id = indicator.id;

	/** The Constant time. */
	public static final SqlColumn<Date> time = indicator.time;

	/** The Constant autid. */
	public static final SqlColumn<Long> autid = indicator.autid;

	/** The Constant autotime. */
	public static final SqlColumn<Float> autotime = indicator.autotime;

	/** The Constant svtime. */
	public static final SqlColumn<Float> svtime = indicator.svtime;

	/** The Constant transactionid. */
	public static final SqlColumn<String> transactionid = indicator.transactionid;

	/** The Constant ticketid. */
	public static final SqlColumn<String> ticketid = indicator.ticketid;

	/** The Constant svfte. */
	public static final SqlColumn<Float> svfte = indicator.svfte;

	/** The Constant impactedCis. */
	public static final SqlColumn<Integer> impactedCis = indicator.impactedCis;

	/** The Constant totalImpactedCis. */
	public static final SqlColumn<Integer> totalImpactedCis = indicator.totalImpactedCis;

	/** The Constant mantime. */
	public static final SqlColumn<Float> mantime = indicator.mantime;
}