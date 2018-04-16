import java.util.*;

public class Puzzel {

    private Bord bord;
    private int nu = 1;
    private int positie1 = 1;
    private int positie2 = 2;

    //Constructor met afwijkende start posities
    public Puzzel(int positie1, int positie2) {
        assert positie1 <= 23 : "position1 does not exist on the bord";
        assert positie2 <= 23 : "position2 does not exist on the bord";
        bord = new Bord();
        this.positie1 = positie1;
        this.positie2 = positie2;
    }

    //Normale constructor
    public Puzzel() {
        bord = new Bord();
    }

    public void run() {
        Toestand start = new Toestand(positie1, positie2, 1);
        LinkedList<Toestand> resultaat = dfs(start, new ArrayList<>());

        for (Toestand toestand : resultaat) {
            System.out.println(toestand.getIsTurn() + " - " + toestand.getPositie1() + " - " + toestand.getPositie2());
        }
    }

    /**
     * De depth-first searching algortime
     *
     * @param start   de huidige toestand
     * @param bezocht een lijst met eerder bezochte toestanden
     * @return een lijst van de oplossing mits deze er is
     */
    private LinkedList<Toestand> dfs(Toestand start, ArrayList<Toestand> bezocht) {
        System.out.println("Toestand " + nu + ": " + start.getIsTurn() + " - " + start.getPositie1() + " - " + start.getPositie2());
        nu++;
        LinkedList<Toestand> oplossing;
        bezocht.add(start);
        //Als de huidige toestand de oplossing is, wordt deze teruggegeven
        if (bord.isGoal(start)) {
            oplossing = new LinkedList<>();
            oplossing.add(start);
            return oplossing;
        } else {
            //Zo niet, dan halen we eerst alle volgende toestanden op
            List<Toestand> buren = bord.getBuren(start);
            //En gaan we elke buur langs zolang we geen oplossing hebben gevonden
            for (Toestand buur : buren) {
                boolean reedsBezocht = false;
                //Eerst gaan we kijken of we die toestand hebben bezocht
                for (Toestand bezochtePlek : bezocht) {
                    if (bezochtePlek.equals(buur)) {
                        reedsBezocht = true;
                        System.out.println("Buur is al bezocht: " + bezochtePlek.getPositie1() + " - " + bezochtePlek.getPositie2() + " - " + bezochtePlek.getIsTurn());
//                        System.out.println("Terug naar " + bezocht.get(bezocht.size() - 2).getPositie1() + " - " + bezocht.get(bezocht.size() - 2).getPositie2());
                    }
                }
                if (!reedsBezocht) {
                    //Als we die toestand niet hebben gehad, roepen we dfs nogmaals aan om met die buur verder te gaan
                    oplossing = dfs(buur, bezocht);
                    if (goalIsReached(oplossing)) {
                        //Als het doel is bereikt, geven we deze lijst met de huidige toestand erbij terug
                        oplossing.addFirst(start);
//                        System.out.println("Oplossing!");
                        return oplossing;
                    } else {
//                        System.out.println("Geen oplossing");
                    }
                }
            }
        }
//        bezocht.remove(start);
        //Als er geen oplossing is gevonden, geven we een lege lijst terug
        return new LinkedList<>();
    }

    private boolean goalIsReached(LinkedList<Toestand> oplossing) {
        //Als de lijst leeg is, is het doel niet bereikt
        if (oplossing.isEmpty()) {
            return false;
        } else if (bord.isGoal(oplossing.getLast())) {
            //Als het laatste positie de oplossing is, hebben we het doel bereikt.
            System.out.println("Finished");
            return true;
        } else {
            return false;
        }
    }
}
