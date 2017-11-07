package syntax;

import lex.Lex;
import model.PPT;
import model.Token;

import java.util.List;
import java.util.Stack;

public class Main {
    
    public static void main(String[] args) {
        Lex lex = new Lex();
        List<Token> tokens = lex.getTokens();
        tokens.add(new Token(0, "$"));

        PPT ppt = new PPT();

        Stack<String> stack = new Stack<>();
        stack.push("END");
        stack.push("S");
    }
}
