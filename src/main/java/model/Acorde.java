package model;

public class Acorde {
    private String tom;
    private String grau;
    private String acorde;

    public Acorde(String tom, String grau, String acorde) {
        this.tom = tom;
        this.grau = grau;
        this.acorde = acorde;
    }

    public String getTom() {
        return tom;
    }

    public String getGrau() {
        return grau;
    }

    public String getAcorde() {
        return acorde;
    }
}
