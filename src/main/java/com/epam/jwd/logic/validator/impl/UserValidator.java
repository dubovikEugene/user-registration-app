package com.epam.jwd.logic.validator.impl;

import com.epam.jwd.entity.User;
import com.epam.jwd.exception.InvalidEmailException;
import com.epam.jwd.exception.InvalidNameException;
import com.epam.jwd.exception.InvalidPasswordException;
import com.epam.jwd.exception.InvalidPhoneNumberFormatException;
import com.epam.jwd.logic.validator.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator implements Validator<User> {

    @Override
    public void validate(User user) throws InvalidNameException,
            InvalidEmailException,
            InvalidPhoneNumberFormatException,
            InvalidPasswordException {

        validateFirstName(user);
        validateLastName(user);
        validatePhoneNumber(user);
        validateEmail(user);
        validatePassword(user);

    }

    private void validateFirstName(User user) throws InvalidNameException {
        Pattern pattern = Pattern.compile("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$");
        Matcher matcher = pattern.matcher(user.getFirstName());
        if (!matcher.find()) {
            throw new InvalidNameException("Invalid first name");
        }

    }

    private void validateLastName(User user) throws InvalidNameException {
        Pattern pattern = Pattern.compile("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$");
        Matcher matcher = pattern.matcher(user.getLastName());
        if (!matcher.find()) {
            throw new InvalidNameException("Invalid last name");
        }
    }

    private void validatePhoneNumber(User user) throws InvalidPhoneNumberFormatException {
        String regex = "^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(user.getPhoneNumber());
        if (!matcher.find()) {
            throw new InvalidPhoneNumberFormatException("Invalid phone number format");
        }
    }


    private void validateEmail(User user) throws InvalidEmailException {
        Pattern pattern = Pattern.compile("^\\w+[a-zA-Z_0-9\\.!\\?-]+@[a-zA-z]{2,}(\\.[a-zA-z]{2,3}){1,3}$");
        Matcher matcher = pattern.matcher(user.getEmail());
        if (!matcher.find()) {
            throw new InvalidEmailException("Invalid email format");
        }

    }

    // At least
    // one lowercase character,
    // one uppercase character,
    // one digit,
    // one special character
    // and length between 8 to 32.
    private void validatePassword(User user) throws InvalidPasswordException {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,32}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(user.getPassword());
        if (!matcher.find()) {
            throw new InvalidPasswordException("Invalid password format");
        }
    }

}
