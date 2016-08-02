package com.funliving.info.resource;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Component
@Path("/")
public class HomeApi {

    @GET
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    public List<String> getLayoutForAppBy(@PathParam("id") int id) {
        List<String> uris = new ArrayList<>();
        uris.add("WEB首页");
        uris.add("App首页");
        return uris;
    }
}
