package functionalInterface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        // Regular way
        System.out.println(isPhoneValid("51421505"));
        System.out.println(isPhoneValid("51421558"));

        // Predicate and BiPredicate way
        System.out.println(isPhoneValid.test("51421558"));
        System.out.println(isPhoneValid.and(containsNumber3).test("51423505"));
        System.out.println(areSame.test("05","05"));
    }

    // Regular way
    static Boolean isPhoneValid(String phone){
        return phone.startsWith("51") && phone.endsWith("05");
    }

    // Predicate and BiPredicate way
    static Predicate<String> isPhoneValid = phone -> phone.startsWith("51") && phone.endsWith("05");
    static Predicate<String> containsNumber3 = phone -> phone.contains("3");
    static BiPredicate<String, String> areSame = String::equals;
}
