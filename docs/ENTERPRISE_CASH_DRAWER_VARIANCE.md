# 钱箱差异治理

`POST /api/enterprise/pos/cash-drawer-variance` 将班次现金差异按容差和重大阈值分级处置。

- 计算签名差异和绝对差异，返回 `NORMAL / EXCEPTION / CRITICAL` 级别。
- 强制核对备用金、投库、临时取现和班次截止状态。
- 超容差时生成收银员说明、双人盲盘、设备日志与证据归档动作。

业务决策为 `CLOSE / INVESTIGATE / BLOCKED`。
