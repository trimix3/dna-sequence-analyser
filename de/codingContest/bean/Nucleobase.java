package de.codingContest.bean;

/**
 *
 * @author J. F. Kammann
 * @email janis.kammann@hotmail.de
 *
 */
public class Nucleobase {
    private int cytosines, guanines, adenines, thymines;

    public Nucleobase() {
        cytosines = 0;
        guanines = 0;
        adenines = 0;
        thymines = 0;
    }

    public Nucleobase(int cytosines, int guanines, int adenines, int thymines) {
        this.cytosines = cytosines;
        this.guanines = guanines;
        this.adenines = adenines;
        this.thymines = thymines;
    }

    public int getCytosines() {
        return cytosines;
    }

    public void setCytosines(int cytosines) {
        this.cytosines = cytosines;
    }

    public int getGuanines() {
        return guanines;
    }

    public void setGuanines(int guanines) {
        this.guanines = guanines;
    }

    public int getAdenines() {
        return adenines;
    }

    public void setAdenines(int adenines) {
        this.adenines = adenines;
    }

    public int getThymines() {
        return thymines;
    }

    public void setThymines(int thymines) {
        this.thymines = thymines;
    }
    
    public int getTotal() {
        return cytosines+guanines+adenines+thymines;
    }
}
