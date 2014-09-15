package app.buusk15.sqlite_495;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends Activity {

	private EditText edt1,edt2;
	private Button btn_save;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add);
		
		edt1 = (EditText) findViewById(R.id.edt1);
		edt2 = (EditText) findViewById(R.id.edt2);
		btn_save = (Button) findViewById(R.id.btn_save);
		
		btn_save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(v == btn_save){
					Save();
				}
					
				
			}
		});
	}
	
	public boolean Save(){
		edt1 = (EditText) findViewById(R.id.edt1);
		edt2 = (EditText) findViewById(R.id.edt2);
		final AlertDialog.Builder adb = new AlertDialog.Builder(this);
		AlertDialog ad = adb.create();
		if (edt1.getText().length() == 0) {
			ad.setMessage("Please input Name");
			edt1.requestFocus();
			return false;
		}
		if (edt2.getText().length() == 0) {
			ad.setMessage("Please input Tel");
			edt2.requestFocus();
			return false;
		}
		control_495DB dbClass = new control_495DB(this);
		long savedata = dbClass.InsertData(edt1.getText().toString(), edt2
				.getText().toString());
		if (savedata <= 0) {
			ad.setMessage("Error !!!!");
			ad.show();
			return false;
		}
		Toast.makeText(getApplicationContext(), "Add Data Successfully",
				Toast.LENGTH_SHORT).show();
		return true;
		
	}
}
