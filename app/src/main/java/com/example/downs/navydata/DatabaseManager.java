package com.example.downs.navydata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.List;

public class DatabaseManager extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "sailorData";
    public static final String ID_FIELD = "_id";
    public static final String NAME_FIELD = "name";
    public static final String UNIT_FIELD = "unit";
    public static final String NOSC_FIELD = "nosc";
    public static final String MOB_ACTIVITY_FIELD = "mob_activity";
    public static final String MOB_BILLET_FIELD = "mob_billet";
    public static final String TRUIC_FIELD = "truic";
    public static final String UMUIC_FIELD = "umuic";
    public static final String NOSC_UIC_FIELD = "nosc_uic";
    public static final String PRD_FIELD = "prd";
    public static final String EAOS_FIELD = "eoas";
    public static final String CED_FIELD = "ced";
    public static final String REPORT_DATE_FIELD = "report_date";
    public static final String RANK_DATE_FIELD = "rank_date";
    public static final String CLEARANCE_DATE_FIELD = "clearance_date";

    public DatabaseManager(Context context) {
        super(context, 
                /*db name=*/ "sailorDate_db2",
                /*cursorFactory=*/ null, 
                /*db version=*/1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("db", "onCreate");
        String sql = "CREATE TABLE " + TABLE_NAME
                + " (" + ID_FIELD + " INTEGER, "
                + NAME_FIELD + " TEXT,"
                + UNIT_FIELD + " TEXT,"
                + NOSC_FIELD + " TEXT,"
                + MOB_ACTIVITY_FIELD + " TEXT,"
                + MOB_BILLET_FIELD + " TEXT,"
                + TRUIC_FIELD + " TEXT,"
                + UMUIC_FIELD + " TEXT,"
                + NOSC_UIC_FIELD + " TEXT,"
                + PRD_FIELD + " TEXT,"
                + EAOS_FIELD + " TEXT,"
                + CED_FIELD + " TEXT,"
                + REPORT_DATE_FIELD + " TEXT,"
                + RANK_DATE_FIELD + " TEXT,"
                + CLEARANCE_DATE_FIELD + " TEXT,"

                + " PRIMARY KEY (" + ID_FIELD + "));";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
        Log.d("db", "onUpdate");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        // re-create the table 
        onCreate(db);
    }

    public SailorData editSailorData(SailorData sailorData) {
        Log.d("db", "editData");
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME_FIELD, sailorData.getName());
        values.put(UNIT_FIELD, sailorData.getUnit());
        values.put(NOSC_FIELD, sailorData.getNosc());
        values.put(MOB_ACTIVITY_FIELD, sailorData.getMob_activity());
        values.put(MOB_BILLET_FIELD, sailorData.getMob_billet());
        values.put(TRUIC_FIELD, sailorData.getTruic());
        values.put(UMUIC_FIELD, sailorData.getUmuic());
        values.put(NOSC_UIC_FIELD, sailorData.getNosc_uic());
        values.put(PRD_FIELD, sailorData.getPrd());
        values.put(EAOS_FIELD, sailorData.getEaos());
        values.put(CED_FIELD, sailorData.getCed());
        values.put(REPORT_DATE_FIELD, sailorData.getReport_date());
        values.put(RANK_DATE_FIELD, sailorData.getRank_date());
        values.put(CLEARANCE_DATE_FIELD, sailorData.getClearance_date());

        long id = db.insert(TABLE_NAME, null, values);
        sailorData.setId(id);
        db.close();

        return sailorData;
    }

    // Getting Sailor data
    SailorData getSailorData(long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[] {
                ID_FIELD, NAME_FIELD, UNIT_FIELD, NOSC_FIELD, MOB_ACTIVITY_FIELD, MOB_BILLET_FIELD,
                TRUIC_FIELD, UMUIC_FIELD, NOSC_UIC_FIELD, PRD_FIELD, EAOS_FIELD, CED_FIELD,
                REPORT_DATE_FIELD,RANK_DATE_FIELD, CLEARANCE_DATE_FIELD}, ID_FIELD + "=?",
                new String[] { String.valueOf(id) }, null,
                null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            SailorData sailorData = new SailorData(
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getString(8),
                    cursor.getString(9),
                    cursor.getString(10),
                    cursor.getString(11),
                    cursor.getString(12),
                    cursor.getString(13),
                    cursor.getString(14));
            sailorData.setId(cursor.getLong(0));
            return sailorData;
        }
        return null;
    }

    // Getting All Contacts
    public List<SailorData> getAllSailors() {
        List<SailorData> unitList = new ArrayList<SailorData>();
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        while (cursor.moveToNext()) {
            SailorData sailorData = new SailorData();
            sailorData.setId(Integer.parseInt(cursor.getString(0)));
            sailorData.setName(cursor.getString(1));
            sailorData.setUnit(cursor.getString(2));
            sailorData.setNosc(cursor.getString(3));
            sailorData.setMob_activity(cursor.getString(4));
            sailorData.setMob_billet(cursor.getString(5));
            sailorData.setTruic(cursor.getString(6));
            sailorData.setUmuic(cursor.getString(7));
            sailorData.setNosc_uic(cursor.getString(8));
            sailorData.setPrd(cursor.getString(9));
            sailorData.setEaos(cursor.getString(10));
            sailorData.setCed(cursor.getString(11));
            sailorData.setReport_date(cursor.getString(12));
            sailorData.setRank_date(cursor.getString(13));
            sailorData.setClearance_date(cursor.getString(14));
            unitList.add(sailorData);
        }
        return unitList;
    }

    public Cursor getSailorsCursor() {
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery(selectQuery, null);
    }

    public int updateSailorData(SailorData sailorData) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME_FIELD, sailorData.getName());
        values.put(UNIT_FIELD, sailorData.getUnit());
        values.put(NOSC_FIELD, sailorData.getNosc());
        values.put(MOB_ACTIVITY_FIELD, sailorData.getMob_activity());
        values.put(MOB_BILLET_FIELD, sailorData.getMob_billet());
        values.put(TRUIC_FIELD, sailorData.getTruic());
        values.put(UMUIC_FIELD, sailorData.getUmuic());
        values.put(NOSC_UIC_FIELD, sailorData.getNosc_uic());
        values.put(PRD_FIELD, sailorData.getPrd());
        values.put(EAOS_FIELD, sailorData.getEaos());
        values.put(CED_FIELD, sailorData.getCed());
        values.put(REPORT_DATE_FIELD, sailorData.getReport_date());
        values.put(RANK_DATE_FIELD, sailorData.getRank_date());
        values.put(CLEARANCE_DATE_FIELD, sailorData.getClearance_date());


        return db.update(TABLE_NAME, values, ID_FIELD + " = ?",
                new String[] { String.valueOf(sailorData.getId()) });
    }

    public void deleteContact(long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, ID_FIELD + " = ?",
                new String[] { String.valueOf(id) });
        db.close();
    }
}