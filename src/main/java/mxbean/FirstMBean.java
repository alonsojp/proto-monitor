package mxbean;

/**
 * @author Jean-Pierre Alonso.
 */
public interface FirstMBean {
    String getNom();

    int getValeur();

    void setValeur(int valeur);

    void rafraichir();
}
