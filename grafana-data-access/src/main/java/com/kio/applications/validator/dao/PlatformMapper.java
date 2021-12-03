/*
* ****************************************************
* * Grafana *
* * KIO Networks *
* * @Author Julio Galindo *
* ****************************************************
*/
package com.kio.applications.validator.dao;

import static com.kio.applications.validator.dao.PlatformDynamicSqlSupport.descr;
import static com.kio.applications.validator.dao.PlatformDynamicSqlSupport.id;
import static com.kio.applications.validator.dao.PlatformDynamicSqlSupport.name;
import static com.kio.applications.validator.dao.PlatformDynamicSqlSupport.platform;
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

import com.kio.applications.validator.model.Platform;

/**
 * The Interface PlatformMapper.
 */
@Mapper
public interface PlatformMapper {

	/** The select list. */
	BasicColumn[] selectList = BasicColumn.columnList(id, name, descr);

	/**
	 * Update all columns.
	 *
	 * @param record the record
	 * @param dsl    the dsl
	 * @return the update DSL
	 */
	static UpdateDSL<UpdateModel> updateAllColumns(Platform record, UpdateDSL<UpdateModel> dsl) {
		return dsl.set(name).equalTo(record::getName).set(descr).equalTo(record::getDescr);
	}

	/**
	 * Update selective columns.
	 *
	 * @param record the record
	 * @param dsl    the dsl
	 * @return the update DSL
	 */
	static UpdateDSL<UpdateModel> updateSelectiveColumns(Platform record, UpdateDSL<UpdateModel> dsl) {
		return dsl.set(name).equalToWhenPresent(record::getName).set(descr).equalToWhenPresent(record::getDescr);
	}

	/**
	 * Count.
	 *
	 * @param completer the completer
	 * @return the long
	 */
	default long count(CountDSLCompleter completer) {
		return MyBatis3Utils.countFrom(this::count, platform, completer);
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
		return MyBatis3Utils.deleteFrom(this::delete, platform, completer);
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
	int insert(InsertStatementProvider<Platform> insertStatement);

	/**
	 * Insert.
	 *
	 * @param record the record
	 * @return the int
	 */
	default int insert(Platform record) {
		return MyBatis3Utils.insert(this::insert, record, platform,
				c -> c.map(name).toProperty("name").map(descr).toProperty("descr"));
	}

	/**
	 * Insert multiple.
	 *
	 * @param records the records
	 * @return the int
	 */
	default int insertMultiple(Collection<Platform> records) {
		return MyBatis3Utils.insertMultiple(this::insertMultiple, records, platform,
				c -> c.map(name).toProperty("name").map(descr).toProperty("descr"));
	}

	/**
	 * Insert multiple.
	 *
	 * @param multipleInsertStatement the multiple insert statement
	 * @return the int
	 */
	default int insertMultiple(MultiRowInsertStatementProvider<Platform> multipleInsertStatement) {
		return insertMultiple(multipleInsertStatement.getInsertStatement(), multipleInsertStatement.getRecords());
	}

	/**
	 * Insert multiple.
	 *
	 * @param insertStatement the insert statement
	 * @param records         the records
	 * @return the int
	 */
	@Insert({ "${insertStatement}" })
	@Options(useGeneratedKeys = true, keyProperty = "records.id")
	int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<Platform> records);

	/**
	 * Insert selective.
	 *
	 * @param record the record
	 * @return the int
	 */
	default int insertSelective(Platform record) {
		return MyBatis3Utils.insert(this::insert, record, platform,
				c -> c.map(name).toPropertyWhenPresent("name", record::getName).map(descr)
						.toPropertyWhenPresent("descr", record::getDescr));
	}

	/**
	 * Select.
	 *
	 * @param completer the completer
	 * @return the list
	 */
	default List<Platform> select(SelectDSLCompleter completer) {
		return MyBatis3Utils.selectList(this::selectMany, selectList, platform, completer);
	}

	/**
	 * Select by primary key.
	 *
	 * @param id_ the id
	 * @return the optional
	 */
	default Optional<Platform> selectByPrimaryKey(Integer id_) {
		return selectOne(c -> c.where(id, isEqualTo(id_)));
	}

	/**
	 * Select distinct.
	 *
	 * @param completer the completer
	 * @return the list
	 */
	default List<Platform> selectDistinct(SelectDSLCompleter completer) {
		return MyBatis3Utils.selectDistinct(this::selectMany, selectList, platform, completer);
	}

	/**
	 * Select many.
	 *
	 * @param selectStatement the select statement
	 * @return the list
	 */
	@SelectProvider(type = SqlProviderAdapter.class, method = "select")
	@Results(
			id = "PlatformResult",
			value = { @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
					@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
					@Result(column = "descr", property = "descr", jdbcType = JdbcType.VARCHAR) })
	List<Platform> selectMany(SelectStatementProvider selectStatement);

	/**
	 * Select one.
	 *
	 * @param completer the completer
	 * @return the optional
	 */
	default Optional<Platform> selectOne(SelectDSLCompleter completer) {
		return MyBatis3Utils.selectOne(this::selectOne, selectList, platform, completer);
	}

	/**
	 * Select one.
	 *
	 * @param selectStatement the select statement
	 * @return the optional
	 */
	@SelectProvider(type = SqlProviderAdapter.class, method = "select")
	@ResultMap("PlatformResult")
	Optional<Platform> selectOne(SelectStatementProvider selectStatement);

	/**
	 * Update.
	 *
	 * @param completer the completer
	 * @return the int
	 */
	default int update(UpdateDSLCompleter completer) {
		return MyBatis3Utils.update(this::update, platform, completer);
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
	default int updateByPrimaryKey(Platform record) {
		return update(c -> c.set(name).equalTo(record::getName).set(descr).equalTo(record::getDescr).where(id,
				isEqualTo(record::getId)));
	}

	/**
	 * Update by primary key selective.
	 *
	 * @param record the record
	 * @return the int
	 */
	default int updateByPrimaryKeySelective(Platform record) {
		return update(c -> c.set(name).equalToWhenPresent(record::getName).set(descr)
				.equalToWhenPresent(record::getDescr).where(id, isEqualTo(record::getId)));
	}
}