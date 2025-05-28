/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.healthsystem.model;

import java.sql.Time;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Represents an appointment within the healthcare system. Encapsulates details
 * such as appointment ID, date, time, and associated patient and doctor.
 * Utilizes Jackson annotations to ensure proper formatting of dates for JSON
 * serialization.
 * Includes details about the patient, doctor, and reason for the visit.
 *
 * @author Leandro
 */
public class Appointment {

    private String appointmentId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date appointmentDate;
    private Time appointmentTime;
    private Patient patient;
    private Doctor doctor;
    private String reasonForVisit;

    /**
     * Default constructor for use in serialization.
     */
    public Appointment() {
    }

    /**
     * Constructs an Appointment with specified details.
     *
     * @param appointmentId Unique identifier for the appointment.
     * @param appointmentDate Date of the appointment.
     * @param appointmentTime Time of the appointment.
     * @param patient Patient involved in the appointment.
     * @param doctor Doctor attending the appointment.
     * @param reasonForVisit
     */
    public Appointment(String appointmentId, Date appointmentDate, Time appointmentTime, Patient patient, Doctor doctor, String reasonForVisit) {
        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.patient = patient;
        this.doctor = doctor;
        this.reasonForVisit = reasonForVisit;
        
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Time getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(Time appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    
    public String getReasonForVisit() {
        return reasonForVisit;
    }

    public void setReasonForVisit(String reasonForVisit) {
        this.reasonForVisit = reasonForVisit;
    }
}
