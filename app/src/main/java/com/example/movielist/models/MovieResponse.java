package com.example.movielist.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResponse {

    @SerializedName("page")
    @Expose
    private Integer page;

    @SerializedName("total_result")
    @Expose
    private Integer totalResult;

    @SerializedName("total_page")
    @Expose
    private Integer totalPage;

    @SerializedName("results")
    @Expose
    private List<Result> results = null;

    public MovieResponse(){}

    public MovieResponse(Integer page, Integer totalResult, Integer totalPage, List<Result> results) {
        this.page = page;
        this.totalResult = totalResult;
        this.totalPage = totalPage;
        this.results = results;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(Integer totalResult) {
        this.totalResult = totalResult;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
