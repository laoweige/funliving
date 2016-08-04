package com.funliving.info.resource;

import com.funliving.info.repository.ApartmentRepository;
import com.funliving.info.repository.entity.Apartment;
import com.funliving.info.repository.entity.Facility;
import com.funliving.info.repository.entity.Room;
import com.funliving.info.repository.entity.User;
import com.funliving.info.resource.repr.ApartmentJson;
import com.funliving.info.resource.repr.FacilityJson;
import com.funliving.info.resource.repr.RoomJson;
import com.funliving.info.resource.repr.UserJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
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
}
