import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        StudentDeserialiser studentParseFunc = new StudentDeserialiser();

        File file = new File("C:\\Users\\Ng Yong Yau\\IdeaProjects\\JavaExcesice\\sample_input.txt");
        BufferedReader reader;
        reader = new BufferedReader(new FileReader(file));
        String getLine = reader.readLine();

       ArrayList<Student> stud = new ArrayList<>();
        while( getLine != null) {
          stud.add(studentParseFunc.parse(getLine));
            getLine = reader.readLine();

        }
        reader.close();
        for(Student stu: stud)
        {
            System.out.println("\nFirstName: "+stu.firstName+"\nLastName: "+stu.lastName+"\nLevel: "+stu.level+"\nstudentClass: "+stu.studentClass);
        }
    }

}
