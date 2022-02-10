/*
* ****************************************************
* * Grafana *
* * KIO Networks *
* * @Author Julio Galindo *
* ****************************************************
*/
package com.kio.applications.validator.dao;

import static com.kio.applications.validator.dao.EquivalenceClientOrganizationDynamicSqlSupport.equivalenceClientOrganization;
import static com.kio.applications.validator.dao.EquivalenceClientOrganizationDynamicSqlSupport.idCliente;
import static com.kio.applications.validator.dao.EquivalenceClientOrganizationDynamicSqlSupport.idOrganizacionAwx;
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

import com.kio.applications.validator.model.EquivalenceClientOrganization;

/**
 * The Interface EquivalenceClientOrganizationMapper.
 */
@Mapper
public interface EquivalenceClientOrganizationMapper {

	/** The select list. */
	BasicColumn[] selectList = BasicColumn.columnList(idCliente, idOrganizacionAwx);

	/**
	 * Update all columns.
	 *
	 * @param record the record
	 * @param dsl    the dsl
	 * @return the update DSL
	 */
	static UpdateDSL<UpdateModel> updateAllColumns(EquivalenceClientOrganization record, UpdateDSL<UpdateModel> dsl) {
		return dsl.set(idCliente).equalTo(record::getIdCliente).set(idOrganizacionAwx)
				.equalTo(record::getIdOrganizacionAwx);
	}

	/**
	 * Update selective columns.
	 *
	 * @param record the record
	 * @param dsl    the dsl
	 * @return the update DSL
	 */
	static UpdateDSL<UpdateModel> updateSelectiveColumns(EquivalenceClientOrganization record,
			UpdateDSL<UpdateModel> dsl) {
		return dsl.set(idCliente).equalToWhenPresent(record::getIdCliente).set(idOrganizacionAwx)
				.equalToWhenPresent(record::getIdOrganizacionAwx);
	}

	/**
	 * Count.
	 *
	 * @param completer the completer
	 * @return the long
	 */
	default long count(CountDSLCompleter completer) {
		return MyBatis3Utils.countFrom(this::count, equivalenceClientOrganization, completer);
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
		return MyBatis3Utils.deleteFrom(this::delete, equivalenceClientOrganization, completer);
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
	 * @param idCliente_         the id cliente
	 * @param idOrganizacionAwx_ the id organizacion awx
	 * @return the int
	 */
	default int deleteByPrimaryKey(Integer idCliente_, Integer idOrganizacionAwx_) {
		return delete(
				c -> c.where(idCliente, isEqualTo(idCliente_)).and(idOrganizacionAwx, isEqualTo(idOrganizacionAwx_)));
	}

	/**
	 * Insert.
	 *
	 * @param record the record
	 * @return the int
	 */
	default int insert(EquivalenceClientOrganization record) {
		return MyBatis3Utils.insert(this::insert, record, equivalenceClientOrganization,
				c -> c.map(idCliente).toProperty("idCliente").map(idOrganizacionAwx).toProperty("idOrganizacionAwx"));
	}

	/**
	 * Insert.
	 *
	 * @param insertStatement the insert statement
	 * @return the int
	 */
	@InsertProvider(type = SqlProviderAdapter.class, method = "insert")
	int insert(InsertStatementProvider<EquivalenceClientOrganization> insertStatement);

	/**
	 * Insert multiple.
	 *
	 * @param records the records
	 * @return the int
	 */
	default int insertMultiple(Collection<EquivalenceClientOrganization> records) {
		return MyBatis3Utils.insertMultiple(this::insertMultiple, records, equivalenceClientOrganization,
				c -> c.map(idCliente).toProperty("idCliente").map(idOrganizacionAwx).toProperty("idOrganizacionAwx"));
	}

	/**
	 * Insert multiple.
	 *
	 * @param multipleInsertStatement the multiple insert statement
	 * @return the int
	 */
	@InsertProvider(type = SqlProviderAdapter.class, method = "insertMultiple")
	int insertMultiple(MultiRowInsertStatementProvider<EquivalenceClientOrganization> multipleInsertStatement);

	/**
	 * Insert selective.
	 *
	 * @param record the record
	 * @return the int
	 */
	default int insertSelective(EquivalenceClientOrganization record) {
		return MyBatis3Utils.insert(this::insert, record, equivalenceClientOrganization,
				c -> c.map(idCliente).toPropertyWhenPresent("idCliente", record::getIdCliente).map(idOrganizacionAwx)
						.toPropertyWhenPresent("idOrganizacionAwx", record::getIdOrganizacionAwx));
	}

	/**
	 * Select.
	 *
	 * @param completer the completer
	 * @return the list
	 */
	default List<EquivalenceClientOrganization> select(SelectDSLCompleter completer) {
		return MyBatis3Utils.selectList(this::selectMany, selectList, equivalenceClientOrganization, completer);
	}

	/**
	 * Select distinct.
	 *
	 * @param completer the completer
	 * @return the list
	 */
	default List<EquivalenceClientOrganization> selectDistinct(SelectDSLCompleter completer) {
		return MyBatis3Utils.selectDistinct(this::selectMany, selectList, equivalenceClientOrganization, completer);
	}

	/**
	 * Select many.
	 *
	 * @param selectStatement the select statement
	 * @return the list
	 */
	@SelectProvider(type = SqlProviderAdapter.class, method = "select")
	@Results(
			id = "EquivalenceClientOrganizationResult",
			value = { @Result(column = "id_cliente", property = "idCliente", jdbcType = JdbcType.INTEGER, id = true),
					@Result(
							column = "id_organizacion_awx",
							property = "idOrganizacionAwx",
							jdbcType = JdbcType.INTEGER,
							id = true) })
	List<EquivalenceClientOrganization> selectMany(SelectStatementProvider selectStatement);

	/**
	 * Select one.
	 *
	 * @param completer the completer
	 * @return the optional
	 */
	default Optional<EquivalenceClientOrganization> selectOne(SelectDSLCompleter completer) {
		return MyBatis3Utils.selectOne(this::selectOne, selectList, equivalenceClientOrganization, completer);
	}

	/**
	 * Select one.
	 *
	 * @param selectStatement the select statement
	 * @return the optional
	 */
	@SelectProvider(type = SqlProviderAdapter.class, method = "select")
	@ResultMap("EquivalenceClientOrganizationResult")
	Optional<EquivalenceClientOrganization> selectOne(SelectStatementProvider selectStatement);

	/**
	 * Update.
	 *
	 * @param completer the completer
	 * @return the int
	 */
	default int update(UpdateDSLCompleter completer) {
		return MyBatis3Utils.update(this::update, equivalenceClientOrganization, completer);
	}

	/**
	 * Update.
	 *
	 * @param updateStatement the update statement
	 * @return the int
	 */
	@UpdateProvider(type = SqlProviderAdapter.class, method = "update")
	int update(UpdateStatementProvider updateStatement);
}