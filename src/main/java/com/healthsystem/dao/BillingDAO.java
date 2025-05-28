package com.healthsystem.dao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Manages billing records for patients within the healthcare system.
 * It supports creating, retrieving, updating, and deleting billing records using a static list.
 * Utilizes PatientDAO to fetch existing patients for billing purposes.
 * 
 * @author Leandro
 */
import com.healthsystem.model.Appointment;
import com.healthsystem.model.Billing;
import com.healthsystem.model.Patient;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class BillingDAO {
    private static final List<Billing> billings = new ArrayList<>();
    
    static {
        // Instantiate Patient DAO
        PatientDAO patientDAO = new PatientDAO();
        AppointmentDAO appointmentDAO = new AppointmentDAO();
        
        // Assume this method returns a list of already created patients
        List<Patient> patients = patientDAO.getAllPatients();
        List<Appointment> appointments = appointmentDAO.getAllAppointments();

        // Generate billing records based on data from other DAOs
        // Check for a sufficient number of patients to create billing records
        if (patients.size() >= 2) {
            // Creating billing entries with dummy amounts and current date
            billings.add(new Billing("1",appointments.get(0),200.50, new Date()));
            billings.add(new Billing("2", appointments.get(1), 350.75, new Date()));
        }
    }

    /**
     * Retrieves all billing records.
     * @return A list of all billing records
     */
    public List<Billing> getAllBillings() {
        return billings;
    }

    /**
     * Retrieves a specific billing record by its ID.
     * @param id The ID of the billing to retrieve
     * @return The billing record if found, null otherwise
     */
    public Billing getBillingById(String id) {
        for (Billing billing : billings) {
            if (billing.getBillingId().equals(id)) {
                return billing;
            }
        }
        return null;
    }

    /**
     * Adds a new billing record to the list.
     * @param billing The billing object to add
     */
    public void addBilling(Billing billing) {
        billings.add(billing);
    }

    /**
     * Updates an existing billing record in the list.
     * @param updatedBilling The updated billing details
     */
    public void updateBilling(Billing updatedBilling) {
        for (int i = 0; i < billings.size(); i++) {
            Billing billing = billings.get(i);
            if (billing.getBillingId().equals(updatedBilling.getBillingId())) {
                billings.set(i, updatedBilling);
                return;
            }
        }
    }

    /**
     * Deletes a billing record based on its ID.
     * @param id The ID of the billing to delete
     * @return true if the billing was successfully deleted, false otherwise
     */
    public boolean deleteBilling(String id) {
        return billings.removeIf(billing -> billing.getBillingId().equals(id));
    }
}

