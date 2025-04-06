package usantatecla.movies.v25;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CustomerStatementTest {

    private String customerName;
    private String movieName;

    @Before
    public void setUp() {
        this.customerName = "customerName";
        this.movieName = "movieName";
    }

    @Test
    public void withoutRentalsTestStatement() {

        Customer customer = new CustomerBuilder().name(this.customerName).build();
        String statement = customer.statement();
        String result = new StatementBuilder().customerName(this.customerName)
                .totalAmount(0).frequentRenterPoints(0).build();
        assertEquals(result, statement);
    }

    @Test
    public void regularRental1DayTestStatement() {
        Movie movie = new RegularMovie(this.movieName);
        Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
        Customer customer = new CustomerBuilder().name(this.customerName).rental(rental).build();
        String statement = customer.statement();
        String result = new StatementBuilder().customerName(this.customerName).movie(this.movieName, 2)
                .totalAmount(2).frequentRenterPoints(1).build();
        assertEquals(result, statement);
    }

    @Test
    public void regularRental2DayTestStatement() {
        Movie movie = new RegularMovie(this.movieName);
        Rental rental = new RentalBuilder().movie(movie).daysRented(2).build();
        Customer customer = new CustomerBuilder().name(this.customerName).rental(rental).build();
        String statement = customer.statement();
        String result = new StatementBuilder().customerName(this.customerName).movie(this.movieName, 2)
                .totalAmount(2).frequentRenterPoints(1).build();
        assertEquals(result, statement);
    }

    @Test
    public void newReleaseRental1DayTestStatement() {
        Movie movie = new NewReleaseMovie(this.movieName);
        Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
        Customer customer = new CustomerBuilder().name(this.customerName).rental(rental).build();
        String statement = customer.statement();
        String result = new StatementBuilder().customerName(this.customerName).movie(this.movieName, 3)
                .totalAmount(3).frequentRenterPoints(1).build();
        assertEquals(result, statement);
    }

    @Test
    public void childrenRental1DayTestStatement() {
        Movie movie = new ChildrenMovie(this.movieName);
        Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
        Customer customer = new CustomerBuilder().name(this.customerName).rental(rental).build();
        String statement = customer.statement();
        String result = new StatementBuilder().customerName(this.customerName).movie(this.movieName, 1.5)
                .totalAmount(1.5).frequentRenterPoints(1).build();
        assertEquals(result, statement);
    }

}
