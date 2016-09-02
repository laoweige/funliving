package com.funliving.info.resource;

import com.funliving.info.repository.ScheduleRepository;
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
 * Created by weizhigang on 16/9/2.
 */
public class ScheduleApiTest extends ApiTest {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Test
    public void test_ScheduleApi_Create() throws Exception {
        Form form = new Form().param("mobile", "13910178445")
                .param("name", "老魏")
                .param("email", "laoweige@163.com")
                .param("status", "1")
                .param("userId", "1")
                .param("endTime", "2016-07-30")
                .param("startTime", "2016-08-30");

        Response response = client().target(getBaseUri()).path("schedule")
                .request(MediaType.TEXT_PLAIN)
                .post(Entity.form(form));
        assertThat(response.getStatus(), is(200));
        int id=response.readEntity(Integer.class);
        assertTrue(id>0);

    }
}