package com.funliving.info.resource;

import com.funliving.info.repository.ScheduleRepository;
import com.funliving.info.repository.entity.Schedule;
import com.funliving.info.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Component
@Path("/schedule")
public class ScheduleApi {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces("text/plain")
    public int create(@BeanParam Schedule schedule) {
        int id = scheduleRepository.create(schedule);
        return id;
    }

}
