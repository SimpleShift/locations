import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("locations")
public class LocationResource {

    @GET
    public Response getAllLocations() {
        List<Location> locations = Database.getLocations();
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



/*
    public List<Employee> getEmployees(String employeeId) {

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