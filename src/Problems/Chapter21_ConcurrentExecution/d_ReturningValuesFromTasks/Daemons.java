package Problems.Chapter21_ConcurrentExecution.d_ReturningValuesFromTasks;

import java.util.concurrent.TimeUnit;

/**
 * @author SashaKhyzhun on 9/12/17.
 * Потомки демоны порождають других демонов.
 * Page 907.
 */

class Daemon implements Runnable {
    private Thread[] t = new Thread[10];
    @Override public void run() {
        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
            System.out.println("DaemonSpawn " + i + " started, ");
        }
        for (int i = 0; i < t.length; i++) {
            System.out.println("t[" + i + "].isDaemon() = " + t[i].isDaemon());
        }
        while (true) {
            Thread.yield();
        }
    }
}
class DaemonSpawn implements Runnable {
    @Override public void run() {
        while (true) Thread.yield();
    }
}

public class Daemons {
    public static void main(String[] args) throws Exception {
        Thread d = new Thread(new Daemon());
        d.setDaemon(true);
        d.start();
        System.out.println("d.isDaemon() = " + d.isDaemon() + ", ");
        // Дать возможность потокам-демонам
        // завершить их стартовые процессы:
        TimeUnit.SECONDS.sleep(1);
    }
}