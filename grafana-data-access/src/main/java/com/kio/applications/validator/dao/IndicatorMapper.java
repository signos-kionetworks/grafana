/*
* ****************************************************
* * Grafana *
* * KIO Networks *
* * @Author Julio Galindo *
* ****************************************************
*/
package com.kio.applications.validator.dao;

import static com.kio.applications.validator.dao.IndicatorDynamicSqlSupport.autid;
import static com.kio.applications.validator.dao.IndicatorDynamicSqlSupport.autotime;
import static com.kio.applications.validator.dao.IndicatorDynamicSqlSupport.id;
import static com.kio.applications.validator.dao.IndicatorDynamicSqlSupport.impactedCis;
import static com.kio.applications.validator.dao.IndicatorDynamicSqlSupport.indicator;
import static com.kio.applications.validator.dao.IndicatorDynamicSqlSupport.svfte;
import static com.kio.applications.validator.dao.IndicatorDynamicSqlSupport.svtime;
import static com.kio.applications.validator.dao.IndicatorDynamicSqlSupport.ticketid;
import static com.kio.applications.validator.dao.IndicatorDynamicSqlSupport.time;
import static com.kio.applications.validator.dao.IndicatorDynamicSqlSupport.totalExecutionTime;
import static com.kio.applications.validator.dao.IndicatorDynamicSqlSupport.totalImpactedCis;
import static com.kio.applications.validator.dao.IndicatorDynamicSqlSupport.transactionid;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

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

import com.kio.applications.validator.model.Indicator;

/**
 * The Interface IndicatorMapper.
 */
@Mapper
public interface IndicatorMapper {

	/** The select list. */
	BasicColumn[] selectList = BasicColumn.columnList(id, time, autid, autotime, svtime, transactionid, ticketid, svfte,
			impactedCis, totalImpactedCis, totalExecutionTime);

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
	@Options(useGeneratedKeys = true, keyProperty = "record.id")
	int insert(InsertStatementProvider<Indicator> insertStatement);

	/**
	 * Insert multiple.
	 *
	 * @param insertStatement the insert statement
	 * @param records         the records
	 * @return the int
	 */
	@Insert({ "${insertStatement}" })
	@Options(useGeneratedKeys = true, keyProperty = "records.id")
	int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<Indicator> records);

	/**
	 * Insert multiple.
	 *
	 * @param multipleInsertStatement the multiple insert statement
	 * @return the int
	 */
	default int insertMultiple(MultiRowInsertStatementProvider<Indicator> multipleInsertStatement) {
		return insertMultiple(multipleInsertStatement.getInsertStatement(), multipleInsertStatement.getRecords());
	}

	/**
	 * Select one.
	 *
	 * @param selectStatement the select statement
	 * @return the optional
	 */
	@SelectProvider(type = SqlProviderAdapter.class, method = "select")
	@ResultMap("IndicatorResult")
	Optional<Indicator> selectOne(SelectStatementProvider selectStatement);

	/**
	 * Select many.
	 *
	 * @param selectStatement the select statement
	 * @return the list
	 */
	@SelectProvider(type = SqlProviderAdapter.class, method = "select")
	@Results(id = "IndicatorResult", value = {
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "time", property = "time", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "autid", property = "autid", jdbcType = JdbcType.BIGINT),
			@Result(column = "autotime", property = "autotime", jdbcType = JdbcType.REAL),
			@Result(column = "svtime", property = "svtime", jdbcType = JdbcType.REAL),
			@Result(column = "transactionid", property = "transactionid", jdbcType = JdbcType.VARCHAR),
			@Result(column = "ticketid", property = "ticketid", jdbcType = JdbcType.VARCHAR),
			@Result(column = "svfte", property = "svfte", jdbcType = JdbcType.REAL),
			@Result(column = "impacted_cis", property = "impactedCis", jdbcType = JdbcType.INTEGER),
			@Result(column = "total_impacted_cis", property = "totalImpactedCis", jdbcType = JdbcType.INTEGER),
			@Result(column = "total_execution_time", property = "totalExecutionTime", jdbcType = JdbcType.INTEGER) })
	List<Indicator> selectMany(SelectStatementProvider selectStatement);

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
		return MyBatis3Utils.countFrom(this::count, indicator, completer);
	}

	/**
	 * Delete.
	 *
	 * @param completer the completer
	 * @return the int
	 */
	default int delete(DeleteDSLCompleter completer) {
		return MyBatis3Utils.deleteFrom(this::delete, indicator, completer);
	}

	/**
	 * Delete by primary key.
	 *
	 * @param id_ the id
	 * @return the int
	 */
	default int deleteByPrimaryKey(Long id_) {
		return delete(c -> c.where(id, isEqualTo(id_)));
	}

	/**
	 * Insert.
	 *
	 * @param record the record
	 * @return the int
	 */
	default int insert(Indicator record) {
		return MyBatis3Utils.insert(this::insert, record, indicator,
				c -> c.map(time).toProperty("time").map(autid).toProperty("autid").map(autotime).toProperty("autotime")
						.map(svtime).toProperty("svtime").map(transactionid).toProperty("transactionid").map(ticketid)
						.toProperty("ticketid").map(svfte).toProperty("svfte").map(impactedCis)
						.toProperty("impactedCis").map(totalImpactedCis).toProperty("totalImpactedCis")
						.map(totalExecutionTime).toProperty("totalExecutionTime"));
	}

	/**
	 * Insert multiple.
	 *
	 * @param records the records
	 * @return the int
	 */
	default int insertMultiple(Collection<Indicator> records) {
		return MyBatis3Utils.insertMultiple(this::insertMultiple, records, indicator,
				c -> c.map(time).toProperty("time").map(autid).toProperty("autid").map(autotime).toProperty("autotime")
						.map(svtime).toProperty("svtime").map(transactionid).toProperty("transactionid").map(ticketid)
						.toProperty("ticketid").map(svfte).toProperty("svfte").map(impactedCis)
						.toProperty("impactedCis").map(totalImpactedCis).toProperty("totalImpactedCis")
						.map(totalExecutionTime).toProperty("totalExecutionTime"));
	}

	/**
	 * Insert selective.
	 *
	 * @param record the record
	 * @return the int
	 */
	default int insertSelective(Indicator record) {
		return MyBatis3Utils.insert(this::insert, record, indicator,
				c -> c.map(time).toPropertyWhenPresent("time", record::getTime).map(autid)
						.toPropertyWhenPresent("autid", record::getAutid).map(autotime)
						.toPropertyWhenPresent("autotime", record::getAutotime).map(svtime)
						.toPropertyWhenPresent("svtime", record::getSvtime).map(transactionid)
						.toPropertyWhenPresent("transactionid", record::getTransactionid).map(ticketid)
						.toPropertyWhenPresent("ticketid", record::getTicketid).map(svfte)
						.toPropertyWhenPresent("svfte", record::getSvfte).map(impactedCis)
						.toPropertyWhenPresent("impactedCis", record::getImpactedCis).map(totalImpactedCis)
						.toPropertyWhenPresent("totalImpactedCis", record::getTotalImpactedCis).map(totalExecutionTime)
						.toPropertyWhenPresent("totalExecutionTime", record::getTotalExecutionTime));
	}

	/**
	 * Select one.
	 *
	 * @param completer the completer
	 * @return the optional
	 */
	default Optional<Indicator> selectOne(SelectDSLCompleter completer) {
		return MyBatis3Utils.selectOne(this::selectOne, selectList, indicator, completer);
	}

	/**
	 * Select.
	 *
	 * @param completer the completer
	 * @return the list
	 */
	default List<Indicator> select(SelectDSLCompleter completer) {
		return MyBatis3Utils.selectList(this::selectMany, selectList, indicator, completer);
	}

	/**
	 * Select distinct.
	 *
	 * @param completer the completer
	 * @return the list
	 */
	default List<Indicator> selectDistinct(SelectDSLCompleter completer) {
		return MyBatis3Utils.selectDistinct(this::selectMany, selectList, indicator, completer);
	}

	/**
	 * Select by primary key.
	 *
	 * @param id_ the id
	 * @return the optional
	 */
	default Optional<Indicator> selectByPrimaryKey(Long id_) {
		return selectOne(c -> c.where(id, isEqualTo(id_)));
	}

	/**
	 * Update.
	 *
	 * @param completer the completer
	 * @return the int
	 */
	default int update(UpdateDSLCompleter completer) {
		return MyBatis3Utils.update(this::update, indicator, completer);
	}

	/**
	 * Update all columns.
	 *
	 * @param record the record
	 * @param dsl    the dsl
	 * @return the update DSL
	 */
	static UpdateDSL<UpdateModel> updateAllColumns(Indicator record, UpdateDSL<UpdateModel> dsl) {
		return dsl.set(time).equalTo(record::getTime).set(autid).equalTo(record::getAutid).set(autotime)
				.equalTo(record::getAutotime).set(svtime).equalTo(record::getSvtime).set(transactionid)
				.equalTo(record::getTransactionid).set(ticketid).equalTo(record::getTicketid).set(svfte)
				.equalTo(record::getSvfte).set(impactedCis).equalTo(record::getImpactedCis).set(totalImpactedCis)
				.equalTo(record::getTotalImpactedCis).set(totalExecutionTime).equalTo(record::getTotalExecutionTime);
	}

	/**
	 * Update selective columns.
	 *
	 * @param record the record
	 * @param dsl    the dsl
	 * @return the update DSL
	 */
	static UpdateDSL<UpdateModel> updateSelectiveColumns(Indicator record, UpdateDSL<UpdateModel> dsl) {
		return dsl.set(time).equalToWhenPresent(record::getTime).set(autid).equalToWhenPresent(record::getAutid)
				.set(autotime).equalToWhenPresent(record::getAutotime).set(svtime).equalToWhenPresent(record::getSvtime)
				.set(transactionid).equalToWhenPresent(record::getTransactionid).set(ticketid)
				.equalToWhenPresent(record::getTicketid).set(svfte).equalToWhenPresent(record::getSvfte)
				.set(impactedCis).equalToWhenPresent(record::getImpactedCis).set(totalImpactedCis)
				.equalToWhenPresent(record::getTotalImpactedCis).set(totalExecutionTime)
				.equalToWhenPresent(record::getTotalExecutionTime);
	}

	/**
	 * Update by primary key.
	 *
	 * @param record the record
	 * @return the int
	 */
	default int updateByPrimaryKey(Indicator record) {
		return update(c -> c.set(time).equalTo(record::getTime).set(autid).equalTo(record::getAutid).set(autotime)
				.equalTo(record::getAutotime).set(svtime).equalTo(record::getSvtime).set(transactionid)
				.equalTo(record::getTransactionid).set(ticketid).equalTo(record::getTicketid).set(svfte)
				.equalTo(record::getSvfte).set(impactedCis).equalTo(record::getImpactedCis).set(totalImpactedCis)
				.equalTo(record::getTotalImpactedCis).set(totalExecutionTime).equalTo(record::getTotalExecutionTime)
				.where(id, isEqualTo(record::getId)));
	}

	/**
	 * Update by primary key selective.
	 *
	 * @param record the record
	 * @return the int
	 */
	default int updateByPrimaryKeySelective(Indicator record) {
		return update(c -> c.set(time).equalToWhenPresent(record::getTime).set(autid)
				.equalToWhenPresent(record::getAutid).set(autotime).equalToWhenPresent(record::getAutotime).set(svtime)
				.equalToWhenPresent(record::getSvtime).set(transactionid).equalToWhenPresent(record::getTransactionid)
				.set(ticketid).equalToWhenPresent(record::getTicketid).set(svfte).equalToWhenPresent(record::getSvfte)
				.set(impactedCis).equalToWhenPresent(record::getImpactedCis).set(totalImpactedCis)
				.equalToWhenPresent(record::getTotalImpactedCis).set(totalExecutionTime)
				.equalToWhenPresent(record::getTotalExecutionTime).where(id, isEqualTo(record::getId)));
	}
}