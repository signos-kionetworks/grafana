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

import com.kio.applications.validator.bo.IfzSearchByKeyBO;
import com.kio.applications.validator.dao.OperativeCatalogMapper;
import com.kio.applications.validator.exception.GenericException;
import com.kio.applications.validator.model.OperativeCatalog;

/**
 * The Class OperativeCatalogBO.
 */
@Service
public class OperativeCatalogBO implements IfzSearchByKeyBO<OperativeCatalog>, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2583084583910196478L;

	/** The operative catalog mapper. */
	@Autowired
	private OperativeCatalogMapper operativeCatalogMapper;

	/**
	 * Search by key values.
	 *
	 * @param value the value
	 * @return the operative catalog
	 * @throws GenericException the generic exception
	 */
	@Override
	public OperativeCatalog searchByKeyValues(OperativeCatalog value) throws GenericException {
		final Optional<com.kio.applications.validator.model.OperativeCatalog> result = this.operativeCatalogMapper
				.selectOne(c -> c
						.where(com.kio.applications.validator.dao.OperativeCatalogDynamicSqlSupport.producto,
								SqlBuilder.isEqualTo(value.getProducto()))
						.and(com.kio.applications.validator.dao.OperativeCatalogDynamicSqlSupport.catnivel1,
								SqlBuilder.isEqualTo(value.getCatnivel1()))
						.and(com.kio.applications.validator.dao.OperativeCatalogDynamicSqlSupport.catnivel2,
								SqlBuilder.isEqualTo(value.getCatnivel2()))
						.and(com.kio.applications.validator.dao.OperativeCatalogDynamicSqlSupport.catnivel3,
								SqlBuilder.isEqualTo(value.getCatnivel3()))
						.orderBy(com.kio.applications.validator.dao.OperativeCatalogDynamicSqlSupport.id).limit(1));
		if (result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
	}

}
