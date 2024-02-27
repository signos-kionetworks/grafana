/*
 * ****************************************************
 * * Grafana *
 * * KIO Networks *
 * * @Author Julio Galindo *
 * ****************************************************
 */

package com.kio.applications.validator.bo.impl;

import com.kio.applications.validator.bo.IfzResourceBO;
import com.kio.applications.validator.bo.IfzSaveBO;
import com.kio.applications.validator.bo.IfzSelectBO;
import com.kio.applications.validator.dao.ResourceMapper;
import com.kio.applications.validator.exception.GenericException;
import com.kio.applications.validator.model.Resource;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Optional;

/**
 * The Class ResourceBO.
 */
@Service
public class ResourceBO implements IfzSaveBO<Resource>, IfzResourceBO, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8087045393972259502L;
	/** The resource mapper. */
	@Autowired
	private ResourceMapper resourceMapper;


	/**
	 * Save.
	 *
	 * @param object
	 *            the object
	 * @return the resource
	 * @throws GenericException
	 *             the generic exception
	 */
	@Override
	public Resource save(Resource object) throws GenericException {
		if (null != object.getId()) {
			this.resourceMapper.updateByPrimaryKey(object);
			return object;
		} else {
			this.resourceMapper.insertSelective(object);
		}
		return object;
	}


	/**
	 * Search resource by resource id resource.
	 *
	 * @param resourceId the resource id
	 * @param originId   the origin id
	 * @return the resource
	 * @throws GenericException the generic exception
	 */
	@Override
	public Resource searchResourceByResourceId(String resourceId, Integer originId) throws GenericException {
		final Optional<Resource> result = this.resourceMapper
				.selectOne(c -> c.where(
								com.kio.applications.validator.dao.ResourceDynamicSqlSupport.identificadorRecurso,
								SqlBuilder.isInCaseInsensitive(
										resourceId.trim().toUpperCase()))
						.and(com.kio.applications.validator.dao.ResourceDynamicSqlSupport.idOrigen,
								SqlBuilder.isEqualTo(
										originId))
						.limit(1));
		return result.orElse(null);
	}
}
