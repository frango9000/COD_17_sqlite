package src;
/**
 * @author fsancheztemprano
 */
public class NewMain {
    public static void main(String[] args) {
        
        SessionDB db = new SessionDB("src/resources/biblio.db");
        db.connect();
        db.close();

    }
}