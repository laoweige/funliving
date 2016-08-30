package com.funliving.info.repository;

import com.funliving.info.repository.entity.AuthCode;
import com.funliving.info.repository.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:applicationContext-test.xml"})
@TransactionConfiguration(transactionManager = "translationManager", defaultRollback = true)
@Transactional
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testLogin() throws Exception {


        userRepository.createUser(new User("13910178888","123456"));
        User users = userRepository.login("13910178888","123456");
        System.out.println(users);
        assertThat(users.getMobile(), is("13910178888"));
        User users2 = userRepository.login("13910178888","1111");
        System.out.println(users2);
        assertNull(users2);

    }

    @Test
    public void testAuthCode() throws Exception {
        AuthCode authCode = new AuthCode();
        authCode.setCode(4566);
        authCode.setMobile("13560845556");
        userRepository.addCode(authCode);


        AuthCode authCode1 = userRepository.queryCode("13560845556");
        System.out.println(authCode1);
        assertThat(authCode1.getMobile(), is("13560845556"));
        assertThat(authCode1.getCode(), is(4566));
        AuthCode authCode2 = userRepository.queryCode("13560845555");
        assertNull(authCode2);

    }


}
