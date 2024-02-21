package com.kio.applications.validator.dao;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ResourceDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final Resource resource = new Resource();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> id = resource.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> name = resource.name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> identificadorRecurso = resource.identificadorRecurso;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> idOrigen = resource.idOrigen;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class Resource extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<String> identificadorRecurso = column("identificador_recurso", JDBCType.VARCHAR);

        public final SqlColumn<Integer> idOrigen = column("id_origen", JDBCType.INTEGER);

        public Resource() {
            super("recurso");
        }
    }
}