package nl.perez.portfolio.Logic;


import com.google.gson.JsonObject;
import nl.perez.portfolio.DAL.Project;
import nl.perez.portfolio.DAL.ProjectRepo;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.UUID;

@ApplicationScoped
public class ProjectManager {
    @Inject ProjectRepo projectRepo;
    public boolean CreateProject(JsonObject obj){
        if(!(obj.has("Name")&& obj.has("Description"))){
            return false;
        }
        if (projectRepo.FindByName(obj.get("Name").getAsString())!= null){
            System.err.println("Name already in use.");
            return false;
        }

        Project project = new Project();
        project.setId(UUID.randomUUID().toString());
        project.setDescription(obj.get("Description").getAsString());
        project.setName(obj.get("Name").getAsString());

        projectRepo.persist(project);
        return true;
    }
    public Project FindByName(String Name){
        return projectRepo.FindByName(Name);

    }
}

