package com.healthsystem.resource;

import com.healthsystem.dao.BillingDAO;
import com.healthsystem.model.Billing;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Web service resource for managing billing records.
 * Provides RESTful API endpoints for creating, retrieving, updating, and deleting billing records.
 * Utilizes BillingDAO to interact with billing data.
 *
 * @author Leandro
 */
@Path("/billings")
public class BillingResource {

    private BillingDAO billingDAO = new BillingDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Billing> getAllBillings() {
        return billingDAO.getAllBillings();
    }

    @GET
    @Path("/{billingId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Billing getBillingById(@PathParam("billingId") String billingId) {
        Billing billing = billingDAO.getBillingById(billingId);
        if (billing == null) {
            throw new NotFoundException("Billing with ID " + billingId + " not found");
        }
        return billing;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Billing addBilling(Billing billing) {
        billingDAO.addBilling(billing);
        return billing;
    }

    @PUT
    @Path("/{billingId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Billing updateBilling(@PathParam("billingId") String billingId, Billing updatedBilling) {
        Billing existingBilling = billingDAO.getBillingById(billingId);
        if (existingBilling == null) {
            throw new NotFoundException("Billing with ID " + billingId + " not found");
        }
        updatedBilling.setBillingId(billingId);
        billingDAO.updateBilling(updatedBilling);
        return updatedBilling;
    }

    @DELETE
    @Path("/{billingId}")
    public void deleteBilling(@PathParam("billingId") String billingId) {
        boolean removed = billingDAO.deleteBilling(billingId);
        if (!removed) {
            throw new NotFoundException("Billing with ID " + billingId + " not found");
        }
    }
}
