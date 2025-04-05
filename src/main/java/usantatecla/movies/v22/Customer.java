package usantatecla.movies.v22;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;

    private List<Rental> rentals;

    public Customer(String name) {
        this.name = name;
        rentals = new ArrayList<Rental>();
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        StringBuilder result = new StringBuilder("Rental Record for " + this.getName() + "\n");
        this.rentals.forEach(rental -> result.append("\t").append(rental.getMovie().getTitle()).append(String.valueOf(rental.getCharge())).append("\n"));

        result.append("Amount owed is ").append(String.valueOf(this.getTotalCharge())).append("\n");
        result.append("You earned ").append(String.valueOf(this.getTotalFrequentRenterPoints())).append(" frequent renter points");
        return result.toString();
    }

    private double getTotalCharge() {
        return  this.rentals
                .stream()
                .mapToDouble(Rental::getCharge)
                .sum();
    }

    private int getTotalFrequentRenterPoints() {
        return this.rentals
                .stream()
                .mapToInt(Rental::getFrequentRenterPoints)
                .sum();
    }
}