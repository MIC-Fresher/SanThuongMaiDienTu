/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import org.springframework.data.domain.Page;
import entity.*;

public class Pages {

    private int current;
    private int begin;
    private int end;
    private int totalPages;
    private List<?> content;
    private Page<?> origPages;

    public Pages(Page<?> pages) {
        this.origPages = pages;
        content = pages.getContent();
        current = pages.getNumber() + 1;
        begin = Math.max(1, current - 2);
        end = Math.min(begin + 10, pages.getTotalPages());
        totalPages = pages.getTotalPages();
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<?> getContent() {
        return content;
    }

    public void setContent(List<?> content) {
        this.content = content;
    }

    public Page<?> getOrigPages() {
        return origPages;
    }

    public void setOrigPages(Page<?> origPages) {
        this.origPages = origPages;
    }

    

}
