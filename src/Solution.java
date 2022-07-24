import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priority priorities = new Priority();

    public static void main(String[] args) {
        // Gets the input from user
        Integer totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }
}
