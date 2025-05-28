/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.healthsystem.dao;

/**
 * Manages prescription records within the healthcare system.
 * Provides functionalities to manage prescriptions including adding, retrieving, updating, and deleting records using a static list.
 * Initializes with a set of predefined prescriptions to demonstrate linking with doctors and patients.
 *
 * @author Leandro
 */
import com.healthsystem.model.Doctor;
import com.healthsystem.model.Patient;
import com.healthsystem.model.Prescription;
import java.util.ArrayList;
import java.util.List;

public class PrescriptionDAO {
    private static final List<Prescription> prescriptions = new ArrayList<>();
    
    static {
        // Instances of DAOs to retrieve doctors and patients
        DoctorDAO doctorDAO = new DoctorDAO();
        PatientDAO patientDAO = new PatientDAO();

        // Fetch lists of doctors and patients
        List<Doctor> doctors = doctorDAO.getAllDoctors();
        List<Patient> patients = patientDAO.getAllPatients();

        // Check if there are enough doctors and patients
        if (doctors.size() >= 2 && patients.size() >= 2) {
            prescriptions.add(new Prescription(
                "1",
                doctors.get(0),
                patients.get(0),
                "Amoxicillin",
                "500mg",
                "Take one tablet three times a day",
                7
            ));
            prescriptions.add(new Prescription(
                "2",
                doctors.get(1),
                patients.get(1),
                "Ibuprofen",
                "200mg",
                "Take two tablets twice a day",
                5
            ));
        }
    }

    /**
     * Retrieves all prescriptions.
     * @return A list of all prescriptions
     */
    public List<Prescription> getAllPrescriptions() {
        return prescriptions;
    }

    /**
     * Retrieves a specific prescription by its ID.
     * @param id The ID of the prescription to retrieve
     * @return The prescription if found, null otherwise
     */
    public Prescription getPrescriptionById(String id) {
        for (Prescription prescription : prescriptions) {
            if (prescription.getPrescriptionId().equals(id)) {
                return prescription;
            }
        }
        return null;
    }

    /**
     * Adds a new prescription to the list.
     * @param prescription The prescription to be added
     */
    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
    }

    /**
     * Updates an existing prescription in the list.
     * @param updatedPrescription The prescription with updated details
     */
    public void updatePrescription(Prescription updatedPrescription) {
        for (int i = 0; i < prescriptions.size(); i++) {
            Prescription prescription = prescriptions.get(i);
            if (prescription.getPrescriptionId().equals(updatedPrescription.getPrescriptionId())) {
                prescriptions.set(i, updatedPrescription);
                return;
            }
        }
    }

    /**
     * Deletes a prescription from the list based on its ID.
     * @param id The ID of the prescription to delete
     * @return true if the prescription was successfully deleted, false otherwise
     */
    public boolean deletePrescription(String id) {
        return prescriptions.removeIf(prescription -> prescription.getPrescriptionId().equals(id));
    }
}
