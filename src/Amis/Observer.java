package Amis;

public class Observer {
    private int nbOp = 0;
    private int nbAffect = 0;

    public void countOp() {
        ++nbOp;
    }


    public void countAffect() {
        ++nbAffect;
    }

    public int getNbAffect() {
        return nbAffect;
    }

    public String toString() {
        //"nbOp : " + nbOp +
        return "nbAffect" + nbAffect;
    }
}

