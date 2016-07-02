
public class Ch1_SelfTest {
 public static void convertGravity(double weight){
	 double moonWeight;
	 double moonConvert = 0.17;
	 moonWeight = moonConvert * weight;
	 System.out.println("Your weight on the moon is " + moonWeight);
 }
 
 public static void main(String[] args){
	 convertGravity(84.4);
 }
}
