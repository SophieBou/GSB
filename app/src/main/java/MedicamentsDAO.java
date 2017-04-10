import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by sophie on 10/04/2017.
 */

public class MedicamentsDAO {

        private static String base = "BDMedicaments";
        private static int version = 1;
        private MaBaseSQLite accesBD;

        public MedicamentsDAO(Context ct){
            accesBD = new MaBaseSQLite(ct, base, null, version);
        }


        public long addMedicaments(Medicaments unMedicament){
            long ret;
            SQLiteDatabase bd = accesBD.getWritableDatabase();

            ContentValues value = new ContentValues();
            value.put("DEPOTLEGAL", unMedicament.getMED_DEPOTLEGAL());
            value.put("NOMCOMMERCIAL", unMedicament.getMED_NOMCOMMERCIAL());
            value.put("CODE", unMedicament.getMED_FAM_CODE().getFAM_CODE());
            value.put("COMPOSITION", unMedicament.getMED_COMPOSITION());
            value.put("EFFETS", unMedicament.getMED_EFFETS());
            value.put("CONTREINDIC", unMedicament.getMED_CONTREINDIC());
            value.put("PRIXECHANTILLON", unMedicament.getMED_PRIXECHANTILLON());

            ret = bd.insert("Medicaments", null, value);
            return ret;
        }


    //    public Composants getMedicament(String nom_){
            //   Medicaments lemedicaments = null;
            //   Cursor curseur;
            //  curseur = accesBD.getReadableDatabase().rawQuery("select * from composant where CODE ="+Code_+";",null);
            //   if (curseur.getCount() > 0) {
                //    curseur.moveToFirst();
                //leArticle = new Article(id,curseur.getString(1), curseur.getInt(2));
                //     lecomposant = new Composants(curseur.getString(0),curseur.getString(1));
                // }
            //  return lecomposant;
            // }


        public ArrayList<Medicaments> getMedicaments(){
            Cursor curseur;
            String req = "select * from Medicaments;";
            curseur = accesBD.getReadableDatabase().rawQuery(req,null);
            return cursorToArticleArrayList(curseur);
        }


        // a revoir pour les familles et les composants
        private ArrayList<Medicaments> cursorToArticleArrayList(Cursor curseur){
            ArrayList<Medicaments> listeMedicaments = new ArrayList<Medicaments>();
            String DEPOTLEGAL;
            String NOMCOMMERCIAL;
            Familles CODE = new Familles();
            String COMPOSITION;
            String EFFETS;
            String CONTREINDIC;
            float PRIXECHANTILLON;

            curseur.moveToFirst();
            while (!curseur.isAfterLast()){
                DEPOTLEGAL = curseur.getString(0);
                NOMCOMMERCIAL = curseur.getString(1);
                CODE.setFAM_CODE(curseur.getString(2)) ;
                COMPOSITION = curseur.getString(3);
                EFFETS = curseur.getString(4);
                CONTREINDIC = curseur.getString(5);
                PRIXECHANTILLON = curseur.getFloat(6);
                listeMedicaments.add(new Medicaments(DEPOTLEGAL,NOMCOMMERCIAL,CODE,COMPOSITION,EFFETS,CONTREINDIC,PRIXECHANTILLON));
                curseur.moveToNext();
            }

            return listeMedicaments;
        }

    }
