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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Component
@Path("/search")
public class SearchApi {
    @Autowired
    private SolrHelper solrHelper;

    @Autowired
    private CollegeRepository collegeRepository;
    @Autowired
    private CityRepository cityRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    public SearchListJson apartments(@DefaultValue("1") @QueryParam("page") int page,
                                       @DefaultValue("10") @QueryParam("pageSize") int pageSize,
                                       @DefaultValue("1") @QueryParam("city") int city,
                                        @DefaultValue("1") @QueryParam("sort") int sort,
                                       @QueryParam("college") int college,
                                       @QueryParam("rent") String rent) {

        SearchListJson result = new SearchListJson();

        List<String> queries = new ArrayList<>();
        List<City> cities = cityRepository.getList(1);
        result.setCities(cities);

        if(city!=0){
            result.setQueryParameters("city="+city);
            queries.add(String.format("City:%s", city));
            List<College> collegeList = collegeRepository.getList(city);
            result.setColleges(new ArrayList<CollegeJson>());
            for(College c:collegeList){
                CollegeJson cj = new CollegeJson(c);
                result.getColleges().add(cj);
            }
            for(City c :cities){
                if(c.getId()==city){
                    result.setCity(c);
                    break;
                }
            }
        }
        result.setQueryParameters(result.getQueryParameters()+"&sort="+sort);
        if(rent!=null && !rent.equals("") && rent.contains(",") && !rent.endsWith(",")){
            String[] rents = rent.split(",");
            queries.add(String.format("Rent:[%s TO %s]", rents[0],rents[1]));
            result.setQueryParameters(result.getQueryParameters()+"&rent="+rents[0]+","+rents[1]);
        }
        if(college!=0){
            for(CollegeJson cj : result.getColleges()){
                if(cj.getId()==college){
                    result.setCollege(cj);
                    break;
                }
            }
            result.setQueryParameters(result.getQueryParameters()+"&college="+college);
        }

        String queryString = "";
        for(int i=0;i<queries.size();i++){
            if(i>0)
                queryString+=" AND ";
            queryString+=queries.get(i);
        }

        if(!queryString.equals("")) {
            int start = (page-1)*pageSize;
            SolrDocumentList apartments = solrHelper.search(queryString,start , pageSize, "*", "apartment");
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
            result.setPage(page);
            result.setPageSize(pageSize);
            if(result.getTotal()%pageSize == 0){
                result.setEndPage((int)(result.getTotal()/pageSize));
            }else{
                result.setEndPage((int)(result.getTotal()/pageSize) + 1);
            }
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
        SolrDocumentList apartments = solrHelper.search(String.format("Apartment:*%s*", keyword), 0, 10, "*","apartment");
        SolrDocumentList cities = solrHelper.search(String.format("CityName:*%s* AND EnName:*%s* AND SpellLetter:*%s*", keyword,keyword,keyword), 0, 10, "*","city");
        SolrDocumentList colleges = solrHelper.search(String.format("College:*%s* AND EnName:*%s* AND SpellLetter:*%s*", keyword,keyword,keyword), 0, 10, "*","college");
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

    @GET
    @Path("init")
    @Produces(MediaType.TEXT_PLAIN)
    public int init() {
        try {
            solrHelper.clear("apartment");
            solrHelper.clear("college");
            solrHelper.clear("city");
            for(int i=1;i<180;i++) {

                ApartmentJson apartmentJson = new ApartmentJson();
                apartmentJson.setId(i);
                apartmentJson.setName("Chapter Spitalfields "+i);
                apartmentJson.setRank(180%10);
                apartmentJson.setRent(321);
                apartmentJson.setNation(1);
                apartmentJson.setCity(1);
                apartmentJson.setCoordinate("1.3434,123.24");
                apartmentJson.setAddress("9 Frying Pan Alley, Spitalfields街区, 伦敦, E1 7HS");
                apartmentJson.setImages("https://static.student-cdn.com/media/cache/light_gallery_main_desktop/mstr/country/united-kingdom/city/london/property/nido-west-hampstead/image-o6i642.jpeg");
                solrHelper.add(apartmentJson, "apartment");
            }

            List<City> cities = cityRepository.getAll();
            for(City city:cities){
                solrHelper.add(city, "city");
            }

            List<College> colleges = collegeRepository.getAll();
            for(College college: colleges){
                solrHelper.add(college, "college");
            }

        }catch (Exception ex){
            throw ex;
        }
        return 1;
    }
}
