/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.pos.repository;
import cn.zhuatech.pos.model.CashierShift;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
public interface CashierShiftRepository extends JpaRepository<CashierShift, Long> {
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    Optional<CashierShift> findFirstByCashierNameAndStatusOrderByOpenedAtDesc(String cashierName, CashierShift.Status status);
}
