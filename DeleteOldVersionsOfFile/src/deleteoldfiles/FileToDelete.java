
/*
* Created by Valentin Badita
 */
package deleteoldfiles;

//~--- JDK imports ------------------------------------------------------------

import java.io.*;

import java.util.regex.*;


/**
 *
 * @author valentin-diana
 * Fiecare fisier din director va fi un obiect de tipul FileToDelete
 * Prin instantiere, membrii Prefix si Sufix vor fi instantiati cu valorile
 * corespunzatoare
 */

public class FileToDelete extends File  implements Sterge {
    private String FileName;
    private String Prefix;
    private Integer Sufix;

    public FileToDelete(File f) {
        super(f, "");
        FileName = f.getName();
        setSufixPrefix();
         if(!this.isDirectory()){
        setSufixPrefix();
        }
        
    }

    public FileToDelete(String s) {
        super(s);
        FileName = s;
        if(!this.isDirectory()){
        setSufixPrefix();
        }
    }

    private String returnPrefix() {
        Pattern p = Pattern.compile("[a-zA-Z_54.]*");
        Matcher m = p.matcher(FileName);

        if (m.find()) {
            return m.group();
        }

        return "Nothing";
    }

    private void setSufixPrefix() {
        Prefix = returnPrefix();
        String StringSufix;
        String IntermediarSufix = FileName.replace(Prefix, "");

        StringSufix = IntermediarSufix.replace(".jar", "");
try {        Sufix = Integer.parseInt(StringSufix);}
catch(NumberFormatException e ){
        System.out.println("Uita-te la fisiere");
        }
}
    

    public Integer getSufix() {
        return Sufix;
    }

    public String getPrefix() {
        return Prefix;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
