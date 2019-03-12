/*
 * @(#)BookBean.java
 */
package com.yuanneng.book.prerson.entity;
import com.yuanneng.book.common.entity.CommonBean;

/**
 * UserBean.java
 * 
 * 功 能： 用户信息bean
 * 
 * <pre>
 * ver      修订日              作者            修订内容
 * -----------------------------------------------------
 * 1.0     2016.08.21         guot        新规做成
 * </pre>
 */
public class CountBean extends CommonBean {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    private String year=null;
    private String count="0";
    private String count_zhi="0";
    private String count_jian="0";
    private String flg=null;
    
    /**
     * @return the year
     */
    public String getYear() {
        return year;
    }
    
    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        this.year = year;
    }
    
    
    
    /**
     * @return the count
     */
    public String getCount() {
        return count;
    }

    
    /**
     * @param count the count to set
     */
    public void setCount(String count) {
        this.count = count;
    }

    /**
     * @return the count_zhi
     */
    public String getCount_zhi() {
        return count_zhi;
    }

    
    /**
     * @param count_zhi the count_zhi to set
     */
    public void setCount_zhi(String count_zhi) {
        this.count_zhi = count_zhi;
    }

    
    /**
     * @return the count_jian
     */
    public String getCount_jian() {
        return count_jian;
    }

    
    /**
     * @param count_jian the count_jian to set
     */
    public void setCount_jian(String count_jian) {
        this.count_jian = count_jian;
    }

    
    /**
     * @return the flg
     */
    public String getFlg() {
        return flg;
    }

    
    /**
     * @param flg the flg to set
     */
    public void setFlg(String flg) {
        this.flg = flg;
    }
    
    
    

}
