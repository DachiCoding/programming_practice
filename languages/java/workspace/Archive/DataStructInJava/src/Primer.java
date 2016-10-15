/**
 * Created by Dachi on 16/7/23.
 * Data structures and algorithm in Java 6th ed
 * Chapter 01
 */

class Counter {
    private int count;
    public Counter(){}
    public Counter(int initial) {count = initial;}
    public int getCount() {return count;}
    public void increment() { count++; }
    public void increment(int delta) { count += delta; }
    public void reset() { count = 0; }
}

public class Primer {

    public static void PrimitiveTypes(){
        //Java primitive types
        boolean flag = true;
        boolean verbose, debug;
        char grade = 'A';
        byte b = 12;
        short s = 24;
        int i,j,k = 257;
        long l = 890L;
        float pi = 3.1416F;
        double e = 2.71828, a = 6.022e23;
    }

    public static void CounterExample(){
        //A running example of class Counter
        Counter c; //Establish the identifier, does not create a instance
        c = new Counter();
        System.out.println(c);
        c.increment();
        c.increment(3);
        int temp = c.getCount();
        System.out.println(temp);
        c.reset();
        Counter d = new Counter(5);
        d.increment();
        Counter e = d;
        temp = e.getCount();
        System.out.println(temp);
        e.increment();
    }

    public static void WrapperExample(){
        Boolean b = new Boolean(true);
        System.out.println(b.booleanValue());
    }

    public static void main(String[] args){

        //CounterExample();
        WrapperExample();



    }
}
