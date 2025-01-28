import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        
        int[] height = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }
        
        // 왼쪽과 오른쪽 최대 높이 배열 생성
        int[] leftMax = new int[W];
        int[] rightMax = new int[W];
        
        // 왼쪽 최대 높이 계산
        leftMax[0] = height[0];
        for (int i = 1; i < W; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        
        // 오른쪽 최대 높이 계산
        rightMax[W - 1] = height[W - 1];
        for (int i = W - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        
        // 빗물 계산
        int water = 0;
        for (int i = 0; i < W; i++) {
            int minHeight = Math.min(leftMax[i], rightMax[i]);
            if (minHeight > height[i]) {
                water += minHeight - height[i];
            }
        }
        
        System.out.println(water);
    }
}