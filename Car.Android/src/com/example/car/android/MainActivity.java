package com.example.car.android;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import car.android.customControls.ServiceWorkListAdapter;
import carinspectorlib.entities.ServiceWork;
import carinspectorlib.model.CarManager;


public class MainActivity extends ActionBarActivity {

	ListView lv_serviceWorks;
	public static final String MESSAGE_SERVICEWORK_ID = "com.example.car.android.MESSAGE_SERVICEWORK_ID";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_work);
        setContentView(R.layout.activity_main);
        
        lv_serviceWorks = (ListView)findViewById(R.id.serviceWorksList);
        
        CarManager test = CarManager.GetTestCarManager();
        ArrayList<ServiceWork> list = test.getServiceWorks();
        
        ServiceWorkListAdapter adapter = 
        		new ServiceWorkListAdapter(
	        		this, 
	        		android.R.layout.simple_list_item_1, 
	        		list);
        
        lv_serviceWorks.setAdapter(adapter);
        
        lv_serviceWorks.setOnItemClickListener(
        		new AdapterView.OnItemClickListener() {
				
        			@Override
        			public void onItemClick(AdapterView<?> parent, final View view, int position, long id)
        			{
        				TextView viewID = (TextView)view.findViewById(R.id.serviceWorkID);
        				int serviceWorkID = Integer.parseInt(viewID.getText().toString());
        				
        				startServiceWorkActivity(serviceWorkID);
        			}
        		
        		}
        	);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onServiceWorkItemClick(View view)
    {
    	startServiceWorkActivity(1);
    }
    
    void startServiceWorkActivity(int serviceWorkID)
    {
    	Intent intent = new Intent(this, ServiceWorkActivity.class);
    	intent.putExtra(MESSAGE_SERVICEWORK_ID, serviceWorkID + "");

    	startActivity(intent);
    }

}


