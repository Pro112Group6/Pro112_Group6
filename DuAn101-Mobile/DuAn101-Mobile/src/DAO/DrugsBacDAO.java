package DAO;

import java.util.ArrayList;
import java.util.List;

import Database.DbHelper;
import Model.ThuocBac;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DrugsBacDAO {
	private SQLiteDatabase db;

	public DrugsBacDAO(Context context) {
		DbHelper dbHelper = new DbHelper(context);
		db = dbHelper.getWritableDatabase();
	}

	public long insert(ThuocBac s) {
		ContentValues values = new ContentValues();
		values.put("tbten", s.tbten);
		values.put("tbthanhphan", s.tbthanhphan);
		values.put("tbmota", s.tbmota);
		values.put("tbhangsx", s.tbhangsx);
		return db.insert("thuocbac", null, values);
	}
	public int update(ThuocBac s){
		ContentValues values = new ContentValues();
		values.put("tbten", s.tbten);
		values.put("tbthanhphan", s.tbthanhphan);
		values.put("tbmota", s.tbmota);
		values.put("tbhangsx", s.tbhangsx);
		return db.update("thuocbac", values, "tbid=?", new String[]{String.valueOf(s.tbid)});
	}
	public int delete(int tbid){
		return db.delete("thuocbac", "tbid=?", new String[]{String.valueOf(tbid)});
	}
	public List<ThuocBac> getBacs(){
		String sql = "SELECT * FROM thuocbac";
		 return getBacs(sql);
	}
	public ThuocBac getBac(int tbid){
		String sql = "SELECT * FROM thuocbac WHERE tbid=?";
		List<ThuocBac> list = getBacs(sql,String.valueOf(tbid));
		return list.get(0);
	}
	public List<ThuocBac> getBacs(String sql,String...args){
		List<ThuocBac> list = new ArrayList<ThuocBac>();
		Cursor c = db.rawQuery(sql, args);
		while(c.moveToNext()){
			ThuocBac s = new ThuocBac();
			s.tbid = c.getInt(c.getColumnIndex("tbid"));
			s.tbmota = c.getString(c.getColumnIndex("tbmota"));
			s.tbhangsx = c.getString(c.getColumnIndex("tbhangsx"));
			s.tbten = c.getString(c.getColumnIndex("tbten"));
			s.tbthanhphan = c.getString(c.getColumnIndex("tbthanhphan"));
			
			list.add(s);
		}
		return list;
	}
}
