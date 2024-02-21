/*
 * ****************************************************
 * * Grafana *
 * * KIO Networks *
 * * @Author Julio Galindo *
 * ****************************************************
 */
package com.kio.applications.validator.dao;

import com.kio.applications.validator.model.EquivalenceClient;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static com.kio.applications.validator.dao.EquivalenceClientDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

/**
 * The Interface EquivalenceClientMapper.
 */
@Mapper
public interface EquivalenceClientMapper {

    /**
     * The select list.
     */
    BasicColumn[] selectList = BasicColumn.columnList(valor, idCliente);

    /**
     * Update all columns.
     *
     * @param record the record
     * @param dsl    the dsl
     * @return the update DSL
     */
    static UpdateDSL<UpdateModel> updateAllColumns(EquivalenceClient record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(valor).equalTo(record::getValor)
                .set(idCliente).equalTo(record::getIdCliente);
    }

    /**
     * Update selective columns.
     *
     * @param record the record
     * @param dsl    the dsl
     * @return the update DSL
     */
    static UpdateDSL<UpdateModel> updateSelectiveColumns(EquivalenceClient record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(valor).equalToWhenPresent(record::getValor)
                .set(idCliente).equalToWhenPresent(record::getIdCliente);
    }

    /**
     * Count.
     *
     * @param selectStatement the select statement
     * @return the long
     */
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    long count(SelectStatementProvider selectStatement);

    /**
     * Delete.
     *
     * @param deleteStatement the delete statement
     * @return the int
     */
    @DeleteProvider(type = SqlProviderAdapter.class, method = "delete")
    int delete(DeleteStatementProvider deleteStatement);

    /**
     * Insert.
     *
     * @param insertStatement the insert statement
     * @return the int
     */
    @InsertProvider(type = SqlProviderAdapter.class, method = "insert")
    int insert(InsertStatementProvider<EquivalenceClient> insertStatement);

    /**
     * Insert multiple.
     *
     * @param multipleInsertStatement the multiple insert statement
     * @return the int
     */
    @InsertProvider(type = SqlProviderAdapter.class, method = "insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<EquivalenceClient> multipleInsertStatement);

    /**
     * Select one.
     *
     * @param selectStatement the select statement
     * @return the optional
     */
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("EquivalenceClientResult")
    Optional<EquivalenceClient> selectOne(SelectStatementProvider selectStatement);

    /**
     * Select many.
     *
     * @param selectStatement the select statement
     * @return the list
     */
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "EquivalenceClientResult", value = {
            @Result(column = "valor", property = "valor", jdbcType = JdbcType.VARCHAR, id = true),
            @Result(column = "id_cliente", property = "idCliente", jdbcType = JdbcType.INTEGER)
    })
    List<EquivalenceClient> selectMany(SelectStatementProvider selectStatement);

    /**
     * Update.
     *
     * @param updateStatement the update statement
     * @return the int
     */
    @UpdateProvider(type = SqlProviderAdapter.class, method = "update")
    int update(UpdateStatementProvider updateStatement);

    /**
     * Count.
     *
     * @param completer the completer
     * @return the long
     */
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, equivalenceClient, completer);
    }

    /**
     * Delete.
     *
     * @param completer the completer
     * @return the int
     */
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, equivalenceClient, completer);
    }

    /**
     * Delete by primary key.
     *
     * @param valor_ the valor
     * @return the int
     */
    default int deleteByPrimaryKey(String valor_) {
        return delete(c ->
                c.where(valor, isEqualTo(valor_))
        );
    }

    /**
     * Insert.
     *
     * @param record the record
     * @return the int
     */
    default int insert(EquivalenceClient record) {
        return MyBatis3Utils.insert(this::insert, record, equivalenceClient, c ->
                c.map(valor).toProperty("valor")
                        .map(idCliente).toProperty("idCliente")
        );
    }

    /**
     * Insert multiple.
     *
     * @param records the records
     * @return the int
     */
    default int insertMultiple(Collection<EquivalenceClient> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, equivalenceClient, c ->
                c.map(valor).toProperty("valor")
                        .map(idCliente).toProperty("idCliente")
        );
    }

    /**
     * Insert selective.
     *
     * @param record the record
     * @return the int
     */
    default int insertSelective(EquivalenceClient record) {
        return MyBatis3Utils.insert(this::insert, record, equivalenceClient, c ->
                c.map(valor).toPropertyWhenPresent("valor", record::getValor)
                        .map(idCliente).toPropertyWhenPresent("idCliente", record::getIdCliente)
        );
    }

    /**
     * Select one.
     *
     * @param completer the completer
     * @return the optional
     */
    default Optional<EquivalenceClient> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, equivalenceClient, completer);
    }

    /**
     * Select.
     *
     * @param completer the completer
     * @return the list
     */
    default List<EquivalenceClient> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, equivalenceClient, completer);
    }

    /**
     * Select distinct.
     *
     * @param completer the completer
     * @return the list
     */
    default List<EquivalenceClient> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, equivalenceClient, completer);
    }

    /**
     * Select by primary key.
     *
     * @param valor_ the valor
     * @return the optional
     */
    default Optional<EquivalenceClient> selectByPrimaryKey(String valor_) {
        return selectOne(c ->
                c.where(valor, isEqualTo(valor_))
        );
    }

    /**
     * Update.
     *
     * @param completer the completer
     * @return the int
     */
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, equivalenceClient, completer);
    }

    /**
     * Update by primary key.
     *
     * @param record the record
     * @return the int
     */
    default int updateByPrimaryKey(EquivalenceClient record) {
        return update(c ->
                c.set(idCliente).equalTo(record::getIdCliente)
                        .where(valor, isEqualTo(record::getValor))
        );
    }


    /**
     * Update by primary key selective.
     *
     * @param record the record
     * @return the int
     */
    default int updateByPrimaryKeySelective(EquivalenceClient record) {
        return update(c ->
                c.set(idCliente).equalToWhenPresent(record::getIdCliente)
                        .where(valor, isEqualTo(record::getValor))
        );
    }
}