package com.example.realestate;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class buy_property extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {

    AlertDialog.Builder builder;
    ImageView property1,property2,property3,property4,property5,property6,property7,property8;
    TextView loc1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_property);

        builder = new AlertDialog.Builder(this);
        property1 = findViewById(R.id.property1);
        property2 = findViewById(R.id.property2);
        property3 = findViewById(R.id.property3);
        property4 = findViewById(R.id.property4);
        property5 = findViewById(R.id.property5);
        property6 = findViewById(R.id.property6);
        property7 = findViewById(R.id.property7);
        property8 = findViewById(R.id.property8);
        property1.setOnClickListener(this);
        property2.setOnClickListener(this);
        property3.setOnClickListener(this);
        property4.setOnClickListener(this);
        property5.setOnClickListener(this);
        property6.setOnClickListener(this);
        property7.setOnClickListener(this);
        property8.setOnClickListener(this);
        loc1 = findViewById(R.id.loc1);
        loc1.setOnClickListener(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.buy_property, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent i = new Intent(getApplicationContext(),Welcome_Page.class);
            startActivity(i);
        } else if (id == R.id.nav_buy) {
            Intent i = new Intent(getApplicationContext(),buy_property.class);
            startActivity(i);

        } else if (id == R.id.nav_sell) {
            Intent i = new Intent(getApplicationContext(),Sell_Property.class);
            startActivity(i);

        } else if (id == R.id.nav_rent) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_contact) {
            try
            {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.linkedin.com/feed/"));
                startActivity(intent);
            }catch (Exception e){
            }

        } else if (id == R.id.nav_logout){
            builder.setMessage("Do You want to close this App?");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog alert = builder.create();
            alert.setTitle("Alert");
            alert.show();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        if(v==property1||v==property2||v==property3||v==property4||v==property5||v==property6||v==property7||v==property8)
        {
            Intent i = new Intent(getApplicationContext(),Gallery1.class);
            startActivity(i);
        }
        if(v==loc1)
        {
            Intent i = new Intent(getApplicationContext(),Location.class);
            startActivity(i);
        }

    }
}
