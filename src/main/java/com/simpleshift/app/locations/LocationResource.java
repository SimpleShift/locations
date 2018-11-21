package com.simpleshift.app.locations;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.client.ClientBuilder;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("locations")
public class LocationResource {

    private String devPath = "http://localhost:8080/v1/employees&locationId=1";
    private String dockerPath = "http://contemployees:8080/v1/employees&locationId=1";

    @GET
    public Response getAllLocations() {

        List<Employee> locations = getEmployees();

        //List<com.simpleshift.app.locations.Location> locations = com.simpleshift.app.locations.Database.getLocations();
        return Response.ok(locations).build();
    }

    @GET
    @Path("{locationId}")
    public Response getLocation(@PathParam("locationId") String locationId) {
        Location e = Database.getLocation(locationId);
        return e != null
                ? Response.ok(e).build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    public Response addNewLocation(Location e) {
        Database.addLocation(e);
        return Response.noContent().build();
    }

    @DELETE
    @Path("{locationId}")
    public Response deleteLocation(@PathParam("locationId") String locationId) {
        Database.deleteLocation(locationId);
        return Response.noContent().build();
    }


    private List<Employee> getEmployees() {
        try {
            return ClientBuilder.newClient()
                    .target(dockerPath)
                    .request().get(new GenericType<List<Employee>>() {
                    });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


/*
    public List<com.simpleshift.app.locations.Employee> getEmployees(String employeeId) {

        try {
            HttpGet request = new HttpGet(basePath + "/v1/orders?where=customerId:EQ:" + customerId);
            HttpResponse response = httpClient.execute(request);

            int status = response.getStatusLine().getStatusCode();

            if (status >= 200 && status < 300) {
                HttpEntity entity = response.getEntity();

                if (entity != null)
                    return getObjects(EntityUtils.toString(entity));
            } else {
                String msg = "Remote server '" + basePath + "' is responded with status " + status + ".";
                log.error(msg);
                throw new InternalServerErrorException(msg);
            }

        } catch (IOException e) {
            String msg = e.getClass().getName() + " occured: " + e.getMessage();
            log.error(msg);
            throw new InternalServerErrorException(msg);
        }
        return new ArrayList<>();

    }
    */
}