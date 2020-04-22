import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.File;

public class Main {

    static int countLine = 0;
    static String inputSearch = "inputSearch";
    static String line = "";
    static String[] temp = { "", "", "", "" };

    public static void main(String[] args) {
        String fileListPath = "C:\\Java\\test.txt";
        BufferedReader mainBr;
        String indifilePath = "";
        try {
            mainBr = new BufferedReader(new FileReader(fileListPath));
            PrintStream o = new PrintStream(new File("Output.txt")); 
          
            System.setOut(o);
            try {
               
                while ((indifilePath = mainBr.readLine()) != null) {
                

                    findInFile(indifilePath);
                }
                mainBr.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void findInFile(String path) {
        int countLine = 0;
        BufferedReader br;
        line = "";
        try {
           File file = new File(path);
           FileReader fileReader = new FileReader(file);
            br = new BufferedReader(fileReader);
            try {
                while ((line = br.readLine()) != null) {
                    countLine++;
                    line = line.trim();
                    if (line.contains(inputSearch)) {
                        try {
                            System.out.println(file.getName()+   "\t " + countLine + "\t " + temp[0] + "\t" + temp[1] + "\t"
                                    + temp[2] + "\t" + temp[3]);
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Exception In " + "line n  " + countLine + " " + path);
                        }
                        countLine++;
                    }
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            
           e.printStackTrace();
    
        }
    }

}