/**
 * Created by Dachi on 16/7/13.
 */

import java.math.BigInteger;

public class BigNumber {
    public static void main(String args[]){
        BigInteger n = BigInteger.valueOf(876543210123456789L);
        BigInteger k = new BigInteger("9876543210123456789");
        BigInteger r = BigInteger.valueOf(5).multiply(n.add(k));

    }
}
