package mirea.manproject.computerhelper.DI;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import mirea.manproject.computerhelper.FunctionRepository;
import mirea.manproject.computerhelper.R;

public class ServiceLocator {

    private static ServiceLocator serviceLocator;

    private NavController navController;
    private AppBarConfiguration mAppBarConfiguration;

    public FunctionRepository functionRepository;

    private ServiceLocator() {
        serviceLocator = this;

        functionRepository = new FunctionRepository();
    }



    public static ServiceLocator getInstance() {
        return serviceLocator;
    }

    public static void init (AppCompatActivity context){
        serviceLocator = new ServiceLocator();
    }

    public static void init_2 (AppCompatActivity context){
        serviceLocator.setContext(context);
    }

    private void setContext(AppCompatActivity context){
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_menu, R.id.nav_function)
                .build();
        navController = Navigation.findNavController(context, R.id.nav_host_fragment_container);
        NavigationUI.setupActionBarWithNavController(context, navController, mAppBarConfiguration);
    }

    public void goToFunctionFragment(int position){
        functionRepository.setCurrentFunction(position);
        navController.navigate(R.id.nav_function);
    }

    public void goToResultFragment(){
        navController.navigate(R.id.nav_result);
    }
}

