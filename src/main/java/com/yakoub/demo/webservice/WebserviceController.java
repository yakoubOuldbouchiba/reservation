package com.yakoub.demo.webservice;

import com.yakoub.demo.data.Guest;
import com.yakoub.demo.data.business.GuestDto;
import com.yakoub.demo.data.business.GuestService;
import com.yakoub.demo.data.business.ReservationService;
import com.yakoub.demo.data.business.RoomReservation;
import com.yakoub.demo.util.DateUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WebserviceController {
    private final DateUtils dateUtils;
    private final ReservationService reservationService;

    private final GuestService guestService;

    public WebserviceController(DateUtils dateUtils, ReservationService reservationService, GuestService guestService) {
        this.dateUtils = dateUtils;
        this.reservationService = reservationService;
        this.guestService = guestService;
    }

    @RequestMapping(path = "/reservations", method = RequestMethod.GET)
    public List<RoomReservation> getReservation(@RequestParam(value = "date" , required = false)String dateString){
        Date date = this.dateUtils.createDateFromDateString(dateString);
        return this.reservationService.getRoomReservationsForDate(date);
    }

    @GetMapping(path = "/guests")
    public List<GuestDto> getGuests(){
        return guestService.getGuests();
    }

    @PostMapping(path = "/guests/createOrUpdate" )
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrUpdateGuest(@RequestParam Guest guest){
        this.guestService.createOrUpadteGuest(guest);
    }


}
