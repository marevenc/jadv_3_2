import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        int numberOfAccounts = 3;

        final ExecutorService threadPool = Executors.newFixedThreadPool(numberOfAccounts);
        List<Callable<Integer>> tasks = new ArrayList<>();
        tasks.add(new Account());
        tasks.add(new Account());
        tasks.add(new Account());

        int resultOfAll = 0;
        for(Future<Integer> task : threadPool.invokeAll(tasks)){
            resultOfAll += task.get();
        }
        System.out.println("Выручка по " + numberOfAccounts + " магазинам за день составила: " + resultOfAll);
        threadPool.shutdown();
    }
}
