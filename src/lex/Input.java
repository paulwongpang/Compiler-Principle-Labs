package lex;

import java.io.*;

public class Input {

    public static char[] getInput(String inputFile) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(inputFile)), "GBK"));
        String line;
        int index = 0;
        char input[] = new char[500];

        while (null != (line = br.readLine())) {
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '\t') {
                    continue;
                }
                input[index++] = line.charAt(i);
            }
            input[index++] = '\n';
        }
        input[index] = '#';
        br.close();

        return input;
    }
}
