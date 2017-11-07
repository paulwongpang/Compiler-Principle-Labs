package syntax;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Output {

    public static void output(List<String> output, String inputFile) throws IOException {

        String[] splits = inputFile.split("\\.");
        File outputFile = new File(splits[0] + "_syntax_parsing_result.txt");
        if (!outputFile.exists())
            outputFile.createNewFile();
        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, false));

        for (int i = 0; i < output.size(); i++) {
            bw.write("(" + i + ")" + output.get(i));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
