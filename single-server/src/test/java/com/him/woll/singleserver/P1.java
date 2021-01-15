package com.him.woll.singleserver;

/**
 * @author huangc
 * @version 1.0
 * @date 21/01/15 09:02
 */
public class P1 {

    private String p1name;

    protected String p1pro;

    public String getP1name() {
        return p1name;
    }

    public void setP1name(String p1name) {
        this.p1name = p1name;
    }

    public String getP1pro() {
        return p1pro;
    }

    public void setP1pro(String p1pro) {
        this.p1pro = p1pro;
    }

    @Override
    public String toString() {
        return "P1{" +
                "p1name='" + p1name + '\'' +
                ", p1pro='" + p1pro + '\'' +
                '}';
    }
}
