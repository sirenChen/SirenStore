package utils;

import org.apache.commons.beanutils.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Siren Chen.
 * convert string to Date, for BeanUtils
 */
public class String2DateConvert implements Converter {

    /**
     * convert String to Date
     * @param aClass target class, Date
     * @param o      String
     * @return
     */
    @Override
    public Object convert(Class aClass, Object o) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;

        try {
            date = simpleDateFormat.parse((String) o);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }
}
