package model;

import java.util.LinkedList;

public class Nfa {
    private LinkedList<State> nfa;

    public Nfa() {
        this.setNfa(new LinkedList<State>());
        this.getNfa().clear();
    }

    public LinkedList<State> getNfa() {

        return nfa;
    }

    public void setNfa(LinkedList<State> nfa) {

        this.nfa = nfa;
    }
}
