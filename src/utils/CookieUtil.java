package utils;

import javax.servlet.http.Cookie;

/**
 * Created by Siren Chen.
 */
public class CookieUtil {

    /**
     * get cookie by cookie name
     * @param name cookie name
     * @param cookies cookie array
     * @return Cookie, or null if cookie not find
     */
    public static Cookie getCookieByName(String name, Cookie[] cookies) {

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (name.equals(cookie.getName())) {
                    return cookie;
                }
            }
        }

        return null;
    }

}
