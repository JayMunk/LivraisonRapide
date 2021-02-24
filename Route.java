import java.util.HashMap;
import java.util.List;

public class Route {
	static HashMap<String, List<String>> myListRoute = new HashMap<String, List<String>>();
	String nomRoute = "";

	public Route(String nomRoute) {
		this.nomRoute = nomRoute;
	}

	public void ajouterVilles(List<String> listeVille) {
		myListRoute.put(nomRoute, listeVille);
	}

	public static String getRoute(Colis colis) {
		return (String) getKey(myListRoute, colis);
	}

	public static String getKey(HashMap<String, List<String>> myListRoute2, Colis colis) {
		for (String key : myListRoute2.keySet()) {
			if (myListRoute2.get(key).contains(colis)) {
				return key;
			}
		}
		return null;
	}
}
