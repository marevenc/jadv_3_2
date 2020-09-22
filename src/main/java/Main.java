import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.LongAdder;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        int numberOfAccounts = 3;
        LongAdder stat = new LongAdder();

        final ExecutorService threadPool = Executors.newFixedThreadPool(numberOfAccounts);
        List<Callable<Integer>> tasks = new ArrayList<>();
        tasks.add(new Account(stat));
        tasks.add(new Account(stat));
        tasks.add(new Account(stat));

        List<Future<Integer>> futures = threadPool.invokeAll(tasks);

        System.out.println("Выручка по " + numberOfAccounts + " магазинам за день составила: " + stat.sum());
        threadPool.shutdown();
    }
}
