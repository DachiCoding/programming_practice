
public class Final {
	public static void main(String args[]){
		int s = 0;
		int n = 10;
		int sumCnt = 0;
		int mulCnt = 0;
		for(int i = 0; i < n;i++){
			sumCnt++;
			for(int j = 0;j < i;j++){
				sumCnt++;
				mulCnt++;
			}
		}
		sumCnt++;
		System.out.printf("sum: %d mul: %d",sumCnt,mulCnt);
	}
}
