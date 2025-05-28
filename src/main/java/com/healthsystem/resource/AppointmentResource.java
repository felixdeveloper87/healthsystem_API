package com.healthsystem.resource;

import com.healthsystem.dao.AppointmentDAO;
import com.healthsystem.model.Appointment;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Web service resource for managing appointments.
 * Provides RESTful API endpoints for creating, retrieving, updating, and deleting appointments.
 * Utilizes AppointmentDAO to interact with appointment data.
 *
 * @author Leandro
 */
@Path("/appointments")
public class AppointmentResource {

    private AppointmentDAO appointmentDAO = new AppointmentDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Appointment> getAllAppointments() {
        return appointmentDAO.getAllAppointments();
    }

    @GET
    @Path("/{appointmentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Appointment getAppointmentById(@PathParam("appointmentId") String appointmentId) {
        Appointment appointment = appointmentDAO.getAppointmentById(appointmentId);
        if (appointment == null) {
            throw new NotFoundException("Appointment with ID " + appointmentId + " not found");
        }
        return appointment;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Appointment addAppointment(Appointment appointment) {
        appointmentDAO.addAppointment(appointment);
        return appointment;
    }

    @PUT
    @Path("/{appointmentId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Appointment updateAppointment(@PathParam("appointmentId") String appointmentId, Appointment updatedAppointment) {
        Appointment existingAppointment = appointmentDAO.getAppointmentById(appointmentId);
        if (existingAppointment == null) {
            throw new NotFoundException("Appointment with ID " + appointmentId + " not found");
        }
        updatedAppointment.setAppointmentId(appointmentId);
        appointmentDAO.updateAppointment(updatedAppointment);
        return updatedAppointment;
    }

    @DELETE
    @Path("/{appointmentId}")
    public void deleteAppointment(@PathParam("appointmentId") String appointmentId) {
        boolean removed = appointmentDAO.deleteAppointment(appointmentId);
        if (!removed) {
            throw new NotFoundException("Appointment with ID " + appointmentId + " not found");
        }
    }
}
