import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Vehicule {
    int id;
    String route = "";

    static ArrayList<Vehicule> myVehiculeList = new ArrayList<Vehicule>();
    LinkedList<Colis> listColisCharger = new LinkedList<Colis>();

    public Vehicule(int id) {
        this.id = id;
    }

    public static void chargerVehicule(HashMap<String, Colis> listColis, HashMap<String, List<String>> myListRoute) {
        // pour chaque route
        for (String route : myListRoute.keySet()) {

            // pour chaque colis
            for (String tracking : listColis.keySet()) {

                if (myListRoute.get(route).contains(listColis.get(tracking).getVille())) {
                    Vehicule vehicule = getVehiculeSelonRoute(route);
                    // rajoute colis a liste de colis charger
                    vehicule.listColisCharger.add(listColis.get(tracking));
                }
            }
        }
    }

    public static Vehicule getVehicule(int nbVehicule) {
        return myVehiculeList.get(nbVehicule);
    }

    public static void addVehiculeList(Vehicule vehicule1) {
        myVehiculeList.add(vehicule1);
    }

    public void addRoute(String nomRoute) {
        this.route = nomRoute;
    }

    public static Vehicule getVehiculeSelonRoute(String route2) {
        for (int i = 0; i < myVehiculeList.size(); i++) {
            if (myVehiculeList.get(i).route.equals(route2)) {
                return myVehiculeList.get(i);
            }
        }
        return null;
    }

    public static Vehicule rechercherColis(String trackingDansVehicule) {
        // pour chaque vehicule
        for (int i = 0; i < myVehiculeList.size(); i++) {
            // pour chaque colis dans vehicule
            for (int j = 0; j < myVehiculeList.get(i).listColisCharger.size(); j++) {
                // donne un colis
                if (myVehiculeList.get(i).listColisCharger.get(j).getTracking().equals(trackingDansVehicule)) {
                    return myVehiculeList.get(i);
                }

            }
        }
        return null;
    }

}