package com.kio.applications.validator.bo;

import java.io.Serializable;

import com.kio.applications.validator.exception.GenericException;
import com.kio.applications.validator.model.Automation;

public interface IfzAutomationBO extends Serializable {

	Automation selectAutomation(Automation value) throws GenericException;

}
