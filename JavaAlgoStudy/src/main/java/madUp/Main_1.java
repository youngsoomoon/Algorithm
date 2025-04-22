//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) {
//        Solution sol = new Solution();
//
//        // 테스트 데이터 (예제 1)
//        int n = 999;
//        int[][] prices = {
//                {123, 25},
//                {777, 150},
//        };
//        int[] order = {1,1,2,3,5,8,777,777,777};
//        int cost = 30;
//
//        int result = sol.solution(n, prices, order, cost);
//        System.out.println("최소 비용: " + result); // 기대 출력: 2600
//    }
//}
//
//class Solution {
//    public int solution(int n, int[][] prices, int[] order, int cost) {
//        Map<Integer, Integer> priceMap = new HashMap<>();
//        Set<Integer> wantSet = new HashSet<>();
//        for (int[] p : prices) {
//            priceMap.put(p[0], p[1]);
//            wantSet.add(p[0]);
//        }
//
//        Set<Integer> mustBuySet = new HashSet<>();
//        for (int num : wantSet) {
//            if (!priceMap.containsKey(num)) {
//                mustBuySet.add(num);
//            }
//        }
//
//        Set<Integer> collected = new HashSet<>();
//        int minCost = Integer.MAX_VALUE;
//
//        for (int i = 0; i <= order.length; i++) {
//            if (i > 0) {
//                int sticker = order[i - 1];
//                if (wantSet.contains(sticker)) {
//                    collected.add(sticker);
//                }
//            }
//
//            if (!collected.containsAll(mustBuySet)) continue;
//
//            int totalCost = i * cost;
//
//            for (int sticker : wantSet) {
//                if (!collected.contains(sticker)) {
//                    totalCost += priceMap.get(sticker);
//                }
//            }
//
//            minCost = Math.min(minCost, totalCost);
//        }
//
//        return minCost;
//    }
//}