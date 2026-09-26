/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.pos.service;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * POS班次结束时对钱箱差异进行分级处置、双人复核和证据归档。
 *
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Service
public class CashDrawerVarianceGovernanceService {
    /** 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。 */
    public Assessment assess(Request request) {
        List<String> blockers = new ArrayList<>();
        List<String> actions = new ArrayList<>();
        BigDecimal variance = request.countedCash().subtract(request.expectedCash());
        BigDecimal absoluteVariance = variance.abs();
        if (!request.shiftClosed()) blockers.add("班次尚未执行收银结束与交易截止");
        if (!request.cashMovementsReconciled()) blockers.add("备用金、投库和临时取现记录未对账");
        if (absoluteVariance.compareTo(request.blockingThreshold()) >= 0 && !request.supervisorApproved()) {
            blockers.add("重大钱箱差异未获门店负责人批准");
        }
        if (absoluteVariance.compareTo(request.tolerance()) > 0) {
            if (!request.cashierExplanationRecorded()) actions.add("收银员填写差异原因与交易参考");
            if (!request.secondCountCompleted()) actions.add("由非当班人员执行第二次盲盘");
            if (!request.deviceLogsCaptured()) actions.add("保全POS、钱箱和支付终端日志");
        }
        if (!request.auditEvidenceAttached()) actions.add("归档盘点表、复核签字和差异处置证据");
        Decision decision = !blockers.isEmpty() ? Decision.BLOCKED
                : !actions.isEmpty() ? Decision.INVESTIGATE : Decision.CLOSE;
        String severity = absoluteVariance.compareTo(request.blockingThreshold()) >= 0 ? "CRITICAL"
                : absoluteVariance.compareTo(request.tolerance()) > 0 ? "EXCEPTION" : "NORMAL";
        return new Assessment(request.shiftNo(), decision, variance, absoluteVariance, severity,
                List.copyOf(blockers), List.copyOf(actions));
    }

    /** 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。 */
    public record Request(@NotBlank String shiftNo,
                          @NotNull @DecimalMin("0.00") BigDecimal expectedCash,
                          @NotNull @DecimalMin("0.00") BigDecimal countedCash,
                          @NotNull @DecimalMin("0.00") BigDecimal tolerance,
                          @NotNull @DecimalMin("0.01") BigDecimal blockingThreshold,
                          boolean shiftClosed, boolean cashMovementsReconciled,
                          boolean supervisorApproved, boolean cashierExplanationRecorded,
                          boolean secondCountCompleted, boolean deviceLogsCaptured,
                          boolean auditEvidenceAttached) {}

    /** 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。 */
    public record Assessment(String shiftNo, Decision decision, BigDecimal signedVariance,
                             BigDecimal absoluteVariance, String severity,
                             List<String> blockers, List<String> actions) {}

    /** 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。 */
    public enum Decision { CLOSE, INVESTIGATE, BLOCKED }
}
