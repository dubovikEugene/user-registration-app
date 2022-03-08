package com.epam.jwd.logic.validator;

import com.epam.jwd.exception.InvalidEmailException;
import com.epam.jwd.exception.InvalidNameException;
import com.epam.jwd.exception.InvalidPasswordException;
import com.epam.jwd.exception.InvalidPhoneNumberFormatException;

public interface Validator<T> {
    void validate(T t) throws InvalidNameException,
            InvalidEmailException,
            InvalidPhoneNumberFormatException,
            InvalidPasswordException;
}
