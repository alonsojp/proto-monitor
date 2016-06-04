package mxbean;

/**
 * @author Jean-Pierre Alonso.
 */
public class First implements FirstMBean {
    private static String nom = "PremierMBean";
    private int valeur = 100;

    @Override public String getNom() {
        return nom;
    }

    @Override public int getValeur() {
        return valeur;
    }

    @Override public synchronized void setValeur(int valeur) {
        this.valeur = valeur;
    }

//    @Override
//    public String getAttribute() {return Integer.toString(valeur);}
//
//    @Override
//    public synchronized void setAttributes(AttributeList attList) {}

    @Override public void rafraichir() {
        System.out.println("Rafraichir les donnees");

    }

    public First() {

    }
}
