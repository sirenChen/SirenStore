package utils;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;

/**
 * JSON Utils
 */
public class JsonUtil {

    /**
     * convert array to json
     * @param objects
     * @return
     */
	public static String array2json(Object[] objects){
		
		JSONArray jsonArray = JSONArray.fromObject(objects);
		return jsonArray.toString();
	}
	
	/**
     * convert list to json
	 * @param list
	 * @return
	 */
	public static String list2json(List list){
		
		JSONArray jsonArray = JSONArray.fromObject(list);
		return jsonArray.toString();
	}
	
	/**
     * convert map to json
	 * @param map
	 * @return
	 */
	public static String map2json(Map map){
		
		JSONObject jsonObject = JSONObject.fromObject(map);
		return jsonObject.toString();
		
	}
	
	/**
     * convert object to json
	 * @param object
	 * @return
	 */
	public static String object2json(Object object){
		
		JSONObject jsonObject = JSONObject.fromObject(object);
		return jsonObject.toString();
		
	}
	
	/**
     * convert xml data to json
	 * @param xml
	 * @return
	 */
	public static String xml2json(String xml){
		
		JSONArray jsonArray = (JSONArray) new XMLSerializer().read(xml);
		return jsonArray.toString();
		
	}
	
}
