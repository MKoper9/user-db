package pl.sdacademy.userdb;

import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class FilterPredicates {
    private static Map<Class<? extends Filter>, Predicate<HttpServletRequest>> predicates = configPredicates();

    public static Map<Class<? extends Filter>, Predicate<HttpServletRequest>> configPredicates() {
        Map<Class<? extends Filter>, Predicate<HttpServletRequest>> predicates = new HashMap<>();
        predicates.put(SecuritySessionFilter.class, req -> req.getServletPath().startsWith("/secured"));
        return predicates;
    }

    public static Predicate<HttpServletRequest> predicateFor(Class<? extends Filter> filterType) {
        return predicates.getOrDefault(filterType, req -> true);
    }
}
