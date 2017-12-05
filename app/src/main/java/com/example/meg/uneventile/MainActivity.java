package com.example.meg.uneventile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.HashMap;
import java.util.Map;

import io.keen.client.android.AndroidKeenClientBuilder;
import io.keen.client.java.KeenClient;
import io.keen.client.java.KeenProject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        KeenClient client = new AndroidKeenClientBuilder(this).build();
        KeenClient.initialize(client);

        // This is your actual Project ID and Write Key
        KeenProject project = new KeenProject("5a1fd52fc9e77c0001ab61d2", "BA7A6BF5E961C85E635635C43966648A18D0A5E4FE0CF222FEDEF1DAEE6A078046E8DA79FE32B54A0A964C5CC11A0D5EDA5B93FCDDC9E60960B8436318EE87753CCBEF15FFA57F06B8D3B49C93475E099687243AA705F9ACA21976A95A3626CB", null);
        KeenClient.client().setDefaultProject(project);

        track();
    }

    protected void track() {
        // Create an event to upload to Keen.
        Map<String, Object> event = new HashMap<String, Object>();
        event.put("item", "AppOpen");

        KeenClient.client().addEvent("appOpen", event);
    }


}
