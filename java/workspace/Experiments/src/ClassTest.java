/**
 * Created by Dachi on 16/7/2.
 */

class Puppy {
    int puppyAge;

    public Puppy(String name){
        System.out.println("Passed name is :" + name);
    }

    public void setAge(int age){
        puppyAge = age;
    }

    public int getAge(){
        System.out.println("Puppy's age is :" + puppyAge);
        return puppyAge;
    }

}

public class ClassTest {
    public static void main(String args[]){
        Puppy myPuppy = new Puppy("tommy");
        myPuppy.setAge(2);
        myPuppy.getAge();
    }
}
