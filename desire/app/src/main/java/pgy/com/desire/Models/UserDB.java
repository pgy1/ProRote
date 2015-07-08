package pgy.com.desire.Models;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.json.JSONException;
import org.json.JSONObject;

import pgy.com.desire.Utils.configHelper;

public class UserDB {
	
	public static final String MSG_DBNAME = "user.db";
	private SQLiteDatabase db;
	private static final String tableUser="_user";
	public static final String DataBase_Create = "CREATE table IF NOT EXISTS "+tableUser
			+ " (uid integer PRIMARY KEY autoincrement,sex varchar(2),nick varchar(20),lastime varchar(20) null)";
	
	public static UserDB obj;
	public static UserDB getInstance(Context context){
		if(obj==null){
			obj=new UserDB(context);
		}
		return obj;
	}
	
	private UserDB(Context context){
		db = context.openOrCreateDatabase(configHelper.dbPath+MSG_DBNAME, Context.MODE_PRIVATE,
				null);
//		db.execSQL("DROP table IF EXISTS "+tableUser);
		db.execSQL(DataBase_Create);
	}
	
	//�����û���Ϣ
	public void saveOrupdate(UserBean item){
		if(exist(item)){
			db.execSQL("update "+tableUser +" set sex=?,nick=? where uid='"+item.getEmail()+"'",
					new Object[]{item.getSex(),item.getNick()});
		}else{
			db.execSQL("insert into "+tableUser+" (uid,sex,nick) values (?,?,?)",
					new Object[]{item.getEmail(),item.getSex(),item.getNick()});
		}
	}
	
	public UserBean getUserInfo(String uid){
		Cursor c = db.rawQuery("SELECT * from "+tableUser+" where uid=? limit 1",new String[]{uid});
		UserBean item=null;
		while (c.moveToNext()) {
			item=new UserBean(c.getString(c.getColumnIndex("uid")),c.getString(c.getColumnIndex("sex")),
					c.getString(c.getColumnIndex("nick")));
		}
		return item;
	}
	
	//�Ƿ���ڸü�¼
	public boolean exist(UserBean item){
		Cursor c = db.rawQuery("select * from "+tableUser+" where uid='"+item.getEmail()+"' limit 1",null);
		int count = c.getCount();
		c.close();
		return count==0?false:true;
	}
	
	//��ȡ�û���
	public String getUserName(String uid){
		Cursor c = db.rawQuery("select * from "+tableUser+" where uid='"+uid+"' limit 1",null);
		String userName="";
		while (c.moveToNext()) {
			userName=c.getString(c.getColumnIndex("nick"));
		}
		return userName;
	}
	/**
	 * ��ȡ�û���Ϣ����ӿ�
	 * @author peng
	 *
	 */
	public interface getUserCallBack{
		/**
		 * ��ȡ�û�������Ϣ
		 * @param base
		 */
		void getUserInfo(UserBean base);
		/**
		 * ��ȡ�û�����PushId
		 * @param PushId
		 */
		void getPushId(String PushId);
	}
	
	/**
	 * ��json�н����û���Ϣ
	 * @param json
	 * @param uid
	 */
	public UserBean ParseUserInfo(String json,String uid){
		JSONObject JsonData;
		try {
			JsonData = new JSONObject(json);
			String client=JsonData.getString("client");
			UserBean base=new UserBean(uid, JsonData.getString("sex"),JsonData.getString("nickname"));
			saveOrupdate(base);
		    return base;
		} catch (JSONException e) {
			return null;
		}
		
	}
	
	public void close() {
		db.close();
	}
	

}
