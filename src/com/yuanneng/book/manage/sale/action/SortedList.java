package com.yuanneng.book.manage.sale.action;

import com.yuanneng.book.manage.sale.entity.SaleBean;


public class SortedList implements Comparable<SaleBean>{

    private String type="";
    
    public SortedList(String type) {
        this.type = type;
    }

    @Override
    public int compareTo(SaleBean o) {
        
        int perSum_zhijie = o.getPersonSum_zhijie();
        
        return 0;
    }}
