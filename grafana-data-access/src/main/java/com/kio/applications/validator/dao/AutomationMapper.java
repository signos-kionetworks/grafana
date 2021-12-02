/*
* ****************************************************
* * Grafana *
* * KIO Networks *
* * @Author Julio Galindo *
* ****************************************************
*/
package com.kio.applications.validator.dao;

import static com.kio.applications.validator.dao.AutomationDynamicSqlSupport.areaid;
import static com.kio.applications.validator.dao.AutomationDynamicSqlSupport.autCreatorArea;
import static com.kio.applications.validator.dao.AutomationDynamicSqlSupport.autCreatorUser;
import static com.kio.applications.validator.dao.AutomationDynamicSqlSupport.autEnabled;
import static com.kio.applications.validator.dao.AutomationDynamicSqlSupport.autoexecs;
import static com.kio.applications.validator.dao.AutomationDynamicSqlSupport.automation;
import static com.kio.applications.validator.dao.AutomationDynamicSqlSupport.botDescr;
import static com.kio.applications.validator.dao.AutomationDynamicSqlSupport.botname;
import static com.kio.applications.validator.dao.AutomationDynamicSqlSupport.catopid;
import static com.kio.applications.validator.dao.AutomationDynamicSqlSupport.clienteid;
import static com.kio.applications.validator.dao.AutomationDynamicSqlSupport.crid;
import static com.kio.applications.validator.dao.AutomationDynamicSqlSupport.devtypeid;
import static com.kio.applications.validator.dao.AutomationDynamicSqlSupport.dirid;
import static com.kio.applications.validator.dao.AutomationDynamicSqlSupport.functionid;
import static com.kio.applications.validator.dao.AutomationDynamicSqlSupport.id;
import static com.kio.applications.validator.dao.AutomationDynamicSqlSupport.impactedCis;
import static com.kio.applications.validator.dao.AutomationDynamicSqlSupport.lastModified;
import static com.kio.applications.validator.dao.AutomationDynamicSqlSupport.manexecs;
import static com.kio.applications.validator.dao.AutomationDynamicSqlSupport.mantime;
import static com.kio.applications.validator.dao.AutomationDynamicSqlSupport.platformid;
import static com.kio.applications.validator.dao.AutomationDynamicSqlSupport.registeredDate;
import static com.kio.applications.validator.dao.AutomationDynamicSqlSupport.specialistid;
import static com.kio.applications.validator.dao.AutomationDynamicSqlSupport.suppgroupid;
import static com.kio.applications.validator.dao.AutomationDynamicSqlSupport.tecnologiaid;
import static com.kio.applications.validator.dao.AutomationDynamicSqlSupport.tipoautid;
import static com.kio.applications.validator.dao.AutomationDynamicSqlSupport.tipociid;
import static com.kio.applications.validator.dao.AutomationDynamicSqlSupport.tipoexecid;
import static com.kio.applications.validator.dao.AutomationDynamicSqlSupport.totalImpactedCis;
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

import com.kio.applications.validator.model.Automation;

/**
 * The Interface AutomationMapper.
 */
@Mapper
public interface AutomationMapper {

	/** The select list. */
	BasicColumn[] selectList = BasicColumn.columnList(id, botname, botDescr, areaid, suppgroupid, specialistid, crid,
			clienteid, platformid, tipoautid, functionid, tipoexecid, tipociid, tecnologiaid, catopid, dirid, devtypeid,
			manexecs, autoexecs, mantime, registeredDate, autCreatorArea, autCreatorUser, lastModified, autEnabled,
			impactedCis, totalImpactedCis);

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
	int insert(InsertStatementProvider<Automation> insertStatement);

	/**
	 * Insert multiple.
	 *
	 * @param insertStatement the insert statement
	 * @param records         the records
	 * @return the int
	 */
	@Insert({ "${insertStatement}" })
	@Options(useGeneratedKeys = true, keyProperty = "records.id")
	int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<Automation> records);

	/**
	 * Insert multiple.
	 *
	 * @param multipleInsertStatement the multiple insert statement
	 * @return the int
	 */
	default int insertMultiple(MultiRowInsertStatementProvider<Automation> multipleInsertStatement) {
		return insertMultiple(multipleInsertStatement.getInsertStatement(), multipleInsertStatement.getRecords());
	}

	/**
	 * Select one.
	 *
	 * @param selectStatement the select statement
	 * @return the optional
	 */
	@SelectProvider(type = SqlProviderAdapter.class, method = "select")
	@ResultMap("AutomationResult")
	Optional<Automation> selectOne(SelectStatementProvider selectStatement);

	/**
	 * Select many.
	 *
	 * @param selectStatement the select statement
	 * @return the list
	 */
	@SelectProvider(type = SqlProviderAdapter.class, method = "select")
	@Results(id = "AutomationResult", value = {
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "botname", property = "botname", jdbcType = JdbcType.VARCHAR),
			@Result(column = "bot_descr", property = "botDescr", jdbcType = JdbcType.VARCHAR),
			@Result(column = "areaid", property = "areaid", jdbcType = JdbcType.INTEGER),
			@Result(column = "suppgroupid", property = "suppgroupid", jdbcType = JdbcType.INTEGER),
			@Result(column = "specialistid", property = "specialistid", jdbcType = JdbcType.INTEGER),
			@Result(column = "crid", property = "crid", jdbcType = JdbcType.INTEGER),
			@Result(column = "clienteid", property = "clienteid", jdbcType = JdbcType.INTEGER),
			@Result(column = "platformid", property = "platformid", jdbcType = JdbcType.INTEGER),
			@Result(column = "tipoautid", property = "tipoautid", jdbcType = JdbcType.INTEGER),
			@Result(column = "functionid", property = "functionid", jdbcType = JdbcType.INTEGER),
			@Result(column = "tipoexecid", property = "tipoexecid", jdbcType = JdbcType.INTEGER),
			@Result(column = "tipociid", property = "tipociid", jdbcType = JdbcType.INTEGER),
			@Result(column = "tecnologiaid", property = "tecnologiaid", jdbcType = JdbcType.INTEGER),
			@Result(column = "catopid", property = "catopid", jdbcType = JdbcType.INTEGER),
			@Result(column = "dirid", property = "dirid", jdbcType = JdbcType.INTEGER),
			@Result(column = "devtypeid", property = "devtypeid", jdbcType = JdbcType.INTEGER),
			@Result(column = "manexecs", property = "manexecs", jdbcType = JdbcType.REAL),
			@Result(column = "autoexecs", property = "autoexecs", jdbcType = JdbcType.REAL),
			@Result(column = "mantime", property = "mantime", jdbcType = JdbcType.REAL),
			@Result(column = "registered_date", property = "registeredDate", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "aut_creator_area", property = "autCreatorArea", jdbcType = JdbcType.VARCHAR),
			@Result(column = "aut_creator_user", property = "autCreatorUser", jdbcType = JdbcType.VARCHAR),
			@Result(column = "last_modified", property = "lastModified", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "aut_enabled", property = "autEnabled", jdbcType = JdbcType.BIT),
			@Result(column = "impacted_cis", property = "impactedCis", jdbcType = JdbcType.INTEGER),
			@Result(column = "total_impacted_cis", property = "totalImpactedCis", jdbcType = JdbcType.INTEGER) })
	List<Automation> selectMany(SelectStatementProvider selectStatement);

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
		return MyBatis3Utils.countFrom(this::count, automation, completer);
	}

	/**
	 * Delete.
	 *
	 * @param completer the completer
	 * @return the int
	 */
	default int delete(DeleteDSLCompleter completer) {
		return MyBatis3Utils.deleteFrom(this::delete, automation, completer);
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
	default int insert(Automation record) {
		return MyBatis3Utils.insert(this::insert, record, automation,
				c -> c.map(botname).toProperty("botname").map(botDescr).toProperty("botDescr").map(areaid)
						.toProperty("areaid").map(suppgroupid).toProperty("suppgroupid").map(specialistid)
						.toProperty("specialistid").map(crid).toProperty("crid").map(clienteid).toProperty("clienteid")
						.map(platformid).toProperty("platformid").map(tipoautid).toProperty("tipoautid").map(functionid)
						.toProperty("functionid").map(tipoexecid).toProperty("tipoexecid").map(tipociid)
						.toProperty("tipociid").map(tecnologiaid).toProperty("tecnologiaid").map(catopid)
						.toProperty("catopid").map(dirid).toProperty("dirid").map(devtypeid).toProperty("devtypeid")
						.map(manexecs).toProperty("manexecs").map(autoexecs).toProperty("autoexecs").map(mantime)
						.toProperty("mantime").map(registeredDate).toProperty("registeredDate").map(autCreatorArea)
						.toProperty("autCreatorArea").map(autCreatorUser).toProperty("autCreatorUser").map(lastModified)
						.toProperty("lastModified").map(autEnabled).toProperty("autEnabled").map(impactedCis)
						.toProperty("impactedCis").map(totalImpactedCis).toProperty("totalImpactedCis"));
	}

	/**
	 * Insert multiple.
	 *
	 * @param records the records
	 * @return the int
	 */
	default int insertMultiple(Collection<Automation> records) {
		return MyBatis3Utils.insertMultiple(this::insertMultiple, records, automation,
				c -> c.map(botname).toProperty("botname").map(botDescr).toProperty("botDescr").map(areaid)
						.toProperty("areaid").map(suppgroupid).toProperty("suppgroupid").map(specialistid)
						.toProperty("specialistid").map(crid).toProperty("crid").map(clienteid).toProperty("clienteid")
						.map(platformid).toProperty("platformid").map(tipoautid).toProperty("tipoautid").map(functionid)
						.toProperty("functionid").map(tipoexecid).toProperty("tipoexecid").map(tipociid)
						.toProperty("tipociid").map(tecnologiaid).toProperty("tecnologiaid").map(catopid)
						.toProperty("catopid").map(dirid).toProperty("dirid").map(devtypeid).toProperty("devtypeid")
						.map(manexecs).toProperty("manexecs").map(autoexecs).toProperty("autoexecs").map(mantime)
						.toProperty("mantime").map(registeredDate).toProperty("registeredDate").map(autCreatorArea)
						.toProperty("autCreatorArea").map(autCreatorUser).toProperty("autCreatorUser").map(lastModified)
						.toProperty("lastModified").map(autEnabled).toProperty("autEnabled").map(impactedCis)
						.toProperty("impactedCis").map(totalImpactedCis).toProperty("totalImpactedCis"));
	}

	/**
	 * Insert selective.
	 *
	 * @param record the record
	 * @return the int
	 */
	default int insertSelective(Automation record) {
		return MyBatis3Utils.insert(this::insert, record, automation,
				c -> c.map(botname).toPropertyWhenPresent("botname", record::getBotname).map(botDescr)
						.toPropertyWhenPresent("botDescr", record::getBotDescr).map(areaid)
						.toPropertyWhenPresent("areaid", record::getAreaid).map(suppgroupid)
						.toPropertyWhenPresent("suppgroupid", record::getSuppgroupid).map(specialistid)
						.toPropertyWhenPresent("specialistid", record::getSpecialistid).map(crid)
						.toPropertyWhenPresent("crid", record::getCrid).map(clienteid)
						.toPropertyWhenPresent("clienteid", record::getClienteid).map(platformid)
						.toPropertyWhenPresent("platformid", record::getPlatformid).map(tipoautid)
						.toPropertyWhenPresent("tipoautid", record::getTipoautid).map(functionid)
						.toPropertyWhenPresent("functionid", record::getFunctionid).map(tipoexecid)
						.toPropertyWhenPresent("tipoexecid", record::getTipoexecid).map(tipociid)
						.toPropertyWhenPresent("tipociid", record::getTipociid).map(tecnologiaid)
						.toPropertyWhenPresent("tecnologiaid", record::getTecnologiaid).map(catopid)
						.toPropertyWhenPresent("catopid", record::getCatopid).map(dirid)
						.toPropertyWhenPresent("dirid", record::getDirid).map(devtypeid)
						.toPropertyWhenPresent("devtypeid", record::getDevtypeid).map(manexecs)
						.toPropertyWhenPresent("manexecs", record::getManexecs).map(autoexecs)
						.toPropertyWhenPresent("autoexecs", record::getAutoexecs).map(mantime)
						.toPropertyWhenPresent("mantime", record::getMantime).map(registeredDate)
						.toPropertyWhenPresent("registeredDate", record::getRegisteredDate).map(autCreatorArea)
						.toPropertyWhenPresent("autCreatorArea", record::getAutCreatorArea).map(autCreatorUser)
						.toPropertyWhenPresent("autCreatorUser", record::getAutCreatorUser).map(lastModified)
						.toPropertyWhenPresent("lastModified", record::getLastModified).map(autEnabled)
						.toPropertyWhenPresent("autEnabled", record::getAutEnabled).map(impactedCis)
						.toPropertyWhenPresent("impactedCis", record::getImpactedCis).map(totalImpactedCis)
						.toPropertyWhenPresent("totalImpactedCis", record::getTotalImpactedCis));
	}

	/**
	 * Select one.
	 *
	 * @param completer the completer
	 * @return the optional
	 */
	default Optional<Automation> selectOne(SelectDSLCompleter completer) {
		return MyBatis3Utils.selectOne(this::selectOne, selectList, automation, completer);
	}

	/**
	 * Select.
	 *
	 * @param completer the completer
	 * @return the list
	 */
	default List<Automation> select(SelectDSLCompleter completer) {
		return MyBatis3Utils.selectList(this::selectMany, selectList, automation, completer);
	}

	/**
	 * Select distinct.
	 *
	 * @param completer the completer
	 * @return the list
	 */
	default List<Automation> selectDistinct(SelectDSLCompleter completer) {
		return MyBatis3Utils.selectDistinct(this::selectMany, selectList, automation, completer);
	}

	/**
	 * Select by primary key.
	 *
	 * @param id_ the id
	 * @return the optional
	 */
	default Optional<Automation> selectByPrimaryKey(Long id_) {
		return selectOne(c -> c.where(id, isEqualTo(id_)));
	}

	/**
	 * Update.
	 *
	 * @param completer the completer
	 * @return the int
	 */
	default int update(UpdateDSLCompleter completer) {
		return MyBatis3Utils.update(this::update, automation, completer);
	}

	/**
	 * Update all columns.
	 *
	 * @param record the record
	 * @param dsl    the dsl
	 * @return the update DSL
	 */
	static UpdateDSL<UpdateModel> updateAllColumns(Automation record, UpdateDSL<UpdateModel> dsl) {
		return dsl.set(botname).equalTo(record::getBotname).set(botDescr).equalTo(record::getBotDescr).set(areaid)
				.equalTo(record::getAreaid).set(suppgroupid).equalTo(record::getSuppgroupid).set(specialistid)
				.equalTo(record::getSpecialistid).set(crid).equalTo(record::getCrid).set(clienteid)
				.equalTo(record::getClienteid).set(platformid).equalTo(record::getPlatformid).set(tipoautid)
				.equalTo(record::getTipoautid).set(functionid).equalTo(record::getFunctionid).set(tipoexecid)
				.equalTo(record::getTipoexecid).set(tipociid).equalTo(record::getTipociid).set(tecnologiaid)
				.equalTo(record::getTecnologiaid).set(catopid).equalTo(record::getCatopid).set(dirid)
				.equalTo(record::getDirid).set(devtypeid).equalTo(record::getDevtypeid).set(manexecs)
				.equalTo(record::getManexecs).set(autoexecs).equalTo(record::getAutoexecs).set(mantime)
				.equalTo(record::getMantime).set(registeredDate).equalTo(record::getRegisteredDate).set(autCreatorArea)
				.equalTo(record::getAutCreatorArea).set(autCreatorUser).equalTo(record::getAutCreatorUser)
				.set(lastModified).equalTo(record::getLastModified).set(autEnabled).equalTo(record::getAutEnabled)
				.set(impactedCis).equalTo(record::getImpactedCis).set(totalImpactedCis)
				.equalTo(record::getTotalImpactedCis);
	}

	/**
	 * Update selective columns.
	 *
	 * @param record the record
	 * @param dsl    the dsl
	 * @return the update DSL
	 */
	static UpdateDSL<UpdateModel> updateSelectiveColumns(Automation record, UpdateDSL<UpdateModel> dsl) {
		return dsl.set(botname).equalToWhenPresent(record::getBotname).set(botDescr)
				.equalToWhenPresent(record::getBotDescr).set(areaid).equalToWhenPresent(record::getAreaid)
				.set(suppgroupid).equalToWhenPresent(record::getSuppgroupid).set(specialistid)
				.equalToWhenPresent(record::getSpecialistid).set(crid).equalToWhenPresent(record::getCrid)
				.set(clienteid).equalToWhenPresent(record::getClienteid).set(platformid)
				.equalToWhenPresent(record::getPlatformid).set(tipoautid).equalToWhenPresent(record::getTipoautid)
				.set(functionid).equalToWhenPresent(record::getFunctionid).set(tipoexecid)
				.equalToWhenPresent(record::getTipoexecid).set(tipociid).equalToWhenPresent(record::getTipociid)
				.set(tecnologiaid).equalToWhenPresent(record::getTecnologiaid).set(catopid)
				.equalToWhenPresent(record::getCatopid).set(dirid).equalToWhenPresent(record::getDirid).set(devtypeid)
				.equalToWhenPresent(record::getDevtypeid).set(manexecs).equalToWhenPresent(record::getManexecs)
				.set(autoexecs).equalToWhenPresent(record::getAutoexecs).set(mantime)
				.equalToWhenPresent(record::getMantime).set(registeredDate)
				.equalToWhenPresent(record::getRegisteredDate).set(autCreatorArea)
				.equalToWhenPresent(record::getAutCreatorArea).set(autCreatorUser)
				.equalToWhenPresent(record::getAutCreatorUser).set(lastModified)
				.equalToWhenPresent(record::getLastModified).set(autEnabled).equalToWhenPresent(record::getAutEnabled)
				.set(impactedCis).equalToWhenPresent(record::getImpactedCis).set(totalImpactedCis)
				.equalToWhenPresent(record::getTotalImpactedCis);
	}

	/**
	 * Update by primary key.
	 *
	 * @param record the record
	 * @return the int
	 */
	default int updateByPrimaryKey(Automation record) {
		return update(c -> c.set(botname).equalTo(record::getBotname).set(botDescr).equalTo(record::getBotDescr)
				.set(areaid).equalTo(record::getAreaid).set(suppgroupid).equalTo(record::getSuppgroupid)
				.set(specialistid).equalTo(record::getSpecialistid).set(crid).equalTo(record::getCrid).set(clienteid)
				.equalTo(record::getClienteid).set(platformid).equalTo(record::getPlatformid).set(tipoautid)
				.equalTo(record::getTipoautid).set(functionid).equalTo(record::getFunctionid).set(tipoexecid)
				.equalTo(record::getTipoexecid).set(tipociid).equalTo(record::getTipociid).set(tecnologiaid)
				.equalTo(record::getTecnologiaid).set(catopid).equalTo(record::getCatopid).set(dirid)
				.equalTo(record::getDirid).set(devtypeid).equalTo(record::getDevtypeid).set(manexecs)
				.equalTo(record::getManexecs).set(autoexecs).equalTo(record::getAutoexecs).set(mantime)
				.equalTo(record::getMantime).set(registeredDate).equalTo(record::getRegisteredDate).set(autCreatorArea)
				.equalTo(record::getAutCreatorArea).set(autCreatorUser).equalTo(record::getAutCreatorUser)
				.set(lastModified).equalTo(record::getLastModified).set(autEnabled).equalTo(record::getAutEnabled)
				.set(impactedCis).equalTo(record::getImpactedCis).set(totalImpactedCis)
				.equalTo(record::getTotalImpactedCis).where(id, isEqualTo(record::getId)));
	}

	/**
	 * Update by primary key selective.
	 *
	 * @param record the record
	 * @return the int
	 */
	default int updateByPrimaryKeySelective(Automation record) {
		return update(c -> c.set(botname).equalToWhenPresent(record::getBotname).set(botDescr)
				.equalToWhenPresent(record::getBotDescr).set(areaid).equalToWhenPresent(record::getAreaid)
				.set(suppgroupid).equalToWhenPresent(record::getSuppgroupid).set(specialistid)
				.equalToWhenPresent(record::getSpecialistid).set(crid).equalToWhenPresent(record::getCrid)
				.set(clienteid).equalToWhenPresent(record::getClienteid).set(platformid)
				.equalToWhenPresent(record::getPlatformid).set(tipoautid).equalToWhenPresent(record::getTipoautid)
				.set(functionid).equalToWhenPresent(record::getFunctionid).set(tipoexecid)
				.equalToWhenPresent(record::getTipoexecid).set(tipociid).equalToWhenPresent(record::getTipociid)
				.set(tecnologiaid).equalToWhenPresent(record::getTecnologiaid).set(catopid)
				.equalToWhenPresent(record::getCatopid).set(dirid).equalToWhenPresent(record::getDirid).set(devtypeid)
				.equalToWhenPresent(record::getDevtypeid).set(manexecs).equalToWhenPresent(record::getManexecs)
				.set(autoexecs).equalToWhenPresent(record::getAutoexecs).set(mantime)
				.equalToWhenPresent(record::getMantime).set(registeredDate)
				.equalToWhenPresent(record::getRegisteredDate).set(autCreatorArea)
				.equalToWhenPresent(record::getAutCreatorArea).set(autCreatorUser)
				.equalToWhenPresent(record::getAutCreatorUser).set(lastModified)
				.equalToWhenPresent(record::getLastModified).set(autEnabled).equalToWhenPresent(record::getAutEnabled)
				.set(impactedCis).equalToWhenPresent(record::getImpactedCis).set(totalImpactedCis)
				.equalToWhenPresent(record::getTotalImpactedCis).where(id, isEqualTo(record::getId)));
	}
}