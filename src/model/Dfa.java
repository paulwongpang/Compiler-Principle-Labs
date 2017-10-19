package model;

import java.util.LinkedList;

public class Dfa {
    private LinkedList<State> dfa;

    public Dfa() {
        this.setDfa(new LinkedList<State>());
        this.getDfa().clear();
    }

    public LinkedList<State> getDfa() {

        return dfa;
    }

    public void setDfa(LinkedList<State> nfa) {

        this.dfa = nfa;
    }
}