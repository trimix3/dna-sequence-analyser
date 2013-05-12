package de.codingContest.logic;

import de.codingContest.bean.Nucleobase;

/**
 *
 * @author J. F. Kammann
 * @email janis.kammann@hotmail.de
 *
 */
public class PatternRecognition {

    //Holds the DNA sequence.
    private String dnaSequence;

    /**
     * Constructor and setting the DNA sequence.
     *
     * @param dnaSequence The DNA sequence.
     */
    public PatternRecognition(String dnaSequence) {
        this.dnaSequence = dnaSequence;
    }

    /**
     * Method to count each nucleobase in the DNA sequence.
     *
     * @return (Nucleobase) holds the following: cytosines, guanines, adenines,
     * thymines
     */
    public Nucleobase countNucleobases() {
        String currentChar = "";
        Nucleobase nucleobase = new Nucleobase();
        for (int i = 0; i < dnaSequence.length(); i++) {
            currentChar = String.valueOf(dnaSequence.charAt(i)).toLowerCase();
            switch (currentChar) {
                case "c":
                    nucleobase.setCytosines(nucleobase.getCytosines() + 1);
                    break;
                case "g":
                    nucleobase.setGuanines(nucleobase.getGuanines() + 1);
                    break;
                case "a":
                    nucleobase.setAdenines(nucleobase.getAdenines() + 1);
                    break;
                case "t":
                    nucleobase.setThymines(nucleobase.getThymines() + 1);
                    break;
            }
        }
        return nucleobase;
    }

    /**
     * Method which tests the dna sequence of the tyberius syndrom.
     *
     * @return (boolean) true if tyberius syndrom was found.
     */
    public boolean testOfTyberiusSyndrom() {
        int status = 0;
        for (int i = 0; i < 3; i++) {
            if (dnaSequence.toLowerCase().indexOf("ggg") == -1) {
                status++;
            }
        }
        if(status>=3) {
            return true;
        }
        return false;
    }

    /**
     * Method which searches for a specific pattern in the dna sequence to
     * determine if the person has brown eyes.
     *
     * @return (boolean) true if the nucleobases for brown eye color was found.
     */
    public boolean testOfBrownEyeColor() {
        int index = 0;
        if ((index = dnaSequence.toLowerCase().indexOf("cag")) != -1) {
            if ((String.valueOf(dnaSequence.toLowerCase().charAt(index + 2)).equals("c")
                    && !String.valueOf(dnaSequence.toLowerCase().charAt(index + 3)).equals("c"))
                    || (String.valueOf(dnaSequence.toLowerCase().charAt(index + 2)).equals("g")
                    && !String.valueOf(dnaSequence.toLowerCase().charAt(index + 3)).equals("g"))
                    && !String.valueOf(dnaSequence.toLowerCase().charAt(index + 3)).equals("t")) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method which searches for the first occurrence of ctag.
     *
     * @return (int) -1 if not found, else the index of the first occurrence.
     */
    public int searchForCTAG() {
        return dnaSequence.toLowerCase().indexOf("ctag");
    }

    /**
     * Method which counts purines and pyrimidines.
     *
     * @return (boolean) true if more purines were found than pyrimidines.
     */
    public boolean checkIfMorePurinesThanPyrimidines() {
        String textAtIndex = "";
        String textAtSecondIndex = "";
        int purines = 0;
        int pyrimidines = 0;
        for (int i = 0; i < dnaSequence.length(); i++) {
            textAtIndex = String.valueOf(dnaSequence.toLowerCase().charAt(i));
            textAtSecondIndex = String.valueOf(dnaSequence.toLowerCase().charAt(i + 1));
            if ((textAtIndex.equals("a") && textAtSecondIndex.equals("a"))
                    || (textAtIndex.equals("g") && textAtSecondIndex.equals("g"))) {
                purines++;
            }
            if ((textAtIndex.equals("c") && textAtSecondIndex.equals("t"))
                    || (textAtIndex.equals("t") && textAtSecondIndex.equals("c"))) {
                pyrimidines++;
            }
            i++;
        }
        if (purines > pyrimidines) {
            return true;
        }
        return false;
    }

    /**
     * Method which checks for the Fromingen dischrypsia early onset.
     *
     * @return (boolean) true if found.
     */
    public boolean checkForFromingen() {
        String textAtIndex = "";
        String textAtSecondIndex = "";
        int lastIndex = 0;
        int purines = 0;
        int pyrimidines = 0;
        boolean fromingen = false;
        //looks for the first four purines.
        for (int i = 0; i < dnaSequence.length(); i++) {
            textAtIndex = String.valueOf(dnaSequence.toLowerCase().charAt(i));
            textAtSecondIndex = String.valueOf(dnaSequence.toLowerCase().charAt(i + 1));
            if ((textAtIndex.equals("a") && textAtSecondIndex.equals("a"))
                    || (textAtIndex.equals("g") && textAtSecondIndex.equals("g"))) {
                purines++;
            } else {
                purines = 0;
            }

            if (purines == 4) {
                lastIndex = i;
                break;
            }
            i++;
        }
        //looks for the following four pyrimidines.
        if (purines == 4) {
            for (int i = 0; i < 4; i++) {
                textAtIndex = String.valueOf(dnaSequence.toLowerCase().charAt(lastIndex + i));
                textAtSecondIndex = String.valueOf(dnaSequence.toLowerCase().charAt(lastIndex + i + 1));
                if ((textAtIndex.equals("c") && textAtSecondIndex.equals("t"))
                        || (textAtIndex.equals("t") && textAtSecondIndex.equals("c"))) {
                    pyrimidines++;
                } else {
                    pyrimidines = 0;
                    break;
                }
                if (pyrimidines == 4) {
                    fromingen = true;
                }
            }
        }
        return fromingen;
    }

    /**
     * Method which generates the complementary dna sequence to the original
     * one.
     *
     * @return (String) complementary dna sequence.
     */
    public String getComplementarySequence() {
        String textAtIndex = "";
        String complementaryDnaSequence = "";

        for (int i = 0; i < dnaSequence.length(); i++) {
            textAtIndex = String.valueOf(dnaSequence.toLowerCase().charAt(i));
            switch (textAtIndex) {
                case "a":
                    complementaryDnaSequence += "t";
                    break;
                case "t":
                    complementaryDnaSequence += "a";
                    break;
                case "c":
                    complementaryDnaSequence += "g";
                    break;
                case "g":
                    complementaryDnaSequence += "c";
                    break;
            }
            if (i % 100 == 0 && i != 0) {
                complementaryDnaSequence += "\n";
            }
        }
        System.out.println(complementaryDnaSequence);
        return complementaryDnaSequence;
    }
}