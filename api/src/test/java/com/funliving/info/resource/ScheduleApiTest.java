package com.funliving.info.resource;

import com.funliving.info.repository.ScheduleRepository;
import com.funliving.info.repository.entity.Apply;
import com.funliving.info.repository.entity.Schedule;
import com.funliving.info.resource.necessity.ApiTest;
import com.funliving.info.resource.repr.ApartmentJson;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by weizhigang on 16/9/2.
 */
public class ScheduleApiTest extends ApiTest {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Test
    public void test_ScheduleApi_GetScheduleListByPage() throws Exception {

        Response response = client().target(getBaseUri()).path("schedule")
                .queryParam("page",1)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();
        assertThat(response.getStatus(), is(200));
        List<Schedule> applies=response.readEntity(List.class);
        System.out.println(applies);
        assertTrue(applies.size()>0);

    }

    @Test
    public void test_ScheduleApi_Create() throws Exception {
        Form form = new Form().param("mobile", "13910178445")
                .param("name", "老魏")
                .param("email", "laoweige@163.com")
                .param("status", "1")
                .param("userId", "1")
                .param("endTime", "2016-07-30")
                .param("apartmentId", "2")
                .param("roomId", "1")
                .param("startTime", "2016-08-30");

        Response response = client().target(getBaseUri()).path("schedule")
                .request(MediaType.TEXT_PLAIN)
                .put(Entity.form(form));
        assertThat(response.getStatus(), is(200));
        int id=response.readEntity(Integer.class);
        assertTrue(id>0);

    }

    @Test
    public void test_ScheduleApi_CreateApply() throws Exception {

        Form form = new Form().param("userId", "1")
                .param("createId", "1")
                .param("name", "老魏")
                .param("gender", "1")
                .param("birthday", "2010-08-08")
                .param("mobile", "13910178445")
                .param("email", "laoweige@163.com")
                .param("status", "0")
                .param("university", "大学")
                .param("major", "专业")
                .param("enterDate", "2015-08-08")
                .param("creditName", "2016-08-08")
                .param("creditCard", "68954689058656")
                .param("creditSecurity", "454")
                .param("startDate", "2013-08-08")
                .param("expireDate", "2015-08-08")
                .param("assureName", "老爸")
                .param("assureGender", "1")
                .param("assureRelation", "父母")
                .param("assureBirthday", "1970-08-08")
                .param("assureMobile", "1378765432")
                .param("assureAddress", "贵州黔西");

        Response response = client().target(getBaseUri()).path("schedule/apply")
                .request(MediaType.TEXT_PLAIN)
                .put(Entity.form(form));
        assertThat(response.getStatus(), is(200));
        int id=response.readEntity(Integer.class);
        assertTrue(id>0);

    }

    @Test
    public void test_ScheduleApi_GetApplyListByPage() throws Exception {

        Response response = client().target(getBaseUri()).path("schedule/apply")
                .queryParam("page",1)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();
        assertThat(response.getStatus(), is(200));
        List<Apply> applies=response.readEntity(List.class);
        System.out.println(applies);
        assertTrue(applies.size()>0);

    }

    @Test
    public void test_ScheduleApi_GetApplyListByUsrId() throws Exception {

        Response response = client().target(getBaseUri()).path("schedule/apply/1")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();
        assertThat(response.getStatus(), is(200));
        Apply apply = response.readEntity(Apply.class);
        System.out.println(apply);
        assertNotNull(apply);

    }
}