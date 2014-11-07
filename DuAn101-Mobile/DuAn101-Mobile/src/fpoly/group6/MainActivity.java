package fpoly.group6;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Dialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class MainActivity extends ActionBarActivity {
	// Khai bao cac bien can thiet
	private DrawerLayout mDrawerLayout;
	private ListView mleftList;
	private ActionBarDrawerToggle mDrawerToggle;
	private ArrayList<DanhMuc> arrLeft;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		ActionBar actionBar = getActionBar();
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#336600")));
			
		// Add du lieu vao array
		initArrayForListViewDrawer();

		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		// Link den code
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mleftList = (ListView) findViewById(R.id.left_drawer);

		// bat su kien click cua list ben trai
		mleftList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
					long arg3) {
				switch (pos) {
				case 0:
					// Chuyen sang activity
					Intent i = new Intent(getApplicationContext(),
							ThuocNam.class);
					startActivity(i);
					break;
				case 1:
					Intent i1 = new Intent(getApplicationContext(),
							ThuocBac.class);
					startActivity(i1);
					break;
				case 2:
					Intent i2 = new Intent(getApplicationContext(),
							ThuocTay.class);
					startActivity(i2);
					break;
				case 3:
					Intent i4 = new Intent(getApplicationContext(),
							ThongTin.class);
					startActivity(i4);
					break;
				case 4:
					Intent i5 = new Intent(getApplicationContext(),
							GioiThieu.class);
					startActivity(i5);
					break;
				case 5:
					Intent i6 = new Intent(getApplicationContext(), GopY.class);
					startActivity(i6);
					break;
				case 6:
					Intent i7 = new Intent(getApplicationContext(), AdminLogin.class);
					startActivity(i7);
					break;
				default:
					break;
				}

				mleftList.setItemChecked(pos, true);
				// Dong Drawer khi click xong
				mDrawerLayout.closeDrawer(mleftList);

			}
		});

		// Set Adapter cho list ben trai

		ItemAdapterList adapterLeft = new ItemAdapterList(this, arrLeft);
		mleftList.setAdapter(adapterLeft);

		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);

		mDrawerToggle = new ActionBarDrawerToggle(this, /*
														 * Activity chua
														 * Actionbar
														 */
		mDrawerLayout, /* DrawerLayout de lien ket den ActionBar */
		R.drawable.ic_drawer, /* Hinh anh Drawer */
		R.string.drawer_open, /* Chuoi mo ta hanh dong mo Drawer "open drawer" */
		R.string.drawer_close /* Chuoi mo ta hanh dong dong Drawer "close drawer" */
		) {
			public void onDrawerClosed(View view) {
				getActionBar().setTitle("Tra cứu thuốc");
				invalidateOptionsMenu(); // tao lai menu sau khi options menu da
											// duoc thay doi
			}

			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle("Danh mục");
				invalidateOptionsMenu();
			}
		};

		mDrawerLayout.setDrawerListener(mDrawerToggle);

	}

	// Them du lieu vao array
	private void initArrayForListViewDrawer() {
		// TODO Auto-generated method stub
		arrLeft = new ArrayList<DanhMuc>();

		DanhMuc danhmuc1 = new DanhMuc("Các loại thuốc nam", R.drawable.drugs);
		arrLeft.add(danhmuc1);
		DanhMuc danhmuc2 = new DanhMuc("Các loại thuốc bắc", R.drawable.drugs);
		arrLeft.add(danhmuc2);
		DanhMuc danhmuc3 = new DanhMuc("Các loại thuốc tây", R.drawable.drugs);
		arrLeft.add(danhmuc3);
		DanhMuc danhmuc5 = new DanhMuc("Thông tin", R.drawable.contact);
		arrLeft.add(danhmuc5);
		DanhMuc danhmuc4 = new DanhMuc("Giới thiệu", R.drawable.about);
		arrLeft.add(danhmuc4);
		DanhMuc danhmuc7 = new DanhMuc("Góp ý", R.drawable.feedback);
		arrLeft.add(danhmuc7);
		DanhMuc danhmuc8 = new DanhMuc("Admin", R.drawable.adminlogin);
		arrLeft.add(danhmuc8);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
	}

	/*
	 * Khi goi invalidateOptionsMenu() thi chung ta phai override lai phuong
	 * thuc nay
	 */
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		boolean drawerleftOpen = mDrawerLayout.isDrawerOpen(mleftList);
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	// Bat su kien click tren actionbar
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		int id = item.getItemId();
		switch (id) {
		case android.R.id.home:
			boolean drawerleftOpen = mDrawerLayout.isDrawerOpen(mleftList);
			if (!drawerleftOpen) {
				mDrawerLayout.openDrawer(Gravity.START);
			} else {
				mDrawerLayout.closeDrawer(mleftList);
			}
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
