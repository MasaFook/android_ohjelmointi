package YTJ;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.helloworld.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DataActivity extends AppCompatActivity {
    public static final String TAG ="DataActivity";
    private String businessId;
    private String name;
    private String registrationDate;
    private String companyForm;
    private String url = "http://avoindata.prh.fi/bis/v1?totalResults=false&maxResults=50&resultsFrom=0&name=lappee";
    private ProgressBar progressBar;
    private RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        progressBar = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        Bundle extras = getIntent().getExtras();
        String value1 = extras.getString("ytjSearchTxt");
        if (extras == null){
            return;
        }

        if(value1 != null){
            url = "http://avoindata.prh.fi/bis/v1?totalResults=false&maxResults=50&resultsFrom=0&name="+ value1;
        }

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e(TAG,"Response " + response.toString());
                        ArrayList<Item> itemList = new ArrayList<Item>();
                        try{
                            JSONArray responseItems = (JSONArray) response.getJSONArray("results");
                            progressBar.setMax(responseItems.length());
                            for (int i = 0; i < responseItems.length(); i++){
                                JSONObject currentItem = responseItems.getJSONObject(i);
                                Log.e(TAG,"Response" + currentItem.getString("name"));
                                Item item = new Item();
                                JSONObject dataObj = responseItems.getJSONObject(i);
                                item.setName(dataObj.getString("name"));
                                item.setBusinessId(dataObj.getString("businessId"));
                                item.setCompanyForm(dataObj.getString("companyForm"));
                                item.setRegistrationDate(dataObj.getString("registrationDate"));

                                itemList.add(item);
                                progressBar.setProgress(i);
                            }
                        }catch (JSONException e){
                            throw new RuntimeException();
                        }
                        progressBar.setVisibility(View.INVISIBLE);
                        RecyclerAdapter adapter = new RecyclerAdapter(itemList);
                        adapter.notifyDataSetChanged();
                        recyclerView.setAdapter(adapter);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });
        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(20 * 1000, 1, 1.0f));
        requestQueue.add(jsonObjectRequest);
    }




}