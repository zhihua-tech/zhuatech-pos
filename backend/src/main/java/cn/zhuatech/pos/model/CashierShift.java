/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.pos.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Entity
@Table(name = "pos_cashier_shift")
public class CashierShift extends BaseEntity {
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public enum Status { OPEN, CLOSED }
    @Column(nullable = false, unique = true, length = 32) private String shiftNo;
    @Column(nullable = false, length = 80) private String storeName;
    @Column(nullable = false, length = 24) private String registerNo;
    @Column(nullable = false, length = 40) private String cashierName;
    @Enumerated(EnumType.STRING) @Column(nullable = false, length = 12) private Status status;
    @Column(nullable = false) private LocalDateTime openedAt;
    private LocalDateTime closedAt;
    @Column(nullable = false, precision = 12, scale = 2) private BigDecimal openingCash;
    @Column(nullable = false, precision = 12, scale = 2) private BigDecimal expectedCash;
    @Column(nullable = false) private int orderCount;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    protected CashierShift() {}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public CashierShift(String shiftNo, String storeName, String registerNo, String cashierName, Status status,
                        LocalDateTime openedAt, BigDecimal openingCash, BigDecimal expectedCash, int orderCount) {
        this.shiftNo = shiftNo; this.storeName = storeName; this.registerNo = registerNo;
        this.cashierName = cashierName; this.status = status; this.openedAt = openedAt;
        this.openingCash = openingCash; this.expectedCash = expectedCash; this.orderCount = orderCount;
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getShiftNo() { return shiftNo; }
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
    public Status getStatus() { return status; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public LocalDateTime getOpenedAt() { return openedAt; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public LocalDateTime getClosedAt() { return closedAt; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public BigDecimal getOpeningCash() { return openingCash; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public BigDecimal getExpectedCash() { return expectedCash; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public int getOrderCount() { return orderCount; }
}
