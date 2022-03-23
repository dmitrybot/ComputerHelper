package mirea.manproject.computerhelper;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import mirea.manproject.computerhelper.models.Function;

public class MainActivity extends AppCompatActivity {
    private static MainActivity instance;
    private NavController navController;
    private AppBarConfiguration mAppBarConfiguration;
    private FunctionController functionController = new FunctionController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_menu, R.id.nav_function)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);

        generateFunctions();
    }

    public static MainActivity getInstance() {
        return instance;
    }

    public void goToFunctionFragment(int position){
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        navController.navigate(R.id.nav_function, bundle);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void generateFunctions(){
        functionController.generateFunctions();
    }

    public List<Function> getFunctions(){
        return functionController.getFunctions();
    }

    public Function getFunction(int position){
        return functionController.getFunction(position);
    }
}