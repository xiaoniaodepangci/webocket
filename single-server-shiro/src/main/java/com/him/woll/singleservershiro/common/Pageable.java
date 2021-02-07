package com.him.woll.singleservershiro.common;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 分页工具
 *
 * @author huangc
 * @version 1.0
 * @date 21/02/07 11:03
 */
public class Pageable {

    /**
     * 分页大小
     */
    private Integer pageSize;
    /**
     * 当前分页
     */
    private Integer currPage;


    public Pageable(Integer pageSize, Integer currPage) {
        this.pageSize = pageSize;
        this.currPage = currPage;

    }


    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrPage() {
        return currPage;
    }

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }


}
