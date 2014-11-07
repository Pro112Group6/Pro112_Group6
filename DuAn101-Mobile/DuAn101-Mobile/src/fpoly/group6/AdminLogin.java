package fpoly.group6;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends ActionBarActivity {
	Button btnCancel, btnLogin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin_login);
		btnLogin = (Button) findViewById(R.id.btnLogin);
		btnCancel = (Button) findViewById(R.id.btnCancel);
		final EditText edtAdUser = (EditText) findViewById(R.id.editUser);
		final EditText edtAdPass = (EditText) findViewById(R.id.editPass);
		btnCancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in = new Intent(AdminLogin.this, MainActivity.class);
				startActivity(in);
			}
		});
		btnLogin.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String strUser = edtAdUser.getText().toString();
				 String strPass = edtAdPass.getText().toString();
				 if (strUser.trim().equalsIgnoreCase("")) {
				 Toast.makeText(AdminLogin.this,
				 "Username is not empty. Please try again...",
				 Toast.LENGTH_LONG).show();
				 } else if (strPass.trim().equalsIgnoreCase("")) {
				 Toast.makeText(AdminLogin.this,
				 "Password is not empty. Please try again...",
				 Toast.LENGTH_LONG).show();
				 } else if (strUser.equalsIgnoreCase("admin")
				 && strPass.equalsIgnoreCase("admin")) {
				 Toast.makeText(AdminLogin.this, "Login Successfull",
				 Toast.LENGTH_LONG).show();
				 Intent in = new Intent(AdminLogin.this,
				 ManagerAdmin.class);
				 startActivity(in);	
				 } else {
				 Toast.makeText(AdminLogin.this,
				 "Username or Password is invalid",
				 Toast.LENGTH_LONG).show();
				 }
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.admin_login, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
