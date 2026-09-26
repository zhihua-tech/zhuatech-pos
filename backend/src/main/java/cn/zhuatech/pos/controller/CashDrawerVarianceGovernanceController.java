/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.pos.controller;

import cn.zhuatech.pos.common.ApiResponse;
import cn.zhuatech.pos.service.CashDrawerVarianceGovernanceService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。 */
@RestController
@RequestMapping("/api/enterprise/pos")
public class CashDrawerVarianceGovernanceController {
    private final CashDrawerVarianceGovernanceService service;

    /** 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。 */
    public CashDrawerVarianceGovernanceController(CashDrawerVarianceGovernanceService service) {
        this.service = service;
    }

    /** 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。 */
    @PostMapping("/cash-drawer-variance")
    public ApiResponse<CashDrawerVarianceGovernanceService.Assessment> assess(
            @Valid @RequestBody CashDrawerVarianceGovernanceService.Request request) {
        return ApiResponse.ok("钱箱差异评估完成", service.assess(request));
    }
}
