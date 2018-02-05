package com.chamcode.chamdiem.huongthutuc;

import com.chamcode.chamdiem.hethong.CompilAndExcute;
import com.chamcode.chamdiem.hethong.IMark;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class MarkStruct implements IMark {
    private GenerationStruct generationStruct;
    private CompilAndExcute compilAndExcute;
    private String duLieuOuput;

    public MarkStruct(String path, String username, String codeCuaNguoiDung, String duLieuTest, String duLieuOuput, String kieuTraVe, String rangBuoc) {
        this.duLieuOuput = duLieuOuput;
        this.generationStruct = new GenerationStruct(codeCuaNguoiDung, duLieuTest, kieuTraVe, rangBuoc);
        this.compilAndExcute = new CompilAndExcute(generationStruct.exportToFileJavaNew(path, username));
    }

    @Override
    public int mart() {
        int diem = 0;
        try {
            String[] str = duLieuOuput.split(",");
            List<String> excute = excute();
            for (int i = 0; i < 10; i++) {
                if (str[i].equals(excute.get(i))) {
                    diem += 10;
                }
            }
        } catch (Exception e) {
            return diem;
        }
        return diem;
    }

    @Override
    public List<String> excute() {
        List<String> ds = new LinkedList<>();
        String exc = compilAndExcute.excute();
        if (exc == null) {
            return ds;
        }

        StringTokenizer tokenizer = new StringTokenizer(exc, "\n");
        while (tokenizer.hasMoreTokens()) {
            ds.add(tokenizer.nextToken().trim());
        }
        return ds;
    }

    public static void main(String[] args) {

    }
}
