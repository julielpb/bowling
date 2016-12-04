package jbla;

import java.util.ArrayList;
import java.util.List;

/**
 * Implémentation d'une sequence.
 */
public class SequenceImpl implements Sequence {

    /**
     *
     */
    private final ArrayList<Jeu> jeux;
    /**
     *
     */
    private final int onziemeLancer;
    /**
     *
     */
    private final int douziemeLancer;
    /**
     *
     */
    private static final int DERNIER_JEU = 9;

    /**
     *
     */
    private static final int AVANT_DERNIER_JEU = 8;

    /**
     *
     */
    private static final int MAX_NB_JEU = 10;

    /**
     * Constructor.
     * @param j ygyftf
     * @param onzieme ihhu
     * @param douzieme bvyvy
     */
    public SequenceImpl(final ArrayList<Jeu> j,
                        final int onzieme,
                        final int douzieme) {
        this.jeux = j;
        this.onziemeLancer = onzieme;
        this.douziemeLancer = douzieme;
    }

    /**
     * Retourne si la sequence est valide.
     * @return boolean, si la sequence est valide
     */
    @Override
    public final boolean estValide() {
        List<Jeu> j = this.getJeux();
        int nbJeux = jeux.size();

        //Si le nombre de jeux est different de 10 la sequence est invalide
        if (nbJeux != MAX_NB_JEU) {
            return false;
        }

        for (Jeu jeu : j) {
            //si un des jeux fait tomber moins de 0 quilles
            // ou plus de 10 quille au premier lancer,
            // la sequence est invalide
            if (jeu.getLancer1() > Jeu.STRIKE || jeu.getLancer1() < 0) {
                return false;
            }

            //meme condition pour le deuxieme lancer
            if (jeu.getLancer2() > Jeu.STRIKE) {
                return false;
            }

            if (jeu.getLancer2() < 0) {
                return false;
            }

            //Si l'addition des deux lancers est superieure a 10
            // la sequence est invalide
            if (jeu.getLancer2() + jeu.getLancer1() > Jeu.STRIKE) {
                return false;
            }
        }

        //Si le dernier lancer n'est pas un strike alors pas de onzieme lancer
        if (jeux.get(DERNIER_JEU).getLancer1() < Jeu.STRIKE
                && onziemeLancer > 0) {
            return false;
        }

        //Si le onzieme lancer n'est pas un strike alors pas de douzieme lancer
        if (onziemeLancer < Jeu.STRIKE && douziemeLancer > 0) {
            return false;
        }

        return true;
    }

    /**
     * Calcule le score.
     * @return int, le score de la partie
     */
    @Override
    public final int getScore() {
        int scoreTotal, scoreJeu;
        scoreTotal = 0;
        Jeu jeu, jeuSuiv;
        for (int i = 0; i < jeux.size(); i++) {
            jeu = jeux.get(i);
            scoreJeu = jeu.getScore();
            if (jeu.getTypeJeu() != Jeu.TypeJeu.Normal) {
                if (i < DERNIER_JEU) {
                    jeuSuiv = jeux.get(i + 1);
                    if (jeu.getTypeJeu() == Jeu.TypeJeu.Strike) {
                        scoreJeu += jeuSuiv.getScore();
                        if (jeuSuiv.getTypeJeu() == Jeu.TypeJeu.Strike) {
                            if (i == AVANT_DERNIER_JEU) {
                                scoreJeu += onziemeLancer;
                            } else {
                                scoreJeu += jeux.get(i + 2).getLancer1();
                            }
                        }
                    } else {
                        scoreJeu += jeuSuiv.getLancer1();
                    }
                } else {
                    scoreJeu += onziemeLancer;
                    if (jeu.getTypeJeu() == Jeu.TypeJeu.Strike) {
                        scoreJeu += douziemeLancer;
                    }
                }
            }
            scoreTotal += scoreJeu;
        }
        return scoreTotal;
    }

    /**
     *
     * @return g
     */
    @Override
    public final List<Jeu> getJeux() {
        return this.jeux;
    }
}
