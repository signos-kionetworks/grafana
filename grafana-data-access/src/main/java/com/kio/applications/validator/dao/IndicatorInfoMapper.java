package com.kio.applications.validator.dao;

import static com.kio.applications.validator.dao.IndicatorInfoDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.kio.applications.validator.model.IndicatorInfo;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
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

@Mapper
public interface IndicatorInfoMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, source, userAgent, remoteHost, idIndicador);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="record.id")
    int insert(InsertStatementProvider<IndicatorInfo> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @Insert({
        "${insertStatement}"
    })
    @Options(useGeneratedKeys=true,keyProperty="records.id")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<IndicatorInfo> records);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(MultiRowInsertStatementProvider<IndicatorInfo> multipleInsertStatement) {
        return insertMultiple(multipleInsertStatement.getInsertStatement(), multipleInsertStatement.getRecords());
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("IndicatorInfoResult")
    Optional<IndicatorInfo> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="IndicatorInfoResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="source", property="source", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_agent", property="userAgent", jdbcType=JdbcType.VARCHAR),
        @Result(column="remote_host", property="remoteHost", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_indicador", property="idIndicador", jdbcType=JdbcType.INTEGER)
    })
    List<IndicatorInfo> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, indicatorInfo, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, indicatorInfo, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(IndicatorInfo record) {
        return MyBatis3Utils.insert(this::insert, record, indicatorInfo, c ->
            c.map(source).toProperty("source")
            .map(userAgent).toProperty("userAgent")
            .map(remoteHost).toProperty("remoteHost")
            .map(idIndicador).toProperty("idIndicador")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<IndicatorInfo> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, indicatorInfo, c ->
            c.map(source).toProperty("source")
            .map(userAgent).toProperty("userAgent")
            .map(remoteHost).toProperty("remoteHost")
            .map(idIndicador).toProperty("idIndicador")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(IndicatorInfo record) {
        return MyBatis3Utils.insert(this::insert, record, indicatorInfo, c ->
            c.map(source).toPropertyWhenPresent("source", record::getSource)
            .map(userAgent).toPropertyWhenPresent("userAgent", record::getUserAgent)
            .map(remoteHost).toPropertyWhenPresent("remoteHost", record::getRemoteHost)
            .map(idIndicador).toPropertyWhenPresent("idIndicador", record::getIdIndicador)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<IndicatorInfo> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, indicatorInfo, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<IndicatorInfo> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, indicatorInfo, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<IndicatorInfo> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, indicatorInfo, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<IndicatorInfo> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, indicatorInfo, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(IndicatorInfo record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(source).equalTo(record::getSource)
                .set(userAgent).equalTo(record::getUserAgent)
                .set(remoteHost).equalTo(record::getRemoteHost)
                .set(idIndicador).equalTo(record::getIdIndicador);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(IndicatorInfo record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(source).equalToWhenPresent(record::getSource)
                .set(userAgent).equalToWhenPresent(record::getUserAgent)
                .set(remoteHost).equalToWhenPresent(record::getRemoteHost)
                .set(idIndicador).equalToWhenPresent(record::getIdIndicador);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(IndicatorInfo record) {
        return update(c ->
            c.set(source).equalTo(record::getSource)
            .set(userAgent).equalTo(record::getUserAgent)
            .set(remoteHost).equalTo(record::getRemoteHost)
            .set(idIndicador).equalTo(record::getIdIndicador)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
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
