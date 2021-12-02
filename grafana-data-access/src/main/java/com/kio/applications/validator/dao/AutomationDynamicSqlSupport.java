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
 * The Class AutomationDynamicSqlSupport.
 */
public final class AutomationDynamicSqlSupport {

	/** The Constant automation. */
	public static final Automation automation = new Automation();

	/** The Constant id. */
	public static final SqlColumn<Long> id = automation.id;

	/** The Constant botname. */
	public static final SqlColumn<String> botname = automation.botname;

	/** The Constant botDescr. */
	public static final SqlColumn<String> botDescr = automation.botDescr;

	/** The Constant areaid. */
	public static final SqlColumn<Integer> areaid = automation.areaid;

	/** The Constant suppgroupid. */
	public static final SqlColumn<Integer> suppgroupid = automation.suppgroupid;

	/** The Constant specialistid. */
	public static final SqlColumn<Integer> specialistid = automation.specialistid;

	/** The Constant crid. */
	public static final SqlColumn<Integer> crid = automation.crid;

	/** The Constant clienteid. */
	public static final SqlColumn<Integer> clienteid = automation.clienteid;

	/** The Constant platformid. */
	public static final SqlColumn<Integer> platformid = automation.platformid;

	/** The Constant tipoautid. */
	public static final SqlColumn<Integer> tipoautid = automation.tipoautid;

	/** The Constant functionid. */
	public static final SqlColumn<Integer> functionid = automation.functionid;

	/** The Constant tipoexecid. */
	public static final SqlColumn<Integer> tipoexecid = automation.tipoexecid;

	/** The Constant tipociid. */
	public static final SqlColumn<Integer> tipociid = automation.tipociid;

	/** The Constant tecnologiaid. */
	public static final SqlColumn<Integer> tecnologiaid = automation.tecnologiaid;

	/** The Constant catopid. */
	public static final SqlColumn<Integer> catopid = automation.catopid;

	/** The Constant dirid. */
	public static final SqlColumn<Integer> dirid = automation.dirid;

	/** The Constant devtypeid. */
	public static final SqlColumn<Integer> devtypeid = automation.devtypeid;

	/** The Constant manexecs. */
	public static final SqlColumn<Float> manexecs = automation.manexecs;

	/** The Constant autoexecs. */
	public static final SqlColumn<Float> autoexecs = automation.autoexecs;

	/** The Constant mantime. */
	public static final SqlColumn<Float> mantime = automation.mantime;

	/** The Constant registeredDate. */
	public static final SqlColumn<Date> registeredDate = automation.registeredDate;

	/** The Constant autCreatorArea. */
	public static final SqlColumn<String> autCreatorArea = automation.autCreatorArea;

	/** The Constant autCreatorUser. */
	public static final SqlColumn<String> autCreatorUser = automation.autCreatorUser;

	/** The Constant lastModified. */
	public static final SqlColumn<Date> lastModified = automation.lastModified;

	/** The Constant autEnabled. */
	public static final SqlColumn<Boolean> autEnabled = automation.autEnabled;

	/** The Constant impactedCis. */
	public static final SqlColumn<Integer> impactedCis = automation.impactedCis;

	/** The Constant totalImpactedCis. */
	public static final SqlColumn<Integer> totalImpactedCis = automation.totalImpactedCis;

	/**
	 * The Class Automation.
	 */
	public static final class Automation extends SqlTable {

		/** The id. */
		public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

		/** The botname. */
		public final SqlColumn<String> botname = column("botname", JDBCType.VARCHAR);

		/** The bot descr. */
		public final SqlColumn<String> botDescr = column("bot_descr", JDBCType.VARCHAR);

		/** The areaid. */
		public final SqlColumn<Integer> areaid = column("areaid", JDBCType.INTEGER);

		/** The suppgroupid. */
		public final SqlColumn<Integer> suppgroupid = column("suppgroupid", JDBCType.INTEGER);

		/** The specialistid. */
		public final SqlColumn<Integer> specialistid = column("specialistid", JDBCType.INTEGER);

		/** The crid. */
		public final SqlColumn<Integer> crid = column("crid", JDBCType.INTEGER);

		/** The clienteid. */
		public final SqlColumn<Integer> clienteid = column("clienteid", JDBCType.INTEGER);

		/** The platformid. */
		public final SqlColumn<Integer> platformid = column("platformid", JDBCType.INTEGER);

		/** The tipoautid. */
		public final SqlColumn<Integer> tipoautid = column("tipoautid", JDBCType.INTEGER);

		/** The functionid. */
		public final SqlColumn<Integer> functionid = column("functionid", JDBCType.INTEGER);

		/** The tipoexecid. */
		public final SqlColumn<Integer> tipoexecid = column("tipoexecid", JDBCType.INTEGER);

		/** The tipociid. */
		public final SqlColumn<Integer> tipociid = column("tipociid", JDBCType.INTEGER);

		/** The tecnologiaid. */
		public final SqlColumn<Integer> tecnologiaid = column("tecnologiaid", JDBCType.INTEGER);

		/** The catopid. */
		public final SqlColumn<Integer> catopid = column("catopid", JDBCType.INTEGER);

		/** The dirid. */
		public final SqlColumn<Integer> dirid = column("dirid", JDBCType.INTEGER);

		/** The devtypeid. */
		public final SqlColumn<Integer> devtypeid = column("devtypeid", JDBCType.INTEGER);

		/** The manexecs. */
		public final SqlColumn<Float> manexecs = column("manexecs", JDBCType.REAL);

		/** The autoexecs. */
		public final SqlColumn<Float> autoexecs = column("autoexecs", JDBCType.REAL);

		/** The mantime. */
		public final SqlColumn<Float> mantime = column("mantime", JDBCType.REAL);

		/** The registered date. */
		public final SqlColumn<Date> registeredDate = column("registered_date", JDBCType.TIMESTAMP);

		/** The aut creator area. */
		public final SqlColumn<String> autCreatorArea = column("aut_creator_area", JDBCType.VARCHAR);

		/** The aut creator user. */
		public final SqlColumn<String> autCreatorUser = column("aut_creator_user", JDBCType.VARCHAR);

		/** The last modified. */
		public final SqlColumn<Date> lastModified = column("last_modified", JDBCType.TIMESTAMP);

		/** The aut enabled. */
		public final SqlColumn<Boolean> autEnabled = column("aut_enabled", JDBCType.BIT);

		/** The impacted cis. */
		public final SqlColumn<Integer> impactedCis = column("impacted_cis", JDBCType.INTEGER);

		/** The total impacted cis. */
		public final SqlColumn<Integer> totalImpactedCis = column("total_impacted_cis", JDBCType.INTEGER);

		/**
		 * Instantiates a new automation.
		 */
		public Automation() {
			super("automatizacion");
		}
	}
}