/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.healthsystem.model;

import java.util.List;

/**
 * Represents a doctor within the healthcare system. Extends the Person class,
 * adding specialization details. Includes constructors for creating doctor
 * objects both with and without specialization details initially set.
 *
 * @author Leandro
 */
public class Doctor extends Person {

    private String specialization;
    private List<String> patients;

    /**
     * Default constructor for creating a Doctor instance. Invokes the
     * superclass (Person) constructor to ensure proper initialization of
     * inherited fields.
     */
    public Doctor() {
        super(); // Call the superclass constructor to initialize the person attributes.
    }

    /**
     * Constructs a Doctor with specified details, including specialization.
     *
     * @param id Unique identifier for the doctor.
     * @param name Doctor's full name.
     * @param contactNumber Doctor's contact number.
     * @param email Doctor's email address.
     * @param address Doctor's residential or work address.
     * @param specialization Medical specialization of the doctor.
     */
    public Doctor(String id, String name, String contactNumber, String email, String address, String specialization, List<String> patients) {
        super(id, name, contactNumber, email, address);
        this.specialization = specialization;
        this.patients = patients;
    }

    /**
     * Retrieves the doctor's specialization.
     *
     * @return The medical specialization of the doctor.
     */
    public String getSpecialization() {
        return specialization;
    }

    /**
     * Sets the doctor's specialization.
     *
     * @param specialization New medical specialization to set.
     */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public List<String> getPatientNames() {
        return patients;
    }

    public void setPatientNames(List<String> patients) {
        this.patients = patients;
    }
}
