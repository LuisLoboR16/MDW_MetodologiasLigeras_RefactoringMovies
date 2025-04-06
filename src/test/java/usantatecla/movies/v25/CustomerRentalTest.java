package usantatecla.movies.v25;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CustomerRentalTest {

    @Test
    public void rentalTest() {
        String regularMovieName = "regularMovieName";
        Movie regularMovie = new RegularMovie(regularMovieName);
        Rental regularRental = new RentalBuilder().movie(regularMovie).daysRented(10).build();

        String newReleaseMovieName = "newReleaseMovieName";
        Movie newReleaseMovie = new NewReleaseMovie(newReleaseMovieName);
        Rental newReleaseRental = new RentalBuilder().movie(newReleaseMovie).daysRented(10).build();

        String childrensMovieName = "childrensMovieName";
        Movie childrensMovie = new ChildrenMovie(childrensMovieName);
        Rental childrensRental = new RentalBuilder().movie(childrensMovie).daysRented(10).build();

        String customerName = "customerName";
        Customer customer = new CustomerBuilder().name(customerName)
                .rental(regularRental).rental(newReleaseRental).rental(childrensRental).build();

        String statement = customer.statement();

        String result = new StatementBuilder().customerName(customerName)
                .movie(regularMovieName, 14).movie(newReleaseMovieName, 3).movie(childrensMovieName, 15)
                .totalAmount(32).frequentRenterPoints(4).build();
        assertEquals(result, statement);
    }



}
