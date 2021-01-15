package com.him.woll.singleserver;

/**
 * @author huangc
 * @version 1.0
 * @date 21/01/15 09:03
 */
public class S2 extends P1 {
    private String s2Name;

    public String getS2Name() {
        return s2Name;
    }

    public void setS2Name(String s2Name) {
        this.s2Name = s2Name;
    }

    @Override
    public String toString() {
        return "S2{" +
                "s2Name='" + s2Name + '\'' +
                ", p1pro='" + p1pro + '\'' +
                '}';
    }
}
