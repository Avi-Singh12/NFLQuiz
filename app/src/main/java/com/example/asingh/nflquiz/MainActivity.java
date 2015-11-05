package com.example.asingh.nflquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);

        final Firebase myFirebase = new Firebase("https://nflquizavi.firebaseio.com/");
        final EditText userNameTextField = (EditText) findViewById(R.id.userNameTextView);
        final EditText passwordTextField = (EditText) findViewById(R.id.passwordTextView);
        final Button createAccountButton = (Button) findViewById(R.id.createAccountButton);
        Button loginButton = (Button) findViewById(R.id.loginButton);

        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUserOnFirebase(userNameTextField.getText().toString(), passwordTextField.getText().toString(), myFirebase);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUserOnFirebase(userNameTextField.getText().toString(), passwordTextField.getText().toString(), myFirebase);
            }
        });
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

   public void createUserOnFirebase(final String username, String password, Firebase myFirebase) {
       myFirebase.createUser(username, password, new Firebase.ValueResultHandler<Map<String, Object>>() {
           @Override
           public void onSuccess(Map<String, Object> stringObjectMap) {
               Toast.makeText(MainActivity.this, "New user with id: " + username + " successfully created", Toast.LENGTH_SHORT).show();
           }

           @Override
           public void onError(FirebaseError firebaseError) {
               switch (firebaseError.getCode()) {
                   case FirebaseError.EMAIL_TAKEN:
                       Toast.makeText(MainActivity.this, "Email Already in System", Toast.LENGTH_SHORT).show();
                       break;
                   case FirebaseError.INVALID_EMAIL:
                       Toast.makeText(MainActivity.this, "Email Email or Password", Toast.LENGTH_SHORT).show();
                       break;
                   case FirebaseError.INVALID_PASSWORD:
                       Toast.makeText(MainActivity.this, "Invalid Email or Password", Toast.LENGTH_SHORT).show();
                       break;
                   case FirebaseError.AUTHENTICATION_PROVIDER_DISABLED:
                       Toast.makeText(MainActivity.this, "Authentication Provider Disabled", Toast.LENGTH_SHORT).show();
                       break;
                   case FirebaseError.INVALID_AUTH_ARGUMENTS:
                       Toast.makeText(MainActivity.this, "Invalid Authentication Arguments", Toast.LENGTH_SHORT).show();
                       break;
                   case FirebaseError.NETWORK_ERROR:
                       Toast.makeText(MainActivity.this, "Network Error", Toast.LENGTH_SHORT).show();
                       break;
                   default:
                       Toast.makeText(MainActivity.this, "Error 1", Toast.LENGTH_SHORT).show();
                       break;
               }
           }
       });
   }

    public void loginUserOnFirebase(final String username, final String password, Firebase myFirebase) {
        myFirebase.authWithPassword(username, password, new Firebase.AuthResultHandler() {
            @Override
            public void onAuthenticated(AuthData authData) {
                Toast.makeText(MainActivity.this, "New user with id: " + username + " successfully logged in",Toast.LENGTH_SHORT).show();

                Firebase rootRef = new Firebase("https://nflquizavi.firebaseio.com/data");
                String userID = authData.getUid();

                Map<String, String> map = new HashMap<String, String>();
                map.put("displayName", username);
                map.put("password", password);
                rootRef.child("users").child(userID).setValue(map);

                Intent i = new Intent(getApplicationContext(), WelcomePage.class);
                i.putExtra("USER_NAME", username);
                i.putExtra("USER_ID", userID);
                startActivity(i);
            }

            @Override
            public void onAuthenticationError(FirebaseError firebaseError) {
                switch (firebaseError.getCode()) {
                    case FirebaseError.INVALID_EMAIL:
                        Toast.makeText(MainActivity.this, "Email Email or Password", Toast.LENGTH_SHORT).show();
                        break;
                    case FirebaseError.USER_DOES_NOT_EXIST:
                        Toast.makeText(MainActivity.this, "User not in System", Toast.LENGTH_SHORT).show();
                        break;
                    case FirebaseError.INVALID_PASSWORD:
                        Toast.makeText(MainActivity.this, "Invalid Email or Password", Toast.LENGTH_SHORT).show();
                        break;
                    case FirebaseError.AUTHENTICATION_PROVIDER_DISABLED:
                        Toast.makeText(MainActivity.this, "Authentication Provider Disabled", Toast.LENGTH_SHORT).show();
                        break;
                    case FirebaseError.INVALID_AUTH_ARGUMENTS:
                        Toast.makeText(MainActivity.this, "Invalid Authentication Arguments", Toast.LENGTH_SHORT).show();
                        break;
                    case FirebaseError.NETWORK_ERROR:
                        Toast.makeText(MainActivity.this, "Network Error", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "Error 2", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}
