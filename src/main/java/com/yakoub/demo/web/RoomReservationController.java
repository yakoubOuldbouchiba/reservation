package com.yakoub.demo.web;

import java.util.Date;
import java.util.List;


import com.yakoub.demo.data.business.ReservationService;
import com.yakoub.demo.data.business.RoomReservation;
import com.yakoub.demo.util.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/reservations")
public class RoomReservationController {

    private final DateUtils dateUtils;
    private final ReservationService reservationService;

    public RoomReservationController(DateUtils dateUtils, ReservationService reservationService) {
        this.dateUtils = dateUtils;
        this.reservationService = reservationService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getReservations(@RequestParam(value="date", required=false) String dateString, Model model){
        Date date = this.dateUtils.createDateFromDateString(dateString);
        List<RoomReservation> roomReservations = this.reservationService.getRoomReservationsForDate(date);
        model.addAttribute("roomReservations", roomReservations);
        return "roomres";
    }
}
