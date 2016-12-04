package jbla;

import java.util.List;

/**
 *
 */
public interface Sequence {
    /**
     *
     * @return boolean
     */
    boolean estValide();

    /**
     *
     * @return int
     */
    int getScore();

    /**
     *
     * @return list
     */
    List<Jeu> getJeux();
}
