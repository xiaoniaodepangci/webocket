package com.him.woll.singleservershiro.shiro.kit;

import org.apache.shiro.crypto.hash.Md5Hash;


public class ShiroKit {
    //定义加密算法，可以自己定义
    public static String md5(String password, String salt) {
        String p = null;
        salt = "hjajsfhjkasd";
        //hashlterations为散列算法几次
        p = new Md5Hash(password, salt, 2).toHex();
        return p;
    }

    public static void main(String[] args) {
        String s = md5("123456", "");
        System.out.println(s);
    }
}
