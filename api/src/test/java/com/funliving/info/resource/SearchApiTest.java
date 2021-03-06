package com.funliving.info.resource;

import com.funliving.info.repository.CityRepository;
import com.funliving.info.repository.CollegeRepository;
import com.funliving.info.resource.necessity.ApiTest;
import com.funliving.info.resource.repr.SearchHotJson;
import com.funliving.info.resource.repr.SearchListJson;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/8/9.
 */
public class SearchApiTest extends ApiTest {

    @Autowired
    private CollegeRepository collegeRepository;
    @Autowired
    private CityRepository cityRepository;


    @Test
    public void testSearch_Hot() throws Exception {

        Response response = client().target(getBaseUri()).path("search/hot")
                .queryParam("keyword","1")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();

//        Response response = Response.created(null).entity(apartment).build();
        SearchHotJson result = response.readEntity(SearchHotJson.class);

//        for(SolrDocument doc:list){
//            System.out.println(doc.get("Id"));
//            System.out.println(doc.get("Apartment"));
//        }
        System.out.println(result);
        assertThat(response.getStatus(), is(200));

    }

    @Test
    public void testSearch_Apartment() throws Exception {

        Response response = client().target(getBaseUri()).path("search")
                .queryParam("sort","1.637,18.33")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();

//        Response response = Response.created(null).entity(apartment).build();
        SearchListJson result = response.readEntity(SearchListJson.class);

//        for(SolrDocument doc:list){
//            System.out.println(doc.get("Id"));
//            System.out.println(doc.get("Apartment"));
//        }
        System.out.println(result);
//        assertTrue(result.getColleges().size()>1);
        assertThat(response.getStatus(), is(200));
    }

    @Test
    public void testInit() throws Exception {
        Response response = client().target(getBaseUri()).path("search/init")
                .request(MediaType.TEXT_PLAIN)
                .get();

//        Response response = Response.created(null).entity(apartment).build();
        int result = response.getLength();

//        for(SolrDocument doc:list){
//            System.out.println(doc.get("Id"));
//            System.out.println(doc.get("Apartment"));
//        }
        System.out.println(result);
//        assertTrue(result.getColleges().size()>1);
        assertThat(response.getStatus(), is(200));
    }
}