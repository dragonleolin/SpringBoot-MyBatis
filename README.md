# SpringBoot-MyBatis

### 1. 建置SpringBoot專案
### 2. 在POM檔加入需要用的套件
  ![image](https://user-images.githubusercontent.com/42775462/174925037-ba659af9-76e2-46e9-a0db-bab7ddfe2711.png)
## 3. 撰寫application.yml檔
    ```
    spring:
    datasource:
      url: jdbc:mysql://localhost:3306/demo?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8
      username: root
      password: 1234
      driver-class-name: com.mysql.cj.jdbc.Driver
    # 整合Mybatis
    mybatis:
      type-aliases-package: com.example.demo
      # 原來mapper與mapper.xml在同一路徑，現在不在同一路徑需要設定下面的引數，目的就是告訴*.xml檔案的路徑
      mapper-locations: classpath*:mapper/*.xml
      configuration:   #指定mybatis全域性組態檔中的相關設定項
       map-underscore-to-camel-case: true
    ```
## 4. 資料夾結構如下
  ![image](https://user-images.githubusercontent.com/42775462/174925627-a30159f6-6659-4be5-972b-21c0dc6fd178.png)
 
### 5. 製作POJO，還有使用getter跟setter方法
  ![image](https://user-images.githubusercontent.com/42775462/174926266-3d24da25-427f-4e61-80b9-baad99194afe.png)

## 6. 建立Mapper的介面，放要呼叫的方法名稱
### 要注意要放@Mapper(這個註解表示了這個類是一個mybatis的mapper介面類)跟@Repository的Annotation
  ![image](https://user-images.githubusercontent.com/42775462/174926640-0706585f-24e1-4430-9233-841f6da91d4f.png)

## 7. 在resource內建造mapper資料夾，放mapper的xml檔
### 建立ProductMapper.xml，要注意namespace="com.example.demo.mapper.ProductMapper"是否有指向mapper的方法介面，可以使用MyBatis的tag
  ![image](https://user-images.githubusercontent.com/42775462/174927057-9e00c8d8-648f-41d6-953f-86db68ae6687.png)
## 8. 建立Controller
### 使用ResultAPI的模式，撰寫對應的API，並寫CRUD的功能
  ![image](https://user-images.githubusercontent.com/42775462/174927892-0f0716df-d385-4290-8599-681cea0cf663.png)

  
