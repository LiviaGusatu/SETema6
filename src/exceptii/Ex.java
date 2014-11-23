package exceptii;

/**
 * Created by Livia on 11/23/2014.
 */
public class Ex extends Exception {

    public Ex(String s, String err) {
        super("Exceptie \"" + s + "\" : " + err);
    }
}
