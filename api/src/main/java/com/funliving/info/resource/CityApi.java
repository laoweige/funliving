package com.funliving.info.resource;

import com.funliving.info.repository.CityRepository;
import com.funliving.info.repository.CollegeRepository;
import com.funliving.info.repository.entity.City;
import com.funliving.info.repository.entity.College;
import com.funliving.info.resource.repr.CollegeJson;
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
@Path("/city")
public class CityApi {

    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CollegeRepository collegeRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    @Path("{id}")
    public City getEntity(@PathParam("id") int id) {
        City city = cityRepository.getEntity(id);
        return city;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    @Path("{id}/colleges")
    public List<CollegeJson> getColleges(@PathParam("id") int id) {
        List<College> colleges = collegeRepository.getList(id);
        List<CollegeJson> result = new ArrayList<>();
        for(College college: colleges){
            result.add(new CollegeJson(college));
        }
        return result;
    }
}
