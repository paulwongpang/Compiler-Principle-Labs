package lex;

import model.Token;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Output {

    public static void output(List<Token> output, String inputFile) throws IOException {

        String[] splits = inputFile.split("\\.");
        File outputFile = new File(splits[0] + "_result.txt");
        if (!outputFile.exists())
            outputFile.createNewFile();
        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, false));

        for (Token t : output) {
//            System.out.println(t.toString());
            bw.write(t.toString());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
