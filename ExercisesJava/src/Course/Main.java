package Course;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Map<String,Courses> courses = new HashMap<>();
        String line;



        while (!"end".equals(line = sc.nextLine())){
            String [] input = line.split(":");
            String courseName = input[0].trim();
            String studentName = input[1].trim();
            Students student = new Students(studentName);

            if (courses.containsKey(courseName)){
                courses.get(courseName).AddStudents(student);
            }
            else{
                List<Students> newStudents = new ArrayList<>();
                Courses courses1 = new Courses();
                courses1.SetStudents(newStudents);
                courses1.AddStudents(student);
                courses1.SetCourseName(courseName);
                courses.put(courseName,courses1);
            }
        }
        List<Courses> listCourse = new ArrayList<>();
        for (Map.Entry<String,Courses> course: courses.entrySet()) {
            listCourse.add(course.getValue());
        }
        Collections.sort(listCourse);
        Collections.reverse(listCourse);

        for (Courses course: listCourse) {
            course.SortStudents();

            System.out.printf("%s : %d%n",course.GetCourseName(),course.GetStudentsCount());

            for (Students studentList: course.GetStudents()) {
                System.out.println("-- "+studentList.GetName());
            }


        }
    }
}
