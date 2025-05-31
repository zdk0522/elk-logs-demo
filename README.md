# ELK Logs Demo

本项目是一个完整的 ELK（Elasticsearch + Logstash + Kibana）日志收集与可视化展示的 Demo，结合 Java AOP 实现自动化埋点，便于服务端日志分析与监控。

---

## 📌 项目目标

通过本项目，你可以了解如何：

- 使用 AOP 切面自动记录业务操作日志
- 使用 Filebeat 采集本地日志并发送至 Logstash
- 使用 Logstash 过滤日志字段并写入 Elasticsearch
- 使用 Kibana 可视化日志信息
- 解决日志时间与时区不一致问题

---

## 🛠 技术栈

| 技术组件      | 说明                                     |
|---------------|------------------------------------------|
| Java          | 后端语言，核心逻辑编写                   |
| Spring Boot   | 后端框架                                 |
| AOP           | 实现统一日志采集                         |
| Filebeat      | 日志收集工具，负责读取日志文件           |
| Logstash      | 日志处理工具，使用 grok+date 进行字段提取 |
| Elasticsearch | 日志存储                                 |
| Kibana        | 可视化工具                               |
| Docker        | 全部组件使用 Docker 进行容器化部署       |

---

## 🔧 项目结构说明

```bash
elk-logs-demo/
├── docker-compose.yml         # 一键启动 ELK 的 Docker 配置
├── .env                       # 设置环境变量（ES、Kibana、Logstash 等）
├── filebeat.yml               # Filebeat 配置文件
├── logstash.conf              # Logstash pipeline 配置
├── logs/
│   └── application.log        # AOP 输出的日志文件
├── src/
│   └── ...                    # Java Spring Boot 项目源代码（含 AOP 切面）
├── logback-spring.xml         # Logback 日志格式定义
└── README.md                  # 项目说明文档（当前文件）
