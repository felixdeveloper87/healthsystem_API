/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.healthsystem.dao;

/**
 * Handles the operations related to managing appointments in the healthcare system.
 * Provides methods to create, retrieve, update, and delete appointments using a static list.
 * Utilizes DoctorDAO and PatientDAO to fetch existing doctors and patients for appointment setup.
 * @author Leandro
 */
import com.healthsystem.model.Appointment;
import com.healthsystem.model.Doctor;
import com.healthsystem.model.Patient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Time;

public class AppointmentDAO {
    private static final List<Appointment> appointments = new ArrayList<>();
    
    static {
        // Instantiate DAOs for Doctor and Patient
        DoctorDAO doctorDAO = new DoctorDAO();
        PatientDAO patientDAO = new PatientDAO();
        
        // Assume these methods return lists of existing doctors and patients
        List<Doctor> doctors = doctorDAO.getAllDoctors();
        List<Patient> patients = patientDAO.getAllPatients();

        // Create appointments using data from other DAOs
        // Check if there are enough doctors and patients to schedule appointments
        // Create a Date object for the appointment date using the current date
        Date appointmentDate = new Date(); // Assumes the current date

        // Create a Time object for the appointment time, set for 9:00 AM
        Time appointmentTime = Time.valueOf("09:00:00");

        // Adding an appointment to the list
        appointments.add(new Appointment("1", appointmentDate, appointmentTime, patients.get(0), doctors.get(0), "feeling unwell"));
        
        // Repeat for different times or with other doctors/patients as needed
        Time anotherAppointmentTime = Time.valueOf("10:00:00");
        appointments.add(new Appointment("2", appointmentDate, anotherAppointmentTime, patients.get(1), doctors.get(1), "Routinal check-up"));
    }

    /**
     * Retrieves all appointments.
     * @return A list of all appointments
     */
    public List<Appointment> getAllAppointments() {
        return appointments;
    }

    /**
     * Retrieves a specific appointment by ID.
     * @param id The ID of the appointment to retrieve
     * @return The appointment if found, null otherwise
     */
    public Appointment getAppointmentById(String id) {
        for (Appointment appointment : appointments) {
            if (appointment.getAppointmentId().equals(id)) {
                return appointment;
            }
        }
        return null;
    }

    /**
     * Adds a new appointment to the list.
     * @param appointment The appointment object to add
     */
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    /**
     * Updates an existing appointment in the list.
     * @param updatedAppointment The updated appointment details
     */
    public void updateAppointment(Appointment updatedAppointment) {
        for (int i = 0; i < appointments.size(); i++) {
            Appointment appointment = appointments.get(i);
            if (appointment.getAppointmentId().equals(updatedAppointment.getAppointmentId())) {
                appointments.set(i, updatedAppointment);
                return;
            }
        }
    }

    /**
     * Deletes an appointment based on its ID.
     * @param id The ID of the appointment to delete
     * @return true if the appointment was deleted, false otherwise
     */
    public boolean deleteAppointment(String id) {
        return appointments.removeIf(appointment -> appointment.getAppointmentId().equals(id));
    }
}

