import java.util.concurrent.atomic.AtomicInteger;

public class task_5 {
    //В системах, допускающих ожидание потоков, могут возникнуть две проблемы:
    // взаимоблокировка, когда один или несколько потоков будут вечно ожидать события, которое не может произойти,
    // и отсрочка на неопределенный срок, при которой один или несколько потоков будут ожидать событие,
    // которое не может произойти.
    // Приведите пример того, как каждая из этих проблем может возникнуть в многопоточных программах на Java.
    static void _1(){

        Object obj_one = new Object();
        Object obj_two = new Object();

        var one = new Thread(() -> {
            synchronized (obj_one) {
                System.out.println(Thread.currentThread().getName() + " get lock obj_one.");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (obj_two){
                    System.out.println(Thread.currentThread().getName() + " get lock obj_two.");
                }
                System.out.println(Thread.currentThread().getName() + " release lock obj_two.");
            }
            System.out.println(Thread.currentThread().getName() + " release obj_one.");
        });

        var two = new Thread(() -> {
            synchronized (obj_two) {
                System.out.println(Thread.currentThread().getName() + " get lock obj_two.");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (obj_one){
                    System.out.println(Thread.currentThread().getName() + " get lock obj_one.");
                }
                System.out.println(Thread.currentThread().getName() + " release lock obj_one.");
            }
            System.out.println(Thread.currentThread().getName() + " release obj_two.");
        });

        one.start();
        two.start();
    }

    static void _2(){

        Object obj = new Object();
        AtomicInteger number = new AtomicInteger(0);

        var one = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " start.");
            for (var i = 0; i < 10; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (obj) {
                    number.set(i);
                    obj.notify();
                }
            }
            System.out.println(Thread.currentThread().getName() + " finished.");
        });

        var two = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " start.");
            while (true) {
                synchronized (obj) {
                    try {
                        obj.wait(); // Поток больше никто не будит, поэтому после печати цифр 0-9 поток будет висеть
                        // до тех пор, пока консольное приложение не будет остановлено.
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(number.get());
                }
            }
        });

        one.start();
        two.start();

    }
}

