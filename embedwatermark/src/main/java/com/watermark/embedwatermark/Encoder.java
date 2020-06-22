package com.watermark.embedwatermark;

public class Encoder {
    public static String encodeString(String watermark ){
        String watermarkAscii="";
        for (char c : watermark.toCharArray()){
            watermarkAscii +=Integer.toString(cekKodeEncode((int)c));
        }
        return watermarkAscii;
    }
    private static int cekKodeEncode(int ascii){
        if(encodeAsciiSeratus(ascii)){
            ascii = 138;
        }else if(encodeAsciiLebihSeratus(ascii)){
            ascii+=10;
        }else if(encodeAsciiDuaAngka(ascii)){
            ascii+=200;
        }else if(encodeAsciiHabisModSepuluh(ascii)){
            ascii+=301;
        }
        return ascii;
    }
    private static boolean encodeAsciiSeratus(int ascii){
        if(ascii == 100){
            return true;
        }
        return false;
    }
    private static boolean encodeAsciiLebihSeratus(int ascii){
        if(ascii > 100 && ascii <200 && ascii %10 !=0){
            return true;
        }
        return false;
    }
    private static boolean encodeAsciiDuaAngka(int ascii){
        if(ascii < 100 &&  ascii % 10 != 0){
            return true;
        }
        return false;
    }
    private static boolean encodeAsciiHabisModSepuluh(int ascii){
        if(ascii % 10 == 0){
            return true;
        }
        return false;
    }

}
