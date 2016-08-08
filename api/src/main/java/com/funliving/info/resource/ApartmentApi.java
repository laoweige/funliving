package com.funliving.info.resource;

import com.funliving.info.common.SolrHelper;
import com.funliving.info.repository.ApartmentRepository;
import com.funliving.info.repository.entity.Apartment;
import com.funliving.info.repository.entity.Facility;
import com.funliving.info.repository.entity.Room;
import com.funliving.info.resource.repr.ApartmentJson;
import com.funliving.info.resource.repr.FacilityJson;
import com.funliving.info.resource.repr.RoomJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Component
@Path("/apartment")
public class ApartmentApi {

    @Autowired
    ApartmentRepository apartmentRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    @Path("{id}")
    public ApartmentJson getEntity(@PathParam("id") int id) {
        Apartment apartment =  apartmentRepository.getEntity(id);
        ApartmentJson result = new ApartmentJson(apartment);
        List<Room> rooms = apartmentRepository.getRooms(id);
        for(Room room : rooms){
            result.getRooms().add(new RoomJson(room));
        }
        List<Facility> facilities = apartmentRepository.getFacilities(id);
        for(Facility facility : facilities){
            result.getFacilities().add(new FacilityJson(facility));
        }
        return result;
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("create")
    public Response create(@BeanParam Apartment apartment)
            throws URISyntaxException, IOException {

        int size = apartmentRepository.create(apartment);
        if(size>0){
            ApartmentJson apartmentJson = new ApartmentJson(apartment);
            SolrHelper.add(apartmentJson,"172.17.1.187:9080/solr/","apartment");
        }
        System.out.println(size);
        return Response.created(new URI("")).build();
    }

//    @POST
//    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("create")
//    public Response create(@FormParam("name") String name)
//            throws URISyntaxException, IOException {
//        System.out.println(name);
////        int size = apartmentRepository.create(apartment);
////        System.out.println(size);
//
//        return Response.created(new URI("")).build();
//    }
}
