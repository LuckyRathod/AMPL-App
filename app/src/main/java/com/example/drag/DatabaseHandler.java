package com.example.drag;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
	// All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "Users";
 
    // Contacts table name
    private static final String TABLE_CONTACTS = "Cust";
 
    // Contacts Table Columns names
    private static final String KEY_ID = "ID";
    private static final String KEY_Name = "Name";
    private static final String KEY_Email = "Email";
    private static final String KEY_Mob = "Mob";
    private static final String KEY_Pass = "Pass";
    
    
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " TEXT," + KEY_Name + " TEXT,"
                + KEY_Email + " TEXT," + KEY_Mob + " TEXT,"
                + KEY_Pass + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
        
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
 
        // Create tables again
        onCreate(db);
	}
	
	 /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */
 
    // Adding new contact
    	void addUser(User u) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_ID, u.getID()); 
        values.put(KEY_Name, u.getName()); 
        values.put(KEY_Email, u.getEmail()); 
        values.put(KEY_Mob, u.getMob()); 
        values.put(KEY_Pass, u.getPass()); 
        
        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        db.close(); // Closing database connection
    }
 
    	
    	public String getName(String ID) {
        	SQLiteDatabase db = this.getReadableDatabase();
            //String countQuery = "SELECT  "+KEY_Name+" FROM " + TABLE_CONTACTS+" where "+KEY_ID+" = '"+ID+"'";

            Cursor cursor = db.query(true, TABLE_CONTACTS, new String[] {KEY_Name}, KEY_ID +" = "+ ID, null, null, null, null, null, null);
            
            String name ="Null";
            if (cursor .getCount() > 0)
            {
            	cursor.moveToFirst();
            	name = cursor.getString(0);
            	cursor.close();
            }
            return name;
        }
    	
    	
    	public String getId() {
    		String Id="1001";
            SQLiteDatabase db = this.getReadableDatabase();
            //String countQuery = "SELECT "+KEY_ID+" FROM " + TABLE_CONTACTS+" Order By "+KEY_ID+" Desc";
            
            	Cursor cursor = db.query(true, TABLE_CONTACTS, new String[] {KEY_ID}, null, null, null, null, KEY_ID+" DESC", null, null);
                if (cursor.getCount() > 0)
            	{
            		cursor.moveToFirst();
            		int id = Integer.parseInt(cursor.getString(0));
            		id += 1;
            		Id = ""+id;
            	}
            	cursor.close();
            
            return Id;
        }
    	
    	
    /*
    	User checkLogin(String ID,String Pass) {
        SQLiteDatabase db = this.getReadableDatabase();
 
        Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_PName,
        		KEY_Station, KEY_Img, KEY_Desc, KEY_Add,KEY_Pn, KEY_Map}, KEY_PName + "=?",
                new String[] { String.valueOf(PName) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
 
        Place p = new Place(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6));
        // return contact
        return p;
    }
     
    
    	// Getting All Place for Station
    public List<Place> getAllPlace(String S) {
        List<Place> contactList = new ArrayList<Place>();
        // Select All Query
        String selectQuery = "SELECT distinct " + KEY_PName + " FROM " + TABLE_CONTACTS+" where " + KEY_Station + "='"+S+"'";
 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Place contact = new Place();
                contact.setPName(cursor.getString(0));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
 
        // return contact list
        return contactList;
    }
     */
    
    public String getPass(String ID) {
    	SQLiteDatabase db = this.getReadableDatabase();
        String countQuery = "SELECT  "+KEY_Pass+" FROM " + TABLE_CONTACTS+" where "+KEY_ID+" = '"+ID+"'";
        Cursor cursor = db.rawQuery(countQuery, null);
        
        if (cursor != null)
            cursor.moveToFirst();
        String pass = cursor.getString(0);
        cursor.close();
        
        return pass;
    }
}