/*
* ****************************************************
* * Grafana *
* * KIO Networks *
* * @Author Julio Galindo *
* ****************************************************
*/
package com.kio.applications.validator.dao;

import static com.kio.applications.validator.dao.TypeTicketDynamicSqlSupport.descr;
import static com.kio.applications.validator.dao.TypeTicketDynamicSqlSupport.id;
import static com.kio.applications.validator.dao.TypeTicketDynamicSqlSupport.name;
import static com.kio.applications.validator.dao.TypeTicketDynamicSqlSupport.typeTicket;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
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

import com.kio.applications.validator.model.TypeTicket;

/**
 * The Interface TypeTicketMapper.
 */
@Mapper
public interface TypeTicketMapper {

	/** The select list. */
	BasicColumn[] selectList = BasicColumn.columnList(id, name, descr);

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
	int insert(InsertStatementProvider<TypeTicket> insertStatement);

	/**
	 * Insert multiple.
	 *
	 * @param multipleInsertStatement the multiple insert statement
	 * @return the int
	 */
	@InsertProvider(type = SqlProviderAdapter.class, method = "insertMultiple")
	int insertMultiple(MultiRowInsertStatementProvider<TypeTicket> multipleInsertStatement);

	/**
	 * Select one.
	 *
	 * @param selectStatement the select statement
	 * @return the optional
	 */
	@SelectProvider(type = SqlProviderAdapter.class, method = "select")
	@ResultMap("TypeTicketResult")
	Optional<TypeTicket> selectOne(SelectStatementProvider selectStatement);

	/**
	 * Select many.
	 *
	 * @param selectStatement the select statement
	 * @return the list
	 */
	@SelectProvider(type = SqlProviderAdapter.class, method = "select")
	@Results(id = "TypeTicketResult", value = {
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
			@Result(column = "descr", property = "descr", jdbcType = JdbcType.VARCHAR) })
	List<TypeTicket> selectMany(SelectStatementProvider selectStatement);

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
		return MyBatis3Utils.countFrom(this::count, typeTicket, completer);
	}

	/**
	 * Delete.
	 *
	 * @param completer the completer
	 * @return the int
	 */
	default int delete(DeleteDSLCompleter completer) {
		return MyBatis3Utils.deleteFrom(this::delete, typeTicket, completer);
	}

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
	 * @param record the record
	 * @return the int
	 */
	default int insert(TypeTicket record) {
		return MyBatis3Utils.insert(this::insert, record, typeTicket,
				c -> c.map(id).toProperty("id").map(name).toProperty("name").map(descr).toProperty("descr"));
	}

	/**
	 * Insert multiple.
	 *
	 * @param records the records
	 * @return the int
	 */
	default int insertMultiple(Collection<TypeTicket> records) {
		return MyBatis3Utils.insertMultiple(this::insertMultiple, records, typeTicket,
				c -> c.map(id).toProperty("id").map(name).toProperty("name").map(descr).toProperty("descr"));
	}

	/**
	 * Insert selective.
	 *
	 * @param record the record
	 * @return the int
	 */
	default int insertSelective(TypeTicket record) {
		return MyBatis3Utils.insert(this::insert, record, typeTicket,
				c -> c.map(id).toPropertyWhenPresent("id", record::getId).map(name)
						.toPropertyWhenPresent("name", record::getName).map(descr)
						.toPropertyWhenPresent("descr", record::getDescr));
	}

	/**
	 * Select one.
	 *
	 * @param completer the completer
	 * @return the optional
	 */
	default Optional<TypeTicket> selectOne(SelectDSLCompleter completer) {
		return MyBatis3Utils.selectOne(this::selectOne, selectList, typeTicket, completer);
	}

	/**
	 * Select.
	 *
	 * @param completer the completer
	 * @return the list
	 */
	default List<TypeTicket> select(SelectDSLCompleter completer) {
		return MyBatis3Utils.selectList(this::selectMany, selectList, typeTicket, completer);
	}

	/**
	 * Select distinct.
	 *
	 * @param completer the completer
	 * @return the list
	 */
	default List<TypeTicket> selectDistinct(SelectDSLCompleter completer) {
		return MyBatis3Utils.selectDistinct(this::selectMany, selectList, typeTicket, completer);
	}

	/**
	 * Select by primary key.
	 *
	 * @param id_ the id
	 * @return the optional
	 */
	default Optional<TypeTicket> selectByPrimaryKey(Integer id_) {
		return selectOne(c -> c.where(id, isEqualTo(id_)));
	}

	/**
	 * Update.
	 *
	 * @param completer the completer
	 * @return the int
	 */
	default int update(UpdateDSLCompleter completer) {
		return MyBatis3Utils.update(this::update, typeTicket, completer);
	}

	/**
	 * Update all columns.
	 *
	 * @param record the record
	 * @param dsl    the dsl
	 * @return the update DSL
	 */
	static UpdateDSL<UpdateModel> updateAllColumns(TypeTicket record, UpdateDSL<UpdateModel> dsl) {
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
	static UpdateDSL<UpdateModel> updateSelectiveColumns(TypeTicket record, UpdateDSL<UpdateModel> dsl) {
		return dsl.set(id).equalToWhenPresent(record::getId).set(name).equalToWhenPresent(record::getName).set(descr)
				.equalToWhenPresent(record::getDescr);
	}

	/**
	 * Update by primary key.
	 *
	 * @param record the record
	 * @return the int
	 */
	default int updateByPrimaryKey(TypeTicket record) {
		return update(c -> c.set(name).equalTo(record::getName).set(descr).equalTo(record::getDescr).where(id,
				isEqualTo(record::getId)));
	}

	/**
	 * Update by primary key selective.
	 *
	 * @param record the record
	 * @return the int
	 */
	default int updateByPrimaryKeySelective(TypeTicket record) {
		return update(c -> c.set(name).equalToWhenPresent(record::getName).set(descr)
				.equalToWhenPresent(record::getDescr).where(id, isEqualTo(record::getId)));
	}
}