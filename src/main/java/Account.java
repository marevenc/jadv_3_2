import java.util.concurrent.Callable;
import java.util.concurrent.atomic.LongAdder;

public class Account implements Callable {
    LongAdder stat;
    Integer [] proceeds = new Integer[50];

    public Account(LongAdder stat){
            this.stat = stat;
    }

    public Integer[] call(){
        for(int i = 0; i < proceeds.length; i++) {
            proceeds[i] = (int) Math.round((Math.random() * 200));
            stat.add(proceeds[i]);
        }
        return proceeds;
    }
}
