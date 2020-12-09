package com.cykj.myuitl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class MyTool {

    /**
     * 获取格式化时间
     * @return
     */
    public static String getDateString(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);
        return dateString;
    }

    /**
     * 判断是否不为null
     */
    public static boolean isNotNull(String str){
        boolean isNotNull=false;
        if(null != str &&!"".equals(str)){
            isNotNull=true;
        }
        return isNotNull;
    }


}
