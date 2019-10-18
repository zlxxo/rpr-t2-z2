package ba.unsa.etf.rpr.tutorijal02;

public class Interval {

    private double pocetnaTacka;
    private double krajnjaTacka;
    private boolean pocetnaPripada;
    private boolean krajnjaPripada;

    public Interval(double pocetnaTacka, double krajnjaTacka, boolean pocetnaPripada, boolean krajnjaPripada) throws IllegalArgumentException {
        if(pocetnaTacka > krajnjaTacka) throw new IllegalArgumentException("");
        this.pocetnaTacka = pocetnaTacka;
        this.krajnjaTacka = krajnjaTacka;
        this.pocetnaPripada = pocetnaPripada;
        this.krajnjaPripada = krajnjaPripada;
    }

    public Interval() {
        this(0, 0, false, false);
    }

    public boolean isIn(double tacka) {
        return tacka > pocetnaTacka && tacka < krajnjaTacka || tacka == pocetnaTacka && pocetnaPripada || tacka == krajnjaTacka && krajnjaPripada;
    }

    public boolean isNull() {
        return pocetnaTacka == 0 && krajnjaTacka == 0 && !pocetnaPripada && !krajnjaPripada;
    }

    public Interval intersect(Interval interval) {
        Interval i = new Interval();
        double pocetna = pocetnaTacka, krajnja = krajnjaTacka;
        boolean pocetnaPripada = this.pocetnaPripada, krajnjaPripada = this.krajnjaPripada;

        if(pocetna < interval.pocetnaTacka) {
            pocetna = interval.pocetnaTacka;
            pocetnaPripada = interval.pocetnaPripada;
        } else if(pocetna == interval.pocetnaTacka) {
            pocetnaPripada = pocetnaPripada && interval.pocetnaPripada;
        }

        if(krajnja > interval.krajnjaTacka) {
            krajnja = interval.krajnjaTacka;
            krajnjaPripada = interval.krajnjaPripada;
        } else if(krajnja == interval.krajnjaTacka) {
            krajnjaPripada = krajnjaPripada && interval.krajnjaPripada;
        }

        try{
            i = new Interval(pocetna, krajnja, pocetnaPripada, krajnjaPripada);
        } catch (IllegalArgumentException e) {

        }

        return i;
    }

    public static Interval intersect(Interval i, Interval i2) {
        return i.intersect(i2);
    }

    @Override
    public String toString() {
        if(isNull()) return "()";
        String i = "";
        if(pocetnaPripada) i += "[";
        else i += "(";
        i += pocetnaTacka + "," + krajnjaTacka;
        if(krajnjaPripada) i += "]";
        else i += ")";
        return i;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Interval) {
            Interval i = (Interval) o;
            return pocetnaTacka == i.pocetnaTacka && krajnjaTacka == i.krajnjaTacka && pocetnaPripada == i.pocetnaPripada && krajnjaPripada == i.krajnjaPripada;
        }

        return false;
    }

    public double getPocetnaTacka() {
        return pocetnaTacka;
    }

    public void setPocetnaTacka(double pocetnaTacka) {
        this.pocetnaTacka = pocetnaTacka;
    }

    public double getKrajnjaTacka() {
        return krajnjaTacka;
    }

    public void setKrajnjaTacka(double krajnjaTacka) {
        this.krajnjaTacka = krajnjaTacka;
    }

    public boolean isPocetnaPripada() {
        return pocetnaPripada;
    }

    public void setPocetnaPripada(boolean pocetnaPripada) {
        this.pocetnaPripada = pocetnaPripada;
    }

    public boolean isKrajnjaPripada() {
        return krajnjaPripada;
    }

    public void setKrajnjaPripada(boolean krajnjaPripada) {
        this.krajnjaPripada = krajnjaPripada;
    }
}
