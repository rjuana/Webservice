package com.jhon.webservices;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;
import com.jhon.webservices.adaptadores.PageAdapter;
import com.jhon.webservices.fragment.FragmentReciclerview;
import com.jhon.webservices.fragment.InstagramFragment;
import com.jhon.webservices.menus.ActivityAbout;
import com.jhon.webservices.menus.ActivityContacto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    //  private ImageButton favoritoimagen;
 //   private TextView like1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        tootb.setLogo(R.drawable.pataperro);
        toolbar     = findViewById(R.id.toolbarfr);
        tabLayout   = findViewById(R.id.tablayout);
        viewPager   =findViewById(R.id.viewpager);
        Toolbar tootb = findViewById(R.id.actionbar);
        setSupportActionBar(tootb);
        setupviewpager();

        if (toolbar != null){
            setSupportActionBar(toolbar);
        }
    }
    private ArrayList<Fragment> agregarfragments (){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new FragmentReciclerview());
        fragments.add(new InstagramFragment());
        return fragments;
    }
   public void setupviewpager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarfragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_baseline_house_24);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_baseline_pets_24);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return (true);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.Favoritos:
                Intent intent1 = new Intent(MainActivity.this, MisContactos.class);
                startActivity(intent1);
                break;
           case R.id.About:
                Intent intent = new Intent(this, ActivityAbout.class);
                startActivity(intent);
                break;
            case R.id.Contacto:
                Intent intent2 = new Intent(this, ActivityContacto.class);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}