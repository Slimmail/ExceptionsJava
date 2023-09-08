package Homework;

import java.time.LocalDate;

/**
 * Person
 */
public class Person {
  String lastName;
  String name;
  String fatherName;
  LocalDate dateBirth;
  String phoneNumber;
  String gender;

  public Person(String lastName, String name, String fatherName, LocalDate dateBirth, String phoneNumber,
      String gender) {
    this.lastName = lastName;
    this.name = name;
    this.fatherName = fatherName;
    this.dateBirth = dateBirth;
    this.phoneNumber = phoneNumber;
    this.gender = gender;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFatherName() {
    return fatherName;
  }

  public void setFatherName(String fatherName) {
    this.fatherName = fatherName;
  }

  public LocalDate getDateBirth() {
    return dateBirth;
  }

  public void setDateBirth(LocalDate dateBirth) {
    this.dateBirth = dateBirth;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  @Override
  public String toString() {
    return "<" + lastName + "><" + name + "><" + fatherName + "><" + dateBirth
        + "><" + phoneNumber + "><" + gender + ">";
  }

}