package lex;

import model.Token;
import model.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static lex.Input.getInput;
import static model.Util.charToString;

public class Lex {

    private int code;
    private char[] characters;
    private char input[] = new char[500];
    private int index;
    private int number;
    private List<Token> output;

    public void lex() {

        output = new ArrayList<>();
        String inputFile = "test2.txt";

        // input
        try {
            input = getInput(inputFile);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        index = 0;
        int row = 1;

        // scan
        while (input[index] != '#') {
            number = 0;
            scanner();

            switch (code) {
                case 57: // integer
                    output.add(new Token(code, String.valueOf(number)));
                    break;

                case -1: // new line
                    row++;
                    break;

                case -2: // number is too large
                    output.add(new Token("ERROR: Integer overflow at row " + row));
                    break;

                case -3: // undefined characters
                    output.add(new Token("ERROR: Undefined character at row " + row));
                    break;

                case -4:
                    break;

                default: // characters
                    output.add(new Token(code, charToString(characters)));
                    break;
            }
        }

        // output
//        try {
//            output(output, inputFile);
//        } catch (IOException e2) {
//            e2.printStackTrace();
//        }
    }

    private void scanner() {
        characters = new char[20];
        char ch = input[index];
        index++;

        // SITUATION 1: reverse words or variables
        if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
            int subIndex = 0;

            while ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                characters[subIndex++] = ch;
                ch = input[index++];
            }

            for (int i = 0; i < Util.reservedWords.length; i++) {
                if (charToString(characters).equals(Util.reservedWords[i])) {
                    code = i + 1;
                    index--;
                    return;
                }
            }

            index--;
            code = 56;

            // SITUATION 2: numbers
        } else if (ch >= '0' && ch <= '9') {
            number = 0;

            while (ch >= '0' && ch <= '9') {
                number = number * 10 + ch - '0';

                // ERROR: num is too large
                if (number < 0) {
                    code = -2;
                    break;
                }
                ch = input[index++];
                code = 57;
            }

            index--;

            // SITUATION 3: other situation
        } else {
            int subIndex = 0;
            characters[subIndex++] = ch;

            switch (ch) {
                case '+':
                    ch = input[index++];

                    if (ch == '=') { // +=
                        code = 23;
                        characters[subIndex++] = ch;
                    } else { // +
                        code = 22;
                        index--;
                    }
                    break;

                case '-':
                    ch = input[index++];
                    if (ch >= '0' && ch <= '9') { //negative number
                        number = 0;
                        while (ch >= '0' && ch <= '9') {
                            number = number * 10 + ch - '0';
                            ch = input[index++];

                            //ERROR: number is too large
                            if (number < 0) {
                                code = -2;
                            }

                            code = 57;
                        }

                        index--;
                        number *= -1;
                    } else if (ch == '=') { // -=
                        code = 25;
                        characters[++subIndex] = ch;
                    } else { // -
                        code = 24;
                        index--;
                    }
                    break;

                case '*':
                    ch = input[index++];
                    if (ch == '=') { // *=
                        code = 27;
                        characters[subIndex++] = ch;
                    } else if (ch == '/') { // */
                        code = 44;
                        characters[subIndex++] = ch;
                    } else { // *
                        code = 26;
                        index--;
                    }
                    break;

                case '/':
                    ch = input[index++];
                    if (ch == '=') { // /=
                        code = 29;
                        characters[subIndex++] = ch;
                    } else if (ch == '/') { // //
                        code = 42;
                        characters[subIndex++] = ch;
                    } else if (ch == '*') { // /*
                        code = 26;
                        characters[subIndex++] = ch;
                    } else {// /
                        code = 28;
                        index--;
                    }
                    break;

                case '=':
                    ch = input[index++];
                    if (ch == '=') { // ==
                        code = 31;
                        characters[subIndex++] = ch;
                    } else { // =
                        code = 30;
                        index--;
                    }
                    break;

                case '<':
                    ch = input[index++];
                    if (ch == '=') { // <=
                        code = 39;
                        characters[subIndex++] = ch;
                    } else { // <
                        code = 38;
                        index--;
                    }
                    break;

                case '>':
                    ch = input[++index];
                    if (ch == '=') { // >=
                        code = 41;
                        characters[subIndex++] = ch;
                    } else { // >
                        code = 40;
                        index--;
                    }
                    break;

                case '&':
                    ch = input[index++];
                    if (ch == '&') { // &&
                        code = 33;
                        characters[subIndex++] = ch;
                    } else { // &
                        code = 32;
                        index--;
                    }
                    break;

                case '|':
                    ch = input[index++];
                    if (ch == '|') { // ||
                        code = 35;
                        characters[subIndex++] = ch;
                    } else { // |
                        code = 34;
                        index--;
                    }
                    break;

                case '!':
                    ch = input[index++];
                    if (ch == '=') { // !=
                        code = 37;
                        characters[subIndex++] = ch;
                    } else { // !
                        code = 36;
                        index--;
                    }
                    break;

                case '(':
                    code = 45;
                    break;

                case ')':
                    code = 46;
                    break;

                case '[':
                    code = 47;
                    break;

                case ']':
                    code = 48;
                    break;

                case '{':
                    code = 49;
                    break;

                case '}':
                    code = 50;
                    break;

                case ',':
                    code = 51;
                    break;

                case ':':
                    code = 52;
                    break;

                case ';':
                    code = 53;
                    break;

                case '\'':
                    code = 54;
                    break;

                case '\"':
                    code = 55;
                    break;

                case '\n':
                    code = -1;
                    break;

                case ' ':
                    code = -4;
                    break;

                default:
                    code = -3;
                    break;
            }
        }
    }

    public List<Token> getTokens() {
        lex();
        return output;
    }
}
