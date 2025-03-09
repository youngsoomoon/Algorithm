# Java 알고리즘 학습 프로젝트

이 프로젝트는 Java 8을 기반으로 코딩 테스트와 알고리즘 문제 해결 능력을 향상시키기 위한 학습 자료입니다.

## 프로젝트 구조

```
JavaAlgoStudy/
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── array/        # 배열 관련 알고리즘
│   │       ├── string/       # 문자열 처리 알고리즘
│   │       ├── dp/           # 동적 프로그래밍
│   │       ├── graph/        # 그래프 알고리즘
│   │       ├── tree/         # 트리 자료구조 알고리즘
│   │       ├── sort/         # 정렬 알고리즘
│   │       ├── search/       # 탐색 알고리즘
│   │       └── implementation/ # 구현 문제
│   └── test/
│       └── java/            # 테스트 코드
├── pom.xml                  # Maven 프로젝트 설정
└── README.md                # 프로젝트 설명
```

## 개발 환경

- Java 8 (JDK 1.8)
- Maven 3.6+
- JUnit 5 (테스트용)

## 알고리즘 카테고리

1. **배열(Array)**: 배열 조작, 슬라이딩 윈도우, 투 포인터 등
2. **문자열(String)**: 문자열 처리, 패턴 매칭, 정규식 등
3. **동적 프로그래밍(DP)**: 메모이제이션, 타뷸레이션 등
4. **그래프(Graph)**: BFS, DFS, 다익스트라, 벨만-포드, 플로이드-워셜 등
5. **트리(Tree)**: 이진 트리, 이진 탐색 트리, 힙 등
6. **정렬(Sort)**: 퀵 정렬, 병합 정렬, 힙 정렬 등
7. **탐색(Search)**: 이진 탐색, 깊이/너비 우선 탐색 등
8. **구현(Implementation)**: 시뮬레이션, 구현 문제 등

## 사용 방법

1. 이 저장소를 클론합니다.
2. Maven을 사용하여 의존성을 설치합니다: `mvn install`
3. 각 알고리즘 카테고리 폴더에서 예제 코드를 확인하고 학습합니다.
4. 새로운 알고리즘 문제를 해결하고 적절한 폴더에 추가합니다.

## 컴파일 및 실행 방법

1. 프로젝트 루트 디렉토리에서 다음 명령어로 컴파일합니다:

   ```
   mvn compile
   ```

2. 특정 클래스를 실행하려면 다음 명령어를 사용합니다:
   ```
   mvn exec:java -Dexec.mainClass="array.TwoSum"
   ```

## 참고 자료

- [백준 온라인 저지](https://www.acmicpc.net/)
- [프로그래머스](https://programmers.co.kr/)
- [LeetCode](https://leetcode.com/)
- [GeeksforGeeks](https://www.geeksforgeeks.org/)
