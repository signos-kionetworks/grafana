package com.kio.applications.validator.dao;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class IndicatorDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final Indicator indicator = new Indicator();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = indicator.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> time = indicator.time;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> autid = indicator.autid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Float> autotime = indicator.autotime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Float> svtime = indicator.svtime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> transactionid = indicator.transactionid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> ticketid = indicator.ticketid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Float> svfte = indicator.svfte;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> impactedCis = indicator.impactedCis;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> totalImpactedCis = indicator.totalImpactedCis;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Double> mantime = indicator.mantime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> idRecurso = indicator.idRecurso;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class Indicator extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Date> time = column("time", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> autid = column("autid", JDBCType.BIGINT);

        public final SqlColumn<Float> autotime = column("autotime", JDBCType.REAL);

        public final SqlColumn<Float> svtime = column("svtime", JDBCType.REAL);

        public final SqlColumn<String> transactionid = column("transactionid", JDBCType.VARCHAR);

        public final SqlColumn<String> ticketid = column("ticketid", JDBCType.VARCHAR);

        public final SqlColumn<Float> svfte = column("svfte", JDBCType.REAL);

        public final SqlColumn<Integer> impactedCis = column("impacted_cis", JDBCType.INTEGER);

        public final SqlColumn<Integer> totalImpactedCis = column("total_impacted_cis", JDBCType.INTEGER);

        public final SqlColumn<Double> mantime = column("mantime", JDBCType.DOUBLE);

        public final SqlColumn<Integer> idRecurso = column("id_recurso", JDBCType.INTEGER);

        public Indicator() {
            super("indicadores");
        }
    }
}