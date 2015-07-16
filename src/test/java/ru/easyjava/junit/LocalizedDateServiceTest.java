package ru.easyjava.junit;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LocalizedDateServiceTest {
    private LocalizedDateService testedObject = new LocalizedDateService();

    @Test
    public void testFormatDate() throws Exception {
        LocaleHolder.setLocale("ru");

        Calendar date = Calendar.getInstance();
        date.set(1961, 4, 21, 9, 7, 0);
        assertThat(testedObject.formatDate(date.getTime()), is("Вс, мая 21, '61"));
    }

    @Test
    public void testFormatDateTW() throws Exception {
        LocaleHolder.setLocale("th");

        Calendar date = Calendar.getInstance();
        date.set(1961, 4, 21, 9, 7, 0);
        assertThat(testedObject.formatDate(date.getTime()), is("อา., พ.ค. 21, '61"));
    }
}
