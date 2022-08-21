package com.bottomnav.id;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

	Toolbar toolbar;
	BottomNavigationView bottomNavigationView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		bottomNavigationView = findViewById(R.id.bottomMenu);
		// Method fragment yang akan pertama kali dimuat
		getSupportFragmentManager().beginTransaction().replace(R.id.container, new FragmentHome()).commit();

		bottomNavigationView.setItemIconTintList(null);
		BadgeDrawable badgeDrawable = bottomNavigationView.getOrCreateBadge(R.id.favoriteNav);
		badgeDrawable.setVisible(true);
		badgeDrawable.setNumber(1);
		bottomNavigationView
				.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
					@Override
					public boolean onNavigationItemSelected(MenuItem item) {
						Fragment pilihFragment = null;
						switch (item.getItemId()) {
						case R.id.homeNav:
							toolbar.setTitle("Home");
							Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
							pilihFragment = new FragmentHome();
							break;
						case R.id.favoriteNav:
							toolbar.setTitle("Favorite");
							Toast.makeText(MainActivity.this, "Favorite", Toast.LENGTH_SHORT).show();
							pilihFragment = new FragmentFavorite();
							break;
						case R.id.profileNav:
							toolbar.setTitle("Profile");
							Toast.makeText(MainActivity.this, "Profile", Toast.LENGTH_SHORT).show();
							pilihFragment = new FragmentProfile();
							break;
						}
						getSupportFragmentManager().beginTransaction().replace(R.id.container, pilihFragment).commit();
						return true;
					}

				});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_toolbar, menu);
		return true;
	}
}