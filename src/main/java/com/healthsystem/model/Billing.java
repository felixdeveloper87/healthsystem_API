/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.healthsystem.model;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Represents a billing record within the healthcare system. Encapsulates
 * details such as billing ID, associated patient, amount due, and due date.
 * Utilizes Jackson annotations to ensure proper formatting of dates for JSON
 * serialization.
 *
 * @author Leandro
 */
public class Billing {

    private String billingId;
    private double amountDue;
    private Appointment appointment;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dueDate;

    /**
     * Default constructor for use in serialization.
     */
    public Billing() {
    }

    /**
     * Constructs a Billing record with specified details.
     *
     * @param billingId Unique identifier for the billing record.
     * @param appointment
     * @param amountDue Total amount due.
     * @param dueDate Date by which the payment is due.
     */
    public Billing(String billingId, Appointment appointment, double amountDue, Date dueDate) {
        this.billingId = billingId;
        this.appointment = appointment;
        this.amountDue = amountDue;
        this.dueDate = dueDate;
    }

    public String getBillingId() {
        return billingId;
    }

    public void setBillingId(String billingId) {
        this.billingId = billingId;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public double getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(double amountDue) {
        this.amountDue = amountDue;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
