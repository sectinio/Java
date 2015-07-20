
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package deleteoldfiles;

//~--- JDK imports ------------------------------------------------------------

import java.io.*;

import java.util.*;

/**
 *
 * @author valentin-diana
 */
public class DeleteOldFIles {

    /**
     *
     */
    public static void main(String[] args) {
        //O metoda nu prea sanatoasa de programare, nefiind in spiritul OOP
        //probabil doar clasa FileToDelete
        String input;
        if(args.length==0)
        {
            input=".";
        }
        else
            input=args[0];
        
        FileToDelete             directory     = new FileToDelete(input);
        File[]                   listDirectory = directory.listFiles();
        //un tablou continand toate fisiere din director;
        int                      i             = listDirectory.length;
        //numarul de fisiere, avem nevoie de el;
        FileToDelete[]           fisier        = new FileToDelete[i];
        //un tablou de tipul FileToDelete
        List<FileToDelete>       listamea      = new ArrayList<>();
        //o lista adaugand fisierele
        List<FileToDelete>       listamea1     = new ArrayList<>();
        List<List<Integer>>      max;
        //Pastram sufixele de tip Integer 
        Set<String>              prefixSet = new HashSet<>();
        //un Set cu prefixe distincte
        List<List<FileToDelete>> group;
        //un tabliu multidimensional avand ca prima dimensiune prefixul distinct 
        // iar a doua dimensiune sufixul;

        // for (int k=0;k<=i-1;k++)
        for (File j : listDirectory) {

            // fisier[k]=null;
            FileToDelete m = new FileToDelete(j);

            listamea.add(m);
        }

        for (FileToDelete k : listamea) {
            prefixSet.add(k.getPrefix());
        }

        group = new ArrayList<>(prefixSet.size());
        max   = new ArrayList<>(prefixSet.size());

        for (String s : prefixSet) {
            group.add(new ArrayList());
            max.add(new ArrayList());
        }

        Iterator<String> iteratorPrefixSet = prefixSet.iterator();

//      System.out.println(prefixSet.toString());
        for (Iterator<String> r = prefixSet.iterator(); r.hasNext(); ) {
            for (int l = 0; l < group.size(); l++) {
                String next = r.next();

                for (FileToDelete k : listamea) {
                    if (k.getPrefix().equals(next)) {
                        group.get(l).add(k);
                    }
                }
            }

            r.remove();
        }

        for (int w = 0; w < group.size(); w++) {
            for (FileToDelete z : group.get(w)) {
                max.get(w).add(z.getSufix());
                Collections.sort(max.get(w));
                Collections.reverse(max.get(w));
            }
        }

  

        for (int v = 0; v < max.size(); v++) {
            for (FileToDelete o : group.get(v)) {
                if (o.getSufix() < max.get(v).get(0)) {
                    o.delete();
                }
            }
        }
    }
}


