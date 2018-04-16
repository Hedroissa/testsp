public class Toestand {

    private int positie1;
    private int positie2;
    private int isTurn;

    //Constructor
    public Toestand(int positie1, int positie2, int isTurn) {
        assert positie1 <= 23 : "position can't ne higher than 23";
        assert positie2 <= 23 : "position can't ne higher than 23";
        assert positie1 > 0 : "position can't be smaller than 0";
        assert positie2 > 0 : "position can't be smaller than 0";
        assert isTurn >= 0 : "invalid turn";
        this.positie1 = positie1;
        this.positie2 = positie2;
        this.isTurn = isTurn % 2;
    }

    /**
     * Geeft de positie van speler 1 terug.
     *
     * @return positie speler 1
     */
    public int getPositie1() {
        return positie1;
    }

    /**
     * Geeft de positie van speler 2 terug.
     *
     * @return positie speler 2
     */
    public int getPositie2() {
        return positie2;
    }

    /**
     * Geeft terug wie aan de beurt is.
     *
     * @return 1 voor speler 1, 0 voor speler 2
     */
    public int getIsTurn() {
        return isTurn % 2;
    }

    /**
     * Controleert of de gegeven toestand hetzelfde is als deze toestand. Ook wordt de toestand omgedraaid (spelers en beurt omgewisseld),
     * en zo wordt er ook gecontroleert of dit toestand hetzelfde is als met de gegeven toestand.
     *
     * @param toestand het te vergelijken toestand
     * @return zelfde toestand
     */
    public boolean equals(Toestand toestand) {
        return positie1 == toestand.getPositie1() &&
                positie2 == toestand.getPositie2() &&
                isTurn == toestand.getIsTurn() ||
                positie1 == toestand.getPositie2() &&
                        positie2 == toestand.getPositie1() &&
                        (isTurn + 1) % 2 == toestand.getIsTurn();
    }

    /**
     * Geeft de positie van de huidige speler terug.
     *
     * @return positie huidige speler
     */
    public int getPositionOfCurrentPlayer() {
        if (isTurn == 1) {
            return positie1;
        } else if (isTurn == 0) {
            return positie2;
        }

        return Integer.MIN_VALUE;
    }

    /**
     * Geeft de positie van de andere speler terug.
     *
     * @return positie andere speler
     */
    public int getPositionOfOther() {
        if (isTurn == 1) {
            return positie2;
        } else if (isTurn == 0) {
            return positie1;
        }

        return Integer.MIN_VALUE;
    }
}
