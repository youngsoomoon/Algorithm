// package array; 패키지 선언 제거 (IDE에서 직접 실행하기 위함)

import java.util.HashMap;
import java.util.Map;

/**
 * Two Sum 문제
 * 
 * 문제: 정수 배열과 타겟 숫자가 주어졌을 때, 배열에서 두 수의 합이 타겟 숫자가 되는 인덱스 두 개를 찾아라.
 * 각 입력에 정확히 하나의 해가 있다고 가정하며, 같은 요소를 두 번 사용할 수 없다.
 * 
 * 예시:
 * 입력: nums = [2, 7, 11, 15], target = 9
 * 출력: [0, 1] (nums[0] + nums[1] = 2 + 7 = 9)
 */
public class TwoSum {
    
    /**
     * 브루트 포스 방식으로 해결 - O(n²) 시간 복잡도
     */
    public static int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {}; // 해를 찾지 못한 경우
    }
    
    /**
     * 해시맵을 사용한 최적화 방식 - O(n) 시간 복잡도
     */
    public static int[] twoSumOptimized(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i };
            }
            numMap.put(nums[i], i);
        }
        
        return new int[] {}; // 해를 찾지 못한 경우
    }
    
    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        
        // 브루트 포스 방식
        int[] resultBruteForce = twoSumBruteForce(nums, target);
        System.out.print("브루트 포스 결과: [");
        System.out.print(resultBruteForce[0] + ", " + resultBruteForce[1]);
        System.out.println("]");
        
        // 최적화 방식
        int[] resultOptimized = twoSumOptimized(nums, target);
        System.out.print("최적화 결과: [");
        System.out.print(resultOptimized[0] + ", " + resultOptimized[1]);
        System.out.println("]");
    }
} 