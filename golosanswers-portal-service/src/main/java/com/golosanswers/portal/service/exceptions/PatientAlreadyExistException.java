package com.golosanswers.portal.service.exceptions;

import com.golosanswers.portal.exceptions.GolosanswersException;

public class PatientAlreadyExistException extends GolosanswersException {

    public PatientAlreadyExistException(String patientId) {
        super("Patient with such id [" + patientId + "] already exist");
    }
}
