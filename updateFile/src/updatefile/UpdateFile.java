/*
 Trying to update a row in a file and keeping the line number
 */
package updatefile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.List;

/**
 *
 * @author Valentin Badita
 */
public class UpdateFile {

    /*
    
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String newValue = "Valentin";
        int line = 0;
        File input = new File ("input.txt");
        List<String> lines = Files.readAllLines(input.toPath());
        for (String tempString: lines)
        {
           if(tempString.startsWith("USERNAME"))
           {
               line=lines.indexOf(tempString);
           }
           
        }
        lines.set(line, "USERNAME=" + newValue);
        Files.write(input.toPath(), lines);
        System.out.println(line);
    }
    
}
