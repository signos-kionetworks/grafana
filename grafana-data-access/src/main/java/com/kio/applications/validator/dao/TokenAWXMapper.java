/*
* ****************************************************
* * Grafana *
* * KIO Networks *
* * @Author Julio Galindo *
* ****************************************************
*/
package com.kio.applications.validator.dao;

import static com.kio.applications.validator.dao.TokenAWXDynamicSqlSupport.id;
import static com.kio.applications.validator.dao.TokenAWXDynamicSqlSupport.idArea;
import static com.kio.applications.validator.dao.TokenAWXDynamicSqlSupport.token;
import static com.kio.applications.validator.dao.TokenAWXDynamicSqlSupport.tokenAWX;
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

import com.kio.applications.validator.model.TokenAWX;

/**
 * The Interface TokenAWXMapper.
 */
@Mapper
public interface TokenAWXMapper {

	/** The select list. */
	BasicColumn[] selectList = BasicColumn.columnList(id, token, idArea);

	/**
	 * Update all columns.
	 *
	 * @param record the record
	 * @param dsl    the dsl
	 * @return the update DSL
	 */
	static UpdateDSL<UpdateModel> updateAllColumns(TokenAWX record, UpdateDSL<UpdateModel> dsl) {
		return dsl.set(token).equalTo(record::getToken).set(idArea).equalTo(record::getIdArea);
	}

	/**
	 * Update selective columns.
	 *
	 * @param record the record
	 * @param dsl    the dsl
	 * @return the update DSL
	 */
	static UpdateDSL<UpdateModel> updateSelectiveColumns(TokenAWX record, UpdateDSL<UpdateModel> dsl) {
		return dsl.set(token).equalToWhenPresent(record::getToken).set(idArea).equalToWhenPresent(record::getIdArea);
	}

	/**
	 * Count.
	 *
	 * @param completer the completer
	 * @return the long
	 */
	default long count(CountDSLCompleter completer) {
		return MyBatis3Utils.countFrom(this::count, tokenAWX, completer);
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
		return MyBatis3Utils.deleteFrom(this::delete, tokenAWX, completer);
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
	int insert(InsertStatementProvider<TokenAWX> insertStatement);

	/**
	 * Insert.
	 *
	 * @param record the record
	 * @return the int
	 */
	default int insert(TokenAWX record) {
		return MyBatis3Utils.insert(this::insert, record, tokenAWX,
				c -> c.map(token).toProperty("token").map(idArea).toProperty("idArea"));
	}

	/**
	 * Insert multiple.
	 *
	 * @param records the records
	 * @return the int
	 */
	default int insertMultiple(Collection<TokenAWX> records) {
		return MyBatis3Utils.insertMultiple(this::insertMultiple, records, tokenAWX,
				c -> c.map(token).toProperty("token").map(idArea).toProperty("idArea"));
	}

	/**
	 * Insert multiple.
	 *
	 * @param multipleInsertStatement the multiple insert statement
	 * @return the int
	 */
	default int insertMultiple(MultiRowInsertStatementProvider<TokenAWX> multipleInsertStatement) {
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
	int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<TokenAWX> records);

	/**
	 * Insert selective.
	 *
	 * @param record the record
	 * @return the int
	 */
	default int insertSelective(TokenAWX record) {
		return MyBatis3Utils.insert(this::insert, record, tokenAWX,
				c -> c.map(token).toPropertyWhenPresent("token", record::getToken).map(idArea)
						.toPropertyWhenPresent("idArea", record::getIdArea));
	}

	/**
	 * Select.
	 *
	 * @param completer the completer
	 * @return the list
	 */
	default List<TokenAWX> select(SelectDSLCompleter completer) {
		return MyBatis3Utils.selectList(this::selectMany, selectList, tokenAWX, completer);
	}

	/**
	 * Select by primary key.
	 *
	 * @param id_ the id
	 * @return the optional
	 */
	default Optional<TokenAWX> selectByPrimaryKey(Integer id_) {
		return selectOne(c -> c.where(id, isEqualTo(id_)));
	}

	/**
	 * Select distinct.
	 *
	 * @param completer the completer
	 * @return the list
	 */
	default List<TokenAWX> selectDistinct(SelectDSLCompleter completer) {
		return MyBatis3Utils.selectDistinct(this::selectMany, selectList, tokenAWX, completer);
	}

	/**
	 * Select many.
	 *
	 * @param selectStatement the select statement
	 * @return the list
	 */
	@SelectProvider(type = SqlProviderAdapter.class, method = "select")
	@Results(
			id = "TokenAWXResult",
			value = { @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
					@Result(column = "token", property = "token", jdbcType = JdbcType.VARCHAR),
					@Result(column = "id_area", property = "idArea", jdbcType = JdbcType.INTEGER) })
	List<TokenAWX> selectMany(SelectStatementProvider selectStatement);

	/**
	 * Select one.
	 *
	 * @param completer the completer
	 * @return the optional
	 */
	default Optional<TokenAWX> selectOne(SelectDSLCompleter completer) {
		return MyBatis3Utils.selectOne(this::selectOne, selectList, tokenAWX, completer);
	}

	/**
	 * Select one.
	 *
	 * @param selectStatement the select statement
	 * @return the optional
	 */
	@SelectProvider(type = SqlProviderAdapter.class, method = "select")
	@ResultMap("TokenAWXResult")
	Optional<TokenAWX> selectOne(SelectStatementProvider selectStatement);

	/**
	 * Update.
	 *
	 * @param completer the completer
	 * @return the int
	 */
	default int update(UpdateDSLCompleter completer) {
		return MyBatis3Utils.update(this::update, tokenAWX, completer);
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
	default int updateByPrimaryKey(TokenAWX record) {
		return update(c -> c.set(token).equalTo(record::getToken).set(idArea).equalTo(record::getIdArea).where(id,
				isEqualTo(record::getId)));
	}

	/**
	 * Update by primary key selective.
	 *
	 * @param record the record
	 * @return the int
	 */
	default int updateByPrimaryKeySelective(TokenAWX record) {
		return update(c -> c.set(token).equalToWhenPresent(record::getToken).set(idArea)
				.equalToWhenPresent(record::getIdArea).where(id, isEqualTo(record::getId)));
	}
}