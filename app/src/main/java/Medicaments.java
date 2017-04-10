import java.util.ArrayList;

/**
 * Created by sophie on 10/04/2017.
 */

public class Medicaments {


    private String MED_DEPOTLEGAL;
    private String MED_NOMCOMMERCIAL;
    private Familles MED_FAM_CODE;
    private String MED_COMPOSITION;
    private String MED_EFFETS;
    private String MED_CONTREINDIC;
    private float MED_PRIXECHANTILLON;
    private ArrayList<Composants> ListeComposant = new ArrayList<Composants>();

    public Medicaments(String MED_DEPOTLEGAL, String MED_NOMCOMMERCIAL, Familles MED_FAM_CODE, String MED_COMPOSITION, String MED_EFFETS, String MED_CONTREINDIC, float MED_PRIXECHANTILLON) {
        this.MED_DEPOTLEGAL = MED_DEPOTLEGAL;
        this.MED_NOMCOMMERCIAL = MED_NOMCOMMERCIAL;
        this.MED_FAM_CODE = MED_FAM_CODE;
        this.MED_COMPOSITION = MED_COMPOSITION;
        this.MED_EFFETS = MED_EFFETS;
        this.MED_CONTREINDIC = MED_CONTREINDIC;
        this.MED_PRIXECHANTILLON = MED_PRIXECHANTILLON;
    }

    public String getMED_DEPOTLEGAL() {
        return this.MED_DEPOTLEGAL;
    }

    public void setMED_DEPOTLEGAL(String MED_DEPOTLEGAL) {
        this.MED_DEPOTLEGAL = MED_DEPOTLEGAL;
    }

    public String getMED_NOMCOMMERCIAL() {
        return this.MED_NOMCOMMERCIAL;
    }

    public void setMED_NOMCOMMERCIAL(String MED_NOMCOMMERCIAL) {
        this.MED_NOMCOMMERCIAL = MED_NOMCOMMERCIAL;
    }

    public Familles getMED_FAM_CODE() {
        return this.MED_FAM_CODE;
    }

    public void setMED_FAM_CODE(Familles MED_FAM_CODE) {
        this.MED_FAM_CODE = MED_FAM_CODE;
    }

    public String getMED_COMPOSITION() {
        return this.MED_COMPOSITION;
    }

    public void setMED_COMPOSITION(String MED_COMPOSITION) {
        this.MED_COMPOSITION = MED_COMPOSITION;
    }
    public String getMED_EFFETS() {
        return this.MED_EFFETS;
    }

    public void setMED_EFFETS(String MED_EFFETS) {
        this.MED_EFFETS = MED_EFFETS;
    }

    public String getMED_CONTREINDIC() {
        return this.MED_CONTREINDIC;
    }

    public void setMED_CONTREINDIC(String MED_CONTREINDIC) {
        this.MED_CONTREINDIC = MED_CONTREINDIC;
    }

    public float getMED_PRIXECHANTILLON() {
        return this.MED_PRIXECHANTILLON;
    }

    public void setMED_PRIXECHANTILLON(float MED_PRIXECHANTILLON) {
        this.MED_PRIXECHANTILLON = MED_PRIXECHANTILLON;
    }


    public ArrayList<Composants> getListeComposant() {
        return this.ListeComposant;
    }

    public void setListeComposant(ArrayList<Composants> ListeComposant) {
        this.ListeComposant = ListeComposant;
    }

}
