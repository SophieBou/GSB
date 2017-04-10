import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by sophie on 10/04/2017.
 */

public class ComposantDAO {
    private static String base = "BDMedicaments";
    private static int version = 1;
    private MaBaseSQLite accesBD;

    public ComposantDAO(Context ct){
        accesBD = new MaBaseSQLite(ct, base, null, version);
    }


    public long addComposants(Composants unComposant){
        long ret;
        SQLiteDatabase bd = accesBD.getWritableDatabase();

        ContentValues value = new ContentValues();
        value.put("CODE", unComposant.getCMP_CODE());
        value.put("LIBELLE", unComposant.getCMP_lIBELLE());

        ret = bd.insert("composant", null, value);
        return ret;
    }


    public Composants getComposant(String Code_){
        Composants lecomposant = null;
        Cursor curseur;
        curseur = accesBD.getReadableDatabase().rawQuery("select * from composant where CODE ="+Code_+";",null);
        if (curseur.getCount() > 0) {
            curseur.moveToFirst();
            //leArticle = new Article(id,curseur.getString(1), curseur.getInt(2));
            lecomposant = new Composants(curseur.getString(0),curseur.getString(1));
        }
        curseur.close();
        return lecomposant;
    }


    public ArrayList<Composants> getComposants(){
        Cursor curseur;
        String req = "select * from famille;";
        curseur = accesBD.getReadableDatabase().rawQuery(req,null);
        return cursorToArticleArrayList(curseur);
    }


    private ArrayList<Composants> cursorToArticleArrayList(Cursor curseur){
        ArrayList<Composants> listeComposants = new ArrayList<Composants>();
        String CODE;
        String LIBELLLE;

        curseur.moveToFirst();
        while (!curseur.isAfterLast()){
            CODE = curseur.getString(0);
            LIBELLLE = curseur.getString(1);

            listeComposants.add(new Composants(CODE,LIBELLLE));
            curseur.moveToNext();
        }

        return listeComposants;
    }
}
