package com.healthsystem.resource;

import com.healthsystem.dao.DoctorDAO;
import com.healthsystem.model.Doctor;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * RESTful service resource for managing doctors.
 * Provides API endpoints for operations such as retrieving all doctors, fetching a specific doctor by ID,
 * adding a new doctor, updating an existing doctor, and deleting a doctor.
 *
 * @author Leandro
 */
@Path("/doctors")
public class DoctorResource {

    private DoctorDAO doctorDAO = new DoctorDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Doctor> getAllDoctors() {
        return doctorDAO.getAllDoctors();
    }

    @GET
    @Path("/{doctorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Doctor getDoctorById(@PathParam("doctorId") String doctorId) {
        Doctor doctor = doctorDAO.getDoctorById(doctorId);
        if (doctor == null) {
            throw new NotFoundException("Doctor with ID " + doctorId + " not found");
        }
        return doctor;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Doctor addDoctor(Doctor doctor) {
        doctorDAO.addDoctor(doctor);
        return doctor;  // Return the newly created doctor
    }

    @PUT
    @Path("/{doctorId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Doctor updateDoctor(@PathParam("doctorId") String doctorId, Doctor updatedDoctor) {
        Doctor existingDoctor = doctorDAO.getDoctorById(doctorId);
        if (existingDoctor == null) {
            throw new NotFoundException("Doctor with ID " + doctorId + " not found");
        }
        updatedDoctor.setId(doctorId);
        doctorDAO.updateDoctor(updatedDoctor);
        return updatedDoctor;  // Return the updated doctor
    }

    @DELETE
    @Path("/{doctorId}")
    public void deleteDoctor(@PathParam("doctorId") String doctorId) {
        boolean removed = doctorDAO.deleteDoctor(doctorId);
        if (!removed) {
            throw new NotFoundException("Doctor with ID " + doctorId + " not found");
        }
    }
}
