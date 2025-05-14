package model;

public class Acorde {
    private String tom;
    private String modo;
    private int grau;
    private String acorde;

    public Acorde(String tom, String modo, int grau, String acorde) {
        this.tom = tom;
        this.modo = modo;
        this.grau = grau;
        this.acorde = acorde;
    }

    // Getters
    public String getTom() {
        return tom;
    }

    public String getModo() {
        return modo;
    }

    public int getGrau() {
        return grau;
    }

    public String getAcorde() {
        return acorde;
    }

    @Override
    public String toString() {
        return grau + " - " + acorde;
    }
}
