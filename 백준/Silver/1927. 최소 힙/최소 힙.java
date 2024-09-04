import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> que = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			int val = Integer.parseInt(br.readLine());
			
			if(val == 0) {
				if(que.isEmpty())
					System.out.println("0");
				else
					System.out.println(que.poll());
			}
			else
				que.add(val);
		}
	}
}