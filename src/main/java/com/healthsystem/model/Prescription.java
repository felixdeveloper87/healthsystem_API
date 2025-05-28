/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.healthsystem.model;

/**
 * Represents a medical prescription within the healthcare system.
 * Encapsulates details such as prescription ID, the prescribing doctor, the patient, medication details,
 * dosage, specific instructions, and the duration of the prescription.
 *
 * @author Leandro
 */
public class Prescription {
    private String prescriptionId;
    private Doctor prescribedBy;
    private Patient patient;
    private String medication;
    private String dosage;
    private String instructions;
    private int durationDays;

    /**
     * Default constructor for creating a Prescription instance without initializing fields.
     */
    public Prescription() {
    }

    /**
     * Constructs a Prescription with specified details.
     * @param prescriptionId Unique identifier for the prescription.
     * @param prescribedBy Doctor who issued the prescription.
     * @param patient Patient to whom the prescription is issued.
     * @param medication Name of the medication prescribed.
     * @param dosage Dosage of the medication.
     * @param instructions Specific instructions for taking the medication.
     * @param durationDays Duration in days for which the medication is prescribed.
     */
    public Prescription(String prescriptionId, Doctor prescribedBy, Patient patient, String medication, String dosage, String instructions, int durationDays) {
        this.prescriptionId = prescriptionId;
        this.prescribedBy = prescribedBy;
        this.patient = patient;
        this.medication = medication;
        this.dosage = dosage;
        this.instructions = instructions;
        this.durationDays = durationDays;
    }

    public String getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(String prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public Doctor getPrescribedBy() {
        return prescribedBy;
    }

    public void setPrescribedBy(Doctor prescribedBy) {
        this.prescribedBy = prescribedBy;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public int getDurationDays() {
        return durationDays;
    }

    public void setDurationDays(int durationDays) {
        this.durationDays = durationDays;
    }
    
}
