#### `import org.springframework.test.context.ContextConfiguration;`

##### => `The import org.springframework.test cannot be resolved`

- [`jar` 파일 다운로드](https://jar-download.com/artifacts/org.springframework/spring-test)

- 해당경로 **`C:\Users\student\.m2\repository\org\springframework\org.springframework.test\3.1.1.RELEASE`**에 `jar` 추가

- `pom.xml`

  ```xml
  <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>org.springframework.test</artifactId>
      <version>3.1.1.RELEASE</version>
      <scope>test</scope>
  </dependency>
  ```

- `maven` -> `update project`

  

##### `pom.xml` 에러남

##### => `Missing artifact org.springframework:org.springframework.test:jar:3.1.1.RELEASE`

- `user/.m2/repository` 삭제
- eclipse spring 재실행
- 처음 에러로 돌아옴...ㅎ,.ㅎ
- `@test`사용하지 않고 `ApplicationContext` 사용하기로



#



#### SpringDAO로 데이터베이스 연결하고자할 때

```xml
<!-- Spring Data Source Bean -->
<bean id="dataSource"
      class="org.springframework.jdbc.datasource.DriverManagerDataSource"
      p:driverClassName="oracle.jdbc.OracleDriver" 
      p:url="jdbc:oracle:thin:@127.0.0.1:1521:orcl"
      p:username="scott" p:password="oracle" />

<bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
    <constructor-arg>
        <ref bean="dataSource" />
    </constructor-arg>
</bean>
```

- `namespace`에서 `jee`와 `p`를 추가하자



#



#### 심각: `Caught exception while allowing TestExecutionListener [org.springframework.test.context.support.DependencyInjectionTestExecutionListener@1e6d1014] to prepare test instance [com.user.UserServiceTest@76707e36]`
##### org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'com.user.UserServiceTest': Injection of autowired dependencies failed; nested exception is org.springframework.beans.factory.BeanCreationException: Could not autowire field: private com.user.UserService com.user.UserServiceTest.userService; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No matching bean of type [com.user.UserService] found for dependency: expected at least 1 bean which qualifies as autowire candidate for this dependency. Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}

1. `autowired` 설정 잘못하여 `bean을` 못찾음

   `@Service("ServiceName")` - `@Autowired`

   `@Repository` - `@Autowired`

2. `implements ClassName`  추가





#





`Caused by: org.springframework.beans.factory.BeanCreationException: Could not autowire field: private com.user.UserService com.user.UserServiceTest.userService; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No matching bean of type [com.user.UserService] found for dependency: expected at least 1 bean which qualifies as autowire candidate for this dependency. Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}`



#



#### `PropertyBatchUpdateException`

##### `Caused by: org.springframework.beans.PropertyBatchUpdateException; nested PropertyAccessExceptions (1) are:`
`PropertyAccessException 1: org.springframework.beans.MethodInvocationException: Property 'driverClassName' threw exception; nested exception is java.lang.IllegalStateException: Could not load JDBC driver class [oracle.jdbc.OracleDriver]`

- `ojdbc6.jar` 라이브러리 추가
- `build path` -> `Configure build path` ->  `add external JARs`인 경우 `dependency` 추가 안해도 됨



#



#### `Caused by: java.sql.SQLIntegrityConstraintViolationException: ORA-01400: NULL을 ("SCOTT"."USERINFO"."UNO")` 안에 삽입할 수 없습니다

- `userinfo` 테이블의 순서(?)를 기본키로 지정해 놓음

- `insert`에 등록해 놓지 않아 발생하는 에러

- DB 테이블 자동으로 1씩 증가하도록 수정하여야

  - oracle sql에는 `auto_increment` 속성이 없으므로 `insert`시 직접 입력

    ```sql
    insert into userinfo (uno, userid, username, userpwd, email, phone)
    values((select nvl(max(uno), 0)+1 from userinfo),?,?,?,?,?)
    ```

  
  
  #
  
  

#### `List`와 `ArrayList`는 무엇이 다른가??

```java
List<BoardVO> boardList = null;
boardList = template.query(board_list, new Object[0], new BoardRowMapper());
```

- 위 코드에서 `BoardVO`를 `ArrayList`로하면 에러남

- 왜?? 무엇이 다르기에?

- `List`

  - `interface` 개념

  - 구현체가 아니기에 구현하는데에 있어 자유도 확보 가능함

  - `index` 사용하여 목록에 접근함 // `get()`,`set()` 사용 가능

    ```java
    List <> list = new ArrayList<>();
    ```

    

- `ArrayList`

  - `List`에 상속된 `class` // 다형성 특징으로 상속 받아 사용

  - 데이터 추가(`add()`), 삭제(`remover()`) 수행시 메모리 재할당하기에 `Array`보다 느림

  - 객체가 포함된 동적 배열 생성에 사용

    ```java
    arrayList<> list = new ArrayList<>();
    ```

    



#



#### `Error parsing SQL Mapper Configuration. Cause: java.io.IOException: Could not find resource study/java/mybatis/mappers/DepartmentMapper.xml`

- `<mappers>`경로수정



#



#### `에러 : java.lang.IllegalArgumentException: Mapped Statements collection does not contain value for ~`



1. **mapper id가 다를경우**

  \- mapper파일(MyBatis의 쿼리문을 등록한 XML파일)에 <select id=''.. 에 id와 

   mapper파일에 직접 접근하는 java파일(DAO나 service)에 적어놓은 id값이 다른 경우 

2. Parameter와 bean의 필드명이 틀린 경우

3. mapper파일(MyBatis의 쿼리문을 등록한 XML파일)에 정의된 네임스페이스(namespace)와 mapper파일에 직접 접근하는 java파일(DAO나 service)에서 호출하는 **네임스페이스(namespace)가 다를 경우**

4. MyBatis config파일에 **mapper가 정의가 되어 있지 않거나 Spelling이 틀린 경우**

5. mapper에 정의된 **namespace 명칭이 같은 Application 내에 중복 될 경우**



#



#### `Exception sending context initialized event to listener instance of class org.springframework.web.context.ContextLoaderListener`

- `dependency`에 `'spring-jdbc' library` 추가



#

#### `Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 46056`

#### `at lab.spring.test.DAOTest.main(DAOTest.java:17)`

- 원인을 모르겠음

  ```xml
  <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
      <property name="dataSource" ref="dataSource" />
      <property name="mapperLocations" value="classpath*:resources/UserMapper.xml" />
  </bean>
  
  <bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
      <constructor-arg ref="sqlSessionFactory" />
  </bean>
  ```

  에서 오류가 나는 것은 확실한데 에러 원인을 못찾겠음!!



# 



#### 하위에러코드

#### `at org.springframework.asm.ClassReader.<init>(Unknown Source)`

#### `at org.springframework.core.type.classreading.SimpleMetadataReader.<init>(SimpleMetadataReader.java:48)`

- JDK 1.8을 사용하려는데 Spring Framework 3 버전을 사용하기 때문

-  JDK 1.8을 사용하려면 Spring Framework 4.0 대를 사용해야 하고, 
  Spring Framework 3 버전을 사용하고 싶다면 JDK 1.7을 사용해야 함
  
- `spring4` 설치 후 `spring-context`추가

  ```xml
  <!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
  <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <version>4.3.26.RELEASE</version>
  </dependency>
  ```

  

#



#### `Exception in thread "main" java.lang.NoClassDefFoundError: org/springframework/core/ResolvableTypeProvider`

-  `spring-context`를 `spring-jdbc` 아래에 추가하면서 에러남
- `spring-jdbc`위에 생성해줌



# 

#### Exception in thread "main" org.mybatis.spring.MyBatisSystemException: nested exception is org.apache.ibatis.exceptions.PersistenceException: 
#### Error querying database.  Cause: org.springframework.jdbc.CannotGetJdbcConnectionException: Could not get JDBC Connection; nested exception is java.sql.SQLException: Listener refused the connection with the following error: ORA-12505, TNS:listener does not currently know of SID given in connect descriptor

- `sql`구문 에러



#



#### `Cause: org.springframework.jdbc.CannotGetJdbcConnectionException: Could not get JDBC Connection; nested exception is java.sql.SQLException: Listener refused the connection with the following error:ORA-12505, TNS:listener does not currently know of SID given in connect descriptor`

- 데이터베이스 정보 입력 오타있었음

  ```xml
  <bean id="dataSource"
  		class="org.springframework.jdbc.datasource.DriverManagerDataSource"
  		p:driverClassName="oracle.jdbc.OracleDriver"
  		p:url="jdbc:oracle:thin:@127.0.0.1:1521:orlc"
  		p:username="scott" p:password="oracle" />
  
  <!-- orcl오타 수정 -->
  <bean id="dataSource"
  		class="org.springframework.jdbc.datasource.DriverManagerDataSource"
  		p:driverClassName="oracle.jdbc.OracleDriver"
  		p:url="jdbc:oracle:thin:@127.0.0.1:1521:orcl"
  		p:username="scott" p:password="oracle" />
  ```



#



#### ` bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: ORA-00984: 열을 사용할 수 없습니다`

- sql 파라메터 받는 부분 `#{}`-> **`${}`**



#



#### `Statement`와 `PreparedStatement`

- `statement`
  - 완전한 sql 문장 실행시 전송
  - hard parsing
  - where 절이 계속 변하는 경우 낭비가 심함
- `preparedStatement`
  - `statement`에서의 낭비가 심하여 바인드 변수 사용
  - sql 전송하여 db파싱하여 실행됨, 처음만 hard parsing 이후는 soft parsing
  - `java` => ?
  - `mybatis` => #{  }



#



