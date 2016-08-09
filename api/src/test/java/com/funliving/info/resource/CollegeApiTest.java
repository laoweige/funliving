package com.funliving.info.resource;

import com.funliving.info.repository.CollegeRepository;
import com.funliving.info.resource.necessity.ApiTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/8/9.
 */
public class CollegeApiTest extends ApiTest {

    @Autowired
    private CollegeRepository collegeRepository;

    @Test
    public void testCollege_Create_API() throws Exception {
        Form form = new Form().param("name", "北京大学 1 北京")
                .param("cityId", "1")
                .param("nationId", "1")
                .param("coordinate", "39.86,116.49");

        Response response = client().target(getBaseUri()).path("college/create")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.form(form));

//        Response response = Response.created(null).entity(apartment).build();
//        System.out.println(result);
        assertThat(response.getStatus(), is(201));
    }
}