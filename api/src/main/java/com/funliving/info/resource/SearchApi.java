package com.funliving.info.resource;

import com.funliving.info.common.SolrHelper;
import com.funliving.info.repository.entity.City;
import com.funliving.info.resource.repr.ApartmentJson;
import com.funliving.info.resource.repr.CollegeJson;
import com.funliving.info.resource.repr.HotJson;
import com.funliving.info.resource.repr.SearchHotJson;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Path("/search")
public class SearchApi {


    @GET
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    public SolrDocumentList apartments(@DefaultValue("1") @QueryParam("page") int page,
                                       @DefaultValue("10") @QueryParam("pageSize") int pageSize,
                                       @DefaultValue("1") @QueryParam("city") int city,
                                       @QueryParam("college") int college,
                                       @QueryParam("rent") String rent) {

        List<String> queries = new ArrayList<>();
        if(city!=0){
            queries.add(String.format("City:%s", city));
        }
        if(rent!=null && !rent.equals("") && rent.contains(",") && !rent.endsWith(",")){
            String[] rents = rent.split(",");
            queries.add(String.format("Rent:[%s TO %s]", rents[0],rents[1]));
        }
        if(college!=0){
            //设置距离排序
        }

        String queryString = "";
        for(int i=0;i<queries.size();i++){
            if(i>0)
                queryString+=" AND ";
            queryString+=queries.get(i);
        }
        if(!queryString.equals("")) {
            int start = (page-1)*pageSize;
            SolrDocumentList apartments = SolrHelper.search(queryString,start , pageSize, "*", "172.17.1.187:9080/solr/", "apartment");
//            for (SolrDocument doc : apartments) {
//
//            }
            return apartments;
        }else {
            throw new WebApplicationException("missing query parameters");
        }
    }

    @GET
    @Path("hot")
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    public SearchHotJson hot(@QueryParam("keyword") String keyword) {
        if(keyword==null || keyword.trim().equals("")){
            throw new WebApplicationException("missing query parameters");
        }
        System.out.println("SolrDocumentList search(@QueryParam(\"keyword\") String keyword)");
        System.out.println("keyword="+keyword);
        SolrDocumentList apartments = SolrHelper.search(String.format("Apartment:*%s*", keyword), 0, 10, "*","172.17.1.187:9080/solr/","apartment");
        SolrDocumentList cities = SolrHelper.search(String.format("CityName:*%s*", keyword), 0, 10, "*","172.17.1.187:9080/solr/","city");
        SolrDocumentList colleges = SolrHelper.search(String.format("College:*%s*", keyword), 0, 10, "*","172.17.1.187:9080/solr/","college");
        SearchHotJson result = new SearchHotJson();
        for(SolrDocument doc:apartments){
            HotJson apartment = new HotJson(doc.get("Id"),doc.get("Apartment"),0);
            result.getApartments().add(apartment);
        }
        for(SolrDocument doc:cities){
            HotJson city = new HotJson(doc.get("Id"),doc.get("CityName"),1);
            result.getCities().add(city);
        }
        for(SolrDocument doc:colleges){
            HotJson college = new HotJson(doc.get("Id"),doc.get("College"),2);
            result.getColleges().add(college);
        }
        return result;
    }
}
