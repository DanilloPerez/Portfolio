package nl.perez.portfolio.DAL;


import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProjectRepo implements PanacheRepository<Project>
{
    public Project FindByName(String Name){
        return find("Name",Name).firstResult();
    }
    public Project FindByID(String id){
        return find("id",id).firstResult();
    }
}
