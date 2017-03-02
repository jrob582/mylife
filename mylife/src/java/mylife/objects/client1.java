/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylife.objects;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author johna
 */
public class client1 implements Serializable {

    private int idclient1;
    private String firstname;
    private String lastname;
    private String addressline1;
    private String addressline2;
    private String city;
    private String state;
    private String zip;
    private String email;
    private String current_status;
    private String phone_number;
    private Map<String, String> states;
    
    
    
    
    
    public int getIdclient1() {
        return idclient1;
    }

    public void setIdclient1(int idclient1) {
        this.idclient1 = idclient1;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddressline1() {
        return addressline1;
    }

    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    public String getAddressline2() {
        return addressline2;
    }

    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurrent_status() {
        return current_status;
    }

    public void setCurrent_status(String current_status) {
        this.current_status = current_status;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
       
        buffer.append("First Name: " + firstname + ";");
        buffer.append("Last Name: " + lastname + ";");
        buffer.append("Addressline1: " + addressline1 + ";");
        buffer.append("Addressline2: " + addressline2 + ";");
        buffer.append("City: " + city + ";");
        buffer.append("State: " + state + ";");
        buffer.append("Zip: " + zip + ";");
        buffer.append("Email: " + email + ";");
        buffer.append("Currentstatus: " + current_status + ";");
        buffer.append("Phone Number: " + phone_number + ";");

        return buffer.toString();
    }
    
    
    public Map<String, String> getStates() {
        states = new LinkedHashMap<>();
        states.put("Alabama", "Alabama");
        states.put("Alaska", "Alaska");
        states.put("Arizona", "Arizona");
        states.put("Arkansas", "Arkansas");
        states.put("California", "California");
        states.put("Colorado", "Colorado");
        states.put("Connecticut", "Connecticut");
        states.put("Delaware", "Delaware");
        states.put("Florida", "Florida");
        states.put("Georgia", "Georgia");
        states.put("Hawaii", "Hawii");
        states.put("Idaho", "Idaho");
        states.put("Illinois", "Illinois");
        states.put("Indiana", "Indiana");
        states.put("Iowa", "Iowa");
        states.put("Kansas", "Kansas");
        states.put("Kentucky", "Kentucky");
        states.put("Louisiana", "Louisiana");
        states.put("Maine", "Maine");
        states.put("Maryland", "Maryland");
        states.put("Massachusetts", "Massachusetts");
        states.put("Michigan", "Michigan");
        states.put("Minnesota", "Minnesota");
        states.put("Mississippi", "Mississippi");
        states.put("Missouri", "Missouri");
        states.put("Montana", "Montana");
        states.put("Nebraska", "Nebraska");
        states.put("Nevada", "Nevada");
        states.put("New Hampshire", "New Hampshire");
        states.put("New Jersey", "New Jersey");
        states.put("New Mexico", "New Mexico");
        states.put("New York", "New York");
        states.put("North Carolina", "North Carolina");
        states.put("North Dakota", "North Dakota");
        states.put("Ohio", "Ohio");
        states.put("Oklahoma", "Oklahoma");
        states.put("Oregon", "Oregon");
        states.put("Pennsylvania", "Pensylvania");
        states.put("Rhode Island", "Rhode Island");
        states.put("South Carolina", "South Carolina");
        states.put("South Dakota", "South Dakota");
        states.put("Tennessee", "Tennessee");
        states.put("Texas", "Texas");
        states.put("Utah", "Utah");
        states.put("Vermont", "Vermont");
        states.put("Virginia", "Virginia");
        states.put("Washington", "Washington");
        states.put("Washington DC", "Washington DC");
        states.put("West Virginia", "West Virginia");
        states.put("Wisconson", "Wisconson");
        states.put("Wyoming", "Wyoming");
        
        return states;
    }
}

