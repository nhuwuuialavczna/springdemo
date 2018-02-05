package com.chamcode.chamdiem.hethong;

import java.io.*;

public class FileUtils {

    String file;

    public FileUtils(String file) {
        this.file = file;
    }

    public String readFile() {
        StringBuilder str = new StringBuilder();
        String line;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            while ((line = bufferedReader.readLine()) != null) {
                str.append(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str.toString();
    }

    public static void main(String[] args) {
        FileUtils fileUtils = new FileUtils("Hello.java");
        System.out.println(fileUtils.readFile());

    }
}