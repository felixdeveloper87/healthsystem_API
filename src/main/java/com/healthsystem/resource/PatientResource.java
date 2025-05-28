package com.healthsystem.resource;

import com.healthsystem.dao.PatientDAO;
import com.healthsystem.model.Patient;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * RESTful service resource for managing patients.
 * Provides API endpoints for operations such as retrieving all patients, fetching a specific patient by ID,
 * adding a new patient, updating an existing patient, and deleting a patient.
 *
 * @author Leandro
 */
@Path("/patients")
public class PatientResource {

    private PatientDAO patientDAO = new PatientDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Patient> getAllPatients() {
        return patientDAO.getAllPatients();
    }

    @GET
    @Path("/{patientId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Patient getPatientById(@PathParam("patientId") String patientId) {
        Patient patient = patientDAO.getPatientById(patientId);
        if (patient == null) {
            throw new NotFoundException("Patient with ID " + patientId + " not found");
        }
        return patient;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addPatient(Patient patient) {
        patientDAO.addPatient(patient);
    }

    @PUT
    @Path("/{patientId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePatient(@PathParam("patientId") String patientId, Patient updatedPatient) {
        Patient existingPatient = patientDAO.getPatientById(patientId);
        if (existingPatient != null) {
            updatedPatient.setId(patientId);  // Ensure the patient's ID is set correctly
            patientDAO.updatePatient(updatedPatient);
        }
    }

    @DELETE
    @Path("/{patientId}")
    public void deletePatient(@PathParam("patientId") String patientId) {
        if (!patientDAO.deletePatient(patientId)) {
            throw new NotFoundException("Patient with ID " + patientId + " not found");
        }
    }
}
