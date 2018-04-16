package web.controller;

import core.entity.Utilisateur;
import core.service.UtilisateurService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@Named
@Path("/user")
public class UtilisateurController implements RestController{

    private static final Logger logger = LoggerFactory.getLogger(UtilisateurController.class);

    @Inject
    private UtilisateurService utilisateurService;

    @GET
    @Path("/")
    public List<Utilisateur> getListUtilisateurs(){
        logger.info("Getting all Users");
        return utilisateurService.findAll();
    }

    @POST
    @Path("/")
    public void saveUtilisateurs(Utilisateur utilisateur){
        logger.info("Saving an User");
        utilisateurService.saveUtilisateur(utilisateur);
    }

    @GET
    @Path("/{id}")
    public Utilisateur getUtilisateur(@PathParam("id") long id){
        logger.info("Getting the User of id: "+id);
        return utilisateurService.findById(id);
    }
    
}
