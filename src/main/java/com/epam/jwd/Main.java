package com.epam.jwd;

import com.epam.jwd.database.UsersDatabase;
import com.epam.jwd.entity.User;
import com.epam.jwd.exception.*;
import com.epam.jwd.logic.ConsoleReader;
import com.epam.jwd.logic.Writer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConsoleReader consoleReader = new ConsoleReader();
        Scanner scanner = new Scanner(System.in);

        User user = consoleReader.setUserFieldsFromConsole(scanner);
        User user2 = consoleReader.setUserFieldsFromConsole(scanner);
        scanner.close();

        UsersDatabase usersDatabase = new UsersDatabase();
        Writer writer = new Writer();

        try {
            writer.write(user, usersDatabase);
            writer.write(user2, usersDatabase);
        } catch (UserExistException
                | InvalidNameException
                | InvalidPasswordException
                | InvalidPhoneNumberFormatException
                | InvalidEmailException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(usersDatabase.getUsersMap().toString());

    }
}
