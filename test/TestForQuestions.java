/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import de.codingContest.logic.PatternRecognition;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author janiskammann
 */
public class TestForQuestions {

    private String dnaSequence;
    private PatternRecognition patternRecognition;

    public TestForQuestions() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        dnaSequence = "ggaatttagggagttcccacattgcccagacgactcgtatagaattggtagttggccatg"
                + "cgtccatatcacaaagacacagtccctggccgaccacactgtaaccacgaatatgcccta"
                + "tcgtacgggttgggatgcacttttgagttatacgcgctcgaatctatgcccagtacacat"
                + "ggtgccgacacctaactaggcagtgaggggcactcagacctgacatgagcggaagaaaga"
                + "acccgcgggggccccacgacgtagcggcgacggctcaaccaatgccccgcccctttcata"
                + "aggccaagcggactgggctttcgcccgagtctaaacccactgtatttaccattcatagtc"
                + "aacagagggactttcaaaattcctaaactggttactgactaagaggaatcctcgcgctaa"
                + "tgaagacaacctccatagaggtcaaatggcgcgcagttgacttcagtattgaccttcttc"
                + "agggtcccccatctttgatacttcacttatggacccggccaccgtgagttgaatcccggc"
                + "gtccctcgcgtccccaacacagacaatatttttacgtgtccaagggcggaaagtgacgag"
                + "gtgagaactggcgccgcgagaccggcccgatttctaataggcgggatagagatctgcccg"
                + "acgcatttcacttgtagtcactcacggtatgactgtgcatgcactgaccgtcgctggcgt"
                + "gtctttaatttaagctaggcttgacgtggagtgcagaatgaccatgttcaaggtgcttcg"
                + "gggctatatacttgggataaacgcgatcctgcggagtagcgtcgagaacaccgactgccg"
                + "aatgtacaatccgcgtgacaatgccgaggctcgagatatcacttgaactgcgggcgaatc"
                + "gattcgagagcccgatcgttaacaagtcgtcggctgtagccaataatatcttggttttag"
                + "atcttgagtgtgggggcgtttacttaaccatccgaacgcg";
        patternRecognition = new PatternRecognition(dnaSequence);
    }

    @After
    public void tearDown() {
        patternRecognition = null;
    }

    /*
     * Three distinct sequences of "GGG" within any 1000-nucleobases signify
     * an elevated riskto acquiring Tyberius syndrome. Based on the given
     * DNA segment, is this female at suchrisk?
     */
    @Test
    public void testForTyberiusSyndrome() {
        boolean result = patternRecognition.testOfTyberiusSyndrom();
        assertFalse(result);
    }

    /*
     * The sequence "CAG" followed by exactly one "C" or one "G"
     * and then not followed by Tin the next 2 slots signifies brown eyes.
     * Does this female have brown eyes?
     */
    @Test
    public void testForBrownEyes() {
        assertTrue(patternRecognition.testOfBrownEyeColor());
    }
    /*
     * How many of each nucleobase does this segment have?
     */

    @Test
    public void testCountNucleobases() {
        int expected = 1000;
        assertEquals(expected, patternRecognition.countNucleobases().getTotal());
    }
    /*
     * What's the location of the first occurrence of the
     * sequence "CTAG" in the given segment(assume nucleobases
     * are numbered from 1 to 1000).
     */

    @Test
    public void testForFirstCTAG() {
        int expected = 195;
        assertEquals(expected, patternRecognition.searchForCTAG());
    }
    /*
     * Does this segment have more purines than pyrimidines?
     */

    @Test
    public void testForMorePurinesThanPyrimidines() {
        assertFalse(patternRecognition.checkIfMorePurinesThanPyrimidines());
    }
    /*
     * Four purines followed by four pyrimidines have been shown
     * to have a strong correlationwith the early onset of Frømingen's dischrypsia.
     * Does this DNA strand show evidence forthis correlation?
     */

    @Test
    public void testForFromingenDischrypsia() {
        assertFalse(patternRecognition.checkForFromingen());
    }
}
