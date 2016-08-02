package com.funliving.info.resource;


import com.funliving.info.repository.UserRepository;
import com.funliving.info.repository.entity.User;
import com.funliving.info.resource.repr.UserJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Component
@Path("/users")
public class UsersApi {

    @Autowired
    private UserRepository userRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserJson> all() {
        List<User> users =  userRepository.All();
        List<UserJson> resultUsers = new ArrayList<>();
        for(User user:users){
            resultUsers.add(new UserJson(user.getId(),user.getName(),user.getMobile()));
        }
        return resultUsers;
    }

}
