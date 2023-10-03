/*
 * ****************************************************
 * * Grafana *
 * * KIO Networks *
 * * @Author Julio Galindo *
 * ****************************************************
 */

package com.kio.applications.validator.bo.impl;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import org.apache.cxf.phase.PhaseInterceptorChain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.kio.applications.validator.bo.IfzValidatorBO;
import com.kio.applications.validator.exception.GenericException;
import com.kio.applications.validator.model.Area;
import com.kio.applications.validator.model.Automation;
import com.kio.applications.validator.model.Client;
import com.kio.applications.validator.model.Creator;
import com.kio.applications.validator.model.EquivalenceClient;
import com.kio.applications.validator.model.EquivalenceClientOrganization;
import com.kio.applications.validator.model.Indicator;
import com.kio.applications.validator.model.LevelOfSpecialization;
import com.kio.applications.validator.model.OperativeCatalog;
import com.kio.applications.validator.model.OrganizationAWX;
import com.kio.applications.validator.model.Platform;
import com.kio.applications.validator.model.Specialist;
import com.kio.applications.validator.model.TechnologicalDomain;
import com.kio.applications.validator.model.Technology;
import com.kio.applications.validator.model.TokenAWX;
import com.kio.applications.validator.model.TypeAutomation;
import com.kio.applications.validator.model.TypeDevelop;
import com.kio.applications.validator.model.TypeExecution;
import com.kio.applications.validator.model.TypeTask;
import com.kio.applications.validator.model.web.ValidatorRequest;
import com.kio.applications.validator.model.web.ValidatorResponse;
import com.kio.applications.validator.util.AppConstants;

// TODO: Auto-generated Javadoc
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

	/** The equivalence client BO. */
	@Autowired
	EquivalenceClientBO equivalenceClientBO;

	/** The indicator BO. */
	@Autowired
	IndicatorBO indicatorBO;

	/** The organization AWXBO. */
	@Autowired
	OrganizationAWXBO organizationAWXBO;

	/** The equivalence client organization BO. */
	@Autowired
	EquivalenceClientOrganizationBO equivalenceClientOrganizationBO;

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

	/** The area BO. */
	@Autowired
	AreaBO areaBO;

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

	/** The creator BO. */
	@Autowired
	CreatorBO creatorBO;

	/** The specialist BO. */
	@Autowired
	SpecialistBO specialistBO;

	/** The operative catalog BO. */
	@Autowired
	OperativeCatalogBO operativeCatalogBO;

	/** The automation BO. */
	@Autowired
	AutomationBO automationBO;

	@Value("${calculate.time.in}")
	private String calculateIn;

	/**
	 * Generate automation.
	 *
	 * @param value the value
	 * @return the automation
	 * @throws GenericException the generic exception
	 */
	private Automation generateAutomation(ValidatorRequest value) throws GenericException {
		Automation automation = new Automation();

		Area area = areaBO.selectById(
				((TokenAWX) PhaseInterceptorChain.getCurrentMessage().get(AppConstants.P_TOKEN)).getIdArea());

		this.validateRequest(value);

		if (null != value.getExtraVars().getOrganization() && !value.getExtraVars().getOrganization().isEmpty()) {
			automation.setClienteid(this.getClientByOrganization(value));
		} else if (null != value.getExtraVars().getClient() && !value.getExtraVars().getClient().isEmpty()) {
			automation.setClienteid(this.validateClient(value));
		} else {
			throw new GenericException("El campo client u organization son obligatorios.");
		}

		if (null != value.getExtraVars().getManualTime()) {
			automation.setMantime(value.getExtraVars().getManualTime());
		} else {
			throw new GenericException("El campo manual_time es obligatorio.");
		}

		if (null != value.getExtraVars().getTotalCis()) {
			automation.setImpactedCis(value.getExtraVars().getTotalCis());
		} else {
			throw new GenericException("El campo total_cis es obligatorio.");
		}

		if (null != value.getExtraVars().getTotalCis()) {
			automation.setTotalImpactedCis(value.getExtraVars().getTotalImpactedCis());
		} else {
			throw new GenericException("El campo total_impacted_cis es obligatorio.");
		}

		automation.setAreaid(area.getId());
		automation.setDirid(area.getIdDireccion());

		automation.setCrid(this.validateCreator(value));
		automation.setSpecialistid(this.validateSpecialist(value));
		automation.setPlatformid(this.validatePlatform(value));
		automation.setTipoautid(this.validateTypeAutomation(value));
		automation.setTipoexecid(this.validateTypeExecution(value));
		automation.setDevtypeid(this.validateTypeDevelop(value));
		automation.setCatopid(this.validateOperativeCatalog(value));

		String uniqueName = String.format(
				"dirid:%s-areaid:%s-clienteid:%s-plataformaid:%s-tipoautid:%s-tipoexecid:%s-devtypeid:%s-catopid:%s",
				automation.getDirid(), automation.getAreaid(), automation.getClienteid(), automation.getPlatformid(),
				automation.getTipoautid(), automation.getTipoexecid(), automation.getDevtypeid(),
				automation.getCatopid());

		automation.setBotDescr(uniqueName);

		if (null != value.getExtraVars().getBotName() && !value.getExtraVars().getBotName().isEmpty()) {
			automation.setBotname(value.getExtraVars().getBotName());
		} else {

			automation.setBotname(uniqueName);
		}

		Automation automationBD = automationBO.searchByKey(automation);
		if (null != automationBD) {
			automation.setId(automationBD.getId());
		}

		automationBO.save(automation);

		return automation;

	}

	/**
	 * Gets the client by organization.
	 *
	 * @param value the value
	 * @return the client by organization
	 * @throws GenericException the generic exception
	 */
	private Integer getClientByOrganization(ValidatorRequest value) throws GenericException {
		OrganizationAWX organizationAWX = organizationAWXBO.selectByName(value.getExtraVars().getOrganization());

		if (null == organizationAWX) {
			throw new GenericException(String.format("El valor [%s] del campo organization no existe.",
					value.getExtraVars().getOrganization()));
		} else {
			EquivalenceClientOrganization equivalenceClientOrganization = equivalenceClientOrganizationBO
					.searchClientByIdOrganization(organizationAWX.getId());
			if (null == equivalenceClientOrganization) {
				throw new GenericException(String.format("No hay cliente asociado a la organización %s.",
						value.getExtraVars().getOrganization()));
			} else {
				return equivalenceClientOrganization.getIdCliente();
			}
		}

	}

	/**
	 * Process request.
	 *
	 * @param value the value
	 * @return the validator response
	 * @throws GenericException the generic exception
	 */
	@Override
	public ValidatorResponse processRequest(ValidatorRequest value) throws GenericException {
		ValidatorResponse response = new ValidatorResponse();
		Automation automation = generateAutomation(value);

		Indicator indicator = new Indicator();

		Date currentDate = new Date();

		String pattern = "'DEPWL.'yyyyMMdd'.'HHmmss'.'SSS";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		indicator.setAutid(automation.getId());
		indicator.setImpactedCis(value.getExtraVars().getTotalCis());
		indicator.setTotalImpactedCis(value.getExtraVars().getTotalImpactedCis());
		indicator.setMantime(value.getExtraVars().getManualTime());
		indicator.setTime(currentDate);
		indicator.setTransactionid(simpleDateFormat.format(currentDate));
		indicator.setUserAgent(value.getExtraVars().getUserAgent());

		if (null != value.getExtraVars().getWoid() && !value.getExtraVars().getWoid().isEmpty()) {
			indicator.setTicketid(value.getExtraVars().getWoid());
		}

		if (null != value.getExtraVars().getSource() && !value.getExtraVars().getSource().isEmpty()) {
			indicator.setSource(value.getExtraVars().getSource());
		}

		int valueCalculate= 3600 ;
		if(calculateIn.equalsIgnoreCase("minutes")){
			valueCalculate = 60;
		}

		if (null != value.getExtraVars().getPlaybookStartTimestamp()
				&& value.getExtraVars().getPlaybookStartTimestamp() > 0) {
			float autotime = 0;
			if (null != value.getExtraVars().getPlaybookEndTimestamp()
					&& value.getExtraVars().getPlaybookEndTimestamp() > 0) {
				if (value.getExtraVars().getPlaybookEndTimestamp() < value.getExtraVars().getPlaybookStartTimestamp()) {
					throw new GenericException(
							"El valor del campo playbook_end_timestamp no puede ser menor que el valor del campo playbook_start_timestamp.");
				}
				autotime = (float) ((value.getExtraVars().getPlaybookEndTimestamp()
						- value.getExtraVars().getPlaybookStartTimestamp()) / valueCalculate);
			} else {
				autotime = (float) ((Instant.now().getEpochSecond() - value.getExtraVars().getPlaybookStartTimestamp())
						/ valueCalculate);
			}
			float svtime = (value.getExtraVars().getManualTime() - autotime);
			float svfte = svtime / 150;
			/*
			 * if (autotime < 0 || svtime < 0) { throw new
			 * GenericException("El campo autotime o svtime son numeos negativos." ); }
			 */

			indicator.setSvtime(svtime);
			indicator.setAutotime(autotime);
			indicator.setSvfte(svfte);

		} else {
			throw new GenericException("El campo playbook_start_timestamp es obligatorio.");
		}

		indicatorBO.save(indicator);

		response.setRecordId(indicator.getId().intValue());
		response.setAutId(automation.getId().intValue());
		response.setMessage("Registro exitoso");

		return response;
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

				EquivalenceClient equivalenceClient = equivalenceClientBO
						.selectByName(value.getExtraVars().getClient());

				if (null != equivalenceClient) {
					client = clientBO.selectById(equivalenceClient.getIdCliente());
				} else {
					throw new GenericException(String.format("El valor [%s] del campo client no existe.",
							value.getExtraVars().getClient()));
				}
			}
		} else {
			throw new GenericException("El campo client es obligatorio.");
		}
		return client.getId();
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

		operativeCatalog = this.operativeCatalogBO.searchByKey(operativeCatalog);

		if (null != operativeCatalog) {
			return operativeCatalog.getId();
		} else {
			throw new GenericException(String.format(
					"No se encontró registro del catálogo operativo con los datos technological_domain = [%s], level_of_specialization = [%s], type_of_task = [%s] y technology = [%s].",
					value.getExtraVars().getTechnologicalDomain(), value.getExtraVars().getLevelOfSpecialization(),
					value.getExtraVars().getTypeOfTask(), value.getExtraVars().getTechnology()));
		}

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

	/**
	 * Validate creator.
	 *
	 * @param value the value
	 * @return the integer
	 * @throws GenericException the generic exception
	 */
	private Integer validateCreator(ValidatorRequest value) throws GenericException {
		Creator creator = null;

		if (null != value.getExtraVars().getCreator() && !value.getExtraVars().getCreator().isEmpty()) {
			creator = creatorBO.selectByName(value.getExtraVars().getCreator());

		}
		return creator != null ? creator.getId() : 1;
	}

	/**
	 * Validate specialist.
	 *
	 * @param value the value
	 * @return the integer
	 * @throws GenericException the generic exception
	 */
	private Integer validateSpecialist(ValidatorRequest value) throws GenericException {
		Specialist specialist = null;

		if (null != value.getExtraVars().getSpecialist() && !value.getExtraVars().getSpecialist().isEmpty()) {
			specialist = specialistBO.selectByName(value.getExtraVars().getSpecialist());

		}
		return specialist != null ? specialist.getId() : 0;
	}

}
