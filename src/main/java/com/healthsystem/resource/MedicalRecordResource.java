package com.healthsystem.resource;

import com.healthsystem.dao.MedicalRecordDAO;
import com.healthsystem.model.MedicalRecord;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * RESTful service resource for managing medical records.
 * Offers API endpoints for various operations like retrieving all records, fetching a specific record by ID,
 * adding a new record, updating an existing record, and deleting a record.
 *
 * @author Leandro
 */
@Path("/medicalRecords")
public class MedicalRecordResource {

    private MedicalRecordDAO medicalRecordDAO = new MedicalRecordDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecordDAO.getAllMedicalRecords();
    }

    @GET
    @Path("/{recordId}")
    @Produces(MediaType.APPLICATION_JSON)
    public MedicalRecord getMedicalRecordById(@PathParam("recordId") String recordId) {
        MedicalRecord record = medicalRecordDAO.getMedicalRecordById(recordId);
        if (record == null) {
            throw new NotFoundException("Medical Record with ID " + recordId + " not found");
        }
        return record;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public MedicalRecord addMedicalRecord(MedicalRecord record) {
        medicalRecordDAO.addMedicalRecord(record);
        return record;  // Return the newly created medical record
    }

    @PUT
    @Path("/{recordId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public MedicalRecord updateMedicalRecord(@PathParam("recordId") String recordId, MedicalRecord updatedRecord) {
        MedicalRecord existingRecord = medicalRecordDAO.getMedicalRecordById(recordId);
        if (existingRecord == null) {
            throw new NotFoundException("Medical Record with ID " + recordId + " not found");
        }
        updatedRecord.setRecordId(recordId);
        medicalRecordDAO.updateMedicalRecord(updatedRecord);
        return updatedRecord;  // Return the updated medical record
    }

    @DELETE
    @Path("/{recordId}")
    public void deleteMedicalRecord(@PathParam("recordId") String recordId) {
        boolean removed = medicalRecordDAO.deleteMedicalRecord(recordId);
        if (!removed) {
            throw new NotFoundException("Medical Record with ID " + recordId + " not found");
        }
    }
}
