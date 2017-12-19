package outils;

import java.util.HashMap;

public class CustomedException extends Exception {

    public static final int USER_ERR = 10;
    public static final int SQL_ERR = 20;
    public static final int NUMBER_FORMAT_ERR = 30;
    
    private int number;
    private HashMap<String, String> erreurs;

    public CustomedException() {
    }

    public CustomedException(String message) {
        super(message);
    }

    public CustomedException(int number, HashMap<String, String> erreurs) {
        this.number = number;
        this.erreurs = erreurs;
    }

    public CustomedException(int number, HashMap<String, String> erreurs, String message) {
        super(message);
        this.number = number;
        this.erreurs = erreurs;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public HashMap<String, String> getErreurs() {
        return erreurs;
    }

    public void setErreurs(HashMap<String, String> erreurs) {
        this.erreurs = erreurs;
    }

}
