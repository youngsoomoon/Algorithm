// package dp; 패키지 선언 제거 (IDE에서 직접 실행하기 위함)

import java.util.HashMap;
import java.util.Map;

/**
 * 피보나치 수열 문제
 * 
 * 문제: n번째 피보나치 수를 구하라.
 * 피보나치 수열은 다음과 같이 정의됩니다:
 * F(0) = 0, F(1) = 1
 * F(n) = F(n-1) + F(n-2), n > 1
 * 
 * 예시:
 * 입력: n = 5
 * 출력: 5 (피보나치 수열: 0, 1, 1, 2, 3, 5, 8, 13, ...)
 */
public class Fibonacci {
    
    /**
     * 재귀 방식으로 구현 - O(2^n) 시간 복잡도
     */
    public static int fibRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }
    
    /**
     * 메모이제이션(Top-down DP) 방식으로 구현 - O(n) 시간 복잡도
     */
    public static int fibMemoization(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return fibMemoHelper(n, memo);
    }
    
    private static int fibMemoHelper(int n, Map<Integer, Integer> memo) {
        if (n <= 1) {
            return n;
        }
        
        // 이미 계산된 값이 있으면 재사용
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        
        // 계산 후 메모에 저장
        int result = fibMemoHelper(n - 1, memo) + fibMemoHelper(n - 2, memo);
        memo.put(n, result);
        return result;
    }
    
    /**
     * 타뷸레이션(Bottom-up DP) 방식으로 구현 - O(n) 시간 복잡도
     */
    public static int fibTabulation(int n) {
        if (n <= 1) {
            return n;
        }
        
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    }
    
    /**
     * 공간 최적화된 방식으로 구현 - O(n) 시간 복잡도, O(1) 공간 복잡도
     */
    public static int fibOptimized(int n) {
        if (n <= 1) {
            return n;
        }
        
        int prev = 0;
        int current = 1;
        
        for (int i = 2; i <= n; i++) {
            int next = prev + current;
            prev = current;
            current = next;
        }
        
        return current;
    }
    
    public static void main(String[] args) {
        int n = 10;
        
        System.out.println("재귀 방식: " + fibRecursive(n));
        System.out.println("메모이제이션 방식: " + fibMemoization(n));
        System.out.println("타뷸레이션 방식: " + fibTabulation(n));
        System.out.println("최적화 방식: " + fibOptimized(n));
        
        // 성능 비교 (큰 n 값에서는 재귀 방식은 매우 느림)
        int largeN = 40;
        
        long startTime = System.currentTimeMillis();
        int result1 = fibMemoization(largeN);
        long endTime = System.currentTimeMillis();
        System.out.println("메모이제이션 (n=" + largeN + "): " + result1 + ", 시간: " + (endTime - startTime) + "ms");
        
        startTime = System.currentTimeMillis();
        int result2 = fibTabulation(largeN);
        endTime = System.currentTimeMillis();
        System.out.println("타뷸레이션 (n=" + largeN + "): " + result2 + ", 시간: " + (endTime - startTime) + "ms");
        
        startTime = System.currentTimeMillis();
        int result3 = fibOptimized(largeN);
        endTime = System.currentTimeMillis();
        System.out.println("최적화 (n=" + largeN + "): " + result3 + ", 시간: " + (endTime - startTime) + "ms");
    }
} 