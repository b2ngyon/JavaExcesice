import java.io.*;
import java.util.ArrayList;

public class SchemaGenerator {
    public  static void main(String[] args) throws IOException {

        schemaObj obj = new schemaObj();
        File file = new File("C:\\Users\\Ng Yong Yau\\IdeaProjects\\JavaExcesice\\schema.txt");
        BufferedReader reader;
        reader = new BufferedReader(new FileReader(file));
        String getLine = reader.readLine();
        obj.className = getLine.split(",")[0];
        obj.classDesc = getLine.split(",")[1];
        getLine = reader.readLine();
        while( getLine != null) {
            obj.objList.add(getLine.split(",")[0]);
            obj.loc.add(Integer.parseInt(getLine.split(",")[1]));
            obj.loc.add(Integer.parseInt(getLine.split(",")[2]));

            getLine = reader.readLine();


        }
        reader.close();
        String show = "/*" + obj.classDesc +" */ public class  "+obj.className + " { \n";
        for(int i=0;i<obj.objList.size();i++)
        {
            show = show + "public String " +obj.objList.get(i)+";\n";
        }

        show = show +"}";

        String showDeser = "public class "+obj.className+"Deserialiser { "+"\n\tpublic  "+obj.className +" parse(String linefeed){"
                +"\n\t\t "+obj.className+" record = new "+obj.className+"();\n";
        for (int k = 0; k < obj.loc.size(); k++) {
            for(int j=0;j<obj.objList.size();j++){
                showDeser = showDeser + "\t\trecord." + obj.objList.get(j) + "=linefeed.substring(" + (obj.loc.get(k)-1) + "," + obj.loc.get(k + 1) + ").trim();\n";
                k=k+2;
            }
        }
        showDeser = showDeser+"\n\t\treturn record;\n\t}\n}";

    System.out.println(showDeser);
    FileOutputStream out = new FileOutputStream("C:\\Users\\Ng Yong Yau\\IdeaProjects\\JavaExcesice\\src\\"+obj.className.concat(".java"));
    out.write(show.getBytes());
    out.flush();
    out.close();

    /*output another class file*/
    FileOutputStream out2 = new FileOutputStream("C:\\Users\\Ng Yong Yau\\IdeaProjects\\JavaExcesice\\src\\"+obj.className.concat("Deserialiser.java"));
    out2.write(showDeser.getBytes());
    out2.flush();
    out2.close();


    }


    public static class schemaObj
    {
        private String className;
        private String classDesc;
        private ArrayList<String> objList = new ArrayList<>();
        private ArrayList<Integer> loc = new ArrayList<>();
    }
}
