package com.company;

import javax.imageio.IIOException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    static StringBuilder notifyText = new StringBuilder();

    public static void main(String[] args) throws IOException {

        File games = new File("D://Games");
        createDir(games);

        File src = new File("D://Games/src");
        createDir(src);

        File res = new File("D://Games/res");
        createDir(res);

        File saveGames = new File("D://Games/savegames");
        createDir(saveGames);

        File temp = new File("D://Games/temp");
        createDir(temp);

        File main = new File("D://Games/src/main");
        createDir(main);

        File test = new File("D://Games/src/test");
        createDir(test);

        File mainJava = new File("D://Games/src/main/Main.java");
        fileCreate(mainJava);

        File utilsJava = new File("D://Games/src/main/Utils.java");
        fileCreate(utilsJava);

        File drawables = new File("D://Games/res/drawables");
        createDir(drawables);

        File vectors = new File("D://Games/res/vectors");
        createDir(vectors);

        File icons = new File("D://Games/res/icons");
        createDir(icons);

        File tempTxt = new File("D://Games/temp/temp.txt");
        fileCreate(tempTxt);

        String text = String.valueOf(notifyText);
        System.out.println(text);

        try (FileWriter tempWriter = new FileWriter(tempTxt)) {
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
