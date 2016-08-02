package com.funliving.info.repository;

import com.funliving.info.repository.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:applicationContext-test.xml"})
@TransactionConfiguration(transactionManager = "translationManager", defaultRollback = true)
@Transactional
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testAll() throws Exception {
        userRepository.createUser(new User("13910178445","123456"));
        User users = userRepository.login("13910178445","123456");
        System.out.println(users);
        assertThat(users.getMobile(), is("13910178445"));
        User users2 = userRepository.login("13910178445","1111");
        System.out.println(users2);
    }


}
