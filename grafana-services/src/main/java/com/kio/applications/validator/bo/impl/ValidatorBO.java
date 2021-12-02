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

import com.kio.applications.validator.bo.IfzValidatorBO;
import com.kio.applications.validator.exception.GenericException;
import com.kio.applications.validator.model.Automation;
import com.kio.applications.validator.model.Client;
import com.kio.applications.validator.model.LevelOfSpecialization;
import com.kio.applications.validator.model.OperativeCatalog;
import com.kio.applications.validator.model.Platform;
import com.kio.applications.validator.model.TechnologicalDomain;
import com.kio.applications.validator.model.Technology;
import com.kio.applications.validator.model.TypeAutomation;
import com.kio.applications.validator.model.TypeDevelop;
import com.kio.applications.validator.model.TypeExecution;
import com.kio.applications.validator.model.TypeTask;
import com.kio.applications.validator.model.web.ValidatorRequest;
import com.kio.applications.validator.model.web.ValidatorResponse;

/**
 * The Class ValidatorBO.
 */
@Service
public class ValidatorBO implements IfzValidatorBO, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -519514140719855552L;

	/** The client BO. */
	@Autowired
	ClientBO clientBO;

	/** The platform BO. */
	@Autowired
	PlatformBO platformBO;

	/** The type automation BO. */
	@Autowired
	TypeAutomationBO typeAutomationBO;

	/** The type execution BO. */
	@Autowired
	TypeExecutionBO typeExecutionBO;

	/** The type develop BO. */
	@Autowired
	TypeDevelopBO typeDevelopBO;

	/** The technological domain BO. */
	@Autowired
	TechnologicalDomainBO technologicalDomainBO;

	/** The technology BO. */
	@Autowired
	TechnologyBO technologyBO;

	/** The level of specialization BO. */
	@Autowired
	LevelOfSpecializationBO levelOfSpecializationBO;

	/** The type task BO. */
	@Autowired
	TypeTaskBO typeTaskBO;

	/**
	 * Process request.
	 *
	 * @param value the value
	 * @return the validator response
	 * @throws GenericException the generic exception
	 */
	@Override
	public ValidatorResponse processRequest(ValidatorRequest value) throws GenericException {
		Automation automation = new Automation();

		this.validateRequest(value);
		automation.setClienteid(this.validateClient(value));
		automation.setPlatformid(this.validatePlatform(value));
		automation.setTipoautid(this.validateTypeAutomation(value));
		automation.setTipoexecid(this.validateTypeExecution(value));
		automation.setDevtypeid(this.validateTypeDevelop(value));
		automation.setCatopid(this.validateOperativeCatalog(value));
		
		//TODO: buscar automation en caso de encontrar llenar indicadores, sino generar botname y descripcion
		return null;
	}

	/**
	 * Validate request.
	 *
	 * @param value the value
	 * @return true, if successful
	 * @throws GenericException the generic exception
	 */
	private boolean validateRequest(ValidatorRequest value) throws GenericException {
		if (null == value) {
			throw new GenericException("El request es nulo.");
		}

		if (null == value.getExtraVars()) {
			throw new GenericException("El nodo extravars es obligatorio.");
		}

		return true;
	}

	/**
	 * Validate client.
	 *
	 * @param value the value
	 * @return the integer
	 * @throws GenericException the generic exception
	 */
	private Integer validateClient(ValidatorRequest value) throws GenericException {
		Client client = null;

		if (null != value.getExtraVars().getClient() && !value.getExtraVars().getClient().isEmpty()) {
			client = clientBO.selectByName(value.getExtraVars().getClient());
			if (null == client) {
				throw new GenericException(
						String.format("El valor [%s] del campo client no existe.", value.getExtraVars().getClient()));
			}
		} else {
			throw new GenericException("El campo client es obligatorio.");
		}
		return client.getId();
	}

	/**
	 * Validate platform.
	 *
	 * @param value the value
	 * @return the integer
	 * @throws GenericException the generic exception
	 */
	private Integer validatePlatform(ValidatorRequest value) throws GenericException {
		Platform platform = null;

		if (null != value.getExtraVars().getPlatform() && !value.getExtraVars().getPlatform().isEmpty()) {
			platform = platformBO.selectByName(value.getExtraVars().getPlatform());
			if (null == platform) {
				throw new GenericException(String.format("El valor [%s] del campo platform no existe.",
						value.getExtraVars().getPlatform()));
			}
		} else {
			throw new GenericException("El campo platform es obligatorio.");
		}
		return platform.getId();
	}

	/**
	 * Validate type automation.
	 *
	 * @param value the value
	 * @return the integer
	 * @throws GenericException the generic exception
	 */
	private Integer validateTypeAutomation(ValidatorRequest value) throws GenericException {
		TypeAutomation typeAutomation = null;

		if (null != value.getExtraVars().getTypeOfAutomation()
				&& !value.getExtraVars().getTypeOfAutomation().isEmpty()) {
			typeAutomation = typeAutomationBO.selectByName(value.getExtraVars().getTypeOfAutomation());
			if (null == typeAutomation) {
				throw new GenericException(String.format("El valor [%s] del campo type_develop no existe.",
						value.getExtraVars().getTypeOfAutomation()));
			}
		} else {
			throw new GenericException("El campo type_develop es obligatorio.");
		}
		return typeAutomation.getId();
	}

	/**
	 * Validate type execution.
	 *
	 * @param value the value
	 * @return the integer
	 * @throws GenericException the generic exception
	 */
	private Integer validateTypeExecution(ValidatorRequest value) throws GenericException {
		TypeExecution typeExecution = null;

		if (null != value.getExtraVars().getTypeOfExecution() && !value.getExtraVars().getTypeOfExecution().isEmpty()) {
			typeExecution = typeExecutionBO.selectByName(value.getExtraVars().getTypeOfExecution());
			if (null == typeExecution) {
				throw new GenericException(String.format("El valor [%s] del campo type_execution no existe.",
						value.getExtraVars().getTypeOfExecution()));
			}
		} else {
			throw new GenericException("El campo typeExecution es obligatorio.");
		}
		return typeExecution.getId();
	}

	/**
	 * Validate type develop.
	 *
	 * @param value the value
	 * @return the integer
	 * @throws GenericException the generic exception
	 */
	private Integer validateTypeDevelop(ValidatorRequest value) throws GenericException {
		TypeDevelop typeDevelop = null;

		if (null != value.getExtraVars().getTypeOfDevelop() && !value.getExtraVars().getTypeOfDevelop().isEmpty()) {
			typeDevelop = typeDevelopBO.selectByName(value.getExtraVars().getTypeOfDevelop());
			if (null == typeDevelop) {
				throw new GenericException(String.format("El valor [%s] del campo type_develop no existe.",
						value.getExtraVars().getTypeOfDevelop()));
			}
		} else {
			throw new GenericException("El campo type_develop es obligatorio.");
		}
		return typeDevelop.getId();
	}

	/**
	 * Validate operative catalog.
	 *
	 * @param value the value
	 * @return the integer
	 * @throws GenericException the generic exception
	 */
	private Integer validateOperativeCatalog(ValidatorRequest value) throws GenericException {
		OperativeCatalog operativeCatalog = new OperativeCatalog();

		operativeCatalog.setCatnivel1(validateTechnologicalDomain(value));
		operativeCatalog.setCatnivel2(validateLevelOfSpecialization(value));
		operativeCatalog.setCatnivel3(validateTypeTask(value));
		operativeCatalog.setProducto(validateTechnology(value));
		
		//TODO: buscar operative cataloge

		return operativeCatalog.getId();
	}

	/**
	 * Validate technological domain.
	 *
	 * @param value the value
	 * @return the integer
	 * @throws GenericException the generic exception
	 */
	private Integer validateTechnologicalDomain(ValidatorRequest value) throws GenericException {
		TechnologicalDomain technologicalDomain = null;

		if (null != value.getExtraVars().getTechnologicalDomain()
				&& !value.getExtraVars().getTechnologicalDomain().isEmpty()) {
			technologicalDomain = technologicalDomainBO.selectByName(value.getExtraVars().getTechnologicalDomain());
			if (null == technologicalDomain) {
				throw new GenericException(String.format("El valor [%s] del campo technological_domain no existe.",
						value.getExtraVars().getTechnologicalDomain()));
			}
		} else {
			throw new GenericException("El campo technological_domain es obligatorio.");
		}
		return technologicalDomain.getId();
	}

	/**
	 * Validate technology.
	 *
	 * @param value the value
	 * @return the integer
	 * @throws GenericException the generic exception
	 */
	private Integer validateTechnology(ValidatorRequest value) throws GenericException {
		Technology technology = null;

		if (null != value.getExtraVars().getTechnology() && !value.getExtraVars().getTechnology().isEmpty()) {
			technology = technologyBO.selectByName(value.getExtraVars().getTechnology());
			if (null == technology) {
				throw new GenericException(String.format("El valor [%s] del campo technology no existe.",
						value.getExtraVars().getTechnology()));
			}
		} else {
			throw new GenericException("El campo technology es obligatorio.");
		}
		return technology.getId();
	}

	/**
	 * Validate level of specialization.
	 *
	 * @param value the value
	 * @return the integer
	 * @throws GenericException the generic exception
	 */
	private Integer validateLevelOfSpecialization(ValidatorRequest value) throws GenericException {
		LevelOfSpecialization levelOfSpecialization = null;

		if (null != value.getExtraVars().getLevelOfSpecialization()
				&& !value.getExtraVars().getLevelOfSpecialization().isEmpty()) {
			levelOfSpecialization = levelOfSpecializationBO
					.selectByName(value.getExtraVars().getLevelOfSpecialization());
			if (null == levelOfSpecialization) {
				throw new GenericException(String.format("El valor [%s] del campo level_of_specialization no existe.",
						value.getExtraVars().getLevelOfSpecialization()));
			}
		} else {
			throw new GenericException("El campo level_of_specialization es obligatorio.");
		}
		return levelOfSpecialization.getId();
	}

	/**
	 * Validate type task.
	 *
	 * @param value the value
	 * @return the integer
	 * @throws GenericException the generic exception
	 */
	private Integer validateTypeTask(ValidatorRequest value) throws GenericException {
		TypeTask typeTask = null;

		if (null != value.getExtraVars().getTypeOfTask() && !value.getExtraVars().getTypeOfTask().isEmpty()) {
			typeTask = typeTaskBO.selectByName(value.getExtraVars().getTypeOfTask());
			if (null == typeTask) {
				throw new GenericException(String.format("El valor [%s] del campo type_of_task no existe.",
						value.getExtraVars().getTypeOfTask()));
			}
		} else {
			throw new GenericException("El campo type_of_task es obligatorio.");
		}
		return typeTask.getId();
	}

}
