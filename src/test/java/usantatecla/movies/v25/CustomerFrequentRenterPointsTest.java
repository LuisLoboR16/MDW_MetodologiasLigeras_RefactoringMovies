package usantatecla.movies.v25;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
public class CustomerFrequentRenterPointsTest {

    private String customerName;
    private String movieName;

    @Before
    public void setUp() {
        this.customerName = "customerName";
        this.movieName = "movieName";
    }

    @Test
    public void withoutRentalsTestTotalFrequentRenterPoints() {
        Customer customer = new CustomerBuilder().name(this.customerName).build();
        assertTrue(customer.getTotalFrequentRenterPoints() == 0);
    }	@Test
    public void regularRental1DayTestTotalFrequentRenterPoints() {
        Movie movie = new RegularMovie(this.movieName);
        Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
        Customer customer = new CustomerBuilder().name(this.customerName).rental(rental).build();
        assertTrue(customer.getTotalFrequentRenterPoints() == 1);
    }

    @Test
    public void regularRental2DayTestTotalFrequentRenterPoints() {
        Movie movie = new RegularMovie(this.movieName);
        Rental rental = new RentalBuilder().movie(movie).daysRented(2).build();
        Customer customer = new CustomerBuilder().name(this.customerName).rental(rental).build();
        assertTrue(customer.getTotalFrequentRenterPoints() == 1);
    }

    @Test
    public void newReleaseRental1DayTestTotalFrequentRenterPoints() {
        Movie movie = new NewReleaseMovie(this.movieName);
        Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
        Customer customer = new CustomerBuilder().name(this.customerName).rental(rental).build();
        assertTrue(customer.getTotalFrequentRenterPoints() == 1);
    }


    @Test
    public void childrenRental1DayTestTotalFrequentRenterPoints() {
        Movie movie = new ChildrenMovie(this.movieName);
        Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
        Customer customer = new CustomerBuilder().name(this.customerName).rental(rental).build();
        assertTrue(customer.getTotalFrequentRenterPoints() == 1);
    }

}
