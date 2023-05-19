import annotations.AfterSuit;
import annotations.BeforeSuite;
import annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TestRunner {
    public static void start(Class<?> clazz) {
        Objects.requireNonNull(clazz);

        List<Method> beforeSuit = new ArrayList<>();
        List<Method> test = new ArrayList<>();
        List<Method> afterSuit = new ArrayList<>();

        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                beforeSuit.add(method);
            } else if (method.isAnnotationPresent(Test.class)) {
                test.add(method);
            } else if (method.isAnnotationPresent(AfterSuit.class)) {
                afterSuit.add(method);
            }
        }

        if (beforeSuit.size() > 1 || afterSuit.size() > 1) {
            throw new RuntimeException("@BeforeSuit and @AfterSuit should be called only one time");
        }

        if (!beforeSuit.isEmpty()) {
            try {
                beforeSuit.get(0).invoke(clazz.newInstance());
            } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
                throw new RuntimeException(e);
            }
        }

        test = test.stream()
                .sorted(Comparator.comparingInt(method -> method.getAnnotation(Test.class).priority()))
                .collect(Collectors.toList());
        for (Method method : test) {
            try {
                method.invoke(clazz.newInstance());
            } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
                throw new RuntimeException(e);
            }
        }

        if (!afterSuit.isEmpty()) {
            try {
                afterSuit.get(0).invoke(clazz.newInstance());
            } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
                throw new RuntimeException(e);
            }
        }
    }
}