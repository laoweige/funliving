package com.funliving.info.repository;

import com.funliving.info.repository.entity.College;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:applicationContext-test.xml"})
@TransactionConfiguration(transactionManager = "translationManager", defaultRollback = true)
@Transactional
public class CollegeRepositoryTest {

    @Autowired
    private CollegeRepository collegeRepository;

    @Test
    public void testGetEntity() throws Exception {

    }

    @Test
    public void testGetList() throws Exception {
        List<College> collegeList = collegeRepository.getList(1);
        System.out.println(collegeList);
        assertTrue(collegeList.size() > 0);
    }

    @Test
    public void testCreate() throws Exception {

    }
}