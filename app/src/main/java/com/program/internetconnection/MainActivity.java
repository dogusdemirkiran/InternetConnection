package com.program.internetconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.mesaj);
        button = findViewById(R.id.sendButton);
        tumKisiler();
/*
        String jsonVeri = "{\"bayraklar\":[{\"bayrak_id\":\"1\",\"bayrak_ad\":\"T\\u00fcrkiye\",\"bayrak_resim\":\"turkiye\"},{\"bayrak_id\":\"2\",\"bayrak_ad\":\"Almanya\",\"bayrak_resim\":\"almanya\"},{\"bayrak_id\":\"3\",\"bayrak_ad\":\"\\u0130talya\",\"bayrak_resim\":\"italya\"},{\"bayrak_id\":\"4\",\"bayrak_ad\":\"Fransa\",\"bayrak_resim\":\"fransa\"},{\"bayrak_id\":\"5\",\"bayrak_ad\":\"Hollanda\",\"bayrak_resim\":\"hollanda\"},{\"bayrak_id\":\"6\",\"bayrak_ad\":\"\\u0130spanya\",\"bayrak_resim\":\"ispanya\"},{\"bayrak_id\":\"7\",\"bayrak_ad\":\"Slovenya\",\"bayrak_resim\":\"slovenya\"},{\"bayrak_id\":\"8\",\"bayrak_ad\":\"Slovakya\",\"bayrak_resim\":\"slovakya\"},{\"bayrak_id\":\"9\",\"bayrak_ad\":\"Estonya\",\"bayrak_resim\":\"estonya\"},{\"bayrak_id\":\"10\",\"bayrak_ad\":\"Rusya\",\"bayrak_resim\":\"rusya\"},{\"bayrak_id\":\"11\",\"bayrak_ad\":\"Bulgaristan\",\"bayrak_resim\":\"bulgaristan\"},{\"bayrak_id\":\"12\",\"bayrak_ad\":\"Romanya\",\"bayrak_resim\":\"romanya\"},{\"bayrak_id\":\"13\",\"bayrak_ad\":\"Norve\\u00e7\",\"bayrak_resim\":\"norvec\"},{\"bayrak_id\":\"14\",\"bayrak_ad\":\"Yunanistan\",\"bayrak_resim\":\"yunanistan\"},{\"bayrak_id\":\"15\",\"bayrak_ad\":\"Bosna Hersek\",\"bayrak_resim\":\"bosnahersek\"}],\"success\":1}";

        try {
            JSONObject jsonObject = new JSONObject(jsonVeri);

            JSONArray bayraklarListe = jsonObject.getJSONArray("bayraklar");
            for(int i=0; i<bayraklarListe.length();i++){
                JSONObject b = bayraklarListe.getJSONObject(i);
                int bayrak_id = b.getInt("bayrak_id");
                String bayrak_ad = b.getString("bayrak_ad");
                String bayrak_resim = b.getString("bayrak_resim");
                Log.e("bayrak_id",String.valueOf(bayrak_id));
                Log.e("bayrak_ad",bayrak_ad);
                Log.e("bayrak_resim",bayrak_resim);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        String jsonFilmVeri = "{\"filmler\":[{\"film_id\":\"1\",\"film_ad\":\"Interstellar\",\"film_yil\":\"2015\",\"film_resim\":\"interstellar.png\",\"kategori\":{\"kategori_id\":\"4\",\"kategori_ad\":\"Bilim Kurgu\"},\"yonetmen\":{\"yonetmen_id\":\"1\",\"yonetmen_ad\":\"Christopher Nolan\"}},{\"film_id\":\"2\",\"film_ad\":\"Inception\",\"film_yil\":\"2010\",\"film_resim\":\"inception.png\",\"kategori\":{\"kategori_id\":\"4\",\"kategori_ad\":\"Bilim Kurgu\"},\"yonetmen\":{\"yonetmen_id\":\"1\",\"yonetmen_ad\":\"Christopher Nolan\"}},{\"film_id\":\"3\",\"film_ad\":\"The Pianist\",\"film_yil\":\"2002\",\"film_resim\":\"thepianist.png\",\"kategori\":{\"kategori_id\":\"3\",\"kategori_ad\":\"Drama\"},\"yonetmen\":{\"yonetmen_id\":\"4\",\"yonetmen_ad\":\"Roman Polanski\"}},{\"film_id\":\"4\",\"film_ad\":\"Bir Zamanlar Anadolu'da\",\"film_yil\":\"2011\",\"film_resim\":\"birzamanlaranadoluda.png\",\"kategori\":{\"kategori_id\":\"3\",\"kategori_ad\":\"Drama\"},\"yonetmen\":{\"yonetmen_id\":\"3\",\"yonetmen_ad\":\"Nuri Bilge Ceylan\"}},{\"film_id\":\"5\",\"film_ad\":\"The Hateful Eight\",\"film_yil\":\"2015\",\"film_resim\":\"thehatefuleight.png\",\"kategori\":{\"kategori_id\":\"1\",\"kategori_ad\":\"Aksiyon\"},\"yonetmen\":{\"yonetmen_id\":\"2\",\"yonetmen_ad\":\"Quentin Tarantino\"}},{\"film_id\":\"18\",\"film_ad\":\"Django\",\"film_yil\":\"2013\",\"film_resim\":\"django.png\",\"kategori\":{\"kategori_id\":\"1\",\"kategori_ad\":\"Aksiyon\"},\"yonetmen\":{\"yonetmen_id\":\"2\",\"yonetmen_ad\":\"Quentin Tarantino\"}}],\"success\":1}";

        try {
                JSONObject jsonObject = new JSONObject(jsonFilmVeri);
                JSONArray filmlerliste = jsonObject.getJSONArray("filmler");
                for(int i=0; i<filmlerliste.length(); i++){
                    JSONObject f = filmlerliste.getJSONObject(i);
                    int film_id = f.getInt("film_id");
                    String film_ad = f.getString("film_ad");
                    int film_yil = f.getInt("film_yil");
                    String film_resim = f.getString("film_resim");

                    JSONObject kategori = f.getJSONObject("kategori");
                    int kategori_id = kategori.getInt("kategori_id");
                    String kategori_ad = kategori.getString("kategori_ad");

                    JSONObject yonetmen = f.getJSONObject("yonetmen");
                    int yonetmen_id = yonetmen.getInt("yonetmen_id");
                    String yonetmen_ad = yonetmen.getString("yonetmen_ad");

                    Log.e("film_id",String.valueOf(film_id));
                    Log.e("film_ad",film_ad);
                    Log.e("film_yil",String.valueOf(film_yil));
                    Log.e("film_resim",film_resim);
                    Log.e("kategori_id",String.valueOf(kategori_id));
                    Log.e("kategori_ad",kategori_ad);
                    Log.e("yonetmen_id",String.valueOf(yonetmen_id));
                    Log.e("yonetmen_ad",yonetmen_ad);

                }
        }catch (JSONException e){
            e.printStackTrace();
        }
*/

/*
    public void kisi_Ekle(){
        //String text = editText.getText().toString();
        String url = "URL";
        //url = url.concat(text);
        StringRequest istek = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Sonuc:",response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<>();
                //params.put("id","2");
                params.put("kullanici_Adi","isim");
                params.put("kullanici_Sifre","asd123");

                return params;
            }
        };

        Volley.newRequestQueue(this).add(istek);

    }
*/
    }
        public void tumKisiler() {
            String url = "URL";
            StringRequest istek = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    // Log.e("Cevap: ", response);
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        JSONArray kisilerListe = jsonObject.getJSONArray("users");
                        for(int i=0;i<kisilerListe.length();i++){
                            JSONObject k = kisilerListe.getJSONObject(i);
                            int id = k.getInt("id");
                            String kullanici_Adi = k.getString("kullanici_Adi");
                            String kullanici_Sifre = k.getString("kullanici_Sifre");

                            Log.e("id",String.valueOf(id));
                            Log.e("Ad",kullanici_Adi);
                            Log.e("Şifre",kullanici_Sifre);
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });

            Volley.newRequestQueue(this).add(istek);
        }
}