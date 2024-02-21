package com.kio.applications.validator.dao;

import com.kio.applications.validator.model.TokenAWX;
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

import static com.kio.applications.validator.dao.TokenAWXDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

/**
 * The interface Token awx mapper.
 */
@Mapper
public interface TokenAWXMapper {
    /**
     * The Select list.
     */

    BasicColumn[] selectList = BasicColumn.columnList(id, token, idArea, emailUser, idOrigen);

    /**
     * Update all columns update dsl.
     *
     * @param record the record
     * @param dsl    the dsl
     * @return the update dsl
     */
    static UpdateDSL<UpdateModel> updateAllColumns(TokenAWX record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(token).equalTo(record::getToken)
                .set(idArea).equalTo(record::getIdArea)
                .set(emailUser).equalTo(record::getEmailUser)
                .set(idOrigen).equalTo(record::getIdOrigen);
    }

    /**
     * Update selective columns update dsl.
     *
     * @param record the record
     * @param dsl    the dsl
     * @return the update dsl
     */
    static UpdateDSL<UpdateModel> updateSelectiveColumns(TokenAWX record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(token).equalToWhenPresent(record::getToken)
                .set(idArea).equalToWhenPresent(record::getIdArea)
                .set(emailUser).equalToWhenPresent(record::getEmailUser)
                .set(idOrigen).equalToWhenPresent(record::getIdOrigen);
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
    int insert(InsertStatementProvider<TokenAWX> insertStatement);

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
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<TokenAWX> records);

    /**
     * Insert multiple int.
     *
     * @param multipleInsertStatement the multiple insert statement
     * @return the int
     */
    default int insertMultiple(MultiRowInsertStatementProvider<TokenAWX> multipleInsertStatement) {
        return insertMultiple(multipleInsertStatement.getInsertStatement(), multipleInsertStatement.getRecords());
    }

    /**
     * Select one optional.
     *
     * @param selectStatement the select statement
     * @return the optional
     */
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("TokenAWXResult")
    Optional<TokenAWX> selectOne(SelectStatementProvider selectStatement);

    /**
     * Select many list.
     *
     * @param selectStatement the select statement
     * @return the list
     */
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "TokenAWXResult", value = {
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "token", property = "token", jdbcType = JdbcType.VARCHAR),
            @Result(column = "id_area", property = "idArea", jdbcType = JdbcType.INTEGER),
            @Result(column = "email_user", property = "emailUser", jdbcType = JdbcType.VARCHAR),
            @Result(column = "id_origen", property = "idOrigen", jdbcType = JdbcType.INTEGER)
    })
    List<TokenAWX> selectMany(SelectStatementProvider selectStatement);

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
        return MyBatis3Utils.countFrom(this::count, tokenAWX, completer);
    }

    /**
     * Delete int.
     *
     * @param completer the completer
     * @return the int
     */
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, tokenAWX, completer);
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
    default int insert(TokenAWX record) {
        return MyBatis3Utils.insert(this::insert, record, tokenAWX, c ->
                c.map(token).toProperty("token")
                        .map(idArea).toProperty("idArea")
                        .map(emailUser).toProperty("emailUser")
                        .map(idOrigen).toProperty("idOrigen")
        );
    }

    /**
     * Insert multiple int.
     *
     * @param records the records
     * @return the int
     */
    default int insertMultiple(Collection<TokenAWX> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, tokenAWX, c ->
                c.map(token).toProperty("token")
                        .map(idArea).toProperty("idArea")
                        .map(emailUser).toProperty("emailUser")
                        .map(idOrigen).toProperty("idOrigen")
        );
    }

    /**
     * Insert selective int.
     *
     * @param record the record
     * @return the int
     */
    default int insertSelective(TokenAWX record) {
        return MyBatis3Utils.insert(this::insert, record, tokenAWX, c ->
                c.map(token).toPropertyWhenPresent("token", record::getToken)
                        .map(idArea).toPropertyWhenPresent("idArea", record::getIdArea)
                        .map(emailUser).toPropertyWhenPresent("emailUser", record::getEmailUser)
                        .map(idOrigen).toPropertyWhenPresent("idOrigen", record::getIdOrigen)
        );
    }

    /**
     * Select one optional.
     *
     * @param completer the completer
     * @return the optional
     */
    default Optional<TokenAWX> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, tokenAWX, completer);
    }

    /**
     * Select list.
     *
     * @param completer the completer
     * @return the list
     */
    default List<TokenAWX> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, tokenAWX, completer);
    }

    /**
     * Select distinct list.
     *
     * @param completer the completer
     * @return the list
     */
    default List<TokenAWX> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, tokenAWX, completer);
    }

    /**
     * Select by primary key optional.
     *
     * @param id_ the id
     * @return the optional
     */
    default Optional<TokenAWX> selectByPrimaryKey(Integer id_) {
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
        return MyBatis3Utils.update(this::update, tokenAWX, completer);
    }

    /**
     * Update by primary key int.
     *
     * @param record the record
     * @return the int
     */
    default int updateByPrimaryKey(TokenAWX record) {
        return update(c ->
                c.set(token).equalTo(record::getToken)
                        .set(idArea).equalTo(record::getIdArea)
                        .set(emailUser).equalTo(record::getEmailUser)
                        .set(idOrigen).equalTo(record::getIdOrigen)
                        .where(id, isEqualTo(record::getId))
        );
    }

    /**
     * Update by primary key selective int.
     *
     * @param record the record
     * @return the int
     */
    default int updateByPrimaryKeySelective(TokenAWX record) {
        return update(c ->
                c.set(token).equalToWhenPresent(record::getToken)
                        .set(idArea).equalToWhenPresent(record::getIdArea)
                        .set(emailUser).equalToWhenPresent(record::getEmailUser)
                        .set(idOrigen).equalToWhenPresent(record::getIdOrigen)
                        .where(id, isEqualTo(record::getId))
        );
    }
}