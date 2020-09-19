import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.LongAdder;

public class Account implements Callable {
    int [] proceeds = new int[50];

    public Account(){
        for(int i = 0; i < proceeds.length; i++){
            proceeds[i] = (int) Math.round((Math.random() * 200));
        }
    }

    public Integer call(){
        LongAdder stat = new LongAdder();
        return Arrays.stream(proceeds).sum();
    }
}
