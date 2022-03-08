package com.epam.jwd.logic;

import com.epam.jwd.entity.Gender;
import com.epam.jwd.entity.User;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleReader {

    public User setUserFieldsFromConsole(Scanner scanner) {
//        Scanner scanner = new Scanner(System.in);

        String fName = getFirstNameFromConsole(scanner);
        String lName = getLastNameFromConsole(scanner);
        Gender gender = getGenderFromConsole(scanner);
        String email = getEmailFromConsole(scanner);
        String phoneNumber = getPhoneNumberFromConsole(scanner);
        String password = getPasswordFromConsole(scanner);
        System.out.println();
//        scanner.close();
        return new User(fName,
                lName,
                gender,
                phoneNumber,
                email,
                password);
    }

    private String getFirstNameFromConsole(Scanner scanner) {
        System.out.print("Enter your first name: \t");

        return scanner.nextLine();
    }

    private String getLastNameFromConsole(Scanner scanner) {
        System.out.print("Enter your last name: \t");

        return scanner.nextLine();
    }

    private Gender getGenderFromConsole(Scanner scanner) {
        System.out.print("Enter your gender (Male(M) or Female(F)): \t");

        String genderString = scanner.nextLine();
        Pattern patternMale = Pattern.compile("^[mM][aA][Ll][Ee]$|^[mM]$");
        Matcher matcherMale = patternMale.matcher(genderString);
        Pattern patternFemale = Pattern.compile("^[Ff][eE][mM][aA][Ll][Ee]$|^[fF]$");
        Matcher matcherFemale = patternFemale.matcher(genderString);
        if (matcherMale.find()) {
            return Gender.MALE;
        } else if (matcherFemale.find()) {
            return Gender.FEMALE;
        } else {
            return Gender.NONE;
//            throw new EnumConstantNotPresentException(Gender.class, genderString);
        }
    }

    private String getPhoneNumberFromConsole(Scanner scanner) {
        System.out.print("Enter your phone number: \t");

        return scanner.nextLine();
    }

    private String getEmailFromConsole(Scanner scanner) {
        System.out.print("Enter your email: \t");

        return scanner.nextLine();
    }

    // At least
    // one lowercase character,
    // one uppercase character,
    // one digit,
    // one special character
    // and length between 8 to 32.
    //Valid password: 0123456789$abcdefgAB
    private String getPasswordFromConsole(Scanner scanner) {
        System.out.print("Enter your password \n(from 8 to 32 characters): \t");

        return scanner.nextLine();
    }
}
