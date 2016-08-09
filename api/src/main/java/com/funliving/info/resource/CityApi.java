package com.funliving.info.resource;

import com.funliving.info.common.SolrHelper;
import com.funliving.info.repository.CityRepository;
import com.funliving.info.repository.CollegeRepository;
import com.funliving.info.repository.entity.Apartment;
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
    @Path("all")
    public List<City> getAll() {
        List<City> cities = cityRepository.getAll();
        return cities;
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

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("create")
    public Response create(@FormParam("name") String name,@FormParam("nation") int nation)
            throws URISyntaxException, IOException {
        City city = new City();
        city.setName(name);
        city.setNationId(nation);
        int size = cityRepository.create(city);
        if(size>0){
            SolrHelper.add(city, "172.17.1.187:9080/solr/", "city");
        }
        System.out.println(size);
        return Response.created(new URI("")).build();
    }

}
