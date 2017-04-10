import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by sophie on 10/04/2017.
 */

public class FamilleDAO {

    private static String base = "BDMedicaments";
    private static int version = 1;
    private MaBaseSQLite accesBD;

    public FamilleDAO(Context ct){
        accesBD = new MaBaseSQLite(ct, base, null, version);
    }


    public long addFamille(Familles uneFamille){
        long ret;
        SQLiteDatabase bd = accesBD.getWritableDatabase();

        ContentValues value = new ContentValues();
        value.put("CODE", uneFamille.getFAM_CODE());
        value.put("LIBELLE", uneFamille.getFAM_lIBELLE());

        ret = bd.insert("famille", null, value);
        return ret;
    }


    public Familles getFamille(String Code_){
        Familles laFamille = null;
        Cursor curseur;
        curseur = accesBD.getReadableDatabase().rawQuery("select * from famille where CODE ="+Code_+";",null);
        if (curseur.getCount() > 0) {
            curseur.moveToFirst();
            //leArticle = new Article(id,curseur.getString(1), curseur.getInt(2));
            laFamille = new Familles(curseur.getString(0),curseur.getString(1));
        }
        curseur.close();
        return laFamille;
    }


    public ArrayList<Familles> getFamilles(){
        Cursor curseur;
        String req = "select * from famille;";
        curseur = accesBD.getReadableDatabase().rawQuery(req,null);
        return cursorToArticleArrayList(curseur);
    }


    private ArrayList<Familles> cursorToArticleArrayList(Cursor curseur){
        ArrayList<Familles> listeFamilles = new ArrayList<Familles>();
        String CODE;
        String LIBELLLE;

        curseur.moveToFirst();
        while (!curseur.isAfterLast()){
            CODE = curseur.getString(0);
            LIBELLLE = curseur.getString(1);

            listeFamilles.add(new Familles(CODE,LIBELLLE));
            curseur.moveToNext();
        }

        return listeFamilles;
    }

}
