package com.him.woll.singleservershiro.shiro.kit;

import org.apache.shiro.crypto.hash.Md5Hash;


public class ShiroKit {
    //定义加密算法，可以自己定义
    public static String md5(String password, String salt) {
        String p = null;
        //hashlterations为散列算法几次
        p = new Md5Hash(password, salt, 2).toHex();
        return p;
    }
}
