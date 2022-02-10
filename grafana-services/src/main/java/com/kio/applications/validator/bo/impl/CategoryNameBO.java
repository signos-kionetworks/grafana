/*
 * ****************************************************
 * * Grafana *
 * * KIO Networks *
 * * @Author Julio Galindo *
 * ****************************************************
 */

package com.kio.applications.validator.bo.impl;

import java.io.Serializable;
import java.util.Optional;

import org.mybatis.dynamic.sql.SqlBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kio.applications.validator.bo.IfzSelectBO;
import com.kio.applications.validator.dao.CategoryNameMapper;
import com.kio.applications.validator.exception.GenericException;
import com.kio.applications.validator.model.CategoryName;

/**
 * The Class CategoryNameBO.
 */
@Service
public class CategoryNameBO implements IfzSelectBO<CategoryName>, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2664761958834487480L;
	/** The categoryName mapper. */
	@Autowired
	private CategoryNameMapper categoryNameMapper;

	/**
	 * Select by id.
	 *
	 * @param id
	 *            the id
	 * @return the category name
	 * @throws GenericException
	 *             the generic exception
	 */
	@Override
	public CategoryName selectById(int id) throws GenericException {
		final Optional<com.kio.applications.validator.model.CategoryName> result = this.categoryNameMapper
				.selectOne(c -> c.where(
						com.kio.applications.validator.dao.CategoryNameDynamicSqlSupport.id,
						SqlBuilder.isEqualTo(id)));
		if (result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
	}

	/**
	 * Select by name.
	 *
	 * @param value
	 *            the value
	 * @return the category name
	 * @throws GenericException
	 *             the generic exception
	 */
	@Override
	public CategoryName selectByName(String value) throws GenericException {
		final Optional<com.kio.applications.validator.model.CategoryName> result = this.categoryNameMapper
				.selectOne(c -> c.where(
						com.kio.applications.validator.dao.CategoryNameDynamicSqlSupport.name,
						SqlBuilder.isInCaseInsensitive(
								value.trim().toUpperCase()))
						.or(com.kio.applications.validator.dao.CategoryNameDynamicSqlSupport.descr,
								SqlBuilder.isInCaseInsensitive(
										value.trim().toUpperCase()))
						.limit(1));
		if (result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
	}

}
