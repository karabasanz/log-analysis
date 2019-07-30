package com.gizemgozde.loganalysis.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author gizem
 */
public class Log implements Serializable {

    private Integer count;

    private String timestamp;

    private LogLevel level;

    private ServerCity cityname;

    private String detail;

    public Log() {
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public LogLevel getLevel() {
        return level;
    }

    public void setLevel(LogLevel level) {
        this.level = level;
    }

    public ServerCity getCityname() {
        return cityname;
    }

    public void setCityname(ServerCity cityname) {
        this.cityname = cityname;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return count + " "+
            timestamp +
            " " + level +
            " " + cityname.toString().toUpperCase() +
            " " + detail ;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
