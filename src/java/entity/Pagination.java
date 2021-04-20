/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class Pagination {

    private int currentPage;
    private int pageSize;
    private int arraySize;

    public Pagination() {
    }

    public Pagination(int currentPage, int pageSize, int arraySize) {
        this.currentPage = currentPage - 1;
        this.pageSize = pageSize;
        this.arraySize = arraySize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPaginationSize() {
        return arraySize % pageSize != 0 ? arraySize / pageSize + 1 : arraySize / pageSize;
    }

    public int getStartIndex() {
        return currentPage * pageSize+1;
    }

    public int getEndIndex() {
        return currentPage * pageSize + pageSize ;
    }
}
