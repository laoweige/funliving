package com.funliving.info.resource;

import com.funliving.info.common.SolrHelper;
import com.funliving.info.repository.ApartmentRepository;
import com.funliving.info.repository.IntroduceRepository;
import com.funliving.info.repository.PictureRepository;
import com.funliving.info.repository.RoomRepository;
import com.funliving.info.repository.entity.*;
import com.funliving.info.resource.repr.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.client.Entity;
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
    private SolrHelper solrHelper;

    @Autowired
    ApartmentRepository apartmentRepository;
    @Autowired
    private PictureRepository pictureRepository;
    @Autowired
    private IntroduceRepository introduceRepository;

    @Autowired
    private RoomRepository roomRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    @Path("{id}")
    public ApartmentJson getEntity(@PathParam("id") int id,@QueryParam("college") int college) {
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
        List<Picture> pictures = pictureRepository.getList(1, id);
        for(Picture picture:pictures){
            result.getPictures().add(new PictureJson(picture));
        }
        List<Introduce> introduces = introduceRepository.getList(1,id);
        for(Introduce introduce:introduces){
            result.getIntroduces().add(new IntroduceJson(introduce));
        }
        if(college!=0){
            Distance distance = apartmentRepository.toCollegeDistance(id,college);
            result.setDistance(new DistanceJson(distance));
        }
        return result;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    public Apartment create(@BeanParam Apartment apartment)
            throws URISyntaxException, IOException {

        int size = apartmentRepository.create(apartment);
        System.out.println(apartment.getFacility());
        if(size>0 && apartment.getFacility()!=null){

            String[] facilies = apartment.getFacility().split(",");
            if(facilies.length>0){
                for(String f:facilies){
                    apartmentRepository.createFacility(apartment.getId(),Integer.valueOf(f));
                }
            }
        }
        System.out.println(size);
        return apartment;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    @Path("room")
    public Room putRoom(@BeanParam Room room)
            throws URISyntaxException, IOException {
        int size = roomRepository.create(room);
        System.out.println(size);
        return room;
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    @Path("room")
    public int deleteRoom(int id)
            throws URISyntaxException, IOException {
        roomRepository.delete(id);
        return 1;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    @Path("room")
    public List<Room> getRooms(@QueryParam("apartmentId") int apartmentId)
            throws URISyntaxException, IOException {
        List<Room> rooms = roomRepository.getList(apartmentId);
        return rooms;
    }
}
