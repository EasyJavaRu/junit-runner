package ru.easyjava.junit;

/**
 * Keeps current application locale.
 *
 * Not thread-safe.
 */
public final class LocaleHolder {
    /**
     * Locale data.
     */
    private static String locale;

    /**
     * Do not construct me.
     */
    private LocaleHolder() { };

    /**
     * Gets current locale.
     * @return locale value.
     */
    public static String getLocale() {
        return locale;
    }

    /**
     * Sets current locale.
     * @param newLocale new value.
     */
    public static void setLocale(final String newLocale) {
        LocaleHolder.locale = newLocale;
    }
}
