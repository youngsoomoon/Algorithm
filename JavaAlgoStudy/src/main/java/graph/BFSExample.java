// package graph; 패키지 선언 제거 (IDE에서 직접 실행하기 위함)

import java.util.*;

/**
 * 너비 우선 탐색(BFS) 예제
 * 
 * 문제: 주어진 그래프에서 시작 노드로부터 모든 노드를 BFS로 탐색하라.
 * BFS는 큐를 사용하여 현재 노드와 인접한 모든 노드를 먼저 방문한 후, 
 * 그 다음 레벨의 노드들을 방문하는 방식으로 동작한다.
 * 
 * 응용: 최단 경로 찾기, 네트워크 분석, 웹 크롤링 등
 */
public class BFSExample {
    
    // 인접 리스트를 사용한 그래프 표현
    private Map<Integer, List<Integer>> graph;
    
    public BFSExample() {
        graph = new HashMap<>();
    }
    
    /**
     * 그래프에 노드 추가
     */
    public void addNode(int node) {
        graph.putIfAbsent(node, new ArrayList<>());
    }
    
    /**
     * 그래프에 간선 추가 (양방향)
     */
    public void addEdge(int source, int destination) {
        // 양방향 그래프이므로 양쪽에 추가
        graph.putIfAbsent(source, new ArrayList<>());
        graph.putIfAbsent(destination, new ArrayList<>());
        
        graph.get(source).add(destination);
        graph.get(destination).add(source);
    }
    
    /**
     * BFS 탐색 구현
     */
    public List<Integer> bfs(int start) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        
        // 시작 노드를 방문 처리하고 큐에 추가
        visited.add(start);
        queue.add(start);
        
        while (!queue.isEmpty()) {
            // 큐에서 노드를 하나 꺼내서 결과에 추가
            int current = queue.poll();
            result.add(current);
            
            // 현재 노드의 인접 노드들을 방문
            List<Integer> neighbors = graph.getOrDefault(current, Collections.emptyList());
            for (int neighbor : neighbors) {
                // 방문하지 않은 인접 노드만 큐에 추가
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        
        return result;
    }
    
    /**
     * 두 노드 사이의 최단 경로 찾기 (BFS 응용)
     */
    public List<Integer> findShortestPath(int start, int end) {
        // 이전 노드를 추적하기 위한 맵
        Map<Integer, Integer> parentMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        
        // 시작 노드 처리
        visited.add(start);
        queue.add(start);
        
        boolean found = false;
        
        // BFS 탐색
        while (!queue.isEmpty() && !found) {
            int current = queue.poll();
            
            // 목표 노드를 찾았으면 종료
            if (current == end) {
                found = true;
                break;
            }
            
            // 인접 노드 탐색
            List<Integer> neighbors = graph.getOrDefault(current, Collections.emptyList());
            for (int neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                    parentMap.put(neighbor, current); // 경로 추적을 위해 부모 노드 저장
                }
            }
        }
        
        // 경로가 없는 경우
        if (!found) {
            return Collections.emptyList();
        }
        
        // 경로 재구성
        List<Integer> path = new ArrayList<>();
        int current = end;
        
        while (current != start) {
            path.add(current);
            current = parentMap.get(current);
        }
        
        path.add(start);
        Collections.reverse(path); // 시작 -> 끝 순서로 변경
        
        return path;
    }
    
    public static void main(String[] args) {
        BFSExample graph = new BFSExample();
        
        // 그래프 생성
        for (int i = 0; i < 8; i++) {
            graph.addNode(i);
        }
        
        // 간선 추가
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);
        graph.addEdge(3, 7);
        graph.addEdge(5, 7);
        
        // BFS 탐색 결과 출력
        System.out.println("BFS 탐색 결과 (시작 노드: 0):");
        List<Integer> bfsResult = graph.bfs(0);
        System.out.println(bfsResult);
        
        // 최단 경로 찾기
        System.out.println("\n노드 0에서 노드 7까지의 최단 경로:");
        List<Integer> shortestPath = graph.findShortestPath(0, 7);
        System.out.println(shortestPath);
    }
} 