public class task_3 {
    //Необходимо создать три потока, которые изменяют один и тот же объект.
    // Каждый поток должен вывести на экран одну букву 100 раз, и затем увеличить значение символа на 1.

    static void solution() throws InterruptedException {
        var obj = new char[]{'a'};
        var one = new Thread(() -> {
            for (int i = 1; i < 101; i++)
                synchronized (obj) {
                    System.out.println(Thread.currentThread().getName() + ": " + obj[0]);
            }
            synchronized (obj) {
                obj[0] = (char) (obj[0] + 1);
            };
        }, "one");

        var two = new Thread(() -> {
            for (int i = 1; i < 101; i++)
                synchronized (obj) {
                    System.out.println(Thread.currentThread().getName() + ": " + obj[0]);
                }
            synchronized (obj) {
                obj[0] = (char) (obj[0] + 1);
            };
        }, "two" );

        var three = new Thread(() -> {
            for (int i = 1; i < 101; i++)
                synchronized (obj) {
                    System.out.println(Thread.currentThread().getName() + ": " + obj[0]);
                }
            synchronized (obj) {
                obj[0] = (char) (obj[0] + 1);
            };
        }, "three" );

        one.start();
        two.start();
        three.start();

        one.join();
        two.join();
        three.join();
    }
}
