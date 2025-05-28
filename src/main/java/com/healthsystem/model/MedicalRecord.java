/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.healthsystem.model;

import java.util.List;

/**
 * * Represents a medical record in the healthcare system.
 * Contains detailed health information about a patient, including past medical history,
 * current conditions, allergies, surgeries, prescribed medications, and treatment plans.
 *
 * @author Leandro
 */
public class MedicalRecord {
    private String recordId;
    private Patient patient;
    private List<String> diagnoses;
    private List<String> treatments;
    private List<String> allergies; 
    private List<String> surgeries; 
    private List<String> medications; 
    private String treatmentPlan; 

    /**
     * Default constructor for creating a MedicalRecord instance without initializing fields.
     */
    public MedicalRecord(){}

    /**
     * Constructs a MedicalRecord with specified details, including patient information and medical details.
     * @param recordId Unique identifier for the medical record.
     * @param patient Patient associated with this record.
     * @param diagnoses List of diagnoses assigned to the patient.
     * @param treatments List of treatments prescribed to the patient.
     * @param allergies
     * @param surgeries
     * @param medications
     * @param treatmentPlan
     */
    public MedicalRecord(String recordId, Patient patient, List<String> diagnoses, List<String> treatments,
                         List<String> allergies, List<String> surgeries, List<String> medications, String treatmentPlan) {
        this.recordId = recordId;
        this.patient = patient;
        this.diagnoses = diagnoses;
        this.treatments = treatments;
        this.allergies = allergies;
        this.surgeries = surgeries;
        this.medications = medications;
        this.treatmentPlan = treatmentPlan;
    }

    /**
     * Gets the unique record ID of the medical record.
     * @return The record ID.
     */
    public String getRecordId() {
        return recordId;
    }

    /**
     * Sets the unique record ID of the medical record.
     * @param recordId The new record ID to set.
     */
    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    /**
     * Gets the patient associated with the medical record.
     * @return The patient.
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * Sets the patient associated with the medical record.
     * @param patient The patient to set.
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * Gets the list of diagnoses for the patient.
     * @return A list of diagnoses.
     */
    public List<String> getDiagnoses() {
        return diagnoses;
    }

    /**
     * Sets the list of diagnoses for the patient.
     * @param diagnoses A new list of diagnoses to set.
     */
    public void setDiagnoses(List<String> diagnoses) {
        this.diagnoses = diagnoses;
    }

    /**
     * Gets the list of treatments for the patient.
     * @return A list of treatments.
     */
    public List<String> getTreatments() {
        return treatments;
    }

    /**
     * Sets the list of treatments for the patient.
     * @param treatments A new list of treatments to set.
     */
    public void setTreatments(List<String> treatments) {
        this.treatments = treatments;
    }
    
    public List<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }

    public List<String> getSurgeries() {
        return surgeries;
    }

    public void setSurgeries(List<String> surgeries) {
        this.surgeries = surgeries;
    }

    public List<String> getMedications() {
        return medications;
    }

    public void setMedications(List<String> medications) {
        this.medications = medications;
    }

    public String getTreatmentPlan() {
        return treatmentPlan;
    }

    public void setTreatmentPlan(String treatmentPlan) {
        this.treatmentPlan = treatmentPlan;
    }
}
