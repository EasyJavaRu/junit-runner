package ru.easyjava.junit;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Locale-aware date formatting service.
 */
public class LocalizedDateService {
    /**
     * Formats date in a human friendly form.
     * @param date Date to format.
     * @return Formatted date with locale taken into account.
     */
    public final String formatDate(final Date date) {
        DateFormat dateFormat = new SimpleDateFormat("EEE, MMM d, ''yy",
                new Locale(LocaleHolder.getLocale()));
        return dateFormat.format(date);
    }
}
