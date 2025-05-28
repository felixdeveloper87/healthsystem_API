/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.healthsystem.dao;

/**
 * Handles data storage and retrieval operations for doctors in the healthcare
 * system. Provides functionality to add, retrieve, update, and delete doctor
 * records using a static list. Initializes with a set of predefined doctors for
 * demonstration purposes.
 *
 * @author Leandro
 */
import com.healthsystem.model.Doctor;
//import com.healthsystem.model.Patient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DoctorDAO {

    private static final List<Doctor> doctors = new ArrayList<>();
//    private static final List<Patient> patients = new ArrayList<>();

    static {
        // Initialize sample doctors with empty patient lists for simplicity
        doctors.add(new Doctor("1", "Dr. Alice Johnson", "555-0100", "alice.johnson@example.com", "123 Health St", "Cardiology",  Arrays.asList("John Doe", "Jane Doe")));
        doctors.add(new Doctor("2", "Dr. Bob Smith", "555-0120", "bob.smith@example.com", "456 Care Blvd", "Pediatrics",  Arrays.asList("Jane Smith")));
    }

    /**
     * Retrieves all registered doctors.
     *
     * @return A list of all doctors
     */
    public List<Doctor> getAllDoctors() {
        return doctors;
    }

    /**
     * Retrieves a doctor by their unique ID.
     *
     * @param id The ID of the doctor to retrieve
     * @return The doctor if found, null otherwise
     */
    public Doctor getDoctorById(String id) {
        for (Doctor doctor : doctors) {
            if (doctor != null && doctor.getId().equals(id)) {
                return doctor;
            }
        }
        return null;
    }

    /**
     * Adds a new doctor to the list.
     *
     * @param doctor The doctor to be added
     */
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    /**
     * Updates an existing doctor's information in the list.
     *
     * @param updatedDoctor The doctor with updated details
     */
    public void updateDoctor(Doctor updatedDoctor) {
        for (int i = 0; i < doctors.size(); i++) {
            Doctor doctor = doctors.get(i);
            if (doctor.getId().equals(updatedDoctor.getId())) {
                doctors.set(i, updatedDoctor);
                return;
            }
        }
    }

    /**
     * Deletes a doctor from the list based on their ID.
     *
     * @param id The ID of the doctor to delete
     * @return true if the doctor was successfully deleted, false otherwise
     */
    public boolean deleteDoctor(String id) {
        return doctors.removeIf(doctor -> doctor.getId().equals(id));
    }
    
}
