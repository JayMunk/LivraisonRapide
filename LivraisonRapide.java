public class LivraisonRapide {
    int nbVehicule = 0;

    public LivraisonRapide() {
    }

    public void ajouterVehicule(Vehicule vehicule1) {
       Vehicule.addVehiculeList(vehicule1);
    }

    public void ajouterRoute(Route route1) {
        if (nbVehicule < Vehicule.myVehiculeList.size()) {
           Vehicule camion = Vehicule.getVehicule(nbVehicule);
            camion.addRoute(route1.nomRoute);
            nbVehicule++;
        }
    }

    public void ajouterColis(Colis colis1) {
        Colis.colisACharger(colis1.getTracking(), colis1);
    }

    public Vehicule rechercherColisDansVehicule(String trackingDansVehicule) {
       return Vehicule.rechercherColis(trackingDansVehicule);
    }

    public Colis rechercherColisACharger(String trackingACharger) {
        return Colis.findColisACharger(trackingACharger);
    }

    public void chargerColis() {
        Vehicule.chargerVehicule(Colis.listColisACharger, Route.myListRoute);
        Colis.clearList();
    }

}