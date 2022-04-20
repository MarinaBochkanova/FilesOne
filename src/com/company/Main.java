package com.company;

import javax.imageio.IIOException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    static StringBuilder notifyText = new StringBuilder();

    public static void main(String[] args) throws IOException {

        File[] directories = {
                new File("D://Games"),
                new File("D://Games/src"),
                new File("D://Games/res"),
                new File("D://Games/savegames"),
                new File("D://Games/temp"),
                new File("D://Games/src/main"),
                new File("D://Games/src/test"),
                new File("D://Games/res/drawables"),
                new File("D://Games/res/vectors"),
                new File("D://Games/res/icons")
        };

        for (File dir : directories) {
            createDir(dir);
        }

        File[] files = {
                new File("D://Games/src/main/Main.java"),
                new File("D://Games/src/main/Utils.java"),
                new File("D://Games/temp/temp.txt")
        };

        for (File anyFile : files) {
            fileCreate(anyFile);
        }

        String text = String.valueOf(notifyText);
        System.out.println(text);

        try (FileWriter tempWriter = new FileWriter("D://Games/temp/temp.txt")) {
            tempWriter.write(text);
            tempWriter.flush();

        } catch (IIOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void createDir(File file) {
        if (file.mkdir()) {
            notifyText.append("Created a directory " + "'" + file.getName() + "'"
                    + " Directory path " + file.getPath());
            notifyText.append("\n ");
        } else {
            notifyText.append("Failed to create directory " + "'" + file.getName() + "'");
            notifyText.append("\n ");
        }
    }

    public static void fileCreate(File file) {
        try {
            if (file.createNewFile()) {
                notifyText.append("Created a file " + "'" + file.getName() + "'"
                        + " File path " + file.getPath());
                notifyText.append("\n ");
            } else {
                notifyText.append("Failed to create file " + "'" + file.getName() + "'");
                notifyText.append("\n ");
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

}
