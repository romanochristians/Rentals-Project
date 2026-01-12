package za.co.property365.util;

import org.apache.commons.validator.routines.EmailValidator;

import java.util.UUID;

public class Helper {
    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean isValidPostalCode(int postalCode) {
        return postalCode >= 1000 && postalCode <= 9999;
    }

    public static boolean isValidRentalCost(double rentalCost) {
        return rentalCost > 0;
    }

    public static boolean isValidEmail(String email) {
        // Todo: email validation implementation
        throw new UnsupportedOperationException();
    }

    public static boolean isValidMobile(String mobile) {
        // Todo: mobile validation implementation
        throw new UnsupportedOperationException();
    }
}
