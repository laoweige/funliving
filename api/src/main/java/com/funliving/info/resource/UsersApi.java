package com.funliving.info.resource;


import com.funliving.info.repository.UserRepository;
import com.funliving.info.repository.entity.AuthCode;
import com.funliving.info.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Calendar;
import java.util.Date;

@Component
@Path("/users")
public class UsersApi {

    @Autowired
    private UserRepository userRepository;

    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public User login(@BeanParam User user) {
        User result =  userRepository.login(user.getMobile(),user.getPassword());
        if(result!=null){
            return result;
        }
        return new User();
    }

    @POST
    @Path("reg")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public User reg(@BeanParam User user) {
        int status =  userRepository.createUser(user);
        return user;
    }

    @POST
    @Path("auth")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response authCode(@BeanParam AuthCode code)
            throws URISyntaxException, IOException {
        AuthCode authCode = userRepository.queryCode(code.getMobile());
        int result=0;
        if(authCode==null) {
            code.setTotal(1);
            result = sendAuthCode(code);
        }
        Calendar ca=Calendar.getInstance();
        ca.setTime(authCode.getSendTime());
        ca.add(Calendar.MINUTE, 15);
        Date checkDate = ca.getTime();
        if(checkDate.before(code.getSendTime())){
            code.setTotal(1);
            result = sendAuthCode(code);
        }
        return Response.ok(result).build();
    }

    private int sendAuthCode(AuthCode code){
        userRepository.addCode(code);
        return 1;
    }

}
