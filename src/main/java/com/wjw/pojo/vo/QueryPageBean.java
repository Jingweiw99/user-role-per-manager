package com.wjw.pojo.vo;

import java.util.Map;

/*
前端提交currentPage， pageSize进行分页查询
后续加上查询条件
 */
public class QueryPageBean {
    private Integer currentPage; // 当前页码
    private Integer pageSize;   //每页记录数
    private Map queryParams;    //查询条件
    private Integer offset; // 分页查询，开始记录下标


    public Integer getOffset() {
        this.offset = (this.currentPage - 1) * this.pageSize;
        return offset;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Map getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(Map queryParams) {
        this.queryParams = queryParams;
    }


}
