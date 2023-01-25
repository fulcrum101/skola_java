public class Rinda { // FIFO
    class RindasElements{
        String vards;
        RindasElements nakamais;
    }

    private RindasElements sakums, beigas;
    public Rinda(){
        sakums = null;
        beigas = null;
    }

    public boolean tuksa(){
        return sakums==null;
    }
    public void pievienot(String vards){
        RindasElements elem = new RindasElements();
        elem.vards = vards;
        elem.nakamais = null;
        if (!tuksa()){
            beigas.nakamais = elem;
        } else {
            sakums = elem;
        }
        beigas = elem;
    }

    public String nonemt(){
        if (tuksa()) return "";
        String s = sakums.vards;
        sakums = sakums.nakamais;
        if (tuksa()){
            beigas = null;
        }
        return s;
    }
}