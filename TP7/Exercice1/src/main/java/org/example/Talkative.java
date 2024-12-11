package org.example;

public class Talkative implements Runnable {

    private  int ent;

    public Talkative(int ent){
        this.ent = ent;
    }


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Threads"+ent+" : "+ ent);

        }
    }
    public static void main(String[] args) throws InterruptedException {
        Talkative t1 = new Talkative(1);
        Talkative t2 = new Talkative(2);
        Talkative t3 = new Talkative(3);
        Talkative t4 = new Talkative(4);
        Talkative t5 = new Talkative(5);
        Talkative t6 = new Talkative(6);
        Talkative t7 = new Talkative(7);
        Talkative t8 = new Talkative(8);
        Talkative t9 = new Talkative(9);
        Talkative t10 = new Talkative(10);

        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        Thread thread3 = new Thread(t3);
        Thread thread4 = new Thread(t4);
        Thread thread5 = new Thread(t5);
        Thread thread6 = new Thread(t6);
        Thread thread7 = new Thread(t7);
        Thread thread8 = new Thread(t8);
        Thread thread9 = new Thread(t9);
        Thread thread10 = new Thread(t10);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();

  /*      for (int i = 1; i < 11; i++) {
            Talkative talkative = new Talkative(i);
            Thread thread = new Thread(talkative);
            thread.start();

            thread.join();
        }
*/

    }
}
