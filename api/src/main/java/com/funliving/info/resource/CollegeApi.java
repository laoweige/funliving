package com.funliving.info.resource;

import com.funliving.info.repository.CollegeRepository;
import com.funliving.info.repository.entity.College;
import com.funliving.info.resource.repr.ApartmentJson;
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
@Path("/college")
public class CollegeApi {
    @Autowired
    private CollegeRepository collegeRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    @Path("{id}")
    public CollegeJson getEntity(@PathParam("id") int id) {

        College college = collegeRepository.getEntity(id);
        CollegeJson result = new CollegeJson(college);

        return result;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    @Path("all")
    public List<CollegeJson> getList(@PathParam("city") int city) {

        List<College> colleges = collegeRepository.getList(city);
        List<CollegeJson> result = new ArrayList<>();
        for(College college: colleges){
            result.add(new CollegeJson(college));
        }
        return result;
    }
}
