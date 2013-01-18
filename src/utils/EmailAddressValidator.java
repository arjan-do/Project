/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.StringTokenizer;

/**
 *
 * @author Nick
 */
public class EmailAddressValidator {

    public static boolean isValidEmailAddress(String emailAddress) {
        //only if email 
        if (emailAddress != null
                && emailAddress.indexOf("@") > 0
                && lastEmailFieldTwoCharsOrMore(emailAddress) != false
                && emailAddress.indexOf(".") > 0) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean lastEmailFieldTwoCharsOrMore(String emailAddress) {
        if (emailAddress == null) {
            return false;
        }

        StringTokenizer st = new StringTokenizer(emailAddress, ".");
        String lastToken = null;

        while (st.hasMoreTokens()) {
            lastToken = st.nextToken();
        }

        if (lastToken.isEmpty()) {
            return false;
        } else if (lastToken.length() < 2) {
            return false;
        } else if (lastToken.length() >= 5) {
            return false;
        } else {
            return true;
        }

    }
}
