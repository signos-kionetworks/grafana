/*
 * ****************************************************
 * * Grafana *
 * * KIO Networks *
 * * @Author Julio Galindo *
 * ****************************************************
 */
package com.kio.applications.validator.dao;

import com.kio.applications.validator.model.Management;
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

import static com.kio.applications.validator.dao.ManagementDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

/**
 * The Interface ManagementMapper.
 */
@Mapper
public interface ManagementMapper {

    /**
     * The select list.
     */
    BasicColumn[] selectList = BasicColumn.columnList(id, name, descr, idUnidadNegocio);

    /**
     * Update all columns.
     *
     * @param record the record
     * @param dsl    the dsl
     * @return the update DSL
     */
    static UpdateDSL<UpdateModel> updateAllColumns(Management record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(name).equalTo(record::getName).set(descr).equalTo(record::getDescr).set(idUnidadNegocio)
                .equalTo(record::getIdUnidadNegocio);
    }

    /**
     * Update selective columns.
     *
     * @param record the record
     * @param dsl    the dsl
     * @return the update DSL
     */
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Management record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(name).equalToWhenPresent(record::getName).set(descr).equalToWhenPresent(record::getDescr)
                .set(idUnidadNegocio).equalToWhenPresent(record::getIdUnidadNegocio);
    }

    /**
     * Count.
     *
     * @param completer the completer
     * @return the long
     */
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, management, completer);
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
     * @param completer the completer
     * @return the int
     */
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, management, completer);
    }

    /**
     * Delete.
     *
     * @param deleteStatement the delete statement
     * @return the int
     */
    @DeleteProvider(type = SqlProviderAdapter.class, method = "delete")
    int delete(DeleteStatementProvider deleteStatement);

    /**
     * Delete by primary key.
     *
     * @param id_ the id
     * @return the int
     */
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> c.where(id, isEqualTo(id_)));
    }

    /**
     * Insert.
     *
     * @param insertStatement the insert statement
     * @return the int
     */
    @InsertProvider(type = SqlProviderAdapter.class, method = "insert")
    @Options(useGeneratedKeys = true, keyProperty = "record.id")
    int insert(InsertStatementProvider<Management> insertStatement);

    /**
     * Insert.
     *
     * @param record the record
     * @return the int
     */
    default int insert(Management record) {
        return MyBatis3Utils.insert(this::insert, record, management, c -> c.map(name).toProperty("name").map(descr)
                .toProperty("descr").map(idUnidadNegocio).toProperty("idUnidadNegocio"));
    }

    /**
     * Insert multiple.
     *
     * @param records the records
     * @return the int
     */
    default int insertMultiple(Collection<Management> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, management, c -> c.map(name)
                .toProperty("name").map(descr).toProperty("descr").map(idUnidadNegocio).toProperty("idUnidadNegocio"));
    }

    /**
     * Insert multiple.
     *
     * @param multipleInsertStatement the multiple insert statement
     * @return the int
     */
    default int insertMultiple(MultiRowInsertStatementProvider<Management> multipleInsertStatement) {
        return insertMultiple(multipleInsertStatement.getInsertStatement(), multipleInsertStatement.getRecords());
    }

    /**
     * Insert multiple.
     *
     * @param insertStatement the insert statement
     * @param records         the records
     * @return the int
     */
    @Insert({"${insertStatement}"})
    @Options(useGeneratedKeys = true, keyProperty = "records.id")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<Management> records);

    /**
     * Insert selective.
     *
     * @param record the record
     * @return the int
     */
    default int insertSelective(Management record) {
        return MyBatis3Utils.insert(this::insert, record, management,
                c -> c.map(name).toPropertyWhenPresent("name", record::getName).map(descr)
                        .toPropertyWhenPresent("descr", record::getDescr).map(idUnidadNegocio)
                        .toPropertyWhenPresent("idUnidadNegocio", record::getIdUnidadNegocio));
    }

    /**
     * Select.
     *
     * @param completer the completer
     * @return the list
     */
    default List<Management> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, management, completer);
    }

    /**
     * Select by primary key.
     *
     * @param id_ the id
     * @return the optional
     */
    default Optional<Management> selectByPrimaryKey(Integer id_) {
        return selectOne(c -> c.where(id, isEqualTo(id_)));
    }

    /**
     * Select distinct.
     *
     * @param completer the completer
     * @return the list
     */
    default List<Management> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, management, completer);
    }

    /**
     * Select many.
     *
     * @param selectStatement the select statement
     * @return the list
     */
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(
            id = "ManagementResult",
            value = {@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
                    @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
                    @Result(column = "descr", property = "descr", jdbcType = JdbcType.VARCHAR),
                    @Result(column = "id_unidad_negocio", property = "idUnidadNegocio", jdbcType = JdbcType.INTEGER)})
    List<Management> selectMany(SelectStatementProvider selectStatement);

    /**
     * Select one.
     *
     * @param completer the completer
     * @return the optional
     */
    default Optional<Management> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, management, completer);
    }

    /**
     * Select one.
     *
     * @param selectStatement the select statement
     * @return the optional
     */
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("ManagementResult")
    Optional<Management> selectOne(SelectStatementProvider selectStatement);

    /**
     * Update.
     *
     * @param completer the completer
     * @return the int
     */
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, management, completer);
    }

    /**
     * Update.
     *
     * @param updateStatement the update statement
     * @return the int
     */
    @UpdateProvider(type = SqlProviderAdapter.class, method = "update")
    int update(UpdateStatementProvider updateStatement);

    /**
     * Update by primary key.
     *
     * @param record the record
     * @return the int
     */
    default int updateByPrimaryKey(Management record) {
        return update(c -> c.set(name).equalTo(record::getName).set(descr).equalTo(record::getDescr)
                .set(idUnidadNegocio).equalTo(record::getIdUnidadNegocio).where(id, isEqualTo(record::getId)));
    }

    /**
     * Update by primary key selective.
     *
     * @param record the record
     * @return the int
     */
    default int updateByPrimaryKeySelective(Management record) {
        return update(c -> c.set(name).equalToWhenPresent(record::getName).set(descr)
                .equalToWhenPresent(record::getDescr).set(idUnidadNegocio)
                .equalToWhenPresent(record::getIdUnidadNegocio).where(id, isEqualTo(record::getId)));
    }
}