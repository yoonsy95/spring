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





#### 심각: `Caught exception while allowing TestExecutionListener [org.springframework.test.context.support.DependencyInjectionTestExecutionListener@1e6d1014] to prepare test instance [com.user.UserServiceTest@76707e36]`
##### org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'com.user.UserServiceTest': Injection of autowired dependencies failed; nested exception is org.springframework.beans.factory.BeanCreationException: Could not autowire field: private com.user.UserService com.user.UserServiceTest.userService; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No matching bean of type [com.user.UserService] found for dependency: expected at least 1 bean which qualifies as autowire candidate for this dependency. Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}

- `autowired` 설정 잘못하여 `bean을` 못찾음



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
- ... 어떻게 하더랍..?ㅎㅎ

