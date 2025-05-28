package com.healthsystem.resource;

import com.healthsystem.dao.PrescriptionDAO;
import com.healthsystem.model.Prescription;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * RESTful service resource for managing prescriptions.
 * Offers API endpoints for retrieving all prescriptions, fetching a specific prescription by ID,
 * adding a new prescription, updating an existing prescription, and deleting a prescription.
 *
 * @author Leandro
 */
@Path("/prescriptions")
public class PrescriptionResource {

    private PrescriptionDAO prescriptionDAO = new PrescriptionDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Prescription> getAllPrescriptions() {
        return prescriptionDAO.getAllPrescriptions();
    }

    @GET
    @Path("/{prescriptionId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Prescription getPrescriptionById(@PathParam("prescriptionId") String prescriptionId) {
        Prescription prescription = prescriptionDAO.getPrescriptionById(prescriptionId);
        if (prescription == null) {
            throw new NotFoundException("Prescription with ID " + prescriptionId + " not found");
        }
        return prescription;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Prescription addPrescription(Prescription prescription) {
        prescriptionDAO.addPrescription(prescription);
        return prescription;  // Return the newly created prescription
    }

    @PUT
    @Path("/{prescriptionId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Prescription updatePrescription(@PathParam("prescriptionId") String prescriptionId, Prescription updatedPrescription) {
        Prescription existingPrescription = prescriptionDAO.getPrescriptionById(prescriptionId);
        if (existingPrescription == null) {
            throw new NotFoundException("Prescription with ID " + prescriptionId + " not found");
        }
        updatedPrescription.setPrescriptionId(prescriptionId);  // Ensure the ID is set correctly
        prescriptionDAO.updatePrescription(updatedPrescription);
        return updatedPrescription;  // Return the updated prescription
    }

    @DELETE
    @Path("/{prescriptionId}")
    public void deletePrescription(@PathParam("prescriptionId") String prescriptionId) {
        if (!prescriptionDAO.deletePrescription(prescriptionId)) {
            throw new NotFoundException("Prescription with ID " + prescriptionId + " not found");
        }
    }
}
