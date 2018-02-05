package com.chamcode.chamdiem.huongthutuc;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class GenerationStruct {

    private String codeCuaNguoiDung;
    private String className;
    private String targetCode;
    private String duLieuTest;
    private String kieuTraVe;
    private String rangBuoc;

    public GenerationStruct(String codeCuaNguoiDung, String duLieuTest, String kieuTraVe, String rangBuoc) {
        this.duLieuTest = duLieuTest.trim();
        this.codeCuaNguoiDung = codeCuaNguoiDung.trim();
        this.className = getClassName();
        this.kieuTraVe = kieuTraVe.trim();
        this.rangBuoc = rangBuoc.trim();
        custom();
        System.out.println(this.codeCuaNguoiDung);
        if (kieuTraVe.equals("boolean")) {
            if (checkMethodBoolean()) {
                removeHamMain();
            } else {
                this.targetCode = null;
            }
        } else {
            removeHamMain();
        }
    }

    private void custom() {
        List<String> l = new LinkedList<>();
        StringTokenizer tokenizer = new StringTokenizer(this.codeCuaNguoiDung, "\n");
        while (tokenizer.hasMoreTokens()) {
            l.add(tokenizer.nextToken().trim());
        }
        this.codeCuaNguoiDung = String.join(" ", l);
        List<String> l2 = new LinkedList<>();
        StringTokenizer tokenizer2 = new StringTokenizer(this.codeCuaNguoiDung, " ");
        while (tokenizer2.hasMoreTokens()) {
            l2.add(tokenizer2.nextToken().trim());
        }
        this.codeCuaNguoiDung = String.join(" ", l2);
        this.codeCuaNguoiDung = this.codeCuaNguoiDung.replaceAll(Pattern.quote(" { "), "{");
        this.codeCuaNguoiDung = this.codeCuaNguoiDung.replaceAll(Pattern.quote("{ "), "{");
        this.codeCuaNguoiDung = this.codeCuaNguoiDung.replaceAll(Pattern.quote(" {"), "{");

        this.codeCuaNguoiDung = this.codeCuaNguoiDung.replaceAll(Pattern.quote(" } "), "}");
        this.codeCuaNguoiDung = this.codeCuaNguoiDung.replaceAll(Pattern.quote("} "), "}");
        this.codeCuaNguoiDung = this.codeCuaNguoiDung.replaceAll(Pattern.quote(" }"), "}");
    }

    private String getClassName() {
        StringTokenizer tokenizer = new StringTokenizer(codeCuaNguoiDung, " ");
        while (tokenizer.hasMoreElements()) {
            if (tokenizer.nextToken().equals("class")) {
                return tokenizer.nextToken().split(Pattern.quote("{"))[0].trim();
            }
        }
        return null;
    }

    private boolean checkMethodBoolean() {
        String duLieuCuHam = getValueOfMethod(this.rangBuoc);
        assert duLieuCuHam != null;
        if (duLieuCuHam.equals("return true;") || duLieuCuHam.equals("return false;")
                || duLieuCuHam.equals("return true ;")
                ) {
            return false;
        }

        return true;
    }

    private String getValueOfMethod(String rb) {
        int indexMethod = this.codeCuaNguoiDung.indexOf(rb);
        int start = -1;

        int stop = -1;
        int doDaiCode = this.codeCuaNguoiDung.length();
        for (int i = indexMethod; i < this.codeCuaNguoiDung.length(); i++) {
            if (this.codeCuaNguoiDung.charAt(i) == '{') {
                start = i;
                break;
            }
        }
        String duLieuCuHam = null;
        String thamSoTruyenVao = "";

        try {
            if (start != -1) {
                String temp = this.codeCuaNguoiDung.substring(start, this.codeCuaNguoiDung.length());
                thamSoTruyenVao = this.codeCuaNguoiDung.substring(indexMethod, start);
                if (!temp.contains("public")) {
                    // phương thức đặt ở cuối
                    stop = temp.indexOf(";}}");
                    duLieuCuHam = this.codeCuaNguoiDung.substring(start + 1, start + stop + 1);
                } else {
                    // phương thức không đặt ở cuối
                    stop = temp.indexOf("public");
                    duLieuCuHam = this.codeCuaNguoiDung.substring(start + 1, start + stop - 1);
                }
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
        return duLieuCuHam.trim();
    }

    private void removeHamMain() {
        int start = 0;
        int stop = 0;
        String template = "public static void main";


        int batDauHamMain = this.codeCuaNguoiDung.indexOf(template);
        if (batDauHamMain == -1) {
            return;
        }

        for (int i = batDauHamMain; i < this.codeCuaNguoiDung.length(); i++) {
            if (this.codeCuaNguoiDung.charAt(i) == '{') {
                start = i;
                break;
            }
        }


        for (int i = start; i < this.codeCuaNguoiDung.length(); i++) {
            if ((this.codeCuaNguoiDung.charAt(i) == '}' && (this.codeCuaNguoiDung.charAt(i - 1) == ';' || this.codeCuaNguoiDung.charAt(i - 2) == ';'))
                    ||
                    ((this.codeCuaNguoiDung.charAt(i) == '}' && this.codeCuaNguoiDung.charAt(i - 1) == '{') || (this.codeCuaNguoiDung.charAt(i) == '}' && this.codeCuaNguoiDung.charAt(i - 2) == '{'))
                    ) {
                stop = i;
                break;
            }
        }

        if (stop - start == 1 || stop - start == 2) {
            String thayThe = this.codeCuaNguoiDung.substring(batDauHamMain, stop + 1);
            String bangChuoi = "public static void main(String[] args){" + vietLaiHamMain(duLieuTest) + "}";
            this.targetCode = this.codeCuaNguoiDung.replace(thayThe, bangChuoi);
            return;
        }

        String duLieuHamMain = getValueOfMethod("public static void main");
        System.out.println("Dữ liệu hàm main: " + duLieuHamMain);
        this.targetCode = this.codeCuaNguoiDung.replace(duLieuHamMain, vietLaiHamMain(duLieuTest));

    }

    public String vietLaiHamMain(String duLieuTest) {
        String khoiTao = className + " test = new " + className + "();";
        return khoiTao + duLieuTest;
    }

    /**
     * @param username là thư mục chứa file code
     */
    public File exportToFileJavaNew(String path, String username) {
        File file = null;
        if (path == null && username != null) {
            file = new File(username + "\\" + className + ".java");
        }
        if (path == null && username == null) {
            file = new File(className + ".java");
        }
        if (path != null && username != null) {
            file = new File(path + "\\" + username + "\\" + className + ".java");
        }
        try {
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(file))));
            printWriter.println(targetCode);
            printWriter.flush();
            printWriter.close();
        } catch (FileNotFoundException e) {
            return null;
        }
        return file;
    }
}
