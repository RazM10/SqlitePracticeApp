package org.myself.sqlitepractice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "personDB";
    private static final String TABLE_NAME = "person";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String PASSWORD = "password";

    public DatabaseHandler(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String q="CREATE TABLE "+TABLE_NAME+" ( "+ID+" INTEGER PRIMARY KEY , "+NAME+" TEXT , "+PASSWORD+" TEXT)";
        db.execSQL(q);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    void addPerson(Person person){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put(NAME,person.get_name());
        cv.put(PASSWORD,person.get_password());

        db.insert(TABLE_NAME,null,cv);
        db.close();
    }

    public List<Person> gerAll(){
        List<Person> pList=new ArrayList<>();
        String q="SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase db=this.getReadableDatabase();;
        Cursor c=db.rawQuery(q,null);

        if(c.moveToFirst()){
            do {
                Person person=new Person();
                person.set_id(Integer.parseInt(c.getString(0)));
                person.set_name(c.getString(1));
                person.set_password(c.getString(2));
                pList.add(person);
            }while (c.moveToNext());
        }
        return pList;
    }

    void deleteAll(){
        SQLiteDatabase db=this.getWritableDatabase();
        String q="delete from "+TABLE_NAME;
        db.execSQL(q);
    }

}
