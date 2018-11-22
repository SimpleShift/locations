package com.simpleshift.app.locations;

import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.client.ClientBuilder;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("locations")
public class LocationResource {

    private String devPath = "http://localhost:8080/v1/employees";
    private String dockerPath = "http://contemployees:8080/v1/employees";

    private Client httpClient = ClientBuilder.newClient();

    @GET
    public Response getAllLocations() {

        List<Location> locations = Database.getLocations();

        for (Location l : locations) {
            l.setEmployees(getEmployees(l.getId()));
        }

        return Response.ok(locations).build();
    }

    @GET
    @Path("{locationId}")
    public Response getLocation(@PathParam("locationId") String locationId) {

        Location l = Database.getLocation(locationId);

        l.setEmployees(getEmployees(locationId));

        return l != null
                ? Response.ok(l).build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    public Response addNewLocation(Location l) {
        Database.addLocation(l);
        return Response.noContent().build();
    }

    @DELETE
    @Path("{locationId}")
    public Response deleteLocation(@PathParam("locationId") String locationId) {
        Database.deleteLocation(locationId);
        return Response.noContent().build();
    }


    private List<Employee> getEmployees(String locationId) {
        try {
            return httpClient
                    .target(dockerPath + "?locationId=" + locationId)
                    .request().get(new GenericType<List<Employee>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}