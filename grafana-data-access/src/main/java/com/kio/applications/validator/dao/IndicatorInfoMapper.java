package com.kio.applications.validator.dao;

import com.kio.applications.validator.model.IndicatorInfo;
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

import static com.kio.applications.validator.dao.IndicatorInfoDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

/**
 * The interface Indicator info mapper.
 */
@Mapper
public interface IndicatorInfoMapper {
    /**
     * The Select list.
     */

    BasicColumn[] selectList = BasicColumn.columnList(id, source, userAgent, remoteHost, idIndicador);

    /**
     * Update all columns update dsl.
     *
     * @param record the record
     * @param dsl    the dsl
     * @return the update dsl
     */
    static UpdateDSL<UpdateModel> updateAllColumns(IndicatorInfo record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(source).equalTo(record::getSource)
                .set(userAgent).equalTo(record::getUserAgent)
                .set(remoteHost).equalTo(record::getRemoteHost)
                .set(idIndicador).equalTo(record::getIdIndicador);
    }

    /**
     * Update selective columns update dsl.
     *
     * @param record the record
     * @param dsl    the dsl
     * @return the update dsl
     */
    static UpdateDSL<UpdateModel> updateSelectiveColumns(IndicatorInfo record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(source).equalToWhenPresent(record::getSource)
                .set(userAgent).equalToWhenPresent(record::getUserAgent)
                .set(remoteHost).equalToWhenPresent(record::getRemoteHost)
                .set(idIndicador).equalToWhenPresent(record::getIdIndicador);
    }

    /**
     * Count long.
     *
     * @param selectStatement the select statement
     * @return the long
     */
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    long count(SelectStatementProvider selectStatement);

    /**
     * Delete int.
     *
     * @param deleteStatement the delete statement
     * @return the int
     */
    @DeleteProvider(type = SqlProviderAdapter.class, method = "delete")
    int delete(DeleteStatementProvider deleteStatement);

    /**
     * Insert int.
     *
     * @param insertStatement the insert statement
     * @return the int
     */
    @InsertProvider(type = SqlProviderAdapter.class, method = "insert")
    @Options(useGeneratedKeys = true, keyProperty = "record.id")
    int insert(InsertStatementProvider<IndicatorInfo> insertStatement);

    /**
     * Insert multiple int.
     *
     * @param insertStatement the insert statement
     * @param records         the records
     * @return the int
     */
    @Insert({
            "${insertStatement}"
    })
    @Options(useGeneratedKeys = true, keyProperty = "records.id")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<IndicatorInfo> records);

    /**
     * Insert multiple int.
     *
     * @param multipleInsertStatement the multiple insert statement
     * @return the int
     */
    default int insertMultiple(MultiRowInsertStatementProvider<IndicatorInfo> multipleInsertStatement) {
        return insertMultiple(multipleInsertStatement.getInsertStatement(), multipleInsertStatement.getRecords());
    }

    /**
     * Select one optional.
     *
     * @param selectStatement the select statement
     * @return the optional
     */
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("IndicatorInfoResult")
    Optional<IndicatorInfo> selectOne(SelectStatementProvider selectStatement);

    /**
     * Select many list.
     *
     * @param selectStatement the select statement
     * @return the list
     */
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "IndicatorInfoResult", value = {
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "source", property = "source", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_agent", property = "userAgent", jdbcType = JdbcType.VARCHAR),
            @Result(column = "remote_host", property = "remoteHost", jdbcType = JdbcType.VARCHAR),
            @Result(column = "id_indicador", property = "idIndicador", jdbcType = JdbcType.INTEGER)
    })
    List<IndicatorInfo> selectMany(SelectStatementProvider selectStatement);

    /**
     * Update int.
     *
     * @param updateStatement the update statement
     * @return the int
     */
    @UpdateProvider(type = SqlProviderAdapter.class, method = "update")
    int update(UpdateStatementProvider updateStatement);

    /**
     * Count long.
     *
     * @param completer the completer
     * @return the long
     */
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, indicatorInfo, completer);
    }

    /**
     * Delete int.
     *
     * @param completer the completer
     * @return the int
     */
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, indicatorInfo, completer);
    }

    /**
     * Delete by primary key int.
     *
     * @param id_ the id
     * @return the int
     */
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c ->
                c.where(id, isEqualTo(id_))
        );
    }

    /**
     * Insert int.
     *
     * @param record the record
     * @return the int
     */
    default int insert(IndicatorInfo record) {
        return MyBatis3Utils.insert(this::insert, record, indicatorInfo, c ->
                c.map(source).toProperty("source")
                        .map(userAgent).toProperty("userAgent")
                        .map(remoteHost).toProperty("remoteHost")
                        .map(idIndicador).toProperty("idIndicador")
        );
    }

    /**
     * Insert multiple int.
     *
     * @param records the records
     * @return the int
     */
    default int insertMultiple(Collection<IndicatorInfo> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, indicatorInfo, c ->
                c.map(source).toProperty("source")
                        .map(userAgent).toProperty("userAgent")
                        .map(remoteHost).toProperty("remoteHost")
                        .map(idIndicador).toProperty("idIndicador")
        );
    }

    /**
     * Insert selective int.
     *
     * @param record the record
     * @return the int
     */
    default int insertSelective(IndicatorInfo record) {
        return MyBatis3Utils.insert(this::insert, record, indicatorInfo, c ->
                c.map(source).toPropertyWhenPresent("source", record::getSource)
                        .map(userAgent).toPropertyWhenPresent("userAgent", record::getUserAgent)
                        .map(remoteHost).toPropertyWhenPresent("remoteHost", record::getRemoteHost)
                        .map(idIndicador).toPropertyWhenPresent("idIndicador", record::getIdIndicador)
        );
    }

    /**
     * Select one optional.
     *
     * @param completer the completer
     * @return the optional
     */
    default Optional<IndicatorInfo> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, indicatorInfo, completer);
    }

    /**
     * Select list.
     *
     * @param completer the completer
     * @return the list
     */
    default List<IndicatorInfo> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, indicatorInfo, completer);
    }

    /**
     * Select distinct list.
     *
     * @param completer the completer
     * @return the list
     */
    default List<IndicatorInfo> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, indicatorInfo, completer);
    }

    /**
     * Select by primary key optional.
     *
     * @param id_ the id
     * @return the optional
     */
    default Optional<IndicatorInfo> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
                c.where(id, isEqualTo(id_))
        );
    }

    /**
     * Update int.
     *
     * @param completer the completer
     * @return the int
     */
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, indicatorInfo, completer);
    }

    /**
     * Update by primary key int.
     *
     * @param record the record
     * @return the int
     */
    default int updateByPrimaryKey(IndicatorInfo record) {
        return update(c ->
                c.set(source).equalTo(record::getSource)
                        .set(userAgent).equalTo(record::getUserAgent)
                        .set(remoteHost).equalTo(record::getRemoteHost)
                        .set(idIndicador).equalTo(record::getIdIndicador)
                        .where(id, isEqualTo(record::getId))
        );
    }

    /**
     * Update by primary key selective int.
     *
     * @param record the record
     * @return the int
     */
    default int updateByPrimaryKeySelective(IndicatorInfo record) {
        return update(c ->
                c.set(source).equalToWhenPresent(record::getSource)
                        .set(userAgent).equalToWhenPresent(record::getUserAgent)
                        .set(remoteHost).equalToWhenPresent(record::getRemoteHost)
                        .set(idIndicador).equalToWhenPresent(record::getIdIndicador)
                        .where(id, isEqualTo(record::getId))
        );
    }
}
