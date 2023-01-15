public class RindaMasiva {

    private String[] rinda;
    private int sakums, beigas;
    private int n;
    // konstruktors, izveido tukšu rindu n stringiem
    public RindaMasiva(int n) {
        this.n = n;
        rinda = new String[n];
        sakums = -1;
        beigas = -1;
    }
    // metode atgriež True ja rinda ir tukša
    public boolean irTuksa() {
        return sakums == -1;
    }
    // metodei pievieno rindai virkni s, ja rinda nav pilna
    public void pievienot(String s) {
        if ((beigas + 1) % n != sakums) {  //ja palielinot beigas, uzbrauc sākumam - rinda pilna
            beigas = (beigas + 1) % n;   //ja nav pilna, palielina beigas tā, ka var apiet uz riņķi
            rinda[beigas] = s;       //beigās ieliek jauno elementu
            if (sakums == -1) {        // kad rindā ieliek 1.elementu, jāuzstāda arī sākums
                sakums = 0;
            }
        }
    }
    // metode noņem pirmo rindas elementu, ja rinda nav tukša
    public void nonemt() {
        if (!irTuksa()) {    //ja rinda nav tukša
            if (sakums == beigas) {   //ja rindā tikai viens elements
                sakums = -1;        // tad rindu tukšojot sakums jāuzliek -1
                beigas = -1;        // un beigas arī, lai rinda pēc tam atkal pareizi pildās
            } else {
                sakums = (sakums + 1) % n;   //palielina sākuma vērtību tā, lai tā var apiet uz riņķi
            }
        }
    }
    // metode atgriež rindas pirmā elementa vērtību, ja rinda nav tukša
    public String pirmais() {
        String s = "";
        if (!irTuksa()) {    //ja rinda nav tukša
            s = rinda[sakums];  //piešķir rindas sākuma elementa vērtibu
        }
        return s;
    }

    public static void main(String[] args) {
        RindaMasiva rm = new RindaMasiva(3);
        System.out.println(rm.pirmais());
        rm.nonemt();//testē tukšu rindu
        rm.pievienot("Saule");  //testē pievienošanu
        rm.pievienot("Merkurs");//testē pievienošanu
        rm.pievienot("Neptūns");//testē pievienošanu
        rm.pievienot("Zeme"); //testē pilnu rindu
        System.out.println(rm.pirmais());
        rm.nonemt();  //testē noņemsānu
        rm.pievienot("Mēness");  //testē pievienošanu masīva sākumā
        System.out.println(rm.pirmais());
        rm.nonemt();  //testē noņemšanu
        System.out.println(rm.pirmais());
        rm.nonemt();//testē noņemšanu
        System.out.println(rm.pirmais());
        rm.nonemt(); //testē noņemšanu
        System.out.println(rm.pirmais());
        rm.nonemt(); //testē noņemšanu no tukšas rindas
        rm.pievienot("Saturns");  //testē vai pareizi rinda atkal no jauna pildā
        System.out.println(rm.pirmais());
        rm.nonemt();
    }
}
