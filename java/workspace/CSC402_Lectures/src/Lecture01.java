import javax.swing.JOptionPane;


public class Lecture01 {
	public static void main(String args[]){
		StringBuffer s1 = new StringBuffer("abc");
		StringBuffer s2;
		s2 = s1;
		s1.append("de");
		System.out.printf("s1:%s\n",s1);
		System.out.printf("s2:%s\n",s2);
	    String reply;
		reply = JOptionPane.showInputDialog("Price for first item:");
	}
}