import java.util.HashMap;

public class Colis {
    private String tracking;
    private String ville;
    private Double poids;

    static HashMap<String, Colis> listColisACharger = new HashMap<String, Colis>();

    public Colis(String tracking, String destination, Double poids) {
        this.tracking = tracking;
        ville = destination;
        this.poids = poids;
    }

    public static void colisACharger(String tracking, Colis colis1) {
        listColisACharger.put(tracking, colis1);
    }

    public String getTracking() {
        return tracking;
    }

    public String getVille() {
        return ville;
    }

    public static Colis findColisACharger(String trackingACharger) {
        if (listColisACharger.containsKey(trackingACharger)) {
            return listColisACharger.get(trackingACharger);
        } else {
            return null;
        }
    }

    public static void removeFromList(String tracking2) {
        System.out.println("colis " + listColisACharger.get(tracking2));
        listColisACharger.remove(tracking2);
    }

    public static void clearList() {
        listColisACharger.clear();
    }

}
