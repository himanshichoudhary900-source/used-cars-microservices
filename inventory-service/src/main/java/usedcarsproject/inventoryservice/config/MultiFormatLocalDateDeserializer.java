package usedcarsproject.inventoryservice.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;


public class MultiFormatLocalDateDeserializer extends JsonDeserializer<LocalDate> {

    private static final List<DateTimeFormatter> FORMATTERS = Arrays.asList(
            DateTimeFormatter.ofPattern("d-M-uu"),
            DateTimeFormatter.ofPattern("d-M-uuuu"),
            DateTimeFormatter.ofPattern("d/M/uuuu"),
            DateTimeFormatter.ISO_LOCAL_DATE
    );

    @Override
    public LocalDate deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonToken token = p.currentToken();
        if (token == null) {
            return null;
        }


        if (token.isNumeric()) {
            long value = p.getLongValue();
            if (Math.abs(value) < 1_000_000_000_000L) { // seconds
                value = value * 1000L;
            }
            Instant instant = Instant.ofEpochMilli(value);
            return instant.atZone(ZoneId.systemDefault()).toLocalDate();
        }

        String text = p.getText();
        if (text == null || text.isBlank()) {
            return null;
        }
        String trimmed = text.trim();
        for (DateTimeFormatter formatter : FORMATTERS) {
            try {
                return LocalDate.parse(trimmed, formatter);
            } catch (DateTimeParseException ignored) {
            }
        }
        throw InvalidFormatException.from(p, "Unsupported date format for LocalDate: " + text, text, LocalDate.class);
    }
}
