/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.pos.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Entity
@Table(name = "pos_order")
public class PosOrder extends BaseEntity {
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public enum Status { PAID, REFUNDED, PARTIAL_REFUND, VOIDED }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public enum PaymentMethod { WECHAT, ALIPAY, CASH, BANK_CARD, MIXED }
    @Column(nullable = false, unique = true, length = 32) private String orderNo;
    @Column(nullable = false, length = 80) private String storeName;
    @Column(nullable = false, length = 24) private String registerNo;
    @Column(nullable = false, length = 40) private String cashierName;
    @Column(length = 50) private String memberName;
    @Enumerated(EnumType.STRING) @Column(nullable = false, length = 20) private PaymentMethod paymentMethod;
    @Enumerated(EnumType.STRING) @Column(nullable = false, length = 20) private Status status;
    @Column(nullable = false, precision = 14, scale = 2) private BigDecimal subtotal;
    @Column(nullable = false, precision = 14, scale = 2) private BigDecimal discount;
    @Column(nullable = false, precision = 14, scale = 2) private BigDecimal payable;
    @Column(nullable = false, precision = 14, scale = 2) private BigDecimal paid;
    @Column(nullable = false) private int itemCount;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    protected PosOrder() {}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public PosOrder(String orderNo, String storeName, String registerNo, String cashierName, String memberName,
                    PaymentMethod paymentMethod, Status status, BigDecimal subtotal, BigDecimal discount,
                    BigDecimal payable, BigDecimal paid, int itemCount) {
        this.orderNo = orderNo; this.storeName = storeName; this.registerNo = registerNo;
        this.cashierName = cashierName; this.memberName = memberName; this.paymentMethod = paymentMethod;
        this.status = status; this.subtotal = subtotal; this.discount = discount;
        this.payable = payable; this.paid = paid; this.itemCount = itemCount;
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getOrderNo() { return orderNo; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getStoreName() { return storeName; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getRegisterNo() { return registerNo; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getCashierName() { return cashierName; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getMemberName() { return memberName; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public PaymentMethod getPaymentMethod() { return paymentMethod; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public Status getStatus() { return status; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public BigDecimal getSubtotal() { return subtotal; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public BigDecimal getDiscount() { return discount; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public BigDecimal getPayable() { return payable; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public BigDecimal getPaid() { return paid; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public int getItemCount() { return itemCount; }
}
