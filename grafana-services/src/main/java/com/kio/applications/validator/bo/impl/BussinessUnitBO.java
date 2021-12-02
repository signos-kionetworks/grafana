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
import com.kio.applications.validator.dao.BussinessUnitMapper;
import com.kio.applications.validator.exception.GenericException;
import com.kio.applications.validator.model.BussinessUnit;

/**
 * The Class BussinessUnitBO.
 */
@Service
public class BussinessUnitBO implements IfzSelectBO<BussinessUnit>, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4210845512153561186L;
	/** The bussinessUnit mapper. */
	@Autowired
	private BussinessUnitMapper bussinessUnitMapper;

	/**
	 * Select by name.
	 *
	 * @param value the value
	 * @return the bussiness unit
	 * @throws GenericException the generic exception
	 */
	@Override
	public BussinessUnit selectByName(String value) throws GenericException {
		final Optional<com.kio.applications.validator.model.BussinessUnit> result = this.bussinessUnitMapper
				.selectOne(c -> c
						.where(com.kio.applications.validator.dao.BussinessUnitDynamicSqlSupport.name,
								SqlBuilder.isInCaseInsensitive(value.trim().toUpperCase()))
						.or(com.kio.applications.validator.dao.BussinessUnitDynamicSqlSupport.descr,
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
	 * @return the bussiness unit
	 * @throws GenericException the generic exception
	 */
	@Override
	public BussinessUnit selectById(int id) throws GenericException {
		final Optional<com.kio.applications.validator.model.BussinessUnit> result = this.bussinessUnitMapper
				.selectOne(c -> c.where(com.kio.applications.validator.dao.BussinessUnitDynamicSqlSupport.id,
						SqlBuilder.isEqualTo(id)));
		if (result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
	}

}
