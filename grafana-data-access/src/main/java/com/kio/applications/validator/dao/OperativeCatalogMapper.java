/*
* ****************************************************
* * Grafana *
* * KIO Networks *
* * @Author Julio Galindo *
* ****************************************************
*/
package com.kio.applications.validator.dao;

import static com.kio.applications.validator.dao.OperativeCatalogDynamicSqlSupport.automatizable;
import static com.kio.applications.validator.dao.OperativeCatalogDynamicSqlSupport.catalogo;
import static com.kio.applications.validator.dao.OperativeCatalogDynamicSqlSupport.catnivel1;
import static com.kio.applications.validator.dao.OperativeCatalogDynamicSqlSupport.catnivel2;
import static com.kio.applications.validator.dao.OperativeCatalogDynamicSqlSupport.catnivel3;
import static com.kio.applications.validator.dao.OperativeCatalogDynamicSqlSupport.id;
import static com.kio.applications.validator.dao.OperativeCatalogDynamicSqlSupport.operativeCatalog;
import static com.kio.applications.validator.dao.OperativeCatalogDynamicSqlSupport.producto;
import static com.kio.applications.validator.dao.OperativeCatalogDynamicSqlSupport.tiempominutos;
import static com.kio.applications.validator.dao.OperativeCatalogDynamicSqlSupport.tipo;
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

import com.kio.applications.validator.model.OperativeCatalog;

/**
 * The Interface OperativeCatalogMapper.
 */
@Mapper
public interface OperativeCatalogMapper {

	/** The select list. */
	BasicColumn[] selectList = BasicColumn.columnList(id, catalogo, catnivel1, catnivel2, catnivel3, producto, tipo,
			automatizable, tiempominutos);

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
	int insert(InsertStatementProvider<OperativeCatalog> insertStatement);

	/**
	 * Insert multiple.
	 *
	 * @param multipleInsertStatement the multiple insert statement
	 * @return the int
	 */
	@InsertProvider(type = SqlProviderAdapter.class, method = "insertMultiple")
	int insertMultiple(MultiRowInsertStatementProvider<OperativeCatalog> multipleInsertStatement);

	/**
	 * Select one.
	 *
	 * @param selectStatement the select statement
	 * @return the optional
	 */
	@SelectProvider(type = SqlProviderAdapter.class, method = "select")
	@ResultMap("OperativeCatalogResult")
	Optional<OperativeCatalog> selectOne(SelectStatementProvider selectStatement);

	/**
	 * Select many.
	 *
	 * @param selectStatement the select statement
	 * @return the list
	 */
	@SelectProvider(type = SqlProviderAdapter.class, method = "select")
	@Results(id = "OperativeCatalogResult", value = {
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "catalogo", property = "catalogo", jdbcType = JdbcType.INTEGER),
			@Result(column = "catnivel1", property = "catnivel1", jdbcType = JdbcType.INTEGER),
			@Result(column = "catnivel2", property = "catnivel2", jdbcType = JdbcType.INTEGER),
			@Result(column = "catnivel3", property = "catnivel3", jdbcType = JdbcType.INTEGER),
			@Result(column = "producto", property = "producto", jdbcType = JdbcType.INTEGER),
			@Result(column = "tipo", property = "tipo", jdbcType = JdbcType.INTEGER),
			@Result(column = "automatizable", property = "automatizable", jdbcType = JdbcType.BIT),
			@Result(column = "tiempominutos", property = "tiempominutos", jdbcType = JdbcType.REAL) })
	List<OperativeCatalog> selectMany(SelectStatementProvider selectStatement);

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
		return MyBatis3Utils.countFrom(this::count, operativeCatalog, completer);
	}

	/**
	 * Delete.
	 *
	 * @param completer the completer
	 * @return the int
	 */
	default int delete(DeleteDSLCompleter completer) {
		return MyBatis3Utils.deleteFrom(this::delete, operativeCatalog, completer);
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
	default int insert(OperativeCatalog record) {
		return MyBatis3Utils.insert(this::insert, record, operativeCatalog,
				c -> c.map(id).toProperty("id").map(catalogo).toProperty("catalogo").map(catnivel1)
						.toProperty("catnivel1").map(catnivel2).toProperty("catnivel2").map(catnivel3)
						.toProperty("catnivel3").map(producto).toProperty("producto").map(tipo).toProperty("tipo")
						.map(automatizable).toProperty("automatizable").map(tiempominutos).toProperty("tiempominutos"));
	}

	/**
	 * Insert multiple.
	 *
	 * @param records the records
	 * @return the int
	 */
	default int insertMultiple(Collection<OperativeCatalog> records) {
		return MyBatis3Utils.insertMultiple(this::insertMultiple, records, operativeCatalog,
				c -> c.map(id).toProperty("id").map(catalogo).toProperty("catalogo").map(catnivel1)
						.toProperty("catnivel1").map(catnivel2).toProperty("catnivel2").map(catnivel3)
						.toProperty("catnivel3").map(producto).toProperty("producto").map(tipo).toProperty("tipo")
						.map(automatizable).toProperty("automatizable").map(tiempominutos).toProperty("tiempominutos"));
	}

	/**
	 * Insert selective.
	 *
	 * @param record the record
	 * @return the int
	 */
	default int insertSelective(OperativeCatalog record) {
		return MyBatis3Utils.insert(this::insert, record, operativeCatalog,
				c -> c.map(id).toPropertyWhenPresent("id", record::getId).map(catalogo)
						.toPropertyWhenPresent("catalogo", record::getCatalogo).map(catnivel1)
						.toPropertyWhenPresent("catnivel1", record::getCatnivel1).map(catnivel2)
						.toPropertyWhenPresent("catnivel2", record::getCatnivel2).map(catnivel3)
						.toPropertyWhenPresent("catnivel3", record::getCatnivel3).map(producto)
						.toPropertyWhenPresent("producto", record::getProducto).map(tipo)
						.toPropertyWhenPresent("tipo", record::getTipo).map(automatizable)
						.toPropertyWhenPresent("automatizable", record::getAutomatizable).map(tiempominutos)
						.toPropertyWhenPresent("tiempominutos", record::getTiempominutos));
	}

	/**
	 * Select one.
	 *
	 * @param completer the completer
	 * @return the optional
	 */
	default Optional<OperativeCatalog> selectOne(SelectDSLCompleter completer) {
		return MyBatis3Utils.selectOne(this::selectOne, selectList, operativeCatalog, completer);
	}

	/**
	 * Select.
	 *
	 * @param completer the completer
	 * @return the list
	 */
	default List<OperativeCatalog> select(SelectDSLCompleter completer) {
		return MyBatis3Utils.selectList(this::selectMany, selectList, operativeCatalog, completer);
	}

	/**
	 * Select distinct.
	 *
	 * @param completer the completer
	 * @return the list
	 */
	default List<OperativeCatalog> selectDistinct(SelectDSLCompleter completer) {
		return MyBatis3Utils.selectDistinct(this::selectMany, selectList, operativeCatalog, completer);
	}

	/**
	 * Select by primary key.
	 *
	 * @param id_ the id
	 * @return the optional
	 */
	default Optional<OperativeCatalog> selectByPrimaryKey(Integer id_) {
		return selectOne(c -> c.where(id, isEqualTo(id_)));
	}

	/**
	 * Update.
	 *
	 * @param completer the completer
	 * @return the int
	 */
	default int update(UpdateDSLCompleter completer) {
		return MyBatis3Utils.update(this::update, operativeCatalog, completer);
	}

	/**
	 * Update all columns.
	 *
	 * @param record the record
	 * @param dsl    the dsl
	 * @return the update DSL
	 */
	static UpdateDSL<UpdateModel> updateAllColumns(OperativeCatalog record, UpdateDSL<UpdateModel> dsl) {
		return dsl.set(id).equalTo(record::getId).set(catalogo).equalTo(record::getCatalogo).set(catnivel1)
				.equalTo(record::getCatnivel1).set(catnivel2).equalTo(record::getCatnivel2).set(catnivel3)
				.equalTo(record::getCatnivel3).set(producto).equalTo(record::getProducto).set(tipo)
				.equalTo(record::getTipo).set(automatizable).equalTo(record::getAutomatizable).set(tiempominutos)
				.equalTo(record::getTiempominutos);
	}

	/**
	 * Update selective columns.
	 *
	 * @param record the record
	 * @param dsl    the dsl
	 * @return the update DSL
	 */
	static UpdateDSL<UpdateModel> updateSelectiveColumns(OperativeCatalog record, UpdateDSL<UpdateModel> dsl) {
		return dsl.set(id).equalToWhenPresent(record::getId).set(catalogo).equalToWhenPresent(record::getCatalogo)
				.set(catnivel1).equalToWhenPresent(record::getCatnivel1).set(catnivel2)
				.equalToWhenPresent(record::getCatnivel2).set(catnivel3).equalToWhenPresent(record::getCatnivel3)
				.set(producto).equalToWhenPresent(record::getProducto).set(tipo).equalToWhenPresent(record::getTipo)
				.set(automatizable).equalToWhenPresent(record::getAutomatizable).set(tiempominutos)
				.equalToWhenPresent(record::getTiempominutos);
	}

	/**
	 * Update by primary key.
	 *
	 * @param record the record
	 * @return the int
	 */
	default int updateByPrimaryKey(OperativeCatalog record) {
		return update(c -> c.set(catalogo).equalTo(record::getCatalogo).set(catnivel1).equalTo(record::getCatnivel1)
				.set(catnivel2).equalTo(record::getCatnivel2).set(catnivel3).equalTo(record::getCatnivel3).set(producto)
				.equalTo(record::getProducto).set(tipo).equalTo(record::getTipo).set(automatizable)
				.equalTo(record::getAutomatizable).set(tiempominutos).equalTo(record::getTiempominutos)
				.where(id, isEqualTo(record::getId)));
	}

	/**
	 * Update by primary key selective.
	 *
	 * @param record the record
	 * @return the int
	 */
	default int updateByPrimaryKeySelective(OperativeCatalog record) {
		return update(c -> c.set(catalogo).equalToWhenPresent(record::getCatalogo).set(catnivel1)
				.equalToWhenPresent(record::getCatnivel1).set(catnivel2).equalToWhenPresent(record::getCatnivel2)
				.set(catnivel3).equalToWhenPresent(record::getCatnivel3).set(producto)
				.equalToWhenPresent(record::getProducto).set(tipo).equalToWhenPresent(record::getTipo)
				.set(automatizable).equalToWhenPresent(record::getAutomatizable).set(tiempominutos)
				.equalToWhenPresent(record::getTiempominutos).where(id, isEqualTo(record::getId)));
	}
}