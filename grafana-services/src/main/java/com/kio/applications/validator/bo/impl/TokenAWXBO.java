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

import com.kio.applications.validator.bo.IfzTokenAWXBO;
import com.kio.applications.validator.dao.TokenAWXMapper;
import com.kio.applications.validator.exception.GenericException;
import com.kio.applications.validator.model.TokenAWX;

/**
 * The Class TokenAWXBO.
 */
@Service
public class TokenAWXBO implements IfzTokenAWXBO, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -146904473852335462L;

	/** The token AWX mapper. */
	@Autowired
	private TokenAWXMapper tokenAWXMapper;

	/**
	 * Search token.
	 *
	 * @param token
	 *            the token
	 * @return the token AWX
	 * @throws GenericException
	 *             the generic exception
	 */
	@Override
	public TokenAWX searchToken(String token) throws GenericException {
		final Optional<com.kio.applications.validator.model.TokenAWX> result = this.tokenAWXMapper
				.selectOne(c -> c.where(
						com.kio.applications.validator.dao.TokenAWXDynamicSqlSupport.token,
						SqlBuilder.isEqualTo(token)));
        return result.orElse(null);
	}

}
