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
 * The Class EquivalenceClientDynamicSqlSupport.
 */
public final class EquivalenceClientDynamicSqlSupport {

    /**
     * The Constant equivalenceClient.
     */
    public static final EquivalenceClient equivalenceClient = new EquivalenceClient();

    /**
     * The Constant valor.
     */
    public static final SqlColumn<String> valor = equivalenceClient.valor;

    /**
     * The Constant idCliente.
     */
    public static final SqlColumn<Integer> idCliente = equivalenceClient.idCliente;

    /**
     * The Class EquivalenceClient.
     */
    public static final class EquivalenceClient extends SqlTable {

        /**
         * The valor.
         */
        public final SqlColumn<String> valor = column("valor",
                JDBCType.VARCHAR);

        /**
         * The id cliente.
         */
        public final SqlColumn<Integer> idCliente = column("id_cliente",
                JDBCType.INTEGER);

        /**
         * Instantiates a new equivalence client.
         */
        public EquivalenceClient() {
            super("eq_cliente");
        }
    }
}