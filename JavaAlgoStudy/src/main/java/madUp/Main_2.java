//public class Main {
//    static int minSum = Integer.MAX_VALUE;
//    static int R, C;
//
//    public static void main(String[] args) {
//        int[][] grid1 = {
//                {1, 2},
//                {3, 4}
//        };
//
//        int[][] grid2 = {
//                {1, 8, 3, 2},
//                {7, 4, 6, 5}
//        };
//
//        System.out.println(findMinPath(grid1)); // 출력: 7
//        System.out.println(findMinPath(grid2)); // 출력: 19
//    }
//
//    public static int findMinPath(int[][] grid) {
//        R = grid.length;
//        C = grid[0].length;
//        minSum = Integer.MAX_VALUE;
//        dfs(grid, 0, 0, grid[0][0]);
//        return minSum;
//    }
//
//    // i, j: 현재 위치 / sum: 지금까지 누적된 합
//    public static void dfs(int[][] grid, int i, int j, int sum) {
//        if (sum >= minSum) return; // 가지치기
//
//        if (i == R - 1 && j == C - 1) { // 도착
//            minSum = Math.min(minSum, sum);
//            return;
//        }
//
//        // 오른쪽
//        if (j + 1 < C) {
//            dfs(grid, i, j + 1, sum + grid[i][j + 1]);
//        }
//
//        // 아래
//        if (i + 1 < R) {
//            dfs(grid, i + 1, j, sum + grid[i + 1][j]);
//        }
//    }
//}