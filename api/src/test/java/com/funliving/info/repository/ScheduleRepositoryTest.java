package com.funliving.info.repository;

import com.funliving.info.repository.entity.Schedule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:applicationContext-test.xml"})
@TransactionConfiguration(transactionManager = "translationManager", defaultRollback = true)
@Transactional
public class ScheduleRepositoryTest {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Test
    public void testGetEntity() throws Exception {

    }

    @Test
    public void testCreate() throws Exception {
        Schedule schedule = new Schedule();
        schedule.setUserId(1);
        schedule.setEmail("laoweige@163.com");
        schedule.setMobile("13910178445");
        schedule.setName("老魏");
        schedule.setStartTime("2016-09-01");
        schedule.setEndTime("2016-09-02");
        schedule.setCreateTime(new Date());

        scheduleRepository.create(schedule);
        assertTrue(schedule.getId() > 0);
        Schedule entity = scheduleRepository.getEntity(schedule.getId());
        assertThat(schedule.getName(), is(entity.getName()));
    }
}