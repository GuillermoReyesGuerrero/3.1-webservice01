package com.example.guillermo.webservice01;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by guillermo on 20/03/18.
 */

public class GetJson extends AsyncTask<Void,Void,Void> {

    String data ="";
    String dataPais = "";
    String dataCiudad ="";
    String dataClima ="";
    String dataTempMin ="";
    String dataTempMax ="";
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            //URL url = new URL("https://api.myjson.com/bins/1hewlv");
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=Tepic,mx&APPID=0906362826d2cfea265ed029381a7e31");
            HttpURLConnection httpURLConnection = (HttpURLConnection)
                    url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new
                    InputStreamReader(inputStream));
            String line = "";
            while(line != null){
                line = bufferedReader.readLine();
                data = data + line;
            }
            /*JSONArray JA = new JSONArray(data);
            for(int i =0 ;i <JA.length(); i++){
                JSONObject JO = (JSONObject) JA.get(i);
                singleParsed = "Name:" + JO.get("name") + "\n"+
                        "Password:" + JO.get("psw") + "\n"+
                        "Contact:" + JO.get("cel") + "\n"+
                        "Country:" + JO.get("pais") + "\n";
                dataParsed = dataParsed + singleParsed +"\n" ;
            }*/

            JSONObject JO= new JSONObject(data);
            dataPais="Pais: " + JO.getJSONObject("sys").get("country");
            dataCiudad="Ciudad: " + JO.get("name");
            dataClima="Clima: " + JO.getJSONArray("weather").getJSONObject(0).get("description");
            dataTempMin="Temperatura Minima: " + JO.getJSONObject("main").get("temp_min");
            dataTempMax="Temperatura Maxima: " + JO.getJSONObject("main").get("temp_max");


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        MainActivity.datapais.setText(this.dataPais);
        MainActivity.dataciudad.setText(this.dataCiudad);
        MainActivity.dataclima.setText(this.dataClima);
        MainActivity.datatempmin.setText(this.dataTempMin);
        MainActivity.datatempmax.setText(this.dataTempMax);
    }
}
