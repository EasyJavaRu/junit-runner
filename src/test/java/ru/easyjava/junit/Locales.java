package ru.easyjava.junit;

import org.junit.runner.Runner;
import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Locales extends Suite {
    private static Map<String, String> localesToUse;

    static {
        localesToUse = new HashMap<String, String>();
        localesToUse.put("ru", "Вс, мая 21, '61");
        localesToUse.put("th", "อา., พ.ค. 21, '61");
        localesToUse.put("de", "So, Mai 21, '61");
        localesToUse.put("ja", "日, 5 21, '61");
        localesToUse.put("ar", "ح, ماي 21, '61");
    }

    public Locales(Class<?> clazz) throws InitializationError {
        super(clazz, prepareRunners(clazz));
    }

    private static List<Runner> prepareRunners(Class<?> clazz) throws InitializationError {
        List<Runner> result = new ArrayList<Runner>();
        for (String locale : localesToUse.keySet()) {
            result.add(new LocalesRunner(locale, localesToUse.get(locale), clazz));
        }
        return result;
    }
}
