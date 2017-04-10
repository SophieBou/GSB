import java.util.ArrayList;

/**
 * Created by sophie on 10/04/2017.
 */

public class Familles {

    private String FAM_CODE;
    private String FAM_lIBELLE;
    public Familles() {
      }

    public Familles(String FAM_CODE, String FAM_lIBELLE) {
        this.FAM_CODE = FAM_CODE;
        this.FAM_lIBELLE = FAM_lIBELLE;

    }

    public String getFAM_CODE() {
        return this.FAM_CODE;
    }

    public void setFAM_CODE(String FAM_CODE) {
        this.FAM_CODE = FAM_CODE;
    }

    public String getFAM_lIBELLE() {
        return this.FAM_lIBELLE;
    }

    public void setFAM_lIBELLE(String FAM_lIBELLE) {
        this.FAM_lIBELLE = FAM_lIBELLE;
    }
}
