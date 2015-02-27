package dev.jichio.geemu.text;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TextLoader {

    public static String [] loadText(String path) {

        try {
            List<String> list = new ArrayList<String>();
            URL classLoader = TextLoader.class.getResource(path);
            File file = new File(classLoader.getFile());
            Scanner in = new Scanner(file);
            while (in.hasNextLine())
                list.add(in.nextLine());
            String[] array = list.toArray(new String[0]);
            return  array;

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
     return null;
    }
}
