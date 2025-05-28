/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.healthsystem.dao;

/**
 * Manages the storage and retrieval of medical records within the healthcare system.
 * Provides methods to add, retrieve, update, and delete medical records, using a static list initialized with detailed sample data.
 * Leverages the PatientDAO to link records with existing patients and includes comprehensive details like diagnoses, treatments, allergies, and medications.
 *
 * @author Leandro
 */
import com.healthsystem.model.MedicalRecord;
import com.healthsystem.model.Patient;
import java.util.ArrayList;
import java.util.List;

public class MedicalRecordDAO {
    private static final List<MedicalRecord> medicalRecords = new ArrayList<>();

    static {
        // Instance of DAO to obtain patients as needed
        PatientDAO patientDAO = new PatientDAO();
        List<Patient> patients = patientDAO.getAllPatients();

        // Check for sufficient number of patients to link to detailed medical records
        if (patients.size() >= 2) {
            // Create detailed medical records with fictitious medical histories
            List<String> diagnoses1 = new ArrayList<>();
            diagnoses1.add("Diabetes");
            List<String> treatments1 = new ArrayList<>();
            treatments1.add("Insulin");
            List<String> allergies1 = new ArrayList<>();
            allergies1.add("Penicillin");
            List<String> surgeries1 = new ArrayList<>();
            surgeries1.add("Appendectomy");
            List<String> medications1 = new ArrayList<>();
            medications1.add("Metformin");
            String treatmentPlan1 = "Monitor and adjust insulin as needed.";

            List<String> diagnoses2 = new ArrayList<>();
            diagnoses2.add("Hypertension");
            List<String> treatments2 = new ArrayList<>();
            treatments2.add("ACE inhibitors");
            List<String> allergies2 = new ArrayList<>();
            allergies2.add("Aspirin");
            List<String> surgeries2 = new ArrayList<>();
            surgeries2.add("Gallbladder removal");
            List<String> medications2 = new ArrayList<>();
            medications2.add("Lisinopril");
            String treatmentPlan2 = "Regular blood pressure checks.";

            medicalRecords.add(new MedicalRecord("1", patients.get(0), diagnoses1, treatments1, allergies1, surgeries1, medications1, treatmentPlan1));
            medicalRecords.add(new MedicalRecord("2", patients.get(1), diagnoses2, treatments2, allergies2, surgeries2, medications2, treatmentPlan2));
        }
    }

    /**
     * Retrieves all medical records.
     * @return A list of all medical records
     */
    public List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecords;
    }

    /**
     * Retrieves a specific medical record by its ID.
     * @param id The ID of the medical record to retrieve
     * @return The medical record if found, null otherwise
     */
    public MedicalRecord getMedicalRecordById(String id) {
        for (MedicalRecord record : medicalRecords) {
            if (record.getRecordId().equals(id)) {
                return record;
            }
        }
        return null;
    }

    /**
     * Adds a new medical record to the list.
     * @param record The medical record to be added
     */
    public void addMedicalRecord(MedicalRecord record) {
        medicalRecords.add(record);
    }

    /**
     * Updates an existing medical record in the list.
     * @param updatedRecord The medical record with updated details
     */
    public void updateMedicalRecord(MedicalRecord updatedRecord) {
        for (int i = 0; i < medicalRecords.size(); i++) {
            MedicalRecord record = medicalRecords.get(i);
            if (record.getRecordId().equals(updatedRecord.getRecordId())) {
                medicalRecords.set(i, updatedRecord);
                return;
            }
        }
    }

    /**
     * Deletes a medical record from the list based on its ID.
     * @param id The ID of the medical record to delete
     * @return true if the medical record was successfully deleted, false otherwise
     */
    public boolean deleteMedicalRecord(String id) {
        return medicalRecords.removeIf(record -> record.getRecordId().equals(id));
    }
}
