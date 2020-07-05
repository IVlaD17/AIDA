package com.example.aida.models.userModels;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class User implements Serializable {
    // Meta Fields
    private String id;

    // Personal Fields
    private String firstName;
    private String lastName;
    private String diabetesType;

    // Contact Fields
    private String telephone;
    private String emailAddress;
    private String password;

    // Address Fields
    private String address;
    private City city;
    private Country country;

    // Default Constructor
    public User() {
        this.id = "NoID";

        this.firstName = "NoFirstName";
        this.lastName = "NoLastName";
        this.diabetesType = "NoDiabetesType";

        this.telephone = "NoTelephone";
        this.emailAddress = "NoEmail";
        this.password = "NoPassword";

        this.address = "NoAddress";
        this.city = new City();
        this.country = new Country();
    }

    // Generic Constructor
    public User(String id, String firstName, String lastName, String diabetesType, String telephone, String emailAddress, String password, String address, Country country, City city) {
        this.id = id;

        this.firstName = firstName;
        this.lastName = lastName;
        this.diabetesType = diabetesType;

        this.telephone = telephone;
        this.emailAddress = emailAddress;
        this.password = password;

        this.address = address;
        this.city = city;
        this.country = country;
    }

    // Meta Accessors
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    // Personal Accessors
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

    public String getDiabetesType() {
        return diabetesType;
    }
    public void setDiabetesType(String diabetesType) {
        this.diabetesType = diabetesType;
    }

    // Contact Accessors
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    // Address Accessors
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public City getCity() {
        return city;
    }
    public void setCity(City city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }
    public void setCountry(Country country) {
        this.country = country;
    }

    // Database Object Generator
    public Map<String, Object> toDBObject(){
        Map<String, Object> user = new HashMap<>();

        user.put("firstName", firstName);
        user.put("lastName", lastName);
        user.put("diabetesType", diabetesType);

        user.put("telephone", telephone);
        user.put("email", emailAddress);
        user.put("password", password);

        user.put("address", address);
        user.put("city", city.getName());
        user.put("country", country.getName());

        return user;
    }
}
