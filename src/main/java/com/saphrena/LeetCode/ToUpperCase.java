package com.saphrena.LeetCode;

import java.util.ArrayList;

/**
 * @author 热河
 * @created 2022/6/21 20:34
 * @project saphrena
 * @Description 首字母换大写
 */
public class ToUpperCase {
    public String resolve(String str){
        return str.replaceFirst(str.substring(0,1),str.substring(0,1).toUpperCase());
    }

    public String resolve1(String str){
        // 进行字母的ascii编码前移，效率要高于截取字符串进行转换的操作
        char[] chars = str.toCharArray();
        chars[0] -= 32;
        return String.valueOf(chars);
    }

    public String resolve2(String str){
        return str.substring(0,1).toUpperCase() + str.substring(1);
    }

    public String resolve3(String str){
        String[] split = str.split(" ");
        String newsStr = "";
        for (int i = 0; i < split.length; i++) {
            String sub = split[i].substring(0, 1);
            String change = split[i].replaceFirst(split[i].substring(0,1), sub.toUpperCase());
             newsStr += change + " ";
        }
        return newsStr;
    }


    public static void main(String[] args) {
        String str = "saphrena";
        String str1 = "saphrena is handsome";
        String result = new ToUpperCase().resolve(str);
        String result1 = new ToUpperCase().resolve1(str);
        String result2 = new ToUpperCase().resolve2(str);
        String result3 = new ToUpperCase().resolve3(str1);
        System.out.println(result);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);

    }
}
