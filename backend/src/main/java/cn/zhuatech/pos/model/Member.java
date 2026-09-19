/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.pos.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Entity
@Table(name = "pos_member")
public class Member extends BaseEntity {
    @Column(nullable = false, unique = true, length = 24) private String memberNo;
    @Column(nullable = false, length = 50) private String name;
    @Column(nullable = false, unique = true, length = 20) private String mobile;
    @Column(nullable = false, length = 20) private String level;
    @Column(nullable = false) private int points;
    @Column(nullable = false, precision = 12, scale = 2) private BigDecimal balance;
    @Column(nullable = false, precision = 14, scale = 2) private BigDecimal totalSpend;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    protected Member() {}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public Member(String memberNo, String name, String mobile, String level, int points, BigDecimal balance, BigDecimal totalSpend) {
        this.memberNo = memberNo; this.name = name; this.mobile = mobile; this.level = level;
        this.points = points; this.balance = balance; this.totalSpend = totalSpend;
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getMemberNo() { return memberNo; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getName() { return name; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getMobile() { return mobile; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getLevel() { return level; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public int getPoints() { return points; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public BigDecimal getBalance() { return balance; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public BigDecimal getTotalSpend() { return totalSpend; }
}
