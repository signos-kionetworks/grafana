package com.kio.applications.validator.dao;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class IndicatorInfoDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final IndicatorInfo indicatorInfo = new IndicatorInfo();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> id = indicatorInfo.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> source = indicatorInfo.source;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> userAgent = indicatorInfo.userAgent;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> remoteHost = indicatorInfo.remoteHost;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> idIndicador = indicatorInfo.idIndicador;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class IndicatorInfo extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> source = column("source", JDBCType.VARCHAR);

        public final SqlColumn<String> userAgent = column("user_agent", JDBCType.VARCHAR);

        public final SqlColumn<String> remoteHost = column("remote_host", JDBCType.VARCHAR);

        public final SqlColumn<Integer> idIndicador = column("id_indicador", JDBCType.INTEGER);

        public IndicatorInfo() {
            super("indicadores_info");
        }
    }
}
