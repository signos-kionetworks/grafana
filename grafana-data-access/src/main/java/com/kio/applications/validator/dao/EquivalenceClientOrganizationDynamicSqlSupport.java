/*
 * ****************************************************
 * * Grafana *
 * * KIO Networks *
 * * @Author Julio Galindo *
 * ****************************************************
 */
package com.kio.applications.validator.dao;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

/**
 * The Class EquivalenceClientOrganizationDynamicSqlSupport.
 */
public final class EquivalenceClientOrganizationDynamicSqlSupport {

    /**
     * The Constant equivalenceClientOrganization.
     */
    public static final EquivalenceClientOrganization equivalenceClientOrganization = new EquivalenceClientOrganization();
    /**
     * The Constant idCliente.
     */
    public static final SqlColumn<Integer> idCliente = equivalenceClientOrganization.idCliente;
    /**
     * The Constant idOrganizacionAwx.
     */
    public static final SqlColumn<Integer> idOrganizacionAwx = equivalenceClientOrganization.idOrganizacionAwx;

    /**
     * The Class EquivalenceClientOrganization.
     */
    public static final class EquivalenceClientOrganization extends SqlTable {

        /**
         * The id cliente.
         */
        public final SqlColumn<Integer> idCliente = column("id_cliente", JDBCType.INTEGER);

        /**
         * The id organizacion awx.
         */
        public final SqlColumn<Integer> idOrganizacionAwx = column("id_organizacion_awx", JDBCType.INTEGER);

        /**
         * Instantiates a new equivalence client organization.
         */
        public EquivalenceClientOrganization() {
            super("eq_cliente_org");
        }
    }
}