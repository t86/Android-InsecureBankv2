package com.android.insecurebankv2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/*
The page that allows gives the user below functionalities
Transfer: Module that allows transfer of amount between two accounts
View Statement: Module that allows the user to view transaction history for the logged in user
Change Password:  Module that allows the logged in user to change the password
@author Dinesh Shetty
*/
public class PostLogin extends Activity {
	//	The Button that handles the transfer activity
	Button transfer_button;
	//	The Button that handles the view transaction history activity
	Button statement_button;
	//	The Button that handles the change password activity
	Button changepasswd_button;
	String uname;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_post_login);
		Intent intent = getIntent();
		uname = intent.getStringExtra("uname");
		transfer_button = (Button) findViewById(R.id.trf_button);
		transfer_button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				/*
				The class that allows allows transfer of amount between two accounts
				*/
				Intent dT = new Intent(getApplicationContext(), DoTransfer.class);
				startActivity(dT);
			}
		});
		statement_button = (Button) findViewById(R.id.viewStatement_button);
		statement_button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				viewStatment();
			}
		});
		changepasswd_button = (Button) findViewById(R.id.button_ChangePasswd);
		changepasswd_button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				changePasswd();
			}
		});
	}

	/*
	The page that allows the user to view transaction history for the logged in user
	*/
	protected void changePasswd() {
		// TODO Auto-generated method stub
		Intent cP = new Intent(getApplicationContext(), ChangePassword.class);
		cP.putExtra("uname", uname);
		startActivity(cP);
	}

	/*
	The function that allows the user to view transaction history for the logged in user
	*/
	protected void viewStatment() {
		// TODO Auto-generated method stub
		Intent vS = new Intent(getApplicationContext(), ViewStatement.class);
		vS.putExtra("uname", uname);
		startActivity(vS);
	}
	// Added for menu
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	// Added for menu
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			callPreferences();
			return true;
		} else if (id == R.id.action_exit) {
			Intent i = new Intent(getBaseContext(), LoginActivity.class);
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void callPreferences() {
		// TODO Auto-generated method stub
		Intent i = new Intent(this, FilePrefActivity.class);
		startActivity(i);
	}
}