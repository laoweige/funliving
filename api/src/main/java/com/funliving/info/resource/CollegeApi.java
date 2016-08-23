package com.funliving.info.resource;

import com.funliving.info.common.SolrHelper;
import com.funliving.info.repository.CollegeRepository;
import com.funliving.info.repository.entity.City;
import com.funliving.info.repository.entity.College;
import com.funliving.info.resource.repr.ApartmentJson;
import com.funliving.info.resource.repr.CollegeJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Component
@Path("/college")
public class CollegeApi {
    @Autowired
    private CollegeRepository collegeRepository;

    @Autowired
    private SolrHelper solrHelper;

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
    public List<CollegeJson> getList() {

        List<College> colleges = collegeRepository.getAll();
        List<CollegeJson> result = new ArrayList<>();
        for(College college: colleges){
            result.add(new CollegeJson(college));
        }
        return result;
        
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("create")
    public Response create(@BeanParam College college)
            throws URISyntaxException, IOException {

        int size = collegeRepository.create(college);
        if (size > 0) {
            CollegeJson doc = new CollegeJson(college);
            solrHelper.add(doc,"college");
        }
        System.out.println(size);
        return Response.created(new URI("")).build();
    }
}
