# micro-service

#### 基于springcloud的微服务，采用docker-compose部署

###### 部署相关说明：
* Dockfile内容：
```
FROM java:8  //基于jdk1.8的镜像
VOLUME /tmp  //挂载tmp目录
ADD target/eureka-service-0.0.1-SNAPSHOT.jar micro-service/eureka-service.jar  //复制target下面的jar文件到容器并重命名
ENTRYPOINT ["java","-Djava.securityegd=file:/dev/./urandom","-jar","/micro-service/eureka-service.jar","--spring.profiles.active=docker"]  //jar启动的命令，不可被docker run的参数覆盖
EXPOSE 8000  //暴露8000端口
```
* 创建镜像：
```
docker build -t micro-service/eureka-service .
```
docker build -t [标签名:版本号] [路径]

* 创建容器并运行镜像：
```
docker run --name eureka-service -d -p 8000:8000 micro-service/eureka-service
```
docker run --name [容器名] 后台运行 映射容器8000端口到宿主机8000端口 [镜像名]

----------------------- 华丽的分割线 -----------------------------

* 使用docker-maven-plugin创建镜像：

项目pom.xml文件配置：
```
<plugin>
    <groupId>com.spotify</groupId>
    <artifactId>docker-maven-plugin</artifactId>
    <version>1.0.0</version>
    <executions>
        <!--运行 mvn package 的时候 会先打包jar再构建docker镜像-->
        <execution>
            <id>build-image</id>
            <phase>package</phase>
            <goals>
                <goal>build</goal>
            </goals>
        </execution>
    </executions>
    <configuration>
        <imageName>${project.parent.artifactId}/${project.artifactId}</imageName>
        <dockerDirectory>${project.basedir}</dockerDirectory>
        <resources>
            <resource>
                <targetPath>/</targetPath>
                <directory>${project.build.directory}</directory>
                <include>${project.build.finalName}.jar</include>
            </resource>
        </resources>
    </configuration>
</plugin>
```
* 运行mvn命令打包并创建镜像：
```
mvn clean package
```
* 如果不绑定docker:build到mvn的package命令，运行以下命令创建镜像：
```
mvn clean package docker:build
```
* 使用docker-compose创建并运行容器：

docker-compose.yml内容：
```
version: "3" #compose文件格式版本
services:
  eureka-service: #服务名
    image: micro-service/eureka-service #镜像名
    ports:
      - 8000:8000 #向外部暴露端口
    hostname: eureka-service #定义当前服务的域名
  cat-service:
    image: micro-service/cat-service
    ports:
      - 8081:8081
    hostname: cat-service
    links:
      - eureka-service #链接其它服务中的容器
    depends_on:
      - eureka-service #依赖服务，这将影响各个服务容器的启动顺序
  dog-service:
    image: micro-service/dog-service
    ports:
      - 8082:8082
    links:
      - eureka-service
      - cat-service
    depends_on:
      - eureka-service
```
* 在docker-compose.yml所在目录，运行以下命令：
```
docker-compose up -d
```