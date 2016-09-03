package com.funliving.info.resource;

import com.funliving.info.common.SolrHelper;
import com.funliving.info.repository.CityRepository;
import com.funliving.info.repository.CollegeRepository;
import com.funliving.info.repository.entity.City;
import com.funliving.info.repository.entity.College;
import com.funliving.info.resource.repr.CollegeJson;
import com.funliving.info.resource.repr.IndexJson;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Component
@Path("/")
public class HomeApi {

    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CollegeRepository collegeRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    public IndexJson getLayoutForAppBy() {
        IndexJson result = new IndexJson();
        List<City> cities = cityRepository.getAll();
        result.setCities(cities);
        List<College> colleges = collegeRepository.getAll();
        result.setColleges(new ArrayList<CollegeJson>());

        for(College college:colleges){
            result.getColleges().add(new CollegeJson(college));
        }
        return result;
    }


}
