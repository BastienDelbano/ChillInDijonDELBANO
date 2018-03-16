package org.diiage.delbano.chillindijondelbano;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String baseUrlApi = getResources().getString(R.string.base_url_api);
        //Creation de l'urrl de la string recup dans les resources (string.xml)
        URL baseUrl = null;
        try {
            baseUrl = new URL(baseUrlApi);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        AsyncTask<URL,Integer,ArrayList<Signboard>> task = new AsyncTask<URL, Integer, ArrayList<Signboard>>() {
            @Override
            protected ArrayList<Signboard> doInBackground(URL... urls) {

                try {
                    InputStream inputStream = urls[0].openStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                    //Initialisation d'un StringBuilder pour stocker le contenu distant
                    StringBuilder stringBuilder = new StringBuilder();
                    String lineBuffer = null;
                    while ((lineBuffer = bufferedReader.readLine()) != null){
                        stringBuilder.append(lineBuffer);
                    }
                    String data = stringBuilder.toString();
                    JSONArray jsonArray = new JSONArray(data);

                    ArrayList<Signboard> signboards = new ArrayList<>();
                    for (int i = 0; i < jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        JSONParser jsonParser = new JSONParser();
                        signboards.add(jsonParser.JsonToSignboard(jsonObject));
                    }

                    for(Signboard signboard : signboards){

                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    Log.e("EXCEPTION", e.getLocalizedMessage());
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.e("EXCEPTION", e.getLocalizedMessage());
                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.e("EXCEPTION", e.getLocalizedMessage());
                }
                return null;
            }

            @Override
            protected void onPostExecute(ArrayList<Signboard> signboards){
                super.onPostExecute(signboards);
            }
        }.execute(baseUrl);


    }
}
