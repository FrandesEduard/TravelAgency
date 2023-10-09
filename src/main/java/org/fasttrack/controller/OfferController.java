package org.fasttrack.controller;

import org.fasttrack.model.Offer;
import org.fasttrack.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("offers")
public class OfferController {
    private OfferService service;

    @Autowired
    public OfferController(OfferService service) {
        this.service = service;
    }

    @GetMapping
    public List<Offer> getAllOffers() {
        return service.getAllOffers();
    }

    @GetMapping("{offerId}")
    public Offer getOfferById(@PathVariable int offerId) {
        return service.getOfferById(offerId);
    }

    @PostMapping
    public Offer addOffer(@RequestBody Offer offer) {
        return service.addOffer(offer);
    }

    @PutMapping("{offerId}")
    public Offer putOffer(@PathVariable int offerId, @RequestBody Offer offer) {
        return service.replaceOffer(offerId, offer);
    }

    @DeleteMapping("{offerId}")
    public String removeOffer(@PathVariable int offerId) {
        return service.removeOffer(offerId);
    }

}
