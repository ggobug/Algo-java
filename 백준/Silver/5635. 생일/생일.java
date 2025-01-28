import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Student[] students = new Student[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            LocalDateTime birth = LocalDateTime.of(year, month, day, 0, 0);
            students[i] = new Student(name, birth);
        }

        int oldest = 0, youngest = 0;
        for (int i = 1; i < n; i++) {
            if (students[oldest].birth.isAfter(students[i].birth)) {
                oldest = i;
            }
            if (students[youngest].birth.isBefore(students[i].birth)) {
                youngest = i;
            }
        }
        System.out.println(students[youngest].name);
        System.out.println(students[oldest].name);
    }

    static class Student {
        String name;
        LocalDateTime birth;

        public Student(String name, LocalDateTime birth) {
            this.name = name;
            this.birth = birth;
        }
    }
}
