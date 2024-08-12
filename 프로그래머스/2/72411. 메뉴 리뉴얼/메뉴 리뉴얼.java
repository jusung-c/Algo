import java.util.*;
import java.util.stream.*;

class Solution {
    private static class Course {
        private final String course;
        private final int cnt;

        public Course(String course, int cnt) {
            this.course = course;
            this.cnt = cnt;
        }
    }

    private void getCourses(char next, Set<String> selected,
                            List<Set<String>> orderList,
                            Map<Integer, List<Course>> courses) {
        // 종료 조건 1) 최소 2번 이상 함께 주문된 메뉴가 아닌 경우
        int count = (int) orderList.stream()
                .filter(o -> o.containsAll(selected))
                .count();
        if (count < 2) return;

        // 현재까지 만든 코스 조건 검증 후 추가
        int length = selected.size();
        if (courses.containsKey(length)) {
            Course course = new Course(selected.stream()
                    .sorted()
                    .collect(Collectors.joining("")), count);

            List<Course> courseList = courses.get(length);
            Course original = courseList.get(0);

            // 코스 요리의 수가
            if (original.cnt < count) {
                courseList.clear();
                courseList.add(course);
            } else if (original.cnt == count) {
                courseList.add(course);
            }
        }

        // 종료 조건 2) 현재까지 구성한 코스의 메뉴 수가 10개 이상이면 종료
        if (length >= 10) return;

        // 재귀 구현
        for (char menu = next; menu <= 'Z'; menu++) {
            selected.add(String.valueOf(menu));

            getCourses((char) (menu + 1), selected, orderList, courses);

            selected.remove(String.valueOf(menu));
        }
    }

    public String[] solution(String[] orders, int[] course) {
        List<Set<String>> orderList = Arrays.stream(orders)
                .map(String::chars)
                .map(c -> c.mapToObj(menu -> String.valueOf((char) menu))
                        .collect(Collectors.toSet()))
                .collect(Collectors.toList());

        Map<Integer, List<Course>> courses = new HashMap<>();
        for (int length : course) {
            List<Course> list = new ArrayList<>();

            list.add(new Course("", 0));
            courses.put(length, list);
        }

        getCourses('A', new HashSet<>(), orderList, courses);

        return courses.values().stream()                // Stream<List<Course>>
                .filter(list -> list.get(0).cnt > 0)    // Stream<List<Course>>
                .flatMap(List::stream)                  // Stream<Course>
                .map(c -> c.course)                     // Stream<String>
                .sorted()                               // Stream<String>
                .toArray(String[]::new);                // String[]
    }
}