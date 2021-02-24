import java.util.Arrays;

public class Tests {
    private static LivraisonRapide app;

    public static void main(String[] args) {
        app = new LivraisonRapide();

        // Execution des tests
        test_rechercherUnColisNonCharge();
        test_chargerUnColisCharge();
    }

    public static void test_rechercherUnColisNonCharge() {
        boolean passe = true;
        System.out.print("test_rechercherUnColisNonCharge ... ");
        entrerDonneesDeTest();
        app.ajouterColis(new Colis("1111111111", "Dorval", 4.55));
        Colis colis = app.rechercherColisACharger("1111111111");
        if (colis == null) {
            System.out.println("    Erreur: Colis non trouve dans les colis a charger.");
            passe = false;
        }
        Vehicule vehicule = app.rechercherColisDansVehicule("1111111111");
        if (vehicule != null) {
            System.out.println("    Erreur: Colis trouve dans un vehicule");
            passe = false;
        }
        if (passe) {
            System.out.println("ok");
        }
    }

    public static void test_chargerUnColisCharge() {
        boolean passe = true;
        System.out.print("test_chargerUnColisCharge ... ");
        entrerDonneesDeTest();
        app.ajouterColis(new Colis("1111111111", "Dorval", 4.55));
        Colis colis = app.rechercherColisACharger("1111111111");
        if (colis == null) {
            System.out.println("    Erreur: Colis non trouve dans les colis a charger.");
            passe = false;
        }
        app.chargerColis();
        Vehicule vehicule = app.rechercherColisDansVehicule("1111111111");
        if (vehicule == null) {
            System.out.println("    Erreur: Colis non-trouve dans un vehicule");
            passe = false;
        }
        if (passe) {
            System.out.println("ok");
        }
    }

    public static void entrerDonneesDeTest() {
        String[] villes = { "St-Constant", "Candiac", "Chateauguay", "Mercier", "Lasalle", "Laval", "Mont-Royal",
                "Blainville", "Cartierville", "nord", "Lachine", "Dorval", "Pointe-Claire", "Vaudreuil" };

        app.ajouterVehicule(new Vehicule(0));
        app.ajouterVehicule(new Vehicule(1));
        app.ajouterVehicule(new Vehicule(2));
        app.ajouterVehicule(new Vehicule(3));

        Route routeSud = new Route("sud");
        routeSud.ajouterVilles(Arrays.asList("St-Constant", "Candiac", "Chateauguay", "Mercier", "Lasalle"));
        app.ajouterRoute(routeSud);

        Route routeNord = new Route("nord");
        routeNord.ajouterVilles(Arrays.asList("Laval", "Mont-Royal", "Blainville", "Cartierville", "nord"));
        app.ajouterRoute(routeNord);

        Route routeOuest = new Route("ouest");
        routeOuest.ajouterVilles(Arrays.asList("Lachine", "Dorval", "Pointe-Claire", "Vaudreuil"));
        app.ajouterRoute(routeOuest);

        // Generer des colis
        for (int f = 0; f < 100; f++) {
            String ville = villes[(int) (Math.random() * villes.length)];
            String tracking = "";
            for (int i = 0; i < 10; i++) {
                tracking += Character.toString('0' + (int) (Math.random() * 9));
            }
            Double poids = Math.random() * 100;
            app.ajouterColis(new Colis(tracking, ville, poids));
        }
    }

}