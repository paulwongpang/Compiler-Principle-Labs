package model;

public class Token {
    private int code;
    private String string;
    private String error;

    public Token(int code, String string) {
        this.code = code;
        this.string = string;
        this.error = null;
    }

    public Token(String error) {
        this.error = error;
    }

    public String toString() {
        if (this.error != null) {
            return this.error;
        } else {
            return "<" + this.string + ", " + this.code + ">";
        }
    }
}
