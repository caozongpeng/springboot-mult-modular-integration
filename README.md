### springboot-mult-modular-integration
基于springboot多模块项目整合常用技术，有mybatis、thymeleaf、swagger、jsp、lombok等
* 持久层：MyBatis
* 视图层：无（接口返回JSON）、JSP、thymeleaf
* Swagger: swagger-ui、swagger-bootstrap-ui
* 单元测试：Junit
* 日志: Logback
* 配置文件：Properties、YAML
* 其他：lombok







### Swagger的启用和禁用
在application.yml中修改swagger.disabled即可，true表示启用Swagger，false表示禁用Swagger。在项目启动后可查看Swagger的状态。