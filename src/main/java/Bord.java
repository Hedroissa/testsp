import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Bord {

    private HashMap<Integer, Positie> posities = new HashMap<>();
    private final int goal = 23;

    public Bord() {
        //Maak posities
        posities.put(1, new Positie(1, Kleur.PAARS));
        posities.put(2, new Positie(2, Kleur.ZWART));
        posities.put(3, new Positie(3, Kleur.GROEN));
        posities.put(4, new Positie(4, Kleur.GROEN));
        posities.put(5, new Positie(5, Kleur.GROEN));
        posities.put(6, new Positie(6, Kleur.ORANJE));
        posities.put(7, new Positie(7, Kleur.ORANJE));
        posities.put(8, new Positie(8, Kleur.PAARS));
        posities.put(9, new Positie(9, Kleur.PAARS));
        posities.put(10, new Positie(10, Kleur.ZWART));
        posities.put(11, new Positie(11, Kleur.ORANJE));
        posities.put(12, new Positie(12, Kleur.PAARS));
        posities.put(13, new Positie(13, Kleur.ORANJE));
        posities.put(14, new Positie(14, Kleur.GROEN));
        posities.put(15, new Positie(15, Kleur.ORANJE));
        posities.put(16, new Positie(16, Kleur.GROEN));
        posities.put(17, new Positie(17, Kleur.GROEN));
        posities.put(18, new Positie(18, Kleur.ZWART));
        posities.put(19, new Positie(19, Kleur.ORANJE));
        posities.put(20, new Positie(20, Kleur.GROEN));
        posities.put(21, new Positie(21, Kleur.ZWART));
        posities.put(22, new Positie(22, Kleur.ZWART));
        posities.put(23, new Positie(23, Kleur.FINISH));

        //Buren aanwijzen
        //1
        posities.get(1).addNeighbor(Kleur.ZWART, posities.get(5));
        posities.get(1).addNeighbor(Kleur.PAARS, posities.get(4));
        //2
        posities.get(2).addNeighbor(Kleur.PAARS, posities.get(12));
        posities.get(2).addNeighbor(Kleur.GROEN, posities.get(6));
        //3
        posities.get(3).addNeighbor(Kleur.ORANJE, posities.get(4));
        posities.get(3).addNeighbor(Kleur.ORANJE, posities.get(1));
        //4
        posities.get(4).addNeighbor(Kleur.ZWART, posities.get(13));
        //5
        posities.get(5).addNeighbor(Kleur.ORANJE, posities.get(9));
        //6
        posities.get(6).addNeighbor(Kleur.PAARS, posities.get(10));
        posities.get(6).addNeighbor(Kleur.GROEN, posities.get(9));
        //7
        posities.get(7).addNeighbor(Kleur.GROEN, posities.get(2));
        //8
        posities.get(8).addNeighbor(Kleur.PAARS, posities.get(3));
        //9
        posities.get(9).addNeighbor(Kleur.ZWART, posities.get(14));
        posities.get(9).addNeighbor(Kleur.GROEN, posities.get(4));
        //10
        posities.get(10).addNeighbor(Kleur.GROEN, posities.get(15));
        //11
        posities.get(11).addNeighbor(Kleur.GROEN, posities.get(12));
        posities.get(11).addNeighbor(Kleur.PAARS, posities.get(10));
        //12
        posities.get(12).addNeighbor(Kleur.GROEN, posities.get(7));
        //13
        posities.get(13).addNeighbor(Kleur.GROEN, posities.get(18));
        posities.get(13).addNeighbor(Kleur.GROEN, posities.get(8));
        //14
        posities.get(14).addNeighbor(Kleur.GROEN, posities.get(23));
        posities.get(14).addNeighbor(Kleur.ORANJE, posities.get(20));
        //15
        posities.get(15).addNeighbor(Kleur.PAARS, posities.get(23));
        posities.get(15).addNeighbor(Kleur.GROEN, posities.get(22));
        //16
        posities.get(16).addNeighbor(Kleur.GROEN, posities.get(15));
        //17
        posities.get(17).addNeighbor(Kleur.ZWART, posities.get(16));
        posities.get(17).addNeighbor(Kleur.PAARS, posities.get(12));
        posities.get(17).addNeighbor(Kleur.ZWART, posities.get(11));
        //18
        posities.get(18).addNeighbor(Kleur.ORANJE, posities.get(20));
        posities.get(18).addNeighbor(Kleur.ORANJE, posities.get(9));
        //19
        posities.get(19).addNeighbor(Kleur.GROEN, posities.get(18));
        //20
        posities.get(20).addNeighbor(Kleur.ORANJE, posities.get(21));
        posities.get(20).addNeighbor(Kleur.ZWART, posities.get(19));
        //21
        posities.get(21).addNeighbor(Kleur.ZWART, posities.get(23));
        posities.get(21).addNeighbor(Kleur.ORANJE, posities.get(22));
        //22
        posities.get(22).addNeighbor(Kleur.ORANJE, posities.get(17));
    }

    /**
     * Controleert of een van de pionen op de finish staan.
     *
     * @param toestand huidige toestand
     * @return één van de pionen staat op de finish
     */
    public boolean isGoal(Toestand toestand) {
        assert toestand != null : "Toestand can't be null!";
        return toestand.getPositie1() == goal || toestand.getPositie2() == goal;
    }

    /**
     * Geeft een lijst van buren terug aan de hand van de huidige positie.
     *
     * @param toestand huidige toestand
     * @return
     */
    public List<Toestand> getBuren(Toestand toestand) {
        assert toestand != null : "Toestand can't be null!";
        List<Toestand> result = new LinkedList<>();
        //Huidige speler aan de beurt
        int turn = toestand.getIsTurn();

        //De positie van de huidige speler
        Positie currentPosition = posities.get(toestand.getPositionOfCurrentPlayer());
        //De positie van de andere speler
        Positie positionOfOther = posities.get(toestand.getPositionOfOther());

        //De plekken waar beide spelers vanuit deze toestand heen kunnen
        List<Positie> nextPositions = currentPosition.getNextPositions(positionOfOther);
        List<Positie> nextPositions2 = positionOfOther.getNextPositions(currentPosition);

        //Voor elk van de mogelijke posities worden nieuwe toestanden gemaakt.
        //Om zoveel mogelijk de "beurten"-structuur aan te houden,
        //gaan we eerst de toestanden van de ene speler langs,
        //vervolgens de toestanden van de andere speler.
        for (Positie positie : nextPositions) {
            if (turn == 1) {
                result.add(new Toestand(positie.getNumber(), toestand.getPositie2(), turn + 1));
            } else if (turn == 0) {
                result.add(new Toestand(toestand.getPositie1(), positie.getNumber(), turn + 1));
            }
        }
        turn = (turn + 1) % 2;
        for (Positie positie : nextPositions2) {
            if (turn == 1) {
                result.add(new Toestand(positie.getNumber(), toestand.getPositie2(), turn + 1));
            } else if (turn == 0) {
                result.add(new Toestand(toestand.getPositie1(), positie.getNumber(), turn + 1));
            }
        }


        return result;
    }
}
