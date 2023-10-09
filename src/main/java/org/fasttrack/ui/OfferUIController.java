package org.fasttrack.ui;

import org.fasttrack.model.Offer;
import org.fasttrack.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class OfferUIController {
    private OfferService service;
    @Autowired
    public OfferUIController(OfferService service) {
        this.service = service;
    }

    String getOffers(Model model) {
        List<Offer> offersFromDB = service.getAllOffers();
        model.addAttribute("offers", offersFromDB);
        return "offers-app";
    }
}
