import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n, k , x;
		
		n = sc.nextInt();
		k = sc.nextInt();
		int[] scoreArr = new int[n];
		
		for(int i=0; i<scoreArr.length; i++) {
			scoreArr[i] = sc.nextInt();
		}
		sc.close();
		
		for(int i=1; i<scoreArr.length; i++) {
			int key = scoreArr[i];
			int j = i-1;
			
			while(j>=0 && scoreArr[j]<key) {
				scoreArr[j+1] = scoreArr[j];
				j--;
			}
			scoreArr[j+1] = key;
		}

		System.out.println(scoreArr[k-1]);    
	}
}
