package madUp;

public class Main {
    public static int solution(int m, int k, int a, int b, int[] timetable) {
        int time = 0;
        int i = 0;

        while (i < timetable.length) {
            int startDay = timetable[i];
            int endDay = startDay + k - 1;

            // i번째 수업부터 k일 안에 있는 수업 세기
            int count = 0;
            int j = i;
            while (j < timetable.length && timetable[j] <= endDay) {
                count++;
                j++;
            }

            int withoutMaterial = b * count;
            int withMaterial = m + a * count;

            // 더 싼 방법 선택
            if (withMaterial < withoutMaterial) {
                time += withMaterial;
                i = j; // 이 그룹은 전부 처리했으므로 다음 수업으로 이동
            } else {
                time += b; // 하나만 처리
                i++;       // 다음 수업으로 이동
            }
        }

        return time;
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 4, 1, 2, new int[]{1, 2, 3, 4, 5})); // 8
        System.out.println(solution(2, 2, 1, 2, new int[]{1, 2, 2, 12, 12, 13})); // 10
        System.out.println(solution(10, 3, 1, 10, new int[]{1, 2, 3, 10, 21, 22, 23})); // 36
    }
}
