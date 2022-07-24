import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Priority {
    private PriorityQueue<Student> studentPriorityQueue = new PriorityQueue<>(Comparator.comparing(Student::getCgpa).reversed() // Sort CGPA by descending order
            .thenComparing(Student::getName)                                                                                    // Sort name by ascending order
            .thenComparing(Student::getId));                                                                                    // Sort ID by ascending order

    private List<Student> studentList = new ArrayList<Student>();

    public List<Student> getStudents(List<String> events){
        String[] input;
        Student student;

        Student inputStudent = new Student();

        // Iterate in the events list
        for (String event : events){
            // Split event by its whitespace
            input = event.split(" ");

            Integer id;
            String name;
            Double cgpa;

            // Serve the head student
            if (input[0].equals("SERVED")){
                studentPriorityQueue.poll();
                // Process "ENTER" command and create a new student
            }else if (input[0].equals("ENTER")){
                // Parse (ENTER NAME CGPA ID)
                id = Integer.parseInt(input[3]);
                name = input[1];
                cgpa = Double.parseDouble(input[2]);

                student = new Student(id, name, cgpa);
                studentPriorityQueue.add(student);
                // Otherwise move on to the next iteration
            }else{continue;}
        }

        // Set student to the head item of the priority queue and then add it to the list
        while (!studentPriorityQueue.isEmpty()){
            student = studentPriorityQueue.poll();
            studentList.add(student);
        }

        return studentList;
    }
}
