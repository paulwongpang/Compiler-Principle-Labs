package syntax;

import lex.Lex;
import model.PPT;
import model.Production;
import model.Token;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static syntax.Output.output;


public class Main {

    private static PPT ppt;
    private static List<String> output;

    public static void main(String[] args) {
        String inputFile = "test2.txt";

        // 输入在lex中，是test2.txt
        Lex lex = new Lex();
        List<Token> tokens = lex.getTokens();
        tokens.add(new Token(0, "$"));

        output = new ArrayList<>();
        ppt = new PPT();

        analyse(tokens);

        try {
            output(output, inputFile);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private static void analyse(List<Token> tokens) {
        Stack<String> stack = new Stack<>();
        stack.push("$");
        stack.push("S");

        while (tokens.size() > 0 && stack.size() > 0) {
            Token currentToken = tokens.get(0);
            String currentTokenString = (currentToken.getCode() == 56) ? "id" :
                    ((currentToken.getCode() == 57) ? "num" : currentToken.getString());
            String v = stack.pop();


            // 匹配, 弹出
            if (currentTokenString.equals(v)) {
                tokens.remove(0);
            }

            // 不匹配, v为终结符
            else {
                Production production = ppt.findProduction(currentTokenString, v);
                if (production == null) {
                    output.add("ERROR: invalid input \"" + currentTokenString + "\"");
                    break;
                } else {
                    output.add(production.toString());
                    String[] right = production.getRight();
                    if (right != null) {
                        // 倒序插入
                        for (int i = right.length - 1; i >= 0; i--) {
                            stack.push(right[i]);
                        }
                    }
                }
            }
        }

        if (tokens.size() == 0 && stack.size() == 0) {
            System.out.println("SUCCESS: finish syntax parsing");
        } else {
            System.out.println("ERROR: invalid input");
        }

    }
}
