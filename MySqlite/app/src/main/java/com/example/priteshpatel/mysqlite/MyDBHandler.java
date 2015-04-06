package com.example.priteshpatel.mysqlite;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import  android.content.Context;
import  android.content.ContentValues;

public class MyDBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="products.db";
    private static final String TABLE_NAME="products";
    public static final String COLUMN_ID="_id";
    public static final String COLUMN_PRODUCTSNAME="productsname";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE "+TABLE_NAME+"("+COLUMN_ID+"  INTEGER PRIMARY KEY AUTOINCREMENT , "+COLUMN_PRODUCTSNAME+" TEXT "+");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME+ ";");
        onCreate(db);
    }
    //Add products to the database
    public void addProducts(Products product)
    {
        ContentValues cv=new ContentValues();
        cv.put(COLUMN_PRODUCTSNAME,product.get_productname());
        SQLiteDatabase db=getWritableDatabase();
        db.insert(TABLE_NAME,null,cv);
        db.close();

    }
    //delete products to the database
    public void deleteProducts(String productName){
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("DELETE FROM "+TABLE_NAME+" WHERE "+COLUMN_PRODUCTSNAME+" =\""+productName+"\";");

    }
    //Show data on Page
    public String dataToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE 1";

        //Cursor points to a location in your results
        Cursor c = db.rawQuery(query, null);
        //Move to the first row in your results
        c.moveToFirst();

        //Position after the last row means the end of the results
        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("productsname")) != null) {
                dbString += c.getString(c.getColumnIndex("productsname"));
                dbString += "\n";
            }
            c.moveToNext();
        }
        db.close();
        return dbString;
    }

}
