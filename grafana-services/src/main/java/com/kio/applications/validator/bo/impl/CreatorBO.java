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
import com.kio.applications.validator.dao.CreatorMapper;
import com.kio.applications.validator.exception.GenericException;
import com.kio.applications.validator.model.Creator;

/**
 * The Class CreatorBO.
 */
@Service
public class CreatorBO implements IfzSelectBO<Creator>, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2037146528435608751L;
	/** The creator mapper. */
	@Autowired
	private CreatorMapper creatorMapper;

	/**
	 * Select by name.
	 *
	 * @param value the value
	 * @return the creator
	 * @throws GenericException the generic exception
	 */
	@Override
	public Creator selectByName(String value) throws GenericException {
		final Optional<com.kio.applications.validator.model.Creator> result = this.creatorMapper.selectOne(c -> c
				.where(com.kio.applications.validator.dao.CreatorDynamicSqlSupport.name,
						SqlBuilder.isInCaseInsensitive(value.trim().toUpperCase()))
				.or(com.kio.applications.validator.dao.CreatorDynamicSqlSupport.descr,
						SqlBuilder.isInCaseInsensitive(value.trim().toUpperCase())));
		if (result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
	}

	/**
	 * Select by id.
	 *
	 * @param id the id
	 * @return the creator
	 * @throws GenericException the generic exception
	 */
	@Override
	public Creator selectById(int id) throws GenericException {
		final Optional<com.kio.applications.validator.model.Creator> result = this.creatorMapper.selectOne(
				c -> c.where(com.kio.applications.validator.dao.CreatorDynamicSqlSupport.id, SqlBuilder.isEqualTo(id)));
		if (result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
	}

}
