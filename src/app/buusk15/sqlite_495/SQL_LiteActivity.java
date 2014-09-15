package app.buusk15.sqlite_495;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class SQL_LiteActivity extends Activity {
	private Button btn_insert;
	
	SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqliteactivity);
        control_495DB control_495db = new control_495DB(this);
        control_495db.getWritableDatabase();
        
        btn_insert = (Button) findViewById(R.id.btn_insert);
        btn_insert.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),AddActivity.class);
				startActivity(intent);
			}
		});
        
    }
}
