package mirea.manproject.computerhelper.network;

import java.util.List;

import mirea.manproject.computerhelper.models.Component;
import mirea.manproject.computerhelper.models.Function;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface API {

    @GET("/functions")
    Call<List<Function>> getFunctions();

    @POST("/components")
    Call<List<Component>> getComponents(@Body Function function);
}
