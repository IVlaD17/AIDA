package com.example.aida.models;

import com.example.aida.utility.Methods;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class User implements Serializable {
    private String id;
    private String emailAddress;
    private String password;
    private String firstName;
    private String lastName;
    private String telephone;
    private String address;
    private City city;
    private Country country;
    private String diabetesType;

    public User(String id, String emailAddress, String password, String firstName, String lastName, String telephone,
                String address, Country country, City city, String diabetesType) {
        this.id = id;
        this.emailAddress = emailAddress;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.address = address;
        this.city = city;
        this.country = country;
        this.diabetesType = diabetesType;
    }

    public User(String id, String emailAddress, String password, String firstName, String lastName, String telephone,
                String address, String country, String city, String diabetesType, ArrayList<Country> countries) {
        this.id = id;
        this.emailAddress = emailAddress;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.address = address;
        this.diabetesType = diabetesType;

        this.country = Methods.findCountryByName(country, countries);
        if(this.country != null){
            this.city = Methods.findCityByName(city, this.country.getCities());
        }
        else {
            this.city = null;
        }
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
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

    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

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

    public String getDiabetesType() {
        return diabetesType;
    }
    public void setDiabetesType(String diabetesType) {
        this.diabetesType = diabetesType;
    }

    public Map<String, Object> getDBFormat(){
        Map<String, Object> dbUser = new HashMap<>();

        dbUser.put("email", emailAddress);
        dbUser.put("password", password);
        dbUser.put("address", address);
        dbUser.put("city", city.getName());
        dbUser.put("country", country.getName());
        dbUser.put("diabetesType", diabetesType);
        dbUser.put("firstName", firstName);
        dbUser.put("lastName", lastName);
        dbUser.put("telephone", telephone);

        return dbUser;
    }
}
