package com.funliving.info.resource;

import com.funliving.info.repository.ApartmentRepository;
import com.funliving.info.repository.entity.Apartment;
import com.funliving.info.repository.entity.User;
import com.funliving.info.resource.repr.UserJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Component
@Path("/apartment")
public class ApartmentApi {

    @Autowired
    ApartmentRepository apartmentRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    @Path("{id}")
    public Apartment all(@PathParam("id") int id) {
        Apartment apartment =  apartmentRepository.getEntity(id);
        return apartment;
    }
}
