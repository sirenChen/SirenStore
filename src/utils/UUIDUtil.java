package utils;

import java.util.UUID;

/**
 * Created by Siren Chen on 2017/1/20.
 * generate a random code
 */
public class UUIDUtil {

    public static String genId () {
        return UUID.randomUUID().toString().replace("-","").toUpperCase();
    }

    public static String genCode () {
        return genId();
    }

}
