# Private-Cloud-Common

Common component for my private cloud back-end services.

# Project Structure

aspect 切面注解 
├── filter 过滤器 
├── handler 处理器（异常处理器、 
└── validator 校验器 
constant 常量 
enums 枚举类 
model 实体类 
└── web Web 专用实体
util 工具类

# Commit Specification

| Prefix      | Description         | Comment                     |
|-------------|---------------------|-----------------------------|
| build       | 对项目构建或者依赖的改动        | 比如新增了某个构建步骤                 |
| chore       | 其他修改, 比如构建流程, 依赖管理  | maven依赖、package.json 版本调整等  |
| ci          | CI 的修改              |                             |
| docs        | 文档修改                | 注释、README、TODO 的更改          |
| feat        | 新特性                 | 新增某个类、某个组件，或某个类、某个组件中新增某项功能 |
| fix         | 修改问题                |                             |
| pref        | 性能优化                |                             |
| refactor    | 代码重构                | 对某个类、某个组件的重构                |
| revert      | revert 前一个 commit   |                             |
| release     | 发布                  |                             |
| style       | 代码格式修改, 注意不是 css 修改 | 缩进、变量名称等的更改                 |
| test        | 测试用例修改              |                             |
| improvement | 代码改进（无性能提升）         |                             |