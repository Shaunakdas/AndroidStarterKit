package kit.starter.com.starterkit;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import kit.starter.com.starterkit.db.DaoSession;
import kit.starter.com.starterkit.db.User;
import kit.starter.com.starterkit.db.UserDao;

public class BaseActivity extends AppCompatActivity {
    TextView mTextView;

    final String contentType = "application/json; charset=utf-8";

    UserDao userDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        mTextView = (TextView) findViewById(R.id.response_text);
        getDaoNote();
        getResponseJsonObjectGson();
    }
    //For using Dao for db interaction
    protected void getDaoNote(){
        // get the note DAO
        DaoSession daoSession = ((AppController) getApplication()).getDaoSession();
        userDao = daoSession.getUserDao();
    }

    //For getting response through volley. Using Volley default ResponseQueue and display response as text
    protected void getResponseString() {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://ee9a0bd2.ngrok.io/posts/1";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        mTextView.setText("Response is: "+ response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mTextView.setText("That didn't work!");
            }
        });
        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
    //For getting response through volley. Using Volley default ResponseQueue and display response as JSONObject
    protected void getResponseJsonObject() {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://ee9a0bd2.ngrok.io/posts/1";

        // Request a string response from the provided URL.
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            mTextView.setText("Response: " + response.getString("id"));
                        }
                        catch (JSONException e) {
                            mTextView.setText("That didn't work:JSON Exception!");
                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        mTextView.setText("That didn't work!");
                    }
                });
        // Add the request to the RequestQueue.
        queue.add(jsObjRequest);
    }
    //For getting response through volley. Using Volley default ResponseQueue and display response handled from gson
    protected void postResponseJsonObjectGson() {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://ee9a0bd2.ngrok.io/posts";
        final Gson gson = new Gson();
        final JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("title","new-json-server");
            jsonObject.put("author","new-author");
        }
        catch (JSONException e) {
            mTextView.setText("That didn't work:JSON Exception!");
        }
        // Request a string response from the provided URL.
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.POST, url, jsonObject, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Book book = gson.fromJson(response.toString(),Book.class);
                        mTextView.setText("Response: " + book.getBookId());
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        mTextView.setText("That didn't work!");
                    }
                }){
            /**
             * Add the headers to the request
             * @return headers
             * @throws AuthFailureError
             */
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }

        };
        // Add the request to the RequestQueue.
        queue.add(jsObjRequest);
    }
    //For posting json request and getting response through volley. Using Volley default ResponseQueue and display response handled from gson
    protected void getResponseJsonObjectGson() {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://ee9a0bd2.ngrok.io/posts/1";
        final Gson gson = new Gson();
        // Request a string response from the provided URL.
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Book book = gson.fromJson(response.toString(),Book.class);
                        mTextView.setText("Response: " + book.getBookId());

                        //For Dao usage only. You can comment if not integrated Dao
                        User user = new User();
                        user.setFirst_name(book.getAuthor());
                        user.setLast_name(book.getTitle());
                        userDao.insert(user);
                        Log.d("BaseActivity", "Inserted new note, ID: " + user.getId());
                        mTextView.setText("DB Added: " + user.getId());
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        mTextView.setText("That didn't work!");
                    }
                });
        // Add the request to the RequestQueue.
        queue.add(jsObjRequest);
    }
}
