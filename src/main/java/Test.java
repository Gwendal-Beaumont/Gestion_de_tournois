public class Test {

    //Attributs
    double resultat ;
    boolean seum ;

    public void setSeum(boolean x){
        this.seum = x;
    }
    public void campagnes(double resultat) {
        if (resultat > 50) {
            setSeum(true);
        } else {
            setSeum(false);
        }
    }
}
