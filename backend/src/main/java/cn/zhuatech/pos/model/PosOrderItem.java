/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.pos.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Entity
@Table(name = "pos_order_item")
public class PosOrderItem extends BaseEntity {
    @Column(nullable = false, length = 32) private String orderNo;
    @Column(nullable = false, length = 40) private String sku;
    @Column(nullable = false, length = 120) private String productName;
    @Column(nullable = false, precision = 12, scale = 2) private BigDecimal unitPrice;
    @Column(nullable = false) private int quantity;
    @Column(nullable = false, precision = 14, scale = 2) private BigDecimal lineAmount;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    protected PosOrderItem() {}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public PosOrderItem(String orderNo, String sku, String productName, BigDecimal unitPrice, int quantity, BigDecimal lineAmount) {
        this.orderNo = orderNo; this.sku = sku; this.productName = productName;
        this.unitPrice = unitPrice; this.quantity = quantity; this.lineAmount = lineAmount;
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getOrderNo() { return orderNo; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getSku() { return sku; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getProductName() { return productName; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public BigDecimal getUnitPrice() { return unitPrice; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public int getQuantity() { return quantity; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public BigDecimal getLineAmount() { return lineAmount; }
}
