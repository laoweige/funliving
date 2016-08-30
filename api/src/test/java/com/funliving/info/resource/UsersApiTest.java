package com.funliving.info.resource;

import com.funliving.info.repository.UserRepository;
import com.funliving.info.repository.entity.User;
import com.funliving.info.resource.necessity.ApiTest;
import com.funliving.info.resource.necessity.TestBeans;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by Administrator on 14-11-4.
 */
public class UsersApiTest extends ApiTest {

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
//        userRepository = mock(UserRepository.class);
//        TestBeans.replaceBean("userRepository", userRepository);
        super.setUp();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testAuthCode() throws Exception {
        Form form = new Form().param("mobile", "13910178445")
                .param("code", "3456")
                .param("sendTime","2016-08-30");
        Response response = client().target(getBaseUri()).path("users/auth")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.form(form));

        assertThat(response.getStatus(), is(200));
        //assertThat(result.size(), is(2));
    }


    @Test
    public void testLogin() throws Exception {
        Form form = new Form().param("mobile", "13910178888")
                .param("password", "123456");
        Response response = client().target(getBaseUri()).path("users/login")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.form(form));

        assertThat(response.getStatus(), is(200));

    }
}
