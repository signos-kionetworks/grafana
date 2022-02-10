package com.kio.applications.validator.bo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.kio.applications.validator.bo.impl.ClientBO;
import com.kio.applications.validator.exception.GenericException;
import com.kio.applications.validator.model.Client;

@ContextConfiguration(locations = { "/spring/application-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class TestClienteBO extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	ClientBO clienteBO;

	@Test
	public void testConsultaClienteNombre() {
		Client cliente;
		try {
			cliente = clienteBO.selectByName("360 TXP");

			Assert.assertNotNull(cliente.toString());
		} catch (GenericException e) {
			e.printStackTrace();
		}

	}

}
