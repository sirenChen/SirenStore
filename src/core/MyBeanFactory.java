package core;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * Created by Siren Chen.
 *
 * using the idea of Inversion of Control
 *
 * return the instance of the implementation class
 */
public class MyBeanFactory {

    public static Object getImplClass(String id) {
        Object implClass = null;

        try {
            // get document object
            Document document = new SAXReader().read(MyBeanFactory.class.getClassLoader().getResourceAsStream("MyBeanFactoryConfig.xml"));

            // obtain bean object
            Element element = (Element) document.selectSingleNode("//bean[@id='"+id+"']");

            // obtain class
            String clazz = element.attributeValue("class");

            implClass = Class.forName(clazz).newInstance();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return implClass;
    }

}
