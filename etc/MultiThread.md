# Multi Thread

## 멀티 스레드 개념

현재 실행 중인(메모리에 load되어 있는) 프로그램(애플리케이션)을 **프로세스(process)**라고 부른다. 멀티태스킹(multi tasking)은 2가지 이상의 작업을 동시에 처리하는 것을 뜻하는데, 멀티 태스킹을 통해서 가능하다.

**멀티 프로세스(multi process)**가 프로그램(애플리케이션) 단위의 멀티 태스킹이라면, **멀티 스레드(multi thread)**는 프로그램(애플리케이션) 내부에서의 멀티 태스킹이라고 볼 수 있다.

멀티 프로세스들은 자신의 메모리 공간을 가지고 실행하기 때문에 서로 독립적이다. 따라서 하나의 프로세스에서 오류가 발생해도 다른 프로세스에게 영향을 끼치지 않는다. 하지만 멀티 스레드는 하나의 프로세스 내부에 생성되기 때문에 하나의 스레드가 예외를 발생시키면 프로세스 자체가 종료될 수 있어 다른 스레드에게 영향을 미치게 된다. 그러므로 멀티 스레드에서는 예외 처리에 각별히 신경써야 한다.

모든 Java 애플리케이션은 메인 스레드(main thread)가 `main()` 메소드를 실행하면서 시작된다. 메인 스레드는 필요에 따라 작업 스레드(worker thread)들을 만들어서 병렬로 코드를 실행할 수 있다.

![multi-thread-application](http://www.ntu.edu.sg/home/ehchua/programming/java/images/Multithread.gif)

멀티 스레드 애플리케이션에서는 실행 중인 스레드가 하나라도 있다면 프로세스는 종료되지 않는다. 메인 스레드가 작업 스레드보다 먼저 종료되더라도, 작업 스레드가 계속 실행 중이라면 프로세스는 종료되지 않는다.

<br>

## 작업 스레드 생성과 실행

멀티 스레드로 돌아가는 애플리케이션을 개발하려면, 먼저 몇 개의 작업을 병렬로 실행할지 결정하고, 각 작업 별로(네트워킹, 드로잉, 음악재생 등) 스레드를 생성해야 한다. 즉 메인 작업 이외에 추가적인 병렬 작업의 수만큼 스레드를 생성하면 된다.

Java에서는 작업 스레드도 객체로 생성되기 때문에 클래스가 필요한데, 2가지 방법이 있다. 1) java.lang.Thread 클래스를 직접 객체화해서 생성하거나, 2) Thread를 상속 받는 자식 클래스를 만들어 생성할 수 있다.

### 1) Thread 클래스로부터 직접 생성

이 방법은 `Runnable` 인터페이스를 매개값으로 갖는 생성자를 호출해야 한다.

```java
Thread thread = new Thread(Runnable target);
```

`Runnable`이라는 이름은 작업 스레드가 실행할 수 있는 코드를 갖고 있는 객체라고 해서 붙여진 것이다. `Runnable`에는 `run()`이라는 단 1개의 메소드가 선언되어 있는데, 구현 클래스는 이 `run()`을 overriding하여 작업 스레드가 수행할 일을 코드로 작성해야 한다.

```java
class Task implements Runnable {
    public void run() {
        // 작업 스레드가 실행할 코드
        ...
    }
}
```

`Runnable`을 구현한 객체를 생성한 후, 이것을 매개값으로 해서 `Thread` 생성자를 호출하면 작업 스레드가 생성된다.

```java
Runnable task = new Task();
Thread thread = new Thread(task);
```

`Runnable` 익명 객체를 사용하면 코드가 더 간결해진다.

```java
Thread thread = new Thread(new Runnable() {
    public void run() {
        // 작업 스레드가 실행할 코드
        ...
    }
});
```

`Runnable` 인터페이스는 메소드를 `run()`만 유일하게 가지는데, 이러한 인터페이스를 '함수적 인터페이스(Functional Interface)'라고 한다. 따라서 람다식을 매개값으로 적용할 수 있는데, 코드가 더욱 더 간결해진다.

```java
Thread thread = new Thread(() -> {
    // 작업 스레드가 실행할 코드
    ...
});
```

작업 스레드는 생성되는 즉시 실행되는 것이 아니라, `start()`를 호출해야만 실행된다.

```java
thread.start();
```

`start()`가 호출되면, 작업 스레드는 매개값으로 받은 `Runnable`의 `run()`을 실행하면서 자신의 작업을 처리한다.

### 2) Thread 자식 클래스로부터 생성

작업 스레드가 실행할 작업을 `Runnable`로 만들지 않고, `Thread` 클래스를 상속한 후 `run()`을 overriding해서 스레드가 실행할 코드를 작성한다.

```java
public class WorkerThread extends Thread {
    @Override
    public void run() {
        // 작업 스레드가 실행할 코드
        ...
    }
}
Thread thread = new WorkerThread();
```

`Thread` 익명 객체를 사용하면 코드가 더 간결해진다.

```java
Thread thread = new Thread() {
    public void run() {
        // 작업 스레드가 실행할 코드
        ...
    }
}
```

이렇게 생성된 작업 스레드 객체에서 `start()`를 호출하면 작업 스레드가 자신의 `run()`을 호출한다.

```java
thread.start();
```

<br>

Java에서는 단일 상속만 가능하므로, 가능하면 `Runnable`을 구현하는 방법을 사용하여 상속의 기회를 남겨두는 것이 좋다.

### 스레드의 이름

여러 개의 스레드는 자동적으로 "Thread-`n`"이라는 이름으로 설정되는데, 디버깅을 위해 임의의 이름을 설정해야 할 때 `Thread` 클래스의 `setName()`을 사용한다.

`setName()`과 `getName()`은 `Thread`의 인스턴스 메소드이므로, 스레드 객체의 참조가 필요하다. 만약 스레드 객체의 참조를 갖고 있지 않다면, `Thread`의 static 메소드인 `currentThread()`로 현재 스레드의 참조를 얻을 수 있다.

```java
public class ThreadNameExample {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        System.out.println("프로그램 시작 스레드 이름: " + mainThread);

        ThreadA threadA = new ThreadA();
        System.out.println("작업 스레드 이름: " + threadA.getName());
        threadA.start();

        ThreadB threadB = new ThreadB();
        System.out.println("작업 스레드 이름: " + threadB.getName());
        threadB.start();
    }
}
```

```java
public class ThreadA extends Thread {
    public ThreadA() {
        setName("ThreadA");
    }

    @Override
    public void run() {
        for (int i = 0; i < 2; i++)
            System.out.println(getName() + "가 출력한 내용");
    }
}
```

```java
public class ThreadB extends Thread {
    public ThreadB() {
        setName("ThreadB");
    }

    @Override
    public void run() {
        for (int i = 0; i < 2; i++)
            System.out.println(getName() + "가 출력한 내용");
    }
}
```

<br>

## 스레드 우선순위

- **동시성(Concurrency)**: 멀티 작업을 위해 하나의 코어에서 멀티 스레드가 번갈아가며 실행하는 성질 (multi programming)
- **병렬성(Parallelism)**: 멀티 작업을 위해 멀티 코어에서 개별 스레드를 동시에 실행하는 성질

스레드의 개수가 코어의 개수보다 많을 경우, 스레드를 어떤 순서에 의해 동시성으로 실행할 것인가를 결정해야 하는데, 이를 **스레드 스케줄링(thread scheduling)**이라고 한다. (스레드의 개수보다 코어의 개수가 많을 경우, 우선순위가 큰 영향을 끼치지 못한다.)

Java의 스레드 스케줄링은 우선순위(priority) 방식과 Round Robin 방식을 사용한다. 우선순위 방식은 스레드 객체에 우선순위 번호를 개발자가 코드로 부여할 수 있으나, Round Robin은 JVM에 의해서 정해지므로 코드로 제어할 수 없다.

우선순위 방식에서 우선순위는 1~10까지 부여되며 숫자가 클수록 우선순위가 높다. 우선순위를 부여하지 않으면 기본값으로 5의 우선순위를 할당받는다.

```java
thread.setPriority(우선순위);
thread.setPriority(Thread.MAX_PRIORITY);	// 10
thread.setPriority(Thread.NORM_PRIORITY);	// 5
thread.setPriority(Thread.MIN_PRIORITY);	// 1
```

동일한 계산 작업을 하는 스레드들이 있고 싱글 코어에서 동시성으로 실행할 경우, 우선순위가 높은 스레드가 실행 기회를 더 많이 가지므로 우선순위가 낮은 스레드보다 계산 작업을 빨리 끝낸다.

<br>

## 동기화(synchronized) 메소드와 동기화 블록

멀티 스레드 프로그램에서는 스레드들이 어떤 객체를 공유해서 작업해야 하는 경우가 있다(공유 객체; shared object). 이 경우, 스레드 A를 사용하던 객체가 스레드 B에 의해 상태가 변경될 수 있는데, 스레드 A가 의도했던 것과는 다른 결과를 반환할 수도 있다.

```java
public class MainThreadExample {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        User1 user1 = new User1();
        user1.setCalculator(calculator);
        user1.start();

        User2 user2 = new User2();
        user2.setCalculator(calculator);
        user2.start();
        
        // << 실행결과 >>
        // User1: 50
        // User2: 50
    }
}
```

```java
public class Calculator {
    private int memory;

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        synchronized (this) {
            this.memory = memory;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ie) {
            }
            System.out.println(Thread.currentThread().getName() + ": " + this.memory);
        }
    }
}
```

```java
public class User1 extends Thread {
    private Calculator calculator;

    public User1() {
        setName("User1 Thread");
    }

    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void run() {
        calculator.setMemory(100);
    }
}
```

```java
public class User2 extends Thread {
    private Calculator calculator;

    public User2() {
        setName("User2 Thread");
    }

    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void run() {
        calculator.setMemory(50);
    }
}
```

멀티 스레드 프로그램에서, 한 순간에 하나의 스레드만 실행할 수 있는 영역을 Critical Section(임계 영역)이라고 한다. Java는 critical section을 지정하기 위해 동기화(synchronized) 메소드와 동기화 블록을 제공한다. 즉 스레드가 `synchronized` 영역에 들어가면, 즉시 객체에 잠금(lock)을 걸어 (스레드의 실행이 일시정지되거나 종료되기 전까지는)다른 스레드가 critical section을 실행하지 못하도록 한다.

메소드에 `synchronized`를 추가하면 메소드 전체가 critical section이 되고, 일부분만 critical section으로 만들고 싶다면 `synchronized` 블록을 만들면 된다.

위의 코드에서 `Calculator.java`의 `setMemory()`를 synchronized 메소드로 수정하거나, 메소드 내부를 synchronized 블록으로 감쌀 수도 있다.

```java
public class Calculator {
    private int memory;

    public int getMemory() {
        return memory;
    }
    
    // 1) synchronized 메소드
    public synchronized void setMemory(int memory) {
        this.memory = memory;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ie) {}
        System.out.println(Thread.currentThread().getName() + ": " + this.memory);
    }

    // 2) synchronized 블록
    public void setMemory(int memory) {
        synchronized (this) {
            this.memory = memory;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ie) {}
            System.out.println(Thread.currentThread().getName() + ": " + this.memory);
        }
    }
}
```

`User1` 스레드는 `setMemory()`를 실행하는 순간 `Calculator` 객체를 잠근다. 메인 스레드가 `User2` 스레드를 실행시키지만, synchronized 메소드인 `setMemory()`를 실행시키지는 못하고, `User1`이 `setMemory()`를 모두 실행할 동안 대기해야 한다(RUNNABLE).

<br>

## 스레드 상태(State)

- 스레드 객체를 생성하고 `start()`를 호출하면, 스레드가 바로 실행되는 것이 아니라 '실행 대기' 상태가 된다. '**실행 대기**' 상태란 아직 스케줄링이 되지 않아서 실행 되기를 기대리고 있는 상태를 말한다.
- '실행 대기' 상태에 있는 스레드들 중에서 스레드 스케줄링으로 선택된 스레드가 CPU를 점유하고 `run()`을 호출한다. 이 때를 '**실행(Running)**' 상태라고 한다.
- '실행' 상태의 스레드는 자신의 `run()` 메소드를 모두 완료하기 전에, 스레드 스케줄링에 의해 다시 '실행 대기' 상태로 돌아갈 수도 있다('실행 대기' 상태에 있던 스레드가 선택되어 다시 '실행' 상태가 된다). 이렇게 스레드는 '실행 대기' 상태와 '실행' 상태를 번갈아가면서, 자신의 `run()` 메소드를 조금씩 실행해 나간다.
- 결국 `run()`이 종료되면, 스레드의 실행은 멈춘다. 이를 '**종료**' 상태라고 한다.

![diagram-of-process-state](https://i.stack.imgur.com/W1Oom.jpg)

![java-thread-state-diagram](https://codexplo.files.wordpress.com/2012/10/thread-state-diagram.png)

`Thread` 클래스의 `getState()`를 사용하여 스레드의 상태를 코드에서 확인할 수 있다.

```java
public class StatePrintThread extends Thread {
    private Thread targetThread;

    public StatePrintThread(Thread targetThread) {
        this.targetThread = targetThread;
    }

    @Override
    public void run() {
        while (true) {
            Thread.State state = targetThread.getState();
            System.out.println("타겟 스레드 상태: " + state);

            if (state == State.NEW)
                targetThread.start();
            if (state == State.TERMINATED)
                break;

            try {
                Thread.sleep(500);
            } catch (Exception e) {}
        }
    }
}
```

```java
public class TargetThread extends Thread {
    @Override
    public void run() {
        for (long i = 0; i < 2000000000; i++) {}

        try {
            Thread.sleep(1500);
        } catch (Exception e) {}

        for (long i = 0; i < 2000000000; i++) {}
    }
}
```

```java
public class ThreadStateExample {
    public static void main(String[] args) {
        StatePrintThread statePrintThread = new StatePrintThread(new TargetThread());
        statePrintThread.start();
    }
}
```

타겟 스레드 상태: NEW
타겟 스레드 상태: RUNNABLE
타겟 스레드 상태: TIMED_WAITING
타겟 스레드 상태: TIMED_WAITING
타겟 스레드 상태: TIMED_WAITING
타겟 스레드 상태: RUNNABLE
타겟 스레드 상태: RUNNABLE
타겟 스레드 상태: TERMINATED

와 같이 출력될 것이다.

<br>

## 스레드 상태 제어

실행 중인 스레드의 상태를 변경하는 것을 '스레드 상태 제어'라고 한다. 스레드 제어를 제대로 하기 위해서는, 스레드의 상태를 변화시키는 메소드들을 파악하고 있어야 한다.

| Method                                                       | 설명                                                         |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| `interrupt()`                                                | 일시정지 상태의 스레드에서 <br />InterruptedException을 발생시켜, 예외처리 코드(catch)에서 <br />실행 대기 상태나 종료 상태로 갈 수 있도록 한다. |
| `notify()`<br />`notifyAll()`                                | synchronized 블록 내에서 `wait()`에 의해 일시정지 상태에<br />있는 스레드를 실행대기 상태로 만든다. |
| ~~`resume()`~~                                               | ~~*Deprecated*~~                                             |
| `sleep(long millis)`<br />`sleep(long millis, int nanos)`    | 주어진 시간 동안 스레드를 일시정지 상태로 만든다.<br />주어진 시간이 지나면 자동적으로 실행대기 상태가 된다. |
| `join()`<br />`join(long millis)`<br />`join(long millis, int nanos)` | `join()`을 호출한 스레드는 일시정지 상태가 된다.<br />실행대기 상태로 가려면, `join()`을 멤버로 가지는 스레드가<br />종료되거나, 매개값으로 주어진 시간이 지나야 한다. |
| `wait()`<br />`wait(long millis)`<br />`wait(long millis, int nanos)` | synchronized 블록 내에서 스레드를 일시정지 상태로 만든다.<br />매개값으로 주어진 시간이 지나면 자동적으로 실행대기 상태가 된다.<br />시간이 주어지지 않으면 `notify()`, `notifyAll()`에 의해<br />실행대기 상태로 갈 수 있다. |
| ~~`suspend()`~~                                              | ~~*Deprecated*~~                                             |
| `yield()`                                                    | 실행 중에 우선순위가 동일한 다른 스레드에게 실행을 양보하고<br />실행대기 상태가 된다. |
| ~~`stop()`~~                                                 | ~~*Deprecated*~~                                             |

### 주어진 시간동안 일시정지(`sleep()`)

`Thread.sleep()`을 호출한 스레드는 주어진 시간 동안 '**일시정지**' 상태가 되고, 다시 실행대기 상태로 돌아간다.

매개값에는 얼마 동안 일시정지 상태로 있을 것인지, millisecond 단위로 시간을 주면 된다. 주어진 시간이 되기 전에 `interrupt()`가 호출되면, InterruptedException이 발생하므로 예외처리가 필요하다.

<br>

### 다른 스레드에게 실행 양보(`yield()`)

```java
public void run() {
    while(true) {
        if (work) {
            System.out.println("ThreadA 작업 내용");
        }
    }
}
```

위의 코드에서, work의 값이 false이거나 work의 값이 false에서 true로 변경되는 시점이 불명확하다면, while문은 무의미한 반복을 하게 된다. 이러한 경우 다른 스레드에게 실행을 양보하고 자신은 '실행대기' 상태로 가는 것이 효율적이다. `yield()`를 호출한 스레드는 실행대기 상태로 돌아가고, 동일하거나 높은 우선순위를 갖는 다른 스레드가 실행 기회를 가질 수 있도록 한다.

```java
public class YieldExample {
    public static void main(String[] args) {
        YieldThreadA threadA = new YieldThreadA();
        YieldThreadB threadB = new YieldThreadB();

        threadA.start();
        threadB.start();

        try { Thread.sleep(3000); } catch (InterruptedException ie) {}
        threadA.work = false;

        try { Thread.sleep(3000); } catch (InterruptedException ie) {}
        threadA.work = true;

        try { Thread.sleep(3000); } catch (InterruptedException ie) {}
        threadA.stop = true;
        threadB.stop = true;
    }
}
```

```java
public class YieldThreadA extends Thread {
    public boolean stop = false;
    public boolean work = true;

    @Override
    public void run() {
        while (!stop) {
            if (work)
                System.out.println("ThreadA 작업 내용");
            else
                Thread.yield();
        }
        System.out.println("ThreadA 종료");
    }
}
```

```java
public class YieldThreadB extends Thread {
    public boolean stop = false;
    public boolean work = true;

    @Override
    public void run() {
        while (!stop) {
            if (work)
                System.out.println("ThreadB 작업 내용");
            else
                Thread.yield();
        }
        System.out.println("ThreadB 종료");
    }
}
```

<br>

### 다른 스레드의 종료를 기다림(`join()`)

다른 스레드가 종료될 때까지 기다렸다가 실행해야 하는 경우, 예를 들면 계산 작업을 하는 스레드가 계산을 마칠 때까지 기다렸다가 그 결과를 다른 스레드에서 사용하는 경우에 사용한다.

다음의 코드에서는, 메인 스레드는 `SumThread`가 계산 작업을 모두 마칠 때까지 '일시정지' 상태에 있다가, `SumThread`가 값을 계산하고 종료하면 결과값을 받아 출력한다.

```java
public class SumThread extends Thread {
    private long sum;

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++)
            sum += i;
    }
}
```

```java
public class JoinExample {
    public static void main(String[] args) {
        SumThread sumThread = new SumThread();
        sumThread.start();

        try {
            sumThread.join();
        } catch (InterruptedException ie) {}

        System.out.println("1~100 합: " + sumThread.getSum());
    }
}
```

<br>

### 스레드 간 협업(`wait()`, `notify()`, `notifyAll()`)

두 개의 스레드를 정확히 교대로 번갈아가며 실행해야 하는 경우에 사용한다. 자신의 작업이 끝나면 상대방 스레드를 일시정지 상태에서 풀어주고, 자신은 일시정지 상태로 만드는 것이다. '**공유 객체**'에 두 스레드가 작업할 내용을 각각 **synchronized** 메소드로 구분해 놓는다.

한 스레드가 작업을 완료하면 `notify()`를 호출해서 일시정지 상태에 있는 다른 스레드를 실행대기 상태로 만들고, 자신은 두 번 작업을 하지 않도록 `wait()`을 호출하여 일시정지 상태로 만든다.

`notify()`는 `wait()`에 의해 일시정지 된 스레드 중 1개를 실행대기 상태로 만들고, `notifyAll()`은 `wait()`에 의해 일시정지 된 모든 스레드들을 실행대기 상태로 만든다.

이 메소드들은 `Object` 클래스의 메소드들이므로 모든 공유 객체에서 사용 가능하며, synchronized 메소드 혹은 synchronized 블록 내에서만 사용 가능하다.

다음의 예제는, 공유 객체(`DataBox`)의 `data` 필드의 값이 `null`이면 생산자 스레드를 실행대기 상태로 만들고, 소비자 스레드를 일시정지 상태로 만든다. 반대로 `data` 필드의 값이 `null`이 아니면 소비자 스레드를 실행대기 상태로 만들고, 생산자 스레드를 일시정지 상태로 만든다.

```java
public class DataBox {
    private String data;

    public synchronized String getData() {
        if (this.data == null) {
            try {
                wait();
            } catch (InterruptedException ie) {}
        }
        String returnValue = data;
        System.out.println("ConsumerThread가 읽은 데이터: " + returnValue);
        data = null;
        notify();

        return returnValue;
    }

    public synchronized void setData(String data) {
        if (this.data != null) {
            try {
                wait();
            } catch (InterruptedException ie) {}
        }
        this.data = data;
        System.out.println("ProducerThread가 생성한 데이터: " + data);
        notify();
    }
}
```

```java
public class ProducerThread extends Thread {
    private DataBox dataBox;

    public ProducerThread(DataBox dataBox) {
        this.dataBox = dataBox;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            String data = "Data-" + i;
            dataBox.setData(data);
        }
    }
}
```

```java
public class ConsumerThread extends Thread {
    private DataBox dataBox;

    public ConsumerThread(DataBox dataBox) {
        this.dataBox = dataBox;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            String data = dataBox.getData();
        }
    }
}
```

```java
public class ProducerConsumerExample {
    public static void main(String[] args) {
        DataBox dataBox = new DataBox();

        ProducerThread producerThread = new ProducerThread(dataBox);
        ConsumerThread consumerThread = new ConsumerThread(dataBox);

        producerThread.start();
        consumerThread.start();
    }
}
```

<br>

### 스레드의 안전한 종료(stop 플래그, `interrupt()`)

스레드는 자신의 `run()` 내부가 모두 실행되면 자동적으로 종료된다. 그러나 경우에 따라서는 실행 중인 스레드를 즉시 종료할 필요가 있다. 스레드를 종료하기 위한 최선의 방법은 크게 2가지가 있다.  
(`stop()`은 deprecated됨, 사용 중이던 자원들이 불완전한 상태로 남겨짐)

#### 1) stop 플래그를 이용하는 방법

스레드는 `run()`이 끝나면 자동적으로 종료되므로, `run()`이 정상적으로 종료되도록 유도하는 것이 가장 자연스러운 방법이다.

```java
public class StopFlagExample {
    public static void main(String[] args) {
        PrintThread1 printThread = new PrintThread1();
        printThread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {}
        
        printThread.setStop(true);
    }
}
```

```java
public class PrintThread1 extends Thread {
    private boolean stop;

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    @Override
    public void run() {
        while (!stop) {
            System.out.println("실행 중");
        }
        System.out.println("자원 정리");
        System.out.println("실행 종료");
    }
}
```

#### 2) `interrupt()`를 이용하는 방법

`interrupt()`는 스레드가 일시정지 상태에 있을 때 InterruptedException을 발생시키는 역할을 한다. 이를 통해 `run()`을 정상 종료 시킬 수 있다.

ThreadA가 ThreadB의 `interrupt()`을 실행하면, ThreadB가 `sleep()`으로 일시정지 상태가 될 때 ThreadB에서 InterruptedException이 발생하여 예외처리(catch) 블록으로 이동하고 `run()`이 정상 종료된다.

주의할 점은 스레드가 일시정지 상태가 되지 않으면 `interrupt()`는 아무 의미가 없다. 일시정지를 만들지 않고도 `interrupt()`의 호출 여부를 알 수 있는 방법이 있는데, `interrupt()`가 호출되었다면 스레드의 `interrupted()`와 `isInterrupted()`는  `true`를 리턴한다.

```java
public class InterruptExample {
    public static void main(String[] args) {
        Thread thread = new PrintThread2();
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {}

        thread.interrupt();
    }
}
```

```java
public class PrintThread2 extends Thread {
    @Override
    public void run() {
        // Thread.sleep(1)으로 고의적으로 일시정지 시킴
//        try {
//            while (true) {
//                System.out.println("실행 중");
//                Thread.sleep(1);
//            }
//        } catch (InterruptedException ie) {}

        while (true) {
            System.out.println("실행 중");
            if (Thread.interrupted())
                break;
        }
        System.out.println("자원 정리");
        System.out.println("실행 종료");
    }
}
```

<br>

## 데몬(daemon) 스레드

데몬(daemon) 스레드는 메인 스레드의 작업을 돕는 보조적인 역할을 수행하는 스레드이다. 따라서 메인 스레드가 종료되면 데몬 스레드는 강제적으로 종료된다. 데몬 스레드는 메인 스레드의 보조 역할이기 때문이다.

스레드를 데몬으로 만들기 위해서는 데몬이 될 스레드의 `setDaemon(true)`를 메인 스레드가 호출해주면 된다. 

단 주의할 점은 `start()`가 호출되고 나서 `setDaemon(true)`를 호출하면 `IllegalThreadStateException`이 발생하므로, 반드시 `start()` 전에 `setDaemon(true)`를 호출해야 한다. 또한 현재 실행 중인 스레드가 데몬 스레드인지 구별하기 위해서 `isDaemon()`을 호출할 수 있는데, 데몬 스레드일 경우 true를 리턴한다.

```java
public class AutoSaveThread extends Thread {
    public void save() {
        System.out.println("작업 내용을 저장함");
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                break;
            }
            save();
        }
    }
}
```

```java
public class DaemonExample {
    public static void main(String[] args) {
        AutoSaveThread autoSaveThread = new AutoSaveThread();
        autoSaveThread.setDaemon(true);
        autoSaveThread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException ie) {}

        System.out.println("메인 스레드 종료");
    }
}
```

<br>

## 스레드 그룹

스레드 그룹(ThreadGroup)은 관련된 스레드를 묶어서 관리할 목적으로 이용된다. JVM이 실행되면 `system` 스레드 그룹을 만들고, system의 하위 스레드 그룹으로 `main`을 만들고 메인 스레드를 main 스레드 그룹에 포함시킨다. 명시적으로 스레드 그룹에 포함시키지 않으면 기본적으로 자신을 생성한 스레드와 같은 스레드 그룹에 속하게 된다.

### 스레드 그룹 이름 얻기

현재 스레드가 속한 스레드 그룹의 이름을 얻고 싶다면, 다음과 같은 코드를 사용한다.

```java
ThreadGroup group = Thread.currentGroup().getThreadGroup();
String groupName = group.getName();
```

<br>

```java
public class ThreadInfoExample {
    public static void main(String[] args) {
        AutoSaveThread autoSaveThread = new AutoSaveThread();
        autoSaveThread.setName("AutoSaveThread");
        autoSaveThread.setDaemon(true);
        autoSaveThread.start();

        Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
        Set<Thread> threads = map.keySet();
        for (Thread thread : threads) {
            System.out.println("Name: " + thread.getName() + ((thread.isDaemon()) ? "(데몬)": "(주)"));
            System.out.println("\t" + "소속그룹: " + thread.getThreadGroup().getName());
            System.out.println();
        }
    }
}
```

<br>

### 스레드 그룹 생성

명시적으로 스레드 그룹을 만드려면, 다음 생성자 중 하나를 이용해서 `ThreadGroup` 객체를 만든다.

```java
ThreadGroup tg = new ThreadGroup(String name);
ThreadGroup tg = new ThreadGroup(ThreadGroup parent, String name);
```

스레드 그룹 생성 시 부모 스레드 그룹을 지정하지 않으면, 현재 스레드가 속한 그룹의 하위 그룹으로 생성된다.

새로운 스레드 그룹을 생성한 후, 그 그룹에 어떤 스레드를 포함시키려면 `Thread` 객체를 생성할 때 생성자 매개값으로 스레드 그룹을 지정하면 된다.

```java
Thread t = new Thread(ThreadGroup group, Runnable target);
        Thread t = new Thread(ThreadGroup group, Runnable target, String name);
        Thread t = new Thread(ThreadGroup group, Runnable target, String name, long stackSize);
        Thread t = new Thread(ThreadGroup group, String name);
```

<br>

### 스레드 그룹의 일괄 `interrupt()`

스레드 그룹에서 제공하는 `interrupt()`를 이용하면, 그룹 내에 포함된 모든 스레드들을 한번에 interrupt할 수 있다. 다만 개별 스레드에서 발생하는 `InterruptedException`에 대한 예외 처리를 제공하지 않으므로, 안전한 종료를 위해서는 개별 스레드가 예외 처리를 해야 한다.

```java
public class WorkThread extends Thread {
    public WorkThread(ThreadGroup threadGroup, String threadName) {
        super(threadGroup, threadName);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                System.out.println(getName() + " interrupted");
                break;
            }
        }
        System.out.println(getName() + " 종료됨");
    }
}
```

```java
public class ThreadGroupExample {
    public static void main(String[] args) {
        ThreadGroup myGroup = new ThreadGroup("myGroup");
        WorkThread workThreadA = new WorkThread(myGroup, "workThreadA");
        WorkThread workThreadB = new WorkThread(myGroup, "workThreadB");

        workThreadA.start();
        workThreadB.start();

        System.out.println("[ main 스레드 그룹의 list() 출력 내용 ]");
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        mainGroup.list();
        System.out.println();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException ie) {}

        System.out.println("[ myGroup 스레드 그룹의 interrupt() 호출 ]");
        myGroup.interrupt();
    }
}
```

<br>

## 스레드 풀(ThreadPool)

