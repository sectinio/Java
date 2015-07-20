/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package updatepropfile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Administrator
 */
public class UpdatePropFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        System.out.println("Working Directory = " +
              System.getProperty("user.dir"));
        
        FileInputStream input = new FileInputStream("proptext.txt");
        Properties props = new Properties();
        props.load(input);
        input.close();
        
        FileOutputStream output = new FileOutputStream("proptext.txt");
        props.setProperty("USERNAME", "douchebaddg");
        props.store(output, "noul user");
        output.close();
    }
    
}
