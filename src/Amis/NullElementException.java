package Amis;

@SuppressWarnings("serial")
public class NullElementException extends Exception {
    public NullElementException() {
        super("Au moins un des �l�ments n'existe pas");
    }
}
