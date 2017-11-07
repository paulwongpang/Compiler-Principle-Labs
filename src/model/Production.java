package model;

public class Production {
    private String left;
    private String[] right;

    public Production(String left, String[] right) {
        this.left = left;
        this.right = right;
    }

    /**
     * 产生式转化为字符串
     * @return
     */
    public String toString() {
        String res = left + " -> ";
        if (right != null) {
            for (String image : right) {
                res = res + image + " ";
            }
        } else {
            res = res + "ε";
        }
        return res;
    }
}
