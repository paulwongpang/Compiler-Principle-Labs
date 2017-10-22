package les;

import java.io.*;

public class Input {

    public static char[] getInput(String inputFile) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(inputFile))));
        String line;
        int index = 0;
        char input[] = new char[500];
        char[] tempChars;

        while (null != (line = br.readLine())) {
            tempChars = line.toCharArray();
            for (char c : tempChars) {
                if (c == '\t') {
                    continue;
                }
                input[index++] = c;
            }
            input[index++] = '\n';
        }
        input[index] = '#';
        br.close();

        return input;
    }
}
