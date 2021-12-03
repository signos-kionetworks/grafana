/*
 * ****************************************************
 * * Grafana *
 * * KIO Networks *
 * * @Author Julio Galindo *
 * ****************************************************
 */

package com.kio.applications.validator.bo.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kio.applications.validator.bo.IfzSaveBO;
import com.kio.applications.validator.dao.IndicatorMapper;
import com.kio.applications.validator.exception.GenericException;
import com.kio.applications.validator.model.Indicator;

/**
 * The Class IndicatorBO.
 */
@Service
public class IndicatorBO implements IfzSaveBO<Indicator>, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8879124423137177210L;

	@Autowired
	private IndicatorMapper indicatorMapper;

	@Override
	public Indicator save(Indicator object) throws GenericException {
		if (null != object.getId()) {
			this.indicatorMapper.updateByPrimaryKey(object);
			return object;
		} else {
			this.indicatorMapper.insertSelective(object);
		}
		return object;
	}

}
