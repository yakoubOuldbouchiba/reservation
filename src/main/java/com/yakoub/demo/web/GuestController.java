package com.yakoub.demo.web;

import com.yakoub.demo.data.business.GuestDto;
import com.yakoub.demo.data.business.GuestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/guests")
public class GuestController {
    private final GuestService guestService;

    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getGuests(Model model){
        List<GuestDto> guestDtoList = this.guestService.getGuests();
        model.addAttribute("guests", guestDtoList);
        return "guests";
    }
}
