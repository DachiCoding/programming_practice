/**
 * Created by Dachi on 16/7/17.
 */

interface IntSeqeuence {
    boolean hasNext();
    int next();
}

class SqaureSequence implements IntSeqeuence {
    private int i;

    public boolean hasNext(){
        return true;
    }

    public int next(){
        i++;
        return i * i;
    }
}

class DigitSequence implements IntSeqeuence {
    private int number;

    public DigitSequence(int n){
        number = n;
    }

    public boolean hasNext(){
        return number != 0;
    }

    public int next(){
        int result = number % 10;
        number /= 10;
        return result;
    }

    public int rest(){
        return number;
    }
}

public class InterfaceTest {
}
