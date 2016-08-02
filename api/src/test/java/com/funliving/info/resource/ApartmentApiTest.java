package com.funliving.info.resource;

import com.funliving.info.repository.ApartmentRepository;
import com.funliving.info.repository.entity.Apartment;
import com.funliving.info.repository.entity.User;
import com.funliving.info.resource.necessity.ApiTest;
import com.funliving.info.resource.necessity.TestBeans;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Administrator on 2016/8/2.
 */
public class ApartmentApiTest extends ApiTest {

    @Autowired
    ApartmentRepository apartmentRepository;

    @Before
    public void setUp() throws Exception {
        apartmentRepository = mock(ApartmentRepository.class);
        TestBeans.replaceBean("apartmentRepository", apartmentRepository);
        super.setUp();
    }

    @Test
    public void getEntity() throws Exception {
        Apartment apartment = new Apartment();
        apartment.setId(1);
        apartment.setName("pure-city");
        when(apartmentRepository.getEntity(anyInt())).thenReturn(apartment);
        Response response = client().target(getBaseUri()).path("apartment/"+apartment.getId())
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();
//        Object result = response.getEntity();
        Apartment result = response.readEntity(Apartment.class);

//        List<Object> result = response.(List.class);
        System.out.println(result);
        assertThat(response.getStatus(), is(200));
    }
}