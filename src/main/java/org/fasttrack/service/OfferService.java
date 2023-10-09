package org.fasttrack.service;

import org.fasttrack.exception.EntityNotFoundException;
import org.fasttrack.model.Offer;
import org.fasttrack.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferService {
    private OfferRepository repository;

    @Autowired
    public OfferService(OfferRepository repository) {
        this.repository = repository;
    }

    public List<Offer> getAllOffers() {
        return repository.findAll();
    }

    public List<Offer> getAllOffersByDestination(String destinationName) {
        return repository.findAllByDestination(destinationName);
    }

    public Offer addOffer(Offer offer) {
        return repository.save(offer);
    }

    public Offer getOfferById(int offerId) {
        Optional<Offer> foundOffer = repository.findById(offerId);
        if (foundOffer.isPresent()) {
            return foundOffer.get();
        } else {
            throw new EntityNotFoundException("Nu a fost gasita oferta cu id-ul " + offerId, offerId);
        }
    }

    public String removeOffer(int offerId) {
        repository.deleteById(offerId);
        return "Sters cu succes!";
    }

    public Offer replaceOffer(int offerId, Offer offer) {
        offer.setOfferId(offerId);
        return repository.save(offer);
    }
}
