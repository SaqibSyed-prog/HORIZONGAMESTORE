package com.example.horizongamestore;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "usersRegistered";
    private static final String TABLE_USERS = "users";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_USERNAME = "userName";
    private static final String KEY_PASSWORD = "password";

    public DatabaseHandler(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_USERS + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_NAME + " TEXT,"
                + KEY_USERNAME + " TEXT,"
                + KEY_PASSWORD + " TEXT"+ ")";

        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);

        onCreate(db);
    }
    //to add new user
    public void addUser(UserReg userReg){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, userReg.getName());
        values.put(KEY_USERNAME, userReg.getUserName());
        values.put(KEY_PASSWORD, userReg.getPassword());

        db.insert(TABLE_USERS,null,values);
        db.close();

    }
    public UserReg getUser(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USERS, new String[] {KEY_ID,KEY_NAME,KEY_USERNAME, KEY_PASSWORD}, KEY_ID + "=?",new String[] {String.valueOf(id)}, null,null,null,null);
        if(cursor != null)
            cursor.moveToFirst();

        UserReg userReg = new UserReg(Integer.parseInt(cursor.getString(0)),cursor.getString(1), cursor.getString(2),cursor.getString(3));
        return userReg;

    }//get A list of all users
    public List<UserReg> getAllUsers(){
        List<UserReg> userRegList = new ArrayList<UserReg>();
        String selectQuery = "SELECT * FROM " + TABLE_USERS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);


        if(cursor.moveToFirst()){
            do{
                UserReg userReg = new UserReg();
                userReg.setId(Integer.parseInt(cursor.getString(0)));
                userReg.setName(cursor.getString(1));
                userReg.setUserName(cursor.getString(2));
                userReg.setPassword(cursor.getString(3));
                userRegList.add(userReg);
            }while (cursor.moveToNext());
        }
        return userRegList;
    }
    //update the single user
    public int updateUserReg(UserReg userReg){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME,userReg.getName());
        values.put(KEY_USERNAME,userReg.getUserName());
        values.put(KEY_PASSWORD,userReg.getPassword());

        return db.update(TABLE_USERS, values, KEY_ID + "=?", new String[]{String.valueOf(userReg.getId())});
    }
    //DELETING SINGLE USER
    public void deleteUser(UserReg userReg){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USERS, KEY_ID +"=?", new String[] {
                String.valueOf(userReg.getId())
        });
        db.close();

    }
    //Getting user Count
    public int getUserCount(){
        String countQuery = "SELECT * FROM " + TABLE_USERS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }
    //check for a username
    public Boolean checkusername(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username=?", new String[] {username});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    //check for username and password
    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username=? and password=?", new String[] {username,password});
        if(cursor.getCount()>0)
            return  true;
        else
            return false;
    }
    public Cursor getsingleUser(String usern, String pass){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABLE_USERS + " "+
                "where username = "+ usern+" AND password = "+ pass, null);
        return cursor;
    }






}
