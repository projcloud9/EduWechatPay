package xin.fallen.EduWechatPay.util;

import org.apache.commons.beanutils.ConvertUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import xin.fallen.EduWechatPay.annotation.Alias;

import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Author: fallen
 * Date: 17-2-15
 * Time: 下午4:34
 * Usage:配置文件反射载入
 */
public class ConfigLoader {

    public static boolean load(File config, Class clazz) {
        Document doc;
        SAXReader reader = new SAXReader();
        if (config == null || !config.isFile()) {
            return false;
        }
        try {
            doc = reader.read(config);
        } catch (DocumentException e) {
            throw new RuntimeException("配置文件解析异常,原因是：" + e.getMessage());
        }
        HashMap<String, String> configMap = new HashMap<String, String>();
        Iterator it = doc.getRootElement().elementIterator();
        while (it.hasNext()) {
            Element e = (Element) it.next();
            configMap.put(e.getName().trim(), e.getTextTrim());
        }
        if (configMap.size() == 0) {
            return false;
        }
        try {
            for (Field f : clazz.getDeclaredFields()) {
                //有注解则使用注解别名
                if (f.isAnnotationPresent(Alias.class)) {
                    Alias alias = f.getAnnotation(Alias.class);
                    if (configMap.containsKey(alias.value())) {
                        f.set(null, ConvertUtils.convert(configMap.get(alias.value()), f.getType()));
                    }
                    //没有注解则直接使用变量名
                } else {
                    if (configMap.containsKey(f.getName())) {
                        f.set(null, ConvertUtils.convert(configMap.get(f.getName()), f.getType()));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("转换中出现异常，原因是：" + e.getMessage());
            return false;
        }
        return true;
    }
}