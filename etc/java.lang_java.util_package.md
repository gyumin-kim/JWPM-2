# java.lang / java.util package 정리

## Package java.lang

Java 프로그래밍 언어 디자인의 근본이 되는 클래스들을 제공한다. 가장 중요한 클래스는 클래스 계층구조의 root인 `Object`, 그리고 실행시간(run time)에 클래스를 나타내는 인스턴스인 `Class`이다.

원시타입(Primitive type)인 값을 마치 객체인 것처럼 나타내야할 때가 자주 있다. 래퍼 클래스(Wrapper Class)인 `Boolean`, `Character`, `Integer`, `Long`, `Float`, `Double`이 그러한 역할을 수행한다. 예를 들어, `Double` 타입의 객체는 타입이 double인 필드를 담고 있으며, 이 필드는 해당 유형에 대한 참조가 참조 유형(Reference type)의 변수에 저장될 수 있는 값을 나타낸다. 또한 이러한 클래스들은 원시값들끼리 변환할 수 있는 여러 메소드들을 제공하며, 'equals'나 'hashCode' 같은 표준 메소드들도 지원한다. `Void` 클래스는 객체화할 수 없는(non-instantiable) 클래스이며, void 타입을 나타내는 `Class` 객체에 대한 참조를 갖고 있다.

`Math` 클래스는 수학에서 흔히 사용되는 sine, cosine, square root 같은 함수들을 제공한다. `String`, `StringBuffer`, `StringBuilder` 클래스들은 문자열에 자주 사용되는 연산들을 제공한다.

`ClassLoader`, `Process`, `ProcessBuilder`, `Runtime`, `SecurityManager`, `System` 클래스들은 "시스템 연산"들을 제공하는데, 이를 통해 클래스의 동적 로딩, 외부 프로세스 생성, 시간과 같은 호스트 환경 질의 및 보안 정책의 시행 등을 관리한다.

`Throwable` 클래스는 throw 문에 의해 throw 될 수 있는 객체를 포함한다. `Throwable`의 서브 클래스는 에러와 예외를 나타낸다. 



## Package java.util

Collections 프레임워크, 레거시 Collections 클래스, 이벤트 모델, 날짜 및 시간 기능, 국제화 및 기타 유틸리티 클래스 (String tokenizer, 난수 생성기 및 비트 배열)를 포함한다.