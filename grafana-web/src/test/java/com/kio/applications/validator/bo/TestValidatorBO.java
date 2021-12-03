package com.kio.applications.validator.bo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
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
	@Rollback(false)
	public void testValidator() {
		ValidatorRequest validatorRequest = new ValidatorRequest();
		try {
			ExtraVars vars = new ExtraVars();
			// vars.setClient("360 TXP");
			vars.setPlatform("AWX");
			vars.setTypeOfAutomation("NLU");
			vars.setTypeOfExecution("ON_DEMAND");
			vars.setTypeOfDevelop("INTEGRACION");
			vars.setTechnologicalDomain("SERVICIO APLICACIONES");
			vars.setTechnology("Active Directory");
			vars.setLevelOfSpecialization("Especialidad");
			vars.setTypeOfTask("Mantenimiento");
			vars.setOrganization("IMSS - UNIX");
			vars.setManualTime((float) 2.565656);
			vars.setTotalCis(10);
			vars.setTotalImpactedCis(10);
			vars.setPlaybookStartTimestamp(1638490849);

			validatorRequest.setExtraVars(vars);

			validatorBO.processRequest(validatorRequest);

		} catch (GenericException e) {
			e.printStackTrace();
		}

	}

}
