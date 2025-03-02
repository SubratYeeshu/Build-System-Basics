package org.example;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
//
//        // OkHTTP
//        OkHttpClient client = new OkHttpClient();
//
//        // Builder Pattern
//        Request request = new Request.Builder()
//                .url("https://official-joke-api.appspot.com/random_joke")
//                .build();
//
//        // String getting returned, what if we need java objects
//        try(Response response = client.newCall(request).execute()){
//            System.out.println(response.body().string());
//        }catch (IOException e){
//            e.printStackTrace();
//        }

        // Retrofit: Type safe API calling library created on top of OkHTTP, API interfaces are turned into callable objects, converters are used for other types

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TodoService todoService = retrofit.create(TodoService.class);
        Todo t = todoService.getTodoByID("1").execute().body();
        System.out.println(t.toString());
    }
}