import java.util.HashMap;
import java.util.Map;

/**
 * TwoSum 문제를 IDE에서 직접 실행하기 위한 독립적인 파일
 * 원본 코드와 동일한 기능을 제공합니다.
 */
public class TwoSumRunner {
    
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
        
        System.out.println("\n이 파일은 IDE에서 직접 실행하기 위한 독립적인 파일입니다.");
        System.out.println("원본 코드는 src/main/java/array/TwoSum.java에 있습니다.");
    }
} 