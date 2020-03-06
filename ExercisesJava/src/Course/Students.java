package Course;

public class Students implements Comparable<Students> {
    private String name;
    public Students(String name){
        this.name =name;
    }
    public String GetName(){
      return this.name;
    }
    @Override
    public int compareTo(Students st) {
        return this.GetName().compareTo(st.GetName());
    }


}
