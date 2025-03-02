package org.example;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();

        // Builder Pattern
        Request request = new Request.Builder()
                .url("https://official-joke-api.appspot.com/random_joke")
                .build();

        try(Response response = client.newCall(request).execute()){
            System.out.println(response.body().string());
        }catch (IOException e){
            e.printStackTrace();
        }

        // Retrofit: Type safe API calling library created on top of OkHTTP
    }
}