package model;

public class Production {
    private String left;
    private String[] right;

    public Production(String left, String[] right) {
        this.left = left;
        this.right = right;
    }

    public String[] getRight() {
        return right;
    }

    /**
     * 产生式转化为字符串
     *
     * @return
     */
    public String toString() {
        String res = left + " -> ";
        if (right != null) {
            for (String s : right) {
                res += (s + " ");
            }
        } else {
            res += "ε";
        }
        return res;
    }
}



