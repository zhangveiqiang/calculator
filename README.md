# calculator
## 启动
 - 运行 org.zwq.Calculator 类
## 支持命令
 - cc: 清空所有操作
 - redo: 前滚
 - undo: 回滚
 - esc: 退出
## 支持操作符
 - \+
 - \-
 - \*
 - \/
## 支持实现更多操作符
 - 继承 org.zwq.command.Command 或者 org.zwq.command.NumberCommand
 - 在枚举 org.zwq.enums.Expression 中配置好对应操作符