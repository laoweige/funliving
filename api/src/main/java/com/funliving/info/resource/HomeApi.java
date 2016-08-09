package com.funliving.info.resource;

import com.funliving.info.common.SolrHelper;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Component
@Path("/")
public class HomeApi {

    @GET
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    public List<String> getLayoutForAppBy() {
        List<String> uris = new ArrayList<>();
        uris.add("WEB首页");
        uris.add("App首页");
        return uris;
    }


}
