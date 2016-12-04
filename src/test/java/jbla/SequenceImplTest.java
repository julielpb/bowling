package jbla;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class SequenceImplTest {
    private SequenceImpl j1, j2, j3, j4, j5;

    private List<Sequence> sequencesValides;
    private List<Sequence> sequencesInvalides;

    /**
     *
     */
    @Before
    public void setUp() {
        ArrayList<Jeu> jeux = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            jeux.add(new Jeu(10, 0));
        }

        j1 = new SequenceImpl(jeux,10, 10);
        ArrayList<Jeu> jeux2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            jeux2.add(new Jeu(9, 0));
        }

        j2 = new SequenceImpl(jeux2, 0, 0);
        ArrayList<Jeu> jeux3 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            jeux3.add(new Jeu(5, 5));
        }

        j3 = new SequenceImpl(jeux3, 5, 0);
        ArrayList<Jeu> jeux4 = new ArrayList<>();
        jeux4.add(new Jeu(10, 0));
        for (int i = 0; i < 9; i++) {
            jeux4.add(new Jeu(3, 3));
        }

        j4 = new SequenceImpl(jeux4, 0, 0);
        ArrayList<Jeu> jeux5 = new ArrayList<>();
        jeux5.add(new Jeu(10, 0));
        jeux5.add(new Jeu(3, 7));
        jeux5.add(new Jeu(3, 3));
        jeux5.add(new Jeu(5, 5));
        jeux5.add(new Jeu(10, 0));
        jeux5.add(new Jeu(2, 0));
        for (int i = 0; i < 4; i++) {
            jeux5.add(new Jeu(3, 3));
        }
        j5 = new SequenceImpl(jeux5, 0, 0);


        sequencesValides = new ArrayList<>();
        sequencesInvalides = new ArrayList<>();

        //Premiere sequence valide
        jeux = new ArrayList<>();
        for(int i = 0 ; i < 10 ; i++)
           jeux.add(new Jeu(10, 0));
        this.sequencesValides.add(new SequenceImpl((ArrayList<Jeu>) jeux, 10, 10));

        //Deuxieme sequence valide
        jeux = new ArrayList<>();
        for(int i = 0 ; i < 10 ; i++)
            jeux.add(new Jeu(9, 0));
        this.sequencesValides.add(new SequenceImpl((ArrayList<Jeu>) jeux, 0, 0));

        //Troisieme sequence valide
        jeux = new ArrayList<>();
        for(int i = 0 ; i < 10 ; i++)
            jeux.add(new Jeu(5, 5));
        this.sequencesValides.add(new SequenceImpl((ArrayList<Jeu>) jeux, 0, 0));

        //Quatrieme sequence valide pour cause de onzieme lancer possible
        jeux = new ArrayList<>();
        for(int i = 0 ; i < 10 ; i++)
            jeux.add(new Jeu(10, 0));
        this.sequencesValides.add(new SequenceImpl((ArrayList<Jeu>) jeux, 5, 0));

        //Cinquieme sequence valide pour cause de douzieme lancer possible
        jeux = new ArrayList<>();
        for(int i = 0 ; i < 10 ; i++)
            jeux.add(new Jeu(10, 0));
        this.sequencesValides.add(new SequenceImpl((ArrayList<Jeu>) jeux, 10, 5));

        //Premiere sequence invalide pour cause de trop de jeux
        jeux = new ArrayList<>();
        for(int i = 0 ; i < 11 ; i++)
            jeux.add(new Jeu(5, 5));
        this.sequencesInvalides.add(new SequenceImpl((ArrayList<Jeu>) jeux, 0, 0));

        //Deuxieme sequence invalide pour cause de trop de quilles dans un jeu
        jeux = new ArrayList<>();
        jeux.add(new Jeu(5, 6));
        for(int i = 0 ; i < 9 ; i++)
            jeux.add(new Jeu(5, 5));
        this.sequencesInvalides.add(new SequenceImpl((ArrayList<Jeu>) jeux, 0, 0));

        //Troisieme sequence invalide pour cause de trop de quilles dans un lancer
        jeux = new ArrayList<>();
        jeux.add(new Jeu(11, 3));
        for(int i = 0 ; i < 9 ; i++)
            jeux.add(new Jeu(5, 5));
        this.sequencesInvalides.add(new SequenceImpl((ArrayList<Jeu>) jeux, 0, 0));

        //Quatrieme sequence invalide pour cause de pas assez de quilles dans un lancer
        jeux = new ArrayList<>();
        jeux.add(new Jeu(3, 11));
        for(int i = 0 ; i < 9 ; i++)
            jeux.add(new Jeu(5, 5));
        this.sequencesInvalides.add(new SequenceImpl((ArrayList<Jeu>) jeux, 0, 0));

        //Quatrieme sequence invalide pour cause de pas assez de quilles dans un lancer
        jeux = new ArrayList<>();
        jeux.add(new Jeu(-1, 5));
        for(int i = 0 ; i < 9 ; i++)
            jeux.add(new Jeu(5, 5));
        this.sequencesInvalides.add(new SequenceImpl((ArrayList<Jeu>) jeux, 0, 0));

        //Cinquieme sequence invalide pour cause de pas assez de quilles dans un lancer
        jeux = new ArrayList<>();
        jeux.add(new Jeu(5, -1));
        for(int i = 0 ; i < 9 ; i++)
            jeux.add(new Jeu(5, 5));
        this.sequencesInvalides.add(new SequenceImpl((ArrayList<Jeu>) jeux, 0, 0));

        //Sixieme sequence invalide pour cause de douzieme lancer non possible
        jeux = new ArrayList<>();
        for(int i = 0 ; i < 10 ; i++)
            jeux.add(new Jeu(10, 0));
        this.sequencesInvalides.add(new SequenceImpl((ArrayList<Jeu>) jeux, 5, 5));

        //septieme sequence invalide pour cause de onzieme lancer non possible
        jeux = new ArrayList<>();
        for(int i = 0 ; i < 10 ; i++)
            jeux.add(new Jeu(9, 0));
        this.sequencesInvalides.add(new SequenceImpl((ArrayList<Jeu>) jeux, 5, 5));

    }

    /**
     *
     */
    @Test
    public void testOnlyStrike(){
        Assert.assertEquals(j1.getScore(), 300);
    }

    /**
     *
     */
    @Test
    public void testOnly9(){
        Assert.assertEquals(j2.getScore(), 90);
    }

    /**
     *
     */
    @Test
    public void testSpare5(){
        Assert.assertEquals(j3.getScore(), 150);
    }

    /**
     *
     */
    @Test
    public void testStrike6(){
        Assert.assertEquals(j4.getScore(), 70);
    }

    /**
     *
     */
    @Test
    public void testJeu(){
        Assert.assertEquals(j5.getScore(), 97);
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void testEstValide() throws Exception {
        for(Sequence s : this.sequencesValides) {
            Assert.assertTrue(s.estValide());
        }
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void testEstInvalide() throws Exception {
        for(Sequence s : this.sequencesInvalides) {
            Assert.assertFalse(s.estValide());
        }
    }

}
