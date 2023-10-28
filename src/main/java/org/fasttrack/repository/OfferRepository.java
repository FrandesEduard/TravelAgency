package org.fasttrack.repository;

import org.fasttrack.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Integer> {
    List<Offer> findAllByDestination(String destination);

    List<Offer> findAllByDestinationAndPrice(String destination, int price);
}
