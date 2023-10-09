package org.fasttrack.repository;

import org.fasttrack.model.Offer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OfferReader {
    public static List<Offer> getAllOffers(String filePath) {
        System.out.println(filePath);
        List<Offer> allOffers = new ArrayList<>();
        FileReader fileReader;
        try {
            fileReader = new FileReader(filePath);
        } catch (FileNotFoundException e) {
            System.out.println("couldn't open file");
            return new ArrayList<>();
        }
        Scanner fileScanner = new Scanner(fileReader);

        while (fileScanner.hasNextLine()) {
            String currentLine = fileScanner.nextLine();
            String[] partsOfOffers = currentLine.split("\\|");
            if (partsOfOffers.length < 4) {
            } else {
                String name = partsOfOffers[0];
                String destination = partsOfOffers[1];
                int price = Integer.parseInt(partsOfOffers[2]);
                int lengthOfStay = Integer.parseInt(partsOfOffers[3]);

                Offer currentOffer = new Offer(name, destination, price, lengthOfStay);
                allOffers.add(currentOffer);
            }
        }
        return allOffers;
    }
}
