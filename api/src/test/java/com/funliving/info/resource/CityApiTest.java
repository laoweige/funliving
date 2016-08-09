package com.funliving.info.resource;

import com.funliving.info.repository.ApartmentRepository;
import com.funliving.info.repository.CollegeRepository;
import com.funliving.info.resource.necessity.ApiTest;
import com.funliving.info.resource.necessity.TestBeans;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by Administrator on 2016/8/9.
 */
public class CityApiTest extends ApiTest {

    @Autowired
    private CollegeRepository collegeRepository;

    @Before
    public void setUp() throws Exception {
        collegeRepository = mock(CollegeRepository.class);
        TestBeans.replaceBean("collegeRepository", collegeRepository);
        super.setUp();
    }

    @Test
    public void testCity_Create_Api() throws Exception {
        Form form = new Form().param("name", "伦敦 1 英国")
                .param("nation", "1");

        Response response = client().target(getBaseUri()).path("city/create")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.form(form));

//        Response response = Response.created(null).entity(apartment).build();
//        System.out.println(result);
        assertThat(response.getStatus(), is(201));
    }
}