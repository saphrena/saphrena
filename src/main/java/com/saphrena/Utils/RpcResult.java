package com.saphrena.Utils;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * @author 热河
 * @created 2022/6/16 14:38
 * @project saphrena
 * @Description
 */
public class RpcResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String SUCCESS = "200";
    public static final String INVALID_PARAMS = "400";
    public static final String FAIL = "500";
    public static final String BUSINESS_ERROR = "600";
    private String message = "";
    private String code = "200";
    private T data;
    private Long pageNo;
    private Long pageSize;
    private Long totalCount;
    private Long totalPage;

    public RpcResult() {
    }

    public RpcResult<T> data(T data) {
        this.data = data;
        return this;
    }

    public RpcResult<T> msg(String message) {
        this.message = message;
        return this;
    }

    public RpcResult<T> code(String code) {
        this.code = code;
        return this;
    }

    public RpcResult<T> success() {
        return this.success("200");
    }

    public RpcResult<T> success(String code) {
        this.code = code;
        return this;
    }

    public RpcResult<T> success(String message, T data) {
        return this.success("200", message, data);
    }

    public RpcResult<T> success(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        return this;
    }

    public RpcResult<T> fail() {
        return this.fail("500");
    }

    public RpcResult<T> fail(String code) {
        this.code = code;
        return this;
    }

    public RpcResult<T> fail(String message, T data) {
        return this.fail("500", message, data);
    }

    public RpcResult<T> fail(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        return this;
    }

    public boolean isSuccess() {
        return "200".equals(this.getCode());
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Long getTotalCount() {
        return this.totalCount;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getPageNo() {
        return this.pageNo;
    }

    public void setPageNo(Long pageNo) {
        this.pageNo = pageNo;
    }

    public Long getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotalPage() {
        return this.totalPage;
    }

    public void setTotalPage(Long totalPage) {
        this.totalPage = totalPage;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
