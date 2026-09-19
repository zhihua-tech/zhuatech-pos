/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.pos.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Entity
@Table(name = "pos_product")
public class Product extends BaseEntity {
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public enum Status { ACTIVE, LOW_STOCK, OFF_SHELF }
    @Column(nullable = false, unique = true, length = 40) private String sku;
    @Column(nullable = false, unique = true, length = 40) private String barcode;
    @Column(nullable = false, length = 120) private String name;
    @Column(nullable = false, length = 40) private String category;
    @Column(nullable = false, precision = 12, scale = 2) private BigDecimal price;
    @Column(nullable = false, precision = 12, scale = 2) private BigDecimal memberPrice;
    @Column(nullable = false) private int stock;
    @Enumerated(EnumType.STRING) @Column(nullable = false, length = 20) private Status status;
    @Column(nullable = false, length = 20) private String colorCode;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    protected Product() {}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public Product(String sku, String barcode, String name, String category, BigDecimal price,
                   BigDecimal memberPrice, int stock, Status status, String colorCode) {
        this.sku = sku; this.barcode = barcode; this.name = name; this.category = category;
        this.price = price; this.memberPrice = memberPrice; this.stock = stock;
        this.status = status; this.colorCode = colorCode;
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public void reduceStock(int quantity) {
        if (quantity < 1 || stock < quantity) throw new IllegalArgumentException("库存不足");
        stock -= quantity;
        if (stock < 10) status = Status.LOW_STOCK;
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getSku() { return sku; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getBarcode() { return barcode; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getName() { return name; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getCategory() { return category; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public BigDecimal getPrice() { return price; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public BigDecimal getMemberPrice() { return memberPrice; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public int getStock() { return stock; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public Status getStatus() { return status; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getColorCode() { return colorCode; }
}
