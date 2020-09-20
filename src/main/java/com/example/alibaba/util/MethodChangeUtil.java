package com.example.alibaba.util;

import org.apache.commons.lang3.StringUtils;

public class MethodChangeUtil {


    public static String change(String field) {
        String temp = "";
        if (StringUtils.isNotBlank(field)) {
            temp = Constant.METHOD_PREFIX
                    + field.substring(Constant.NUMBER_ZERO, Constant.NUMBER_ONE).toUpperCase()
                    + field.substring(Constant.NUMBER_ONE)
                    + Constant.METHOD_CLOSE;
        }
        return temp;
    }


}
