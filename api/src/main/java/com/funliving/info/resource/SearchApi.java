package com.funliving.info.resource;

import com.funliving.info.common.SolrHelper;
import com.funliving.info.repository.CityRepository;
import com.funliving.info.repository.CollegeRepository;
import com.funliving.info.repository.entity.City;
import com.funliving.info.repository.entity.College;
import com.funliving.info.resource.repr.*;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Component
@Path("/search")
public class SearchApi {

    @Autowired
    private CollegeRepository collegeRepository;
    @Autowired
    private CityRepository cityRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    public SearchListJson apartments(@DefaultValue("1") @QueryParam("page") int page,
                                       @DefaultValue("10") @QueryParam("pageSize") int pageSize,
                                       @DefaultValue("1") @QueryParam("city") int city,
                                       @QueryParam("college") int college,
                                       @QueryParam("rent") String rent) {

        SearchListJson result = new SearchListJson();

        List<String> queries = new ArrayList<>();
        if(city!=0){
            queries.add(String.format("City:%s", city));
            List<College> collegeList = collegeRepository.getList(city);
            result.setColleges(new ArrayList<CollegeJson>());
            for(College c:collegeList){
                CollegeJson cj = new CollegeJson(c);
                result.getColleges().add(cj);
            }
        }
        if(rent!=null && !rent.equals("") && rent.contains(",") && !rent.endsWith(",")){
            String[] rents = rent.split(",");
            queries.add(String.format("Rent:[%s TO %s]", rents[0],rents[1]));
        }
        if(college!=0){
            College currentCollege = collegeRepository.getEntity(college);
            result.setAddress(currentCollege.getName());
            //设置距离排序
        }else{
            City currentCity = cityRepository.getEntity(city);
            result.setAddress(currentCity.getName());
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
            result.setApartments(new ArrayList<SubApartmentJson>());
            for (SolrDocument doc : apartments) {
                SubApartmentJson saj=new SubApartmentJson();
                saj.setId(Integer.valueOf(doc.get("Id").toString()));
                saj.setName(String.valueOf(doc.get("Apartment").toString()));
                saj.setAddress(String.valueOf(doc.get("Address").toString()));
                saj.setImages(String.valueOf(doc.get("Images").toString()));
                saj.setRent((int)Double.parseDouble(doc.get("Rent").toString()));
                saj.setRank(8);
                result.getApartments().add(saj);
            }
            result.setTotal(apartments.getNumFound());
            result.setCity(city);
            result.setPage(page);
            result.setPageSize(pageSize);
            if(result.getTotal()%pageSize == 0){
                result.setEndPage((int)(result.getTotal()/pageSize));
            }else{
                result.setEndPage((int)(result.getTotal()/pageSize) + 1);
            }

//            result.setAddress("city or college");
            return result;
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
