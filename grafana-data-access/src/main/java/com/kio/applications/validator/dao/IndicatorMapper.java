package com.kio.applications.validator.dao;

import static com.kio.applications.validator.dao.IndicatorDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.kio.applications.validator.model.Indicator;
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
public interface IndicatorMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, time, autid, autotime, svtime, transactionid, ticketid, svfte, impactedCis, totalImpactedCis, mantime, idRecurso);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="record.id")
    int insert(InsertStatementProvider<Indicator> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @Insert({
        "${insertStatement}"
    })
    @Options(useGeneratedKeys=true,keyProperty="records.id")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<Indicator> records);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(MultiRowInsertStatementProvider<Indicator> multipleInsertStatement) {
        return insertMultiple(multipleInsertStatement.getInsertStatement(), multipleInsertStatement.getRecords());
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("IndicatorResult")
    Optional<Indicator> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="IndicatorResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="time", property="time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="autid", property="autid", jdbcType=JdbcType.BIGINT),
        @Result(column="autotime", property="autotime", jdbcType=JdbcType.REAL),
        @Result(column="svtime", property="svtime", jdbcType=JdbcType.REAL),
        @Result(column="transactionid", property="transactionid", jdbcType=JdbcType.VARCHAR),
        @Result(column="ticketid", property="ticketid", jdbcType=JdbcType.VARCHAR),
        @Result(column="svfte", property="svfte", jdbcType=JdbcType.REAL),
        @Result(column="impacted_cis", property="impactedCis", jdbcType=JdbcType.INTEGER),
        @Result(column="total_impacted_cis", property="totalImpactedCis", jdbcType=JdbcType.INTEGER),
        @Result(column="mantime", property="mantime", jdbcType=JdbcType.DOUBLE),
        @Result(column="id_recurso", property="idRecurso", jdbcType=JdbcType.INTEGER)
    })
    List<Indicator> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, indicator, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, indicator, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(Indicator record) {
        return MyBatis3Utils.insert(this::insert, record, indicator, c ->
            c.map(time).toProperty("time")
            .map(autid).toProperty("autid")
            .map(autotime).toProperty("autotime")
            .map(svtime).toProperty("svtime")
            .map(transactionid).toProperty("transactionid")
            .map(ticketid).toProperty("ticketid")
            .map(svfte).toProperty("svfte")
            .map(impactedCis).toProperty("impactedCis")
            .map(totalImpactedCis).toProperty("totalImpactedCis")
            .map(mantime).toProperty("mantime")
            .map(idRecurso).toProperty("idRecurso")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<Indicator> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, indicator, c ->
            c.map(time).toProperty("time")
            .map(autid).toProperty("autid")
            .map(autotime).toProperty("autotime")
            .map(svtime).toProperty("svtime")
            .map(transactionid).toProperty("transactionid")
            .map(ticketid).toProperty("ticketid")
            .map(svfte).toProperty("svfte")
            .map(impactedCis).toProperty("impactedCis")
            .map(totalImpactedCis).toProperty("totalImpactedCis")
            .map(mantime).toProperty("mantime")
            .map(idRecurso).toProperty("idRecurso")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Indicator record) {
        return MyBatis3Utils.insert(this::insert, record, indicator, c ->
            c.map(time).toPropertyWhenPresent("time", record::getTime)
            .map(autid).toPropertyWhenPresent("autid", record::getAutid)
            .map(autotime).toPropertyWhenPresent("autotime", record::getAutotime)
            .map(svtime).toPropertyWhenPresent("svtime", record::getSvtime)
            .map(transactionid).toPropertyWhenPresent("transactionid", record::getTransactionid)
            .map(ticketid).toPropertyWhenPresent("ticketid", record::getTicketid)
            .map(svfte).toPropertyWhenPresent("svfte", record::getSvfte)
            .map(impactedCis).toPropertyWhenPresent("impactedCis", record::getImpactedCis)
            .map(totalImpactedCis).toPropertyWhenPresent("totalImpactedCis", record::getTotalImpactedCis)
            .map(mantime).toPropertyWhenPresent("mantime", record::getMantime)
            .map(idRecurso).toPropertyWhenPresent("idRecurso", record::getIdRecurso)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Indicator> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, indicator, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Indicator> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, indicator, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Indicator> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, indicator, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Indicator> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, indicator, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(Indicator record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(time).equalTo(record::getTime)
                .set(autid).equalTo(record::getAutid)
                .set(autotime).equalTo(record::getAutotime)
                .set(svtime).equalTo(record::getSvtime)
                .set(transactionid).equalTo(record::getTransactionid)
                .set(ticketid).equalTo(record::getTicketid)
                .set(svfte).equalTo(record::getSvfte)
                .set(impactedCis).equalTo(record::getImpactedCis)
                .set(totalImpactedCis).equalTo(record::getTotalImpactedCis)
                .set(mantime).equalTo(record::getMantime)
                .set(idRecurso).equalTo(record::getIdRecurso);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Indicator record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(time).equalToWhenPresent(record::getTime)
                .set(autid).equalToWhenPresent(record::getAutid)
                .set(autotime).equalToWhenPresent(record::getAutotime)
                .set(svtime).equalToWhenPresent(record::getSvtime)
                .set(transactionid).equalToWhenPresent(record::getTransactionid)
                .set(ticketid).equalToWhenPresent(record::getTicketid)
                .set(svfte).equalToWhenPresent(record::getSvfte)
                .set(impactedCis).equalToWhenPresent(record::getImpactedCis)
                .set(totalImpactedCis).equalToWhenPresent(record::getTotalImpactedCis)
                .set(mantime).equalToWhenPresent(record::getMantime)
                .set(idRecurso).equalToWhenPresent(record::getIdRecurso);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Indicator record) {
        return update(c ->
            c.set(time).equalTo(record::getTime)
            .set(autid).equalTo(record::getAutid)
            .set(autotime).equalTo(record::getAutotime)
            .set(svtime).equalTo(record::getSvtime)
            .set(transactionid).equalTo(record::getTransactionid)
            .set(ticketid).equalTo(record::getTicketid)
            .set(svfte).equalTo(record::getSvfte)
            .set(impactedCis).equalTo(record::getImpactedCis)
            .set(totalImpactedCis).equalTo(record::getTotalImpactedCis)
            .set(mantime).equalTo(record::getMantime)
            .set(idRecurso).equalTo(record::getIdRecurso)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Indicator record) {
        return update(c ->
            c.set(time).equalToWhenPresent(record::getTime)
            .set(autid).equalToWhenPresent(record::getAutid)
            .set(autotime).equalToWhenPresent(record::getAutotime)
            .set(svtime).equalToWhenPresent(record::getSvtime)
            .set(transactionid).equalToWhenPresent(record::getTransactionid)
            .set(ticketid).equalToWhenPresent(record::getTicketid)
            .set(svfte).equalToWhenPresent(record::getSvfte)
            .set(impactedCis).equalToWhenPresent(record::getImpactedCis)
            .set(totalImpactedCis).equalToWhenPresent(record::getTotalImpactedCis)
            .set(mantime).equalToWhenPresent(record::getMantime)
            .set(idRecurso).equalToWhenPresent(record::getIdRecurso)
            .where(id, isEqualTo(record::getId))
        );
    }
}