package com.cykj.myuitl;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Field;

public class MappingUtils {
    /**
     * 获取并解析xml
     * @return
     */
    public  static Element fetchXml(){
        File file = new File("src/main/resources/TestTable.xml");
        //实例化xml解析器
        SAXReader reader=new SAXReader();
        try {
            Document doc = reader.read(file);
            //获取根节点
            Element root=doc.getRootElement();
            return root;
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String fetchInsertSql(String bean){
        try {
            Class clz = Class.forName(bean);
            String clzStr = clz.toString();
            //获取类名，substring截取字符串，lastIndexOf获取.最后一次出现的位置，toLowerCase转换小写
            String beanName = clzStr.substring(clzStr.lastIndexOf(".") + 1).toLowerCase();
            //获取类中的所有属性
            Field[] fields = clz.getDeclaredFields();
            StringBuffer sb=null;
            String fileNames="";
            for (Field field : fields) {
                fileNames+=","+field.getName();
                if (sb==null){
                    sb=new StringBuffer();
                    sb.append("?");
                }else {
                    sb.append(",?");
                }
            }
            return "insert into "+beanName+"("+fileNames.substring(1)+") values("+sb.toString()+")";
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


}
