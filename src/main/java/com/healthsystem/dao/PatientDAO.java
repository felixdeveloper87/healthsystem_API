/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.healthsystem.dao;

/**
 * Handles data operations for patients within the healthcare system.
 * Provides methods to manage patient data including adding, retrieving, updating, and deleting records using a static list.
 * Initializes with a set of predefined patients to facilitate testing and development.
 *
 * @author Leandro
 */
//import com.healthsystem.model.Doctor;
import com.healthsystem.model.Patient;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {
    private static final List<Patient> patients = new ArrayList<>();
//    private static final List<Doctor> doctors = new ArrayList<>();

    static {
        // Initialize patients with their doctor's name
        patients.add(new Patient("1", "John Doe", "123456789", "john.doe@example.com", "123 Elm St", "No medical history", "Good", "Dr. Alice Johnson"));
        patients.add(new Patient("2", "Jane Smith", "987654321", "jane.smith@example.com", "456 Oak St", "Allergic to penicillin", "Needs evaluation", "Dr. Bob Smith"));
    }

    /**
     * Retrieves all patients from the static list.
     * @return A list of all patients
     */
    public List<Patient> getAllPatients() {
        return patients;
    }

    /**
     * Retrieves a specific patient by their unique ID.
     * @param id The ID of the patient to retrieve
     * @return The patient if found, null otherwise
     */
    public Patient getPatientById(String id) {
        for (Patient patient : patients) {
            if (patient.getId().equals(id)) {
                return patient;
            }
        }
        return null;
    }

    /**
     * Adds a new patient to the list.
     * @param patient The patient to be added
     */
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    /**
     * Updates an existing patient's information in the list.
     * @param updatedPatient The patient with updated details
     */
    public void updatePatient(Patient updatedPatient) {
        for (int i = 0; i < patients.size(); i++) {
            Patient patient = patients.get(i);
            if (patient.getId().equals(updatedPatient.getId())) {
                patients.set(i, updatedPatient);               
                return;
            }
        }
    }

    /**
     * Deletes a patient from the list based on their ID.
     * @param id The ID of the patient to delete
     * @return 
     */
    public boolean deletePatient(String id) {
        return patients.removeIf(patient -> patient.getId().equals(id));
    }
}
