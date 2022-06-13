package com.company;

import java.util.Arrays;
import java.util.List;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        List<File> folderList = Arrays.asList(
                new File("K://Games13"),
                new File("K://Games13//temp"),
                new File("K://Games13//src"),
                new File("K://Games13//res"),
                new File("K://Games13//savegames"),
                new File("K://Games13//src//main"),
                new File("K://Games13//src//test"),
                new File("K://Games13//res//drawables"),
                new File("K://Games13//res//vectors"),
                new File("K://Games13//res//icons")
        );
        List<File> fileList = Arrays.asList(
                new File("K://Games13//src//main//Main.java"),
                new File("K://Games13//src//main//Utils.java"),
                new File("K://Games13//temp//temp.txt")
        );
        folderList.stream().forEach(folder -> {
            if (folder.mkdir()) sb.append("Каталог " + folder + " создан\n");
            else sb.append("Каталог " + folder + " не создан\n");
        });
        fileList.stream().forEach(file -> {
            try {
                if (file.createNewFile()) sb.append("Файл " + file + " создан\n");
                else sb.append("Файл " + file + " не создан\n");
            } catch (IOException ex) {
                sb.append(ex.getMessage() + '\n');
            }
        });
        try (FileWriter log = new FileWriter("K://Games13//temp//temp.txt", false)) {
            log.write(sb.toString());
            log.flush();
        } catch (IOException ex) {
            sb.append(ex.getMessage() + '\n');
        }
        try (BufferedReader br = new BufferedReader(new FileReader("K://Games13//temp//temp.txt"))) {
            String s;
            while ((s = br.readLine()) != null) System.out.println(s);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
