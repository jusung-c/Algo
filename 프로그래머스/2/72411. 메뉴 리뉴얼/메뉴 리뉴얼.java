import java.util.*;
import java.util.stream.*;

class Solution {
    private static class Course {
        public final String course;
        public final int cnt;
        
        public Course(String course, int cnt) {
            this.course = course;
            this.cnt = cnt;
        }
    }
    
    private void getCourses(char nextMenu, Set<String> selectedMenus,
                           List<Set<String>> orderList,
                           Map<Integer, List<Course>> courses) {
        
        // 현재까지 조합한 메뉴들의 등장 횟수 카운트
        int cnt = (int) orderList.stream()
            .filter(order -> order.containsAll(selectedMenus))
            .count();
        
        // 종료 조건: 2번 미만 주문된 메뉴라면 종료
        if (cnt < 2) return;
        
        // 현재까지 구한 메뉴 구성의 수가 원하는 수인지 판단
        int size = selectedMenus.size();
        if (courses.containsKey(size)) {
            
            // 원하는 구성 메뉴의 수라면 구성한 메뉴를 Course 클래스로 생성
            Course course = new Course(selectedMenus.stream()
                                       .sorted()
                                       .collect(Collectors.joining("")), cnt);
            
            // 기존의 해당 구성 메뉴 수로 구한 메뉴와 등장 횟수(cnt)를 비교
            List<Course> courseList = courses.get(size);
            Course original = courseList.get(0);
            
            // 등장횟수가 더 많으면 기존 코스를 삭제하고 추가
            if (original.cnt < cnt) {
                courseList.clear();
                courseList.add(course);
                
            // 등장횟수가 같으면 그냥 추가    
            } else if (original.cnt == cnt) {
                courseList.add(course);
            }
        }
            
        // 종료 조건: 현재까지 구성한 메뉴의 구성 메뉴 수가 10개 이상이면 종료
        if (size >= 10) return;
        
        for (char menuChar = nextMenu; menuChar <= 'Z'; menuChar++) {
            
            // 다음 메뉴 추가
            String menu = String.valueOf(menuChar);
            selectedMenus.add(menu);
            
            // 재귀 호출
            getCourses((char) (menuChar+1), selectedMenus, orderList, courses);
            
            selectedMenus.remove(menu);
        }
        
    }
    
    public String[] solution(String[] orders, int[] course) {
        List<Set<String>> orderList = Arrays.stream(orders)     // Stream<String>
            .map(String::chars)                                 // Stream<IntStream>
            .map(charStream -> charStream                       
                 .mapToObj(menu -> String.valueOf((char) menu)) // Stream<Stream<String>>
                 .collect(Collectors.toSet()))                   // Stream<Set<String>>
            .collect(Collectors.toList());                      // List<Set<String>>
        
        Map<Integer, List<Course>> courses = new HashMap<>();
        for (int length: course) {
            List<Course> list = new ArrayList<>();
            
            // 초기화
            list.add(new Course("", 0));
            courses.put(length, list);
        }
        
        // 재귀 호출
        getCourses('A', new HashSet<>(), orderList, courses);
        
        return courses.values().stream()            // Stream<List<Course>>
            .filter(list -> list.get(0).cnt > 0)    // Stream<List<Course>>
            .flatMap(List::stream)                  // Stream<Course>
            .map(c -> c.course)                     // Stream<String>
            .sorted()                               // Stream<String>
            .toArray(String[]::new);                // String[]
        
    }
}