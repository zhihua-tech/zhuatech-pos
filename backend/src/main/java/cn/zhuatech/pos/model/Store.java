/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.pos.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Entity
@Table(name = "pos_store")
public class Store extends BaseEntity {
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public enum Status { OPEN, PREPARING, CLOSED }
    @Column(nullable = false, unique = true, length = 24) private String storeCode;
    @Column(nullable = false, length = 80) private String name;
    @Column(nullable = false, length = 40) private String city;
    @Column(nullable = false, length = 120) private String address;
    @Enumerated(EnumType.STRING) @Column(nullable = false, length = 16) private Status status;
    @Column(nullable = false) private int registerCount;
    @Column(nullable = false, precision = 14, scale = 2) private BigDecimal todaySales;
    @Column(nullable = false) private int todayOrders;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    protected Store() {}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public Store(String storeCode, String name, String city, String address, Status status,
                 int registerCount, BigDecimal todaySales, int todayOrders) {
        this.storeCode = storeCode; this.name = name; this.city = city; this.address = address;
        this.status = status; this.registerCount = registerCount; this.todaySales = todaySales; this.todayOrders = todayOrders;
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getStoreCode() { return storeCode; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getName() { return name; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getCity() { return city; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getAddress() { return address; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public Status getStatus() { return status; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public int getRegisterCount() { return registerCount; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public BigDecimal getTodaySales() { return todaySales; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public int getTodayOrders() { return todayOrders; }
}
