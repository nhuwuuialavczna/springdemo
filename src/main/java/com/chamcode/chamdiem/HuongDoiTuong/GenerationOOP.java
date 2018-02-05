package com.chamcode.chamdiem.HuongDoiTuong;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class GenerationOOP {
    private String codeCuaNguoiDung;
    private String interfaceCode;
    private String abstractClass;
    private String rangBuoc;
    private String generic;
    private String kieuTraVe;
    private String className;
    private String targetCode;

    public GenerationOOP(String codeCuaNguoiDung) {
        this.codeCuaNguoiDung = codeCuaNguoiDung;
        custom();
    }



    private void custom() {
        List<String> l = new LinkedList<>();
        StringTokenizer tokenizer = new StringTokenizer(codeCuaNguoiDung, " ");
        while (tokenizer.hasMoreTokens()) {
            l.add(tokenizer.nextToken().trim());
        }
        this.codeCuaNguoiDung = String.join(" ", l);
    }
}
