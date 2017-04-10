/**
 * Created by sophie on 10/04/2017.
 */

public class Composants {

    private String CMP_CODE;
    private String CMP_lIBELLE;


    public Composants(String CMP_CODE, String CMP_lIBELLE) {
        this.CMP_CODE = CMP_CODE;
        this.CMP_lIBELLE = CMP_lIBELLE;

    }

    public String getCMP_CODE() {
        return this.CMP_CODE;
    }

    public void setCMP_CODE(String CMP_CODE) {
        this.CMP_CODE = CMP_CODE;
    }

    public String getCMP_lIBELLE() {
        return this.CMP_lIBELLE;
    }

    public void setCMP_lIBELLE(String CMP_lIBELLE) {
        this.CMP_lIBELLE = CMP_lIBELLE;
    }
}
