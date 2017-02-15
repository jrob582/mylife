/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylife.objects;

import java.io.Serializable;

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
        buffer.append("Client1ID: " + this.idclient1 + ";");
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
}
