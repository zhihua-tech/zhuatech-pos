/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.pos.service;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

/** 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。 */
class CashDrawerVarianceGovernanceServiceTest {
    private final CashDrawerVarianceGovernanceService service = new CashDrawerVarianceGovernanceService();

    /** 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。 */
    @Test
    void closesVarianceWithinTolerance() {
        var result = service.assess(request("1000", "1003", true, true));
        assertThat(result.decision()).isEqualTo(CashDrawerVarianceGovernanceService.Decision.CLOSE);
        assertThat(result.severity()).isEqualTo("NORMAL");
    }

    /** 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。 */
    @Test
    void investigatesUnexplainedVariance() {
        var result = service.assess(request("1000", "960", true, false));
        assertThat(result.decision()).isEqualTo(CashDrawerVarianceGovernanceService.Decision.INVESTIGATE);
        assertThat(result.signedVariance()).isEqualByComparingTo("-40");
        assertThat(result.actions()).hasSize(4);
    }

    /** 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。 */
    @Test
    void blocksCriticalVarianceWithoutApproval() {
        var result = service.assess(request("1000", "700", false, false));
        assertThat(result.decision()).isEqualTo(CashDrawerVarianceGovernanceService.Decision.BLOCKED);
        assertThat(result.severity()).isEqualTo("CRITICAL");
    }

    private CashDrawerVarianceGovernanceService.Request request(String expected, String counted,
                                                                 boolean supervisor,
                                                                 boolean prepared) {
        return new CashDrawerVarianceGovernanceService.Request("SHIFT-100",
                new BigDecimal(expected), new BigDecimal(counted), new BigDecimal("5"),
                new BigDecimal("200"), true, true, supervisor, prepared, prepared, prepared, prepared);
    }
}
