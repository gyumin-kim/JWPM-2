# Lambda expression

## 람다식이란?

람다식이란, method를 하나의 식(expression)으로 표현한 것이다. 어떤 method를 람다식으로 표현하면 method의 이름과 리턴값 부분이 없어지므로, 람다식을 '**Anonymous Function**(익명 함수)'라고 부르기도 한다.

람다식은 method에서 이름과 리턴타입 부분을 제거하고, 매개변수 삽입부분과 {} 사이에 `->`를 추가한다.

```java
// method
int max(int a, int b) {
    return a > b ? a : b;
}
```

```java
// lambda
(int a, int b) -> {
    return a > b ? a : b;
}
```

<br>

리턴값이 있는 method의 경우, return문을 식으로 대신할 수 있다. 식의 연산결과가 자동으로 리턴값이 된다.

```java
(int a, int b) -> { return a > b ? a : b; }
(int a, int b) -> a > b ? a : b;
```

람다식에 선언된 매개변수의 타입은 대부분의 경우 생략 가능하다.

```java
(int a, int b) -> a > b ? a : b;
(a, b) -> a > b ? a : b;
```

매개변수가 하나 뿐인 경우에는 괄호(`()`)를 생략할 수 있다. 단 매개변수의 타입이 있으면 생략할 수 없다.

```java
(a) -> a * a;
a -> a * a;

(int a) -> a * a;
int a -> a * a;	// 에러!
```

중괄호(`{}`) 안의 문장이 하나일 때는 중괄호(`{}`)를 생략할 수 있다. 이 때 문장의 끝에 `;`를 빼야 한다.

```java
(String name, int i) -> {
    System.out.println(name + " = " + i);
}

(String name, int i) -> 
	System.out.println(name + " = " + i)
```

그러나 중괄호(`{}`) 안의 문장이 return문일 경우 생략할 수 없다.

```java
(int a, int b) -> { return a > b ? a : b; }
(int a, int b) -> return a > b ? a : b	// 에러!
```

<br>

```java
package com.company;

@FunctionalInterface
interface MyFunction {
    void run();
}

public class LambdaEx1 {
    static void execute(MyFunction f) {
        f.run();
    }

    static MyFunction getMyFunction() {
        MyFunction f = () -> System.out.println("f3.run()");
        return f;
//        return () -> System.out.println("f3.run()");
    }

    public static void main(String[] args) {
        MyFunction f1 = () -> System.out.println("f1.run()");

        MyFunction f2 = new MyFunction() {
            @Override
            public void run() {
                System.out.println("f2.run()");
            }
        };

        MyFunction f3 = getMyFunction();

        f1.run();
        f2.run();
        f3.run();
        System.out.println("");
        execute(f1);
        execute(() -> System.out.println("run()"));
    }
}
```

```java
package com.company;

@FunctionalInterface
interface MyFunction2 {
    void myMethod();
}

public class LambdaEx2 {
    public static void main(String[] args) {
        MyFunction2 f = () -> {};
        Object obj = (MyFunction2) (() -> {});
        String str = ((Object) (MyFunction2) (() -> {})).toString();

        System.out.println(f);
        System.out.println(obj);
        System.out.println(str);
    }
}
```

```java
package com.company;

@FunctionalInterface
interface MyFunction3 {
    void myMethod();
}

class Outer {
    int val = 10;

    class Inner {
        int val = 20;

        void method(int i) {
            int val = 30;
//            i = 10;
            MyFunction3 f = () -> {
                System.out.println("             i: " + i);
                System.out.println("           val: " + val);
                System.out.println("      this.val: " + ++this.val);
                System.out.println("Outer.this.val: " + ++Outer.this.val);
            };

            f.myMethod();
        }
    }
}

public class LambdaEx3 {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.method(100);
    }
}
```

