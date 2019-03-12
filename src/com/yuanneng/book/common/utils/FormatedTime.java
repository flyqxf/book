package com.yuanneng.book.common.utils;

public enum FormatedTime {
    // 8位年月日
    YYYYMMDD("yyyyMMdd"),
    // 带横杠的8位年月日
    HYPHEN_YYYYMMDD("yyyy-MM-dd"),
    // 带斜线的8位年月日
    SLASH_YYYYMMDD("yyyy/MM/dd"),
    // 带斜线的8位年月日+时分
    SLASH_YYYYMMDD_HHMM("yyyy/MM/dd HH:mm"),
    // 带横杠的8位年月日加时分秒
    HYPHEN_YYYYMMDD_HHMMSS("yyyy-MM-dd HH:mm:ss"),
    // 带横杠的8位年月日加时分秒毫秒
    HYPHEN_YYYYMMDD_HHMMSS_SSS("yyyy-MM-dd HH:mm:ss.SSS");

    /**
     * @return formatStr 日期时间格式
     */
    private String formatStr;

    /**
     * @return formatStr 日期时间格式
     */
    private FormatedTime(String formatStr) {
        this.formatStr = formatStr;
    }

    /**
     * @return formatStr 日期时间格式
     */
    public String getFormatStr() {
        return formatStr;
    }

    /**
     * @param formatStr 日期时间格式
     */
    public void setFormatStr(String formatStr) {
        this.formatStr = formatStr;
    }
}
