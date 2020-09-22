import java.util.concurrent.Callable;
import java.util.concurrent.atomic.LongAdder;

public class Account implements Callable {
    Integer [] proceeds = new Integer[50];

    LongAdder stat = new LongAdder();

    public Account(LongAdder stat){
        for(int i = 0; i < proceeds.length; i++){
            proceeds[i] = (int) Math.round((Math.random() * 200));
            stat.add(proceeds[i]);
        }
    }

    public Integer[] call(){
        return proceeds;
    }
}
