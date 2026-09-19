/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.pos.controller;

import cn.zhuatech.pos.common.ApiResponse;
import cn.zhuatech.pos.service.RefundRiskService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController
@RequestMapping("/api/pos/insights")
public class RefundRiskController {
    private final RefundRiskService service;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public RefundRiskController(RefundRiskService service) { this.service = service; }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping("/refund-risk")
    public ApiResponse<RefundRiskService.Result> assess(@Valid @RequestBody RefundRiskService.Request request) {
        return ApiResponse.ok(service.assess(request));
    }
}
