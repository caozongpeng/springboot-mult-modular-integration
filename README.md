### springboot-mult-modular-integration
基于springboot多模块项目整合常用技术，有mybatis、thymeleaf、swagger、jsp、lombok等
* 持久层：MyBatis
* 视图层：无（接口返回JSON）、JSP、thymeleaf
* Swagger: swagger-ui、swagger-bootstrap-ui
* 单元测试：Junit
* 日志: Logback
* 配置文件：Properties、YAML
* 其他：lombok
---

### 模块说明
- codegen-core：存放核心类，如常量类，工具类，异常类，全局实体类等(核心类库，不依赖其它模块)
- codegen-dao：存放持久层类(依赖于core模块)
- codegen-service：存放业务类(依赖于dao模块)
- codegen-api: 存放API(依赖于 service 模块)
---

### 配置说明
所有配置文件全部位于src/main/resources目录下
- application.properties || application.yml：项目全局配置文件
- logback.xml：logback配置
- templates：存放模板文件
- webapp: 存放jsp文件
---

### 持久层说明
##### 实体类、Example类、Mapper类的生成
框架中集成了MyBatis Generator，可通过MyBatis Generator来生成。

---




### Swagger的启用和禁用
在application.yml中修改swagger.disabled即可，true表示启用Swagger，false表示禁用Swagger。在项目启动后可查看Swagger的状态。

---

### 注意
由于在多模块工程中，只能通过 boot-run 或打成 war 包后运行成功才能访问jsp页面，而在 IDEA 内通过main run 或 debug 都不能访问 jsp 资源。
解决办法: 在 IDEA Edit configurations -> Environment 下的 `working directory` 设置为 `$MODULE_WORKING_DIR$` 才行。

