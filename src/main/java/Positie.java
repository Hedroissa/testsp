import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Positie {

    private int number;
    private Kleur kleur;
    private HashMap<Positie, Kleur> neighbors = new HashMap<>();

    //Constructor
    public Positie(int number, Kleur kleur) {
        assert kleur != null : "number can't be null!";
        assert number <= 23 : "number can't be higher than 23!";
        this.number = number;
        this.kleur = kleur;
    }

    /**
     * Buur toevoegen aan deze positie.
     *
     * @param kleur    de kleur van de pijl die deze positie verbindt met zijn buur
     * @param neighbor de buur
     */
    public void addNeighbor(Kleur kleur, Positie neighbor) {
        assert kleur != null : "invalid color";
        neighbors.put(neighbor, kleur);
    }

    /**
     * Geeft de kleur van de positie terug.
     *
     * @return de kleur
     */
    public Kleur getKleur() {
        return kleur;
    }

    /**
     * Geeft een lijst van mogelijke volgende posities terug aan de hand
     * van de kleur waar de andere speler op staat.
     *
     * @param ander de positie van de andere speler
     * @return lijst van posities
     */
    public List<Positie> getNextPositions(Positie ander) {
        assert ander != null : "position can't be null!";
        List<Positie> result = new LinkedList<>();
        for (Map.Entry<Positie, Kleur> entry : neighbors.entrySet()) {
            if (entry.getValue().equals(ander.getKleur())) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    /**
     * Geeft de nummer van de positie terug.
     *
     * @return de nummer
     */
    public int getNumber() {
        return number;
    }
}