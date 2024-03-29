/*
 * ****************************************************
 * * Grafana *
 * * KIO Networks *
 * * @Author Julio Galindo *
 * ****************************************************
 */
package com.kio.applications.validator.dao;

import com.kio.applications.validator.model.LevelOfSpecialization;
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

import static com.kio.applications.validator.dao.LevelOfSpecializationDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

/**
 * The Interface LevelOfSpecializationMapper.
 */
@Mapper
public interface LevelOfSpecializationMapper {

    /**
     * The select list.
     */
    BasicColumn[] selectList = BasicColumn.columnList(id, name, descr);

    /**
     * Update all columns.
     *
     * @param record the record
     * @param dsl    the dsl
     * @return the update DSL
     */
    static UpdateDSL<UpdateModel> updateAllColumns(LevelOfSpecialization record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId).set(name).equalTo(record::getName).set(descr)
                .equalTo(record::getDescr);
    }

    /**
     * Update selective columns.
     *
     * @param record the record
     * @param dsl    the dsl
     * @return the update DSL
     */
    static UpdateDSL<UpdateModel> updateSelectiveColumns(LevelOfSpecialization record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId).set(name).equalToWhenPresent(record::getName).set(descr)
                .equalToWhenPresent(record::getDescr);
    }

    /**
     * Count.
     *
     * @param completer the completer
     * @return the long
     */
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, levelOfSpecialization, completer);
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
        return MyBatis3Utils.deleteFrom(this::delete, levelOfSpecialization, completer);
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
    int insert(InsertStatementProvider<LevelOfSpecialization> insertStatement);

    /**
     * Insert.
     *
     * @param record the record
     * @return the int
     */
    default int insert(LevelOfSpecialization record) {
        return MyBatis3Utils.insert(this::insert, record, levelOfSpecialization,
                c -> c.map(id).toProperty("id").map(name).toProperty("name").map(descr).toProperty("descr"));
    }

    /**
     * Insert multiple.
     *
     * @param records the records
     * @return the int
     */
    default int insertMultiple(Collection<LevelOfSpecialization> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, levelOfSpecialization,
                c -> c.map(id).toProperty("id").map(name).toProperty("name").map(descr).toProperty("descr"));
    }

    /**
     * Insert multiple.
     *
     * @param multipleInsertStatement the multiple insert statement
     * @return the int
     */
    @InsertProvider(type = SqlProviderAdapter.class, method = "insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<LevelOfSpecialization> multipleInsertStatement);

    /**
     * Insert selective.
     *
     * @param record the record
     * @return the int
     */
    default int insertSelective(LevelOfSpecialization record) {
        return MyBatis3Utils.insert(this::insert, record, levelOfSpecialization,
                c -> c.map(id).toPropertyWhenPresent("id", record::getId).map(name)
                        .toPropertyWhenPresent("name", record::getName).map(descr)
                        .toPropertyWhenPresent("descr", record::getDescr));
    }

    /**
     * Select.
     *
     * @param completer the completer
     * @return the list
     */
    default List<LevelOfSpecialization> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, levelOfSpecialization, completer);
    }

    /**
     * Select by primary key.
     *
     * @param id_ the id
     * @return the optional
     */
    default Optional<LevelOfSpecialization> selectByPrimaryKey(Integer id_) {
        return selectOne(c -> c.where(id, isEqualTo(id_)));
    }

    /**
     * Select distinct.
     *
     * @param completer the completer
     * @return the list
     */
    default List<LevelOfSpecialization> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, levelOfSpecialization, completer);
    }

    /**
     * Select many.
     *
     * @param selectStatement the select statement
     * @return the list
     */
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(
            id = "LevelOfSpecializationResult",
            value = {@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
                    @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
                    @Result(column = "descr", property = "descr", jdbcType = JdbcType.VARCHAR)})
    List<LevelOfSpecialization> selectMany(SelectStatementProvider selectStatement);

    /**
     * Select one.
     *
     * @param completer the completer
     * @return the optional
     */
    default Optional<LevelOfSpecialization> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, levelOfSpecialization, completer);
    }

    /**
     * Select one.
     *
     * @param selectStatement the select statement
     * @return the optional
     */
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("LevelOfSpecializationResult")
    Optional<LevelOfSpecialization> selectOne(SelectStatementProvider selectStatement);

    /**
     * Update.
     *
     * @param completer the completer
     * @return the int
     */
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, levelOfSpecialization, completer);
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
    default int updateByPrimaryKey(LevelOfSpecialization record) {
        return update(c -> c.set(name).equalTo(record::getName).set(descr).equalTo(record::getDescr).where(id,
                isEqualTo(record::getId)));
    }

    /**
     * Update by primary key selective.
     *
     * @param record the record
     * @return the int
     */
    default int updateByPrimaryKeySelective(LevelOfSpecialization record) {
        return update(c -> c.set(name).equalToWhenPresent(record::getName).set(descr)
                .equalToWhenPresent(record::getDescr).where(id, isEqualTo(record::getId)));
    }
}