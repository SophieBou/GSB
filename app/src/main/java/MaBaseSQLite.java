import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sophie on 10/04/2017.
 */

public class MaBaseSQLite  extends SQLiteOpenHelper {

    private static final String  MED_DEPOTLEGAL = "DEPOTLEGAL";
    private  static final String MED_NOMCOMMERCIAL = "NOMCOMMERCIAL";
    private  static final String MED_FAM_CODE = "CODE";
    private  static final String MED_COMPOSITION  = "COMPOSITION";
    private  static final String MED_EFFETS = "EFFETS";
    private  static final String MED_CONTREINDIC = "CONTREINDIC";
    private  static final String MED_PRIXECHANTILLON = "PRIXECHANTILLON";
    private  static final String Medicaments_Table = "Medicaments";
    private  static final String MED_TABLE_DROP = "DROP TABLE IF EXISTS " + Medicaments_Table + ";";


    private  static final String Famille_Table = "famille";
    private  static final String FAM_CODE = "CODE";
    private  static final String FAM_lIBELLE = "LIBELLE";
    private  static final String FAM_TABLE_DROP = "DROP TABLE IF EXISTS " + Famille_Table + ";";


    private  static final String Composant_Table = "composant";
    private  static final String CMP_CODE = "CODE";
    private  static final String CMP_lIBELLE = "LIBELLE";
    private  static final String CMP_TABLE_DROP = "DROP TABLE IF EXISTS " + Composant_Table + ";";



    public static final String CREATE_BDD_MED  =
                "CREATE TABLE " + Medicaments_Table + " (" +
                        MED_DEPOTLEGAL + " TEXT PRIMARY KEY, " +
                        MED_NOMCOMMERCIAL + " TEXT, " +
                        MED_FAM_CODE + " TEXT, " +
                        MED_COMPOSITION + " TEXT, " +
                        MED_EFFETS + " TEXT, " +
                        MED_CONTREINDIC + " TEXT, " +
                        MED_PRIXECHANTILLON + " REAL);";


    public static final String CREATE_BDD_FAM  =
            "CREATE TABLE " + Famille_Table + " (" +
                    FAM_CODE + " TEXT PRIMARY KEY, " +
                    FAM_lIBELLE + " TEXT, );";

        public MaBaseSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

    public static final String CREATE_BDD_COMPO  =
            "CREATE TABLE " + Composant_Table + " (" +
                    CMP_CODE + " TEXT PRIMARY KEY, " +
                    CMP_lIBELLE + " TEXT, );";


        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_BDD_MED);
            db.execSQL(CREATE_BDD_FAM);
            db.execSQL(CREATE_BDD_COMPO);

            //  db.execSQL("insert into article (REF,DES,PU,QTE) values('Ref1','Reference1','1',50);");

            // ContentValues value = new ContentValues();
            // value.put("REF", "Esquerra");
            // value.put("DES", "Esquerra des");
            // value.put("PU", "11");
            // value.put("QTE",60);
            // db.insert("article", null, value);
        }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //On peut faire ce qu'on veut ici moi j'ai décidé de supprimer la table et de la recréer
        //comme ça lorsque je change la version les id repartent de 0
        db.execSQL("DROP TABLE " + FAM_TABLE_DROP + ";");
        db.execSQL("DROP TABLE " + MED_TABLE_DROP + ";");
        db.execSQL("DROP TABLE " + CMP_TABLE_DROP + ";");
        onCreate(db);
    }
    }

