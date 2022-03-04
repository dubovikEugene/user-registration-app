package com.epam.jwd.entity;

import java.time.LocalDate;

public class User {
    private String firstName;
    private String lastName;
    private int age;
    private LocalDate birthDate;
    private Gender gender;
    private String phoneNumber;
    private String email;
    private String password;

    public User(String firstName,
                String lastName,
                int age,
                LocalDate birthDate,
                Gender gender,
                String phoneNumber,
                String email,
                String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.birthDate = birthDate;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return age == user.getAge()
                && firstName.equalsIgnoreCase(user.getFirstName())
                && lastName.equalsIgnoreCase(user.getLastName())
                && birthDate.equals(user.getBirthDate())
                && gender == user.getGender()
                && phoneNumber.equalsIgnoreCase(user.getPhoneNumber())
                && email.equalsIgnoreCase(user.getEmail())
                && password.equals(user.getPassword());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = getAge();
        result = prime * result * getFirstName().hashCode();
        result = prime * result * getLastName().hashCode();
        result = prime * result * getBirthDate().hashCode();
        result = prime * result * getGender().hashCode();
        result = prime * result * getPhoneNumber().hashCode();
        result = prime * result * getEmail().hashCode();
        result = prime * result * getPassword().hashCode();
        return result;
    }
}
