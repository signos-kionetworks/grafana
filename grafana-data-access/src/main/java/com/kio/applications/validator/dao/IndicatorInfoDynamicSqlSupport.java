package com.kio.applications.validator.dao;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

/**
 * The type Indicator info dynamic sql support.
 */
public final class IndicatorInfoDynamicSqlSupport {
    /**
     * The constant indicatorInfo.
     */

    public static final IndicatorInfo indicatorInfo = new IndicatorInfo();

    /**
     * The constant id.
     */
    public static final SqlColumn<Integer> id = indicatorInfo.id;

    /**
     * The constant source.
     */
    public static final SqlColumn<String> source = indicatorInfo.source;

    /**
     * The constant userAgent.
     */
    public static final SqlColumn<String> userAgent = indicatorInfo.userAgent;

    /**
     * The constant remoteHost.
     */
    public static final SqlColumn<String> remoteHost = indicatorInfo.remoteHost;

    /**
     * The constant idIndicador.
     */
    public static final SqlColumn<Integer> idIndicador = indicatorInfo.idIndicador;

    /**
     * The type Indicator info.
     */
    public static final class IndicatorInfo extends SqlTable {
        /**
         * The Id.
         */
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        /**
         * The Source.
         */
        public final SqlColumn<String> source = column("source", JDBCType.VARCHAR);

        /**
         * The User agent.
         */
        public final SqlColumn<String> userAgent = column("user_agent", JDBCType.VARCHAR);

        /**
         * The Remote host.
         */
        public final SqlColumn<String> remoteHost = column("remote_host", JDBCType.VARCHAR);

        /**
         * The Id indicador.
         */
        public final SqlColumn<Integer> idIndicador = column("id_indicador", JDBCType.INTEGER);

        /**
         * Instantiates a new Indicator info.
         */
        public IndicatorInfo() {
            super("indicadores_info");
        }
    }
}
