package nl.perez.portfolio.Controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import nl.perez.portfolio.Logic.ProjectManager;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/Projects")
@Transactional
public class ProjectController {
    @Inject ProjectManager projectManager;
    @GET
    @Path("{Name}")
    public String GetProjects(@PathParam("Name")String name){
        return new Gson().toJson(projectManager.FindByName(name));
    }

    @POST
    @Path("AddProject")
    public boolean AddProject(String data){
        JsonObject obj = new Gson().fromJson(data, JsonObject.class);

        return projectManager.CreateProject(obj);
    }

}
