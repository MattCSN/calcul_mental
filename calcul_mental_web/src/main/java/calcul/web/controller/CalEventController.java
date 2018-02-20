package yncrea.pw06.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import yncrea.pw06.core.entity.CalEvent;
import yncrea.pw06.core.service.CalEventService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@Named
@Path("/calevents")
public class CalEventController implements RestController{

    private static final Logger logger = LoggerFactory.getLogger(CalEventController.class);

    @Inject
    private CalEventService calEventService;

    @GET
    @Path("/")
    public List<CalEvent> getListCalEvents(){
        logger.info("Getting all Calendar Events");
        return calEventService.findAll();
    }

    @POST
    @Path("/")
    public void saveCalEvents(CalEvent calEvent){
        logger.info("Saving a Calendar Event");
        calEventService.saveCalEvent(calEvent);
    }

    @GET
    @Path("/{id}")
    public CalEvent getCalEvent(@PathParam("id") long id){
        logger.info("Getting the Calendar Event of id: "+id);
        return calEventService.findById(id);
    }
}
