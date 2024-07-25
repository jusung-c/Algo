import java.util.*;
import java.util.stream.*;

class Solution {
    // 코스 클래스
    private static class Course {
        public final String course;
        public final int cnt;
        
        public Course(String course, int cnt) {
            this.course = course;
            this.cnt = cnt;
        }
    }
    
    // 재귀호출로 가능한 모든 코스 조합 찾기
    private void makeCourse(char nextMenu, Set<String> selectedMenus,
                           List<Set<String>> orderList,
                           Map<Integer, List<Course>> courses) {
        
        // 종료 조건: 2번 미만으로 등장한 메뉴는 종료
        // 현재까지 구한 코스의 등장 횟수 카운트
        int cnt = (int) orderList.stream()      // Stream<Set<String>>
            .filter(order -> order.containsAll(selectedMenus)) // Stream<Set<String>>
            .count();   // long
        if (cnt < 2) return;
        
        // 현재까지 구한 코스의 조건검증
        int size = selectedMenus.size();
        if (courses.containsKey(size)) {
            
            // 원하는 사이즈의 코스요리라면 현재까지 구한 코스를 정렬해서 코스 객체로 생성
            Course course = new Course(selectedMenus.stream()   // Stream<String>
                                      .sorted()
                                      .collect(Collectors.joining("")), cnt);
            
            // 원하는 사이즈의 기존 코스요리와 등장 횟수를 비교
            List<Course> courseList = courses.get(size);
            Course original = courseList.get(0);
            
            if (original.cnt < cnt) {
                courseList.clear();
                courseList.add(course);
            } else if (original.cnt == cnt) {
                courseList.add(course);
            }
            
        }
        
        
        // 종료 조건) 현재까지 구성한 메뉴가 10개에 도달했으면 종료
        if (size == 10) return;
            
        // 다음 메뉴 붙여가면서 재귀호출
        for (char menuChar = nextMenu; menuChar <= 'Z'; menuChar++) {
            String menu = String.valueOf(menuChar);
            selectedMenus.add(menu);
                
            makeCourse((char) (menuChar + 1), selectedMenus, orderList, courses);
                
            selectedMenus.remove(menu);
        }
    
    }
    
    public String[] solution(String[] orders, int[] course) {
        List<Set<String>> orderList = Arrays.stream(orders)   // Stream<String>
            .map(String::chars)                     // Stream<IntStream>
            .map(intStream -> intStream
                 .mapToObj(menu -> String.valueOf((char) menu))    // Stream<Stream<String>>
                 .collect(Collectors.toSet()))      // Stream<Set<String>>
            .collect(Collectors.toList());          // List<Set<String>>
            
        Map<Integer, List<Course>> courses = new HashMap<>();
        for (int length : course) {
            List<Course> list = new ArrayList<>();
            list.add(new Course("", 0));
            
            courses.put(length, list);
        }
        
        makeCourse('A', new HashSet<>(), orderList, courses);
        
        return courses.values().stream()            // Stream<List<Course>>
            .filter(list -> list.get(0).cnt > 0)    // Stream<List<Course>>
            .flatMap(List::stream)                  // Stream<Course>
            .map(c -> c.course)                     // Stream<String>
            .sorted()                               // Stream<String>
            .toArray(String[]::new);                // String[]
    }
}