/*
 * ****************************************************
 * * Grafana *
 * * KIO Networks *
 * * @Author Julio Galindo *
 * ****************************************************
 */

package com.kio.applications.validator.bo.impl;

import com.kio.applications.validator.bo.IfzSelectBO;
import com.kio.applications.validator.dao.OriginMapper;
import com.kio.applications.validator.exception.GenericException;
import com.kio.applications.validator.model.Origin;
import com.kio.applications.validator.model.Platform;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Optional;

/**
 * The Class OriginBO.
 */
@Service
public class OriginBO implements IfzSelectBO<Origin>, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8087045393972259502L;
	/** The origin mapper. */
	@Autowired
	private OriginMapper originMapper;

	/**
	 * Select by id.
	 *
	 * @param id
	 *            the id
	 * @return the origin
	 * @throws GenericException
	 *             the generic exception
	 */
	@Override
	public Origin selectById(int id) throws GenericException {
		final Optional<Origin> result = this.originMapper
				.selectOne(c -> c.where(
						com.kio.applications.validator.dao.OriginDynamicSqlSupport.id,
						SqlBuilder.isEqualTo(id)));
        return result.orElse(null);
	}

	/**
	 * Select by name.
	 *
	 * @param value
	 *            the value
	 * @return the origin
	 * @throws GenericException
	 *             the generic exception
	 */
	@Override
	public Origin selectByName(String value) throws GenericException {
		final Optional<Origin> result = this.originMapper
				.selectOne(c -> c.where(
						com.kio.applications.validator.dao.OriginDynamicSqlSupport.name,
						SqlBuilder.isInCaseInsensitive(
								value.trim().toUpperCase()))
						.or(com.kio.applications.validator.dao.OriginDynamicSqlSupport.descr,
								SqlBuilder.isInCaseInsensitive(
										value.trim().toUpperCase()))
						.limit(1));
        return result.orElse(null);
	}

}
