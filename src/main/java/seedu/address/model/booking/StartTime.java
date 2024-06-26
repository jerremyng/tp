package seedu.address.model.booking;

import static seedu.address.commons.util.AppUtil.checkArgument;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

/**
 * Represents a Booking's start time in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidStartTime(String)}
 */
public class StartTime {

    public static final String MESSAGE_CONSTRAINTS = "Start times must be in the format of YYYY-MM-DD HH:MM "
            + "(ISO_LOCAL_DATE_TIME).\nThe date must also exist for that month/year. (i.e no 31 Feb)";
    private static final DateTimeFormatter formatter = DateTimeFormatter
            .ofPattern("uuuu-MM-dd HH:mm")
            .withResolverStyle(ResolverStyle.STRICT);

    public final String startTimeString;
    public final LocalDateTime startTime;

    /**
     * Constructs a {@code StartTime}.
     *
     * @param startTime A valid start time.
     */
    public StartTime(String startTime) {
        checkArgument(isValidStartTime(startTime), MESSAGE_CONSTRAINTS);
        this.startTimeString = startTime;
        this.startTime = LocalDateTime.parse(startTime, formatter);
    }

    /**
     * Returns true if a given string is a valid start time.
     */
    public static boolean isValidStartTime(String test) {
        try {
            LocalDateTime.parse(test, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public LocalDateTime getTime() {
        return this.startTime;
    }

    @Override
    public String toString() {
        return startTime.format(formatter);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StartTime)) {
            return false;
        }
        StartTime that = (StartTime) other;
        return startTime.equals(that.startTime);
    }

    @Override
    public int hashCode() {
        return startTime.hashCode();
    }

}
