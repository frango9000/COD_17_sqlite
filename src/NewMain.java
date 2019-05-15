package src;
/**
 * @author fsancheztemprano
 */
public class NewMain {
    public static void main(String[] args) {
        
        SessionDB db = new SessionDB();
        db.connect();
        db.close();

    }
}