package mirea.manproject.computerhelper.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import mirea.manproject.computerhelper.DI.ServiceLocator;
import mirea.manproject.computerhelper.models.Component;
import mirea.manproject.computerhelper.models.Function;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Network {

    Retrofit retrofit;
    API api;


    public Network() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        this.retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.3:8080/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        this.api = retrofit.create(API.class);
    }

    public void getFunctions() {
        Call<List<Function>> call = api.getFunctions();
        call.enqueue(new Callback<List<Function>>() {
            @Override
            public void onResponse(Call<List<Function>> call, Response<List<Function>> response) {
                ServiceLocator.getInstance().getFunctionRepository().generateFunctions(response.body());
            }

            @Override
            public void onFailure(Call<List<Function>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void getComponents(Function function) {
        Call<List<Component>> call = api.getComponents(function);
        call.enqueue(new Callback<List<Component>>() {
            @Override
            public void onResponse(Call<List<Component>> call, Response<List<Component>> response) {
                //System.out.println(response.body());
                ServiceLocator.getInstance().getComponentsRepository().setComponentsLiveData(response.body());
            }

            @Override
            public void onFailure(Call<List<Component>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
