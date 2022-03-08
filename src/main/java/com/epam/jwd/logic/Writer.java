package com.epam.jwd.logic;

import com.epam.jwd.database.UsersDatabase;
import com.epam.jwd.entity.User;
import com.epam.jwd.exception.*;
import com.epam.jwd.logic.validator.impl.UserValidator;

public class Writer {

    public void write(User user, UsersDatabase usersDatabase)
            throws UserExistException,
            InvalidNameException,
            InvalidPasswordException,
            InvalidPhoneNumberFormatException,
            InvalidEmailException {
        UserValidator userValidator = new UserValidator();
        userValidator.validate(user);

        if (!usersDatabase.isUserExist(user.getEmail())) {
            usersDatabase.addUser(user);
        } else {
            throw new UserExistException("\nSorry, user with this email already exist\n");
        }

    }
}
