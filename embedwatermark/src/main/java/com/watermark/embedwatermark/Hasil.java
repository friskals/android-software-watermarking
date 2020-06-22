package com.watermark.embedwatermark;

import android.os.Environment;
import android.util.Pair;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Hasil {
    public static ArrayList <Pair <Integer,Integer> > data = new ArrayList <Pair <Integer,Integer> > ();

    public static int counterhuruf = 0;
    static String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Watermark";
    static FileOutputStream  outStream = null;
    static OutputStreamWriter  outStreamWriter = null;

    public static void createWriter() throws IOException {
        File dir = new File(path);
        dir.mkdirs();
        File file = null;
        file = new File(new File(path), "/WatermarkTAII.txt");
        file.createNewFile();
        outStream = new FileOutputStream(file, true);
        outStreamWriter = new OutputStreamWriter(outStream);
    }

    public static void buildWatermark( String watermark) throws IOException {
        createWriter();

        watermark = Encoder.encodeString(watermark);

        int ctr=2;

        for(char c: watermark.toCharArray()){
            counterhuruf++;
            int character_angka = Character.getNumericValue(c);
            for(int i = counterhuruf; i < counterhuruf + character_angka ;i++){
                outStreamWriter.append(counterhuruf +" "+ ctr+"\n");
                ctr++;
            }

        }
         outStreamWriter.flush();

    }

}