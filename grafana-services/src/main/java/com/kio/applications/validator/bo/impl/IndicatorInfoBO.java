/*
 * ****************************************************
 * * Grafana *
 * * KIO Networks *
 * * @Author Julio Galindo *
 * ****************************************************
 */

package com.kio.applications.validator.bo.impl;

import com.kio.applications.validator.bo.IfzSaveBO;
import com.kio.applications.validator.dao.IndicatorInfoMapper;
import com.kio.applications.validator.dao.IndicatorMapper;
import com.kio.applications.validator.exception.GenericException;
import com.kio.applications.validator.model.Indicator;
import com.kio.applications.validator.model.IndicatorInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * The Class IndicatorInfoBO.
 */
@Service
public class IndicatorInfoBO implements IfzSaveBO<IndicatorInfo>, Serializable {

	/** The indicator info mapper. */
	@Autowired
	private IndicatorInfoMapper indicatorInfoMapper;

	/**
	 * Save.
	 *
	 * @param object
	 *            the object
	 * @return the indicator info
	 * @throws GenericException
	 *             the generic exception
	 */
	@Override
	public IndicatorInfo save(IndicatorInfo object) throws GenericException {
		if (null != object.getId()) {
			this.indicatorInfoMapper.updateByPrimaryKey(object);
			return object;
		} else {
			this.indicatorInfoMapper.insertSelective(object);
		}
		return object;
	}

}
