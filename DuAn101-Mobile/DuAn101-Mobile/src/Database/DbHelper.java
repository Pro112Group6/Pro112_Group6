package Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
	public static final String DB_NAME = "Du_An_PRO1012";
	public static final int DB_VERSION = 1;

	public DbHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String createTableDrug1 = "CREATE TABLE thuocbac ("
				+ "tbid INT PRIMARY KEY," + "tbten TEXT NOT NULL,"
				+ "tbthanhphan TEXT NOT NULL" + "tbmota TEXT NOT NUL,"
				+ "tbhangsx TEXT NOT NULL)";
		db.execSQL(createTableDrug1);

		String createTableDrug2 = "CREATE TABLE thuocnam ("
				+ "tnid INT PRIMARY KEY," + "tnten TEXT NOT NULL,"
				+ "tnthanhphan TEXT NOT NULL" + "tnmota TEXT NOT NULL,"
				+ "tnhangsx)";
		db.execSQL(createTableDrug2);

		String createTableDrug3 = "CREATE TABLE thuoctay ("
				+ "ttid INT PRIMARY KEY," + "ttten TEXT NOT NULL,"
				+ "ttthanhphan TEXT NOT NULL" + "ttmota TEXT NOT NULL,"
				+ "tthangsx TEXT NOT NULL)";
		db.execSQL(createTableDrug3);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String droptableDrug1 = "DROP TABLE IF EXISTS thuocbac";
		db.execSQL(droptableDrug1);
		String droptableDrug2 = "DROP TABLE IF EXISTS thuocnam";
		db.execSQL(droptableDrug2);
		String droptableDrug3 = "DROP TABLE IF EXISTS thuoctay";
		db.execSQL(droptableDrug3);
		onCreate(db);

	}

}
