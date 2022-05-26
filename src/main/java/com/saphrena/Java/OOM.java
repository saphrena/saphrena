package com.saphrena.Java;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author saphrena
 * @description 功能描述
 * @create 2022/5/26 026 22:09
 */


public class OOM {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i <1000000; i++){
            String str = "";
            for(int j = 0; j < 1000; j++){
                str += UUID.randomUUID().toString();
            }
            list.add(str);
        }
        System.out.println("OK");
    }
}