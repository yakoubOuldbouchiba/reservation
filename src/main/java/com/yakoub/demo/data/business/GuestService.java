package com.yakoub.demo.data.business;

import com.yakoub.demo.data.Guest;
import com.yakoub.demo.data.GuestRepositroy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class GuestService {
    private final GuestRepositroy guestRepositroy;

    public GuestService(GuestRepositroy guestRepositroy) {
        this.guestRepositroy = guestRepositroy;
    }

    public List<GuestDto> getGuests(){
        Iterable<Guest> guestIterator = this.guestRepositroy.findAll();
        List<GuestDto> guestDtoList = new ArrayList<>();
        guestIterator.forEach(guest -> {
            GuestDto guestDto = new GuestDto();
            guestDto.setId(guest.getId());
            guestDto.setFirstName(guest.getFirstName());
            guestDto.setLastName(guest.getLastName());
            guestDto.setEmailAddres(guest.getEmailAddres());
            guestDto.setAddress(guest.getAddress());
            guestDto.setCountry(guest.getCountry());
            guestDto.setState(guest.getState());
            guestDto.setPhoneNumber(guest.getEmailAddres());
            guestDtoList.add(guestDto);
        });
        return  guestDtoList;
    }

    public Guest createOrUpadteGuest(Guest guest){
        return guestRepositroy.save(guest);
    }
}
