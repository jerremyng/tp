package seedu.address.model.person;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

public class RatingTest {
    @Test
    public void constructor_invalidRating_throwsIllegalArgumentException() {
        int invalidRating = -1;
        assertThrows(IllegalArgumentException.class, () -> new Rating(invalidRating));
    }

    @Test
    public void setRating_invalidRating_throwsIllegalArgumentException() {
        Rating testRating = new Rating(0);
        assertThrows(IllegalArgumentException.class, () -> testRating.setRating(-1));
    }

    @Test
    public void isValidRating() {
        // invalid addresses
        assertFalse(Rating.isValidRating(124)); // empty string
        assertFalse(Rating.isValidRating(-1)); // spaces only

        // valid addresses
        assertTrue(Rating.isValidRating(4));
    }

    @Test
    public void equals() {
        Rating rating = new Rating(5);

        // same values -> returns true
        assertTrue(rating.equals(new Rating(5)));

        // same object -> returns true
        assertTrue(rating.equals(rating));

        // null -> returns false
        assertFalse(rating.equals(null));

        // different types -> returns false
        assertFalse(rating.equals(""));

        // different values -> returns false
        assertFalse(rating.equals(new Rating(0)));
    }
}
