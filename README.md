## springboot-mult-modular-integration
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
#### 实体类、Example类、Mapper类的生成
框架中集成了MyBatis Generator，可通过MyBatis Generator来生成。

---

### 控制层说明
#### 控制层基类
BaseController: 位于com.codes.api
#### 编写控制层
- 所有Controller类都应该继承BaseController，以获取全局处理
- Controller无需手动捕获异常，异常将进行全局捕获（将根据接口类型返回错误页面或异常JSON对象）

---


### 视图层说明
#### thymeleaf
- 页面全部存放于src/main/resources/templates目录下，其中位于templates/common/head.html为通用html，在这里处理了上下文路径等。
- 静态资源存放于src/main/resources/static目录下
#### jsp
- 页面全部存放于src/main/webapp/WEB-INF/pages目录下，其中位于pages/common/head.jsp为通用jsp，在这里处理了上下文路径等。
- 静态资源存放于src/main/webapp/static目录下

---

### 环境分离
不建议使用Maven profile和springboot提供的spring.profiles.active来处理环境分离，这样会暴露生产环境配置信息（如数据库地址，加密密钥等）。生产环境配置应该单独编写并放在打包好的jar包同级目录下。如下：
```
|- 目录
 |-- myproject.jar
 |-- application.properties
```

---

### 切换环境
修改application.properties下的project.env即可，取值为production和development，同时这也是logback appender的名称，环境切换后将自动采用对应的appender。如需增加环境配置，只需要添加对应的logback appender即可。

---

### 单元测试
#### 单元测试基类 
BaseTest：位于codegen-server下的test目录下的com.codes.service包
#### 编写单元测试
编写单元测试类，继承BaseTest即可，测试结果通过BaseTest基类中的print成员方法输出。

---

### 全局异常处理
通过BaseController的exceptionHandle方法捕获全局异常，当访问一个页面接口出错时，将自动跳转至错误页面，当访问一个数据处理接口出错时，将自动返回异常JSON对象。

---

### 日志说明
日志采用springboot推荐的logback框架，对应src/main/resources/logback.xml配置文件。拥有两个Appender，分别是development（日志输出到控制台）和production（日志输出将产生文件并存放至log目录下）。Appender跟随项目环境自动切换。

---

### 404处理
#### thymeleaf
当访问不存在的地址时，默认返回src/main/resources/templates/error/404.html
#### jsp
当访问不存在的地址时，默认返回src/main/webapp/WEB-INF/pages/error/404.jsp

---

### JSON日期格式处理
当接口返回JSON时，默认日期格式为yyyy-MM-dd HH:mm:ss

---


### Swagger的启用和禁用
在application.yml中修改swagger.disabled即可，true表示启用Swagger，false表示禁用Swagger。在项目启动后可查看Swagger的状态。

---

### 注意
由于在多模块工程中，直接运行不能访问jsp页面。
解决办法 codegen-api模块下pom.xml添加下面代码即可
```xml
<build>
  <resources>
    <!-- 打包时将jsp文件拷贝到META-INF目录下-->
    <resource>
      <!-- 指定resources插件处理哪个目录下的资源文件 -->
      <directory>src/main/webapp</directory>
      <!-- 注意必须要放在此目录下才能被访问到-->
      <targetPath>META-INF/resources</targetPath>
    </resource>
  </resources>
</build>
```

