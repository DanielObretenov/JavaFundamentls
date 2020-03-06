package Course;
import java.util.*;

public class Courses implements Comparable<Courses>{
    private String courseName;
    private List<Students> students =new ArrayList<>();

    public void SetCourseName(String name){
        this.courseName= name;
    }
    public String GetCourseName(){

        return this.courseName;
    }

    public void SetStudents(List<Students> students){
      this.students = students;
    }
    public void AddStudents(Students student){
        students.add(student);
    }
    public List<Students>  GetStudents(){
        return this.students;
    }
    public void SortStudents(){
        Collections.sort(this.students);
    }
    public Integer GetStudentsCount(){
        return this.students.size();
    }



    @Override
    public int compareTo(Courses o) {
        return this.GetStudentsCount().compareTo(o.GetStudentsCount());
    }


}


