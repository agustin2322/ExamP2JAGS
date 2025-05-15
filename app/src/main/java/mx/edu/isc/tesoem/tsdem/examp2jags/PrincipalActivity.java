package mx.edu.isc.tesoem.tsdem.examp2jags;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        // Configurar ViewPager2
        ViewPager2 viewPager = findViewById(R.id.viewPager);
        MiPagerAdapter adapter = new MiPagerAdapter(this);
        viewPager.setAdapter(adapter);

        // Configurar TabLayout
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    switch (position) {
                        case 0:
                            tab.setText("Menú");
                            break;
                        case 1:
                            tab.setText("Suma");
                            break;
                        case 2:
                            tab.setText("Resta");
                            break;
                    }
                }).attach();
    }
}
