package com.kio.applications.validator.bo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.kio.applications.validator.bo.impl.ValidatorBO;
import com.kio.applications.validator.exception.GenericException;
import com.kio.applications.validator.model.web.ExtraVars;
import com.kio.applications.validator.model.web.ValidatorRequest;

@ContextConfiguration(locations = { "/spring/application-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class TestValidatorBO extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	ValidatorBO validatorBO;

	@Test
	public void testValidator() {
		ValidatorRequest validatorRequest = new ValidatorRequest();
		try {
			ExtraVars vars = new ExtraVars();
			vars.setClient("360 TXP");
			vars.setPlatform("AWX");
			vars.setTypeOfAutomation("NLU");
			vars.setTypeOfExecution("ON_DEMAND");
			vars.setTypeOfDevelop("INTEGRACION");

			validatorRequest.setExtraVars(vars);

			validatorBO.processRequest(validatorRequest);

		} catch (GenericException e) {
			e.printStackTrace();
		}

	}

}
