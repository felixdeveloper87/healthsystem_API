/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.healthsystem.model;

import java.util.List;

/**
 * Represents a patient in the healthcare system, extending the Person class.
 * Incorporates detailed health-related attributes such as medical history and
 * current health status. Provides constructors to instantiate patient objects
 * either with default settings or specific details.
 *
 * @author Leandro
 */
public class Patient extends Person {

    private String medicalHistory;
    private String currentHealthStatus;
    private String doctorName;

    /**
     * Default constructor for creating a Patient instance. Initializes the
     * superclass Person attributes using its default constructor.
     */
    public Patient() {
        super();
    }

    /**
     * Constructs a Patient with specified personal and health-related details.
     *
     * @param id Unique identifier for the patient.
     * @param name Patient's full name.
     * @param contactNumber Patient's contact number.
     * @param email Patient's email address.
     * @param address Patient's residential or work address.
     * @param medicalHistory Brief description of the patient's past medical
     * history.
     * @param currentHealthStatus Current health status or condition of the
     * patient.
     * @param doctors
     */
    public Patient(String id, String name, String contactNumber, String email, String address,
            String medicalHistory, String currentHealthStatus, String doctorName) {
        super(id, name, contactNumber, email, address);
        this.medicalHistory = medicalHistory;
        this.currentHealthStatus = currentHealthStatus;
        this.doctorName = doctorName;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getCurrentHealthStatus() {
        return currentHealthStatus;
    }

    public void setCurrentHealthStatus(String currentHealthStatus) {
        this.currentHealthStatus = currentHealthStatus;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

}
