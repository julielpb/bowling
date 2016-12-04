package jbla;

/**
 * Classe jeu.
 */
public class Jeu {

    /**
     * gfg.
     */
    private final int lancer1;
    /**
     * gf.
     */
    private final int lancer2;

    /**
     *g.
     */
    protected static final int STRIKE = 10;

    /**
     * Type de jeu.
     */
    public enum TypeJeu {
        /**
         *
         */
        Strike,
        /**
         *
         */
        Spare,
        /**
         *
         */
        Normal
    }

    /**
     * efgg.
     * @return ggrzg
     */
    public final TypeJeu getTypeJeu() {
        if (lancer1 == STRIKE) {
            return TypeJeu.Strike;
        } else if ((lancer1 + lancer2) == STRIKE) {
            return TypeJeu.Spare;
        } else {
            return TypeJeu.Normal;
        }
    }

    /**
     *gzgzerg.
     * @param lanc1 egze
     * @param lanc2 egze
     */
    public Jeu(final int lanc1, final int lanc2) {
        this.lancer1 = lanc1;
        this.lancer2 = lanc2;
    }

    /**
     * zgzerg.
     * @return zgzergzgzerg
     */
    public final int getScore() {
        if (getTypeJeu() == TypeJeu.Strike || getTypeJeu() == TypeJeu.Spare) {
            return STRIKE; //STRIKE
        } else {
            return getLancer1() + getLancer2();
        }
    }

    /**
     * zgzerg.
     * @return zgzerg
     */
    public final int getLancer2() {
        return lancer2;
    }

    /**
     * zgzerg.
     * @return zgzerg
     */
    public final int getLancer1() {
        return lancer1;
    }
}
