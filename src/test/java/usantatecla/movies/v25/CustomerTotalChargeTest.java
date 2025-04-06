package usantatecla.movies.v25;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CustomerTotalChargeTest {

    private String customerName;
    private String movieName;

    @Before
    public void setUp() {
        this.customerName = "customerName";
        this.movieName = "movieName";
    }

    @Test
    public void withoutRentalsTestTotalCharge() {
        Customer customer = new CustomerBuilder().name(this.customerName).build();
        assertTrue(customer.getTotalCharge() == 0);
    }
    @Test
    public void regularRental1DayTestTotalCharge() {
        Movie movie = new RegularMovie(this.movieName);
        Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
        Customer customer = new CustomerBuilder().name(this.customerName).rental(rental).build();
        assertTrue(customer.getTotalCharge() == 2);
    }

    @Test
    public void regularRental2DayTestTotalCharge() {
        Movie movie = new RegularMovie(this.movieName);
        Rental rental = new RentalBuilder().movie(movie).daysRented(2).build();
        Customer customer = new CustomerBuilder().name(this.customerName).rental(rental).build();
        assertTrue(customer.getTotalCharge() == 2);
    }
    @Test
    public void newReleaseRental1DayTestTotalCharge() {
        Movie movie = new NewReleaseMovie(this.movieName);
        Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
        Customer customer = new CustomerBuilder().name(this.customerName).rental(rental).build();
        assertTrue(customer.getTotalCharge() == 3);
    }


    @Test
    public void childrenRental1DayTestTotalCharge() {
        Movie movie = new ChildrenMovie(this.movieName);
        Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
        Customer customer = new CustomerBuilder().name(this.customerName).rental(rental).build();
        assertTrue(customer.getTotalCharge() == 1.5);
    }


}
