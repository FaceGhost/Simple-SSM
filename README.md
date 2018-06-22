# Simple-SSM
史上最简单的spring+springMVC+mybaits整合SSM框架

### 起因来源于搭建ssm系列教程，为此整理一个最简单CURD的全套源码，高手请勿喷，仅供参考学习，想学习的同学的可以参考下列文章

Master分支含有基于SqlSessionTemplate的baseDao, 如果不习惯使用，可切换分支到V1.0.0 

- [教你一步步搭建ssm框架，第一步实现springmvc下的页面跳转 - 2018](https://faceghost.com/article/664531 "教你一步步搭建ssm框架，第一步实现springmvc下的页面跳转 - 2018")

- [教你一步步搭建ssm框架，第二步集成mybatis实现数据的保存 - 2018](https://faceghost.com/article/794821 "教你一步步搭建ssm框架，第二步集成mybatis实现数据的保存 - 2018")

- [教你一步步搭建ssm框架，第三步数据库事务验证及ssm常见事务不起作用排除 - 2018](https://faceghost.com/article/344851  "教你一步步搭建ssm框架，第三步数据库事务验证及ssm常见事务不起作用排除 - 2018") 

- [教你一步步搭建ssm框架，第四步自动生成mybaits实体类，配置文件 - 2018 ](https://faceghost.com/article/184871  "教你一步步搭建ssm框架，第四步自动生成mybaits实体类，配置文件 - 2018 ") 

- [教你一步步搭建ssm框架，第五步之分页插件pagehelper - 2018](https://faceghost.com/article/284941 "教你一步步搭建ssm框架，第五步之分页插件pagehelper - 2018") 

- [教你一步步搭建ssm框架，第六步之EhCache缓存 - 2018](https://faceghost.com/article/895531 "教你一步步搭建ssm框架，第六步之EhCache缓存 - 2018") 

### 版本

- jdk 1.7

- spring 4.2.4 

- mybatis 3.2.8 

- 开发工具：eclipse

- 数据库：mysql


### 数据库配置文件位置

https://github.com/FaceGhost/Simple-SSM/blob/master/src/main/resources/res.properties


### 数据库表及初始数据位置

https://github.com/FaceGhost/Simple-SSM/tree/master/src/main/resources/db


### 启动

Simple-SSM 项目右键->Debug  As  -> Maven build ...  

Goals ： tomcat7:run 


 
### 浏览器访问

http://localhost:8080/Simple-SSM/test

![image](https://github.com/FaceGhost/Simple-SSM/blob/master/preview_01.png)


#### 关注见鬼网微信公众号，获取有趣文章

![image](https://github.com/FaceGhost/Simple-SSM/blob/master/faceghost_qc.jpg)

