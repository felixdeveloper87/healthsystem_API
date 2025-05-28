/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.healthsystem.model;

/**
 * Represents a generic person within the healthcare system.
 * Serves as a superclass for more specific roles such as Patient or Doctor.
 * Encapsulates common attributes such as ID, name, contact information, email, and address.
 *
 * @author Leandro
 */
public class Person {
    private String id;
    private String name;
    private String contactNumber;
    private String email;
    private String address;

    /**
     * Default constructor for creating a Person instance without initializing fields.
     */
    public Person(){
    
    }

    /**
     * Constructs a Person with specified personal details.
     * @param id Unique identifier for the person.
     * @param name Full name of the person.
     * @param contactNumber Contact number of the person.
     * @param email Email address of the person.
     * @param address Residential or work address of the person.
     */
    public Person(String id, String name, String contactNumber, String email, String address) {
        this.id = id;
        this.name = name;
        this.contactNumber = contactNumber;
        this.email = email;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}
