package ru.easyjava.junit;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Calendar;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(Locales.class)
public class RunnerDateServiceTest {
    private LocalizedDateService testedObject = new LocalizedDateService();


    @Test
    public void testFormatDate(String result) throws Exception {
        Calendar date = Calendar.getInstance();
        date.set(1961, 4, 21, 9, 7, 0);
        assertThat(testedObject.formatDate(date.getTime()), is(result));
    }
}
