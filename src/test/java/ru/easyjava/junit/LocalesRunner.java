package ru.easyjava.junit;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

import java.lang.annotation.Annotation;
import java.util.List;

public class LocalesRunner extends BlockJUnit4ClassRunner {
    private String locale;
    private String result;

    public LocalesRunner(String locale, String result, Class<?> clazz) throws InitializationError {
        super(clazz);

        this.locale = locale;
        this.result = result;
    }

    @Override
    protected void validatePublicVoidNoArgMethods(Class<? extends Annotation> annotation, boolean isStatic, List<Throwable> errors) {
        List<FrameworkMethod> methods = getTestClass().getAnnotatedMethods(annotation);

        for (FrameworkMethod eachTestMethod : methods) {
            eachTestMethod.validatePublicVoid(isStatic, errors);
        }
    }

    @Override
    protected Statement methodBlock(final FrameworkMethod method) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                LocaleHolder.setLocale(locale);
                method.getMethod().invoke(getTestClass().getOnlyConstructor().newInstance(), result);
            }
        };
    }

    @Override// The name of the test class
    protected String getName() {
        return String.format("%s [%s]", super.getName(), locale);
    }

    @Override// The name of the test method
    protected String testName(final FrameworkMethod method) {
        return String.format("%s [%s]", method.getName(), locale);
    }
}
