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
import com.kio.applications.validator.dao.TypeTicketMapper;
import com.kio.applications.validator.exception.GenericException;
import com.kio.applications.validator.model.TypeTicket;

/**
 * The Class TypeTicketBO.
 */
@Service
public class TypeTicketBO implements IfzSelectBO<TypeTicket>, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1176967350618025862L;
	/** The typeTicket mapper. */
	@Autowired
	private TypeTicketMapper typeTicketMapper;

	/**
	 * Select by name.
	 *
	 * @param value the value
	 * @return the type ticket
	 * @throws GenericException the generic exception
	 */
	@Override
	public TypeTicket selectByName(String value) throws GenericException {
		final Optional<com.kio.applications.validator.model.TypeTicket> result = this.typeTicketMapper.selectOne(c -> c
				.where(com.kio.applications.validator.dao.TypeTicketDynamicSqlSupport.name,
						SqlBuilder.isInCaseInsensitive(value.trim().toUpperCase()))
				.or(com.kio.applications.validator.dao.TypeTicketDynamicSqlSupport.descr,
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
	 * @return the type ticket
	 * @throws GenericException the generic exception
	 */
	@Override
	public TypeTicket selectById(int id) throws GenericException {
		final Optional<com.kio.applications.validator.model.TypeTicket> result = this.typeTicketMapper.selectOne(c -> c
				.where(com.kio.applications.validator.dao.TypeTicketDynamicSqlSupport.id, SqlBuilder.isEqualTo(id)));
		if (result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
	}

}
