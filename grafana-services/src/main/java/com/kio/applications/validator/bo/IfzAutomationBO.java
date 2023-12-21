package com.kio.applications.validator.bo;

import java.io.Serializable;

import com.kio.applications.validator.exception.GenericException;
import com.kio.applications.validator.model.Automation;

/**
 * The interface Ifz automation bo.
 */
public interface IfzAutomationBO extends Serializable {

	/**
	 * Select automation automation.
	 *
	 * @param value the value
	 * @return the automation
	 * @throws GenericException the generic exception
	 */
	Automation selectAutomation(Automation value) throws GenericException;

}
