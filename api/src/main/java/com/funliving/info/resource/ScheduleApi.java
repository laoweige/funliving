package com.funliving.info.resource;

import com.funliving.info.repository.ApplyRepository;
import com.funliving.info.repository.ScheduleRepository;
import com.funliving.info.repository.entity.Apply;
import com.funliving.info.repository.entity.Schedule;
import com.funliving.info.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Path("/schedule")
public class ScheduleApi {

    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    ApplyRepository applyRepository;

    @GET
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Schedule> getSchedulesByPage(@QueryParam("page") int page) {
        int start = (page-1)*30;
        List<Schedule> schedules = scheduleRepository.getListByPage(start);
        return schedules;
    }

    @GET
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Schedule getScheduleByUserId(@PathParam("id") int id) {
        Schedule schedule = scheduleRepository.getEntity(id);
        return schedule;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces("text/plain")
    public int create(@BeanParam Schedule schedule) {
        int id = scheduleRepository.create(schedule);
        return id;
    }



    @PUT
    @Path("apply")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces("text/plain")
    public int createApply(@BeanParam Apply apply) {
        int id = applyRepository.create(apply);
        return id;
    }

    @POST
    @Path("apply")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces("text/plain")
    public int updateApply(@BeanParam Apply apply) {
        int size = applyRepository.update(apply);
        return size;
    }

    @GET
    @Path("apply/{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Apply getApplyByUserId(@PathParam("id") int userId) {
        Apply apply = applyRepository.getEntity(userId);
        return apply;
    }

    @GET
    @Path("apply")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Apply> getApplyByPage(@QueryParam("page") int page) {

        int start = (page-1)*30;
        List<Apply> applies = applyRepository.getListByPage(start);
        return applies;
    }



}
