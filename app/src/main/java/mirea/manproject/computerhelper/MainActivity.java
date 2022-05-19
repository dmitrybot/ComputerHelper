package mirea.manproject.computerhelper;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import mirea.manproject.computerhelper.DI.ServiceLocator;
import mirea.manproject.computerhelper.network.Network;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println(R.string.battery_title);
        System.out.println(R.string.battery_text);
        System.out.println(R.string.battery_name);
        System.out.println(R.drawable.battery);
        System.out.println(R.string.gpu_title);
        System.out.println(R.string.gpu_text);
        System.out.println(R.string.gpu_name);
        System.out.println(R.drawable.gpu);
        System.out.println(R.string.function_title);
        System.out.println(R.drawable.cooling_icon);
        System.out.println(R.drawable.cpu_icon);
        System.out.println(R.drawable.gpu_icon);
        ServiceLocator.init(this);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ServiceLocator.init_2(this);

    }
}