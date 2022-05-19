package mirea.manproject.computerhelper.DI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import mirea.manproject.computerhelper.network.Network;
import mirea.manproject.computerhelper.repository.ComponentsRepository;
import mirea.manproject.computerhelper.repository.FunctionRepository;
import mirea.manproject.computerhelper.R;

public class ServiceLocator {

    private static ServiceLocator serviceLocator;

    private NavController navController;
    private AppBarConfiguration mAppBarConfiguration;

    private FunctionRepository functionRepository;
    private ComponentsRepository componentsRepository;
    private Network network;

    private ServiceLocator() {
        serviceLocator = this;
        network = new Network();
        functionRepository = new FunctionRepository();
        componentsRepository = new ComponentsRepository();
        network.getFunctions();
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

    public FunctionRepository getFunctionRepository() {
        return functionRepository;
    }

    public ComponentsRepository getComponentsRepository() {
        return componentsRepository;
    }

    public void setComponentsRepository(ComponentsRepository componentsRepository) {
        this.componentsRepository = componentsRepository;
    }

    public void setFunctionRepository(FunctionRepository functionRepository) {
        this.functionRepository = functionRepository;
    }

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    private void setContext(AppCompatActivity context){
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_menu, R.id.nav_function, R.id.nav_result)
                .build();
        navController = Navigation.findNavController(context, R.id.nav_host_fragment_container);
        NavigationUI.setupActionBarWithNavController(context, navController, mAppBarConfiguration);
    }

    public void goToFunctionFragment(int position){
        functionRepository.setCurrentFunction(position);
        navController.navigate(R.id.nav_function);
    }

    public void goToFunctionFragment(){
        navController.navigate(R.id.nav_function);
    }

    public void goToResultFragment(){
        navController.navigate(R.id.nav_result);
    }

    public void changeConfigurationComponent(int componentPosition, int variantPosition){
        functionRepository.changeConfigurationComponent(componentPosition, variantPosition);
    }
}

