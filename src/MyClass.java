import java.util.Random;

class MyClass implements Runnable {
    private Random rnd;
    private String str;
    private String name;

    public MyClass(String str) {
        this.str = str;
        rnd = new Random();
        name = Thread.currentThread().getName();
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(rnd.nextInt(2500) + 500);
            } catch (InterruptedException e) {
            }
            System.out.println(name + ": " + str + " " + i);
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyClass("T 1"));
        Thread thread2 = new Thread(new MyClass("T 2"));

        thread1.start();
        thread2.start();
    }
}