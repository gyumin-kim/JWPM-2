# Java 웹 프로그래밍: 공부한 내용 정리

## Contents

> - [2018/09/03](https://github.com/gyumin-kim/jwpm-2/blob/master/daily/180903.md): 학습목표, 추상 클래스, 추상화, 일반화, 오버라이딩, 요구사항, 인터페이스, StringBuffer 클래스
> - [2018/09/04](https://github.com/gyumin-kim/jwpm-2/blob/master/daily/180904.md): 접근 제어자, private한 생성자, 추상클래스・static 메소드를 활용한 객체 생성, 생성자에서 Generics 활용, PATH・CLASSPATH・JAVA_HOME, java.lang / java.util package, Collection Framework
> - [2018/09/06](https://github.com/gyumin-kim/jwpm-2/blob/master/daily/180906.md): 의존 관계, association 관계, Object의 toString()・hashCode()・equals()
> - [2018/09/07](https://github.com/gyumin-kim/jwpm-2/blob/master/daily/180907.md): 인터페이스, Map 인터페이스, 접근 제어자, Java I/O


> - [2018/09/11](https://github.com/gyumin-kim/jwpm-2/blob/master/daily/180911.md): Java I/O(detail), Exception, `FileExam01-06`, `CopyUtil`, `IOExam01-04`
> - [2018/09/13](https://github.com/gyumin-kim/jwpm-2/blob/master/daily/180913.md): Database Programming, SQL, Maven Project, Connection・PreparedStatement・ResultSet
> - [2018/09/14](https://github.com/gyumin-kim/jwpm-2/blob/master/daily/180914.md): Thread, Lambda interface, 공유 객체, *향후 로드맵*


> - [2018/09/17](https://github.com/gyumin-kim/jwpm-2/blob/master/daily/180917.md): Thread, I/O, Socket을 이용한 채팅 프로그램 만들기
> - [2018/09/18](https://github.com/gyumin-kim/jwpm-2/blob/master/daily/180918.md): URL 형식, HTTP protocol(요청-응답 모델)
> - [2018/09/21](https://github.com/gyumin-kim/jwpm-2/blob/master/daily/180921.md): MiniWAS ↔︎ WebApp, Maven Local Repository, Jackson databind(ObjectMapper)


> - [2018/09/27](https://github.com/gyumin-kim/jwpm-2/blob/master/daily/180927.md): Java 웹프로그래밍, IDE에서 WAS(Tomcat) 설정하기, Web Application의 구조, IntelliJ IDEA Ultimate에서 웹 애플리케이션 생성하기, Dependency scope, Servlet Lifecycle, IoC


> - [2018/10/01](https://github.com/gyumin-kim/jwpm-2/blob/master/daily/181001.md): Servlet Lifecycle, Cookie & Session, JSP의 실행순서, MVC Model 1 & 2
> - [2018/10/02](https://github.com/gyumin-kim/jwpm-2/blob/master/daily/181002.md): 간단한 방명록 만들기, redirect, forward, URL path・parameter, form으로 받은 parameter 읽어들이기, DAO・VO・DTO, EL/JSTL
> - [2018/10/04](https://github.com/gyumin-kim/jwpm-2/blob/master/daily/181004.md): Servlet & JSP's Scope, MySQL user・table 생성 및 guestbook과 연동
> - [2018/10/05](https://github.com/gyumin-kim/jwpm-2/blob/master/daily/181005.md): MiniWAS 완성하기, Annotation 클래스 직접 만들기, WAS 동작 원리 이해하기


> - [2018/10/08](https://github.com/gyumin-kim/jwpm-2/blob/master/daily/181008.md): Git&GitHub 사용법, Git-Flow, 게시판 프로젝트


> - [2018/10/16](https://github.com/gyumin-kim/jwpm-2/blob/master/daily/181016.md): 트랜잭션, 컨테이너, Spring에서의 Bean 생성, 응집도・결합도, AOP, Joinpoint, Pointcut, Advice
> - [2018/10/18](https://github.com/gyumin-kim/jwpm-2/blob/master/daily/181018.md): XML, XML 스키마, XML namespace, 공유객체, singleton scope, property, constructor-arg
> - [2018/10/19](https://github.com/gyumin-kim/jwpm-2/blob/master/daily/181019.md): AnnotationConfigApplicationContext, @Configuration


> - [2018/10/22](https://github.com/gyumin-kim/jwpm-2/blob/master/daily/181022.md): Controller-Service-Repository-DB, commit・rollback, PlatformTransactionManager, @EnableTransactionManagement, @Transactional, DataSource, Connection, DBCP, connection pool, Spring JDBC, JdbcTemplate, DAO 만드는 방법, connection pool에 설정할 수 있는 것들
> - [2018/10/23](https://github.com/gyumin-kim/JWPM-2/blob/master/daily/181023.md)
> - [2018/10/25](https://github.com/gyumin-kim/JWPM-2/blob/master/daily/181025.md)

> - [2018/10/31](https://github.com/gyumin-kim/JWPM-2/blob/master/daily/181031.md)
> - [2018/11/02](https://github.com/gyumin-kim/JWPM-2/blob/master/daily/181102.md)

> - [2018/11/06](https://github.com/gyumin-kim/JWPM-2/blob/master/daily/181106.md)
> - [2018/11/07](https://github.com/gyumin-kim/JWPM-2/blob/master/daily/181107.md)
> - [2018/11/08](https://github.com/gyumin-kim/JWPM-2/blob/master/daily/181108.md)
> - [2018/11/09](https://github.com/gyumin-kim/JWPM-2/blob/master/daily/181109.md)

> - [2018/11/12](https://github.com/gyumin-kim/JWPM-2/blob/master/daily/181112.md)
> - [2018/11/13](https://github.com/gyumin-kim/JWPM-2/blob/master/daily/181113.md)
> - [2018/11/14](https://github.com/gyumin-kim/JWPM-2/blob/master/daily/181114.md)
> - [2018/11/16](https://github.com/gyumin-kim/JWPM-2/blob/master/daily/181116.md)

> - [2018/11/19](https://github.com/gyumin-kim/JWPM-2/blob/master/daily/181119.md)
> - [2018/11/20](https://github.com/gyumin-kim/JWPM-2/blob/master/daily/181120.md)

## Etc.

> - [java.lang / java.util package 정리](https://github.com/gyumin-kim/JWPM-2/blob/master/etc/java.lang_java.util_package.md)
> - [Collection Framework 정리](https://github.com/gyumin-kim/JWPM-2/blob/master/etc/CollectionFramework.md)
> - [GitHub 특강](https://github.com/gyumin-kim/JWPM-2/blob/master/etc/Github_lecture.md)
> - [Lambda Expression](https://github.com/gyumin-kim/JWPM-2/blob/master/etc/LambdaExpression.md)
> - [Multi Thread](https://github.com/gyumin-kim/JWPM-2/blob/master/etc/MultiThread.md)

