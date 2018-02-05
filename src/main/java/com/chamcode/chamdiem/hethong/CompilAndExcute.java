package com.chamcode.chamdiem.hethong;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class CompilAndExcute {
    private String className;
    private String path;
    private String username;

    public CompilAndExcute(File file) {
        this.className = file.getPath();
    }

    private String executeCommand(String command) {
        String line = "";
        String re = "";
        try {
            Process p = Runtime.getRuntime().exec(command);
            BufferedReader bri = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader bre = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            while ((line = bri.readLine()) != null) {
                re += line + "\n";
            }
            bri.close();
            while ((line = bre.readLine()) != null) {
                re += line + "\n";
                System.out.println(5);
            }
            re = re.trim();
            p.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return re;
    }

    private String complieClass() {
        String command = "javac " + this.className;
        return executeCommand(command);
    }

    private String excuteClass() {
        String command = "java " + this.className.split(Pattern.quote("."))[0];
        return executeCommand(command);
    }

    public String excute() {
        String com = complieClass();
        System.out.println(com);
        if (!com.equals("")) {
            return null;
        }
        return excuteClass();
    }

    public static void main(String[] args) {
        CompilAndExcute compilAndExcute = new CompilAndExcute(new File("Hello.java"));
        System.out.println(compilAndExcute.excute());
    }
}
