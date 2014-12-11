package car.android.customControls;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.opengl.Visibility;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import carinspectorlib.entities.ServiceWork;

import com.example.car.android.R;

public class ServiceWorkListAdapter extends ArrayAdapter<ServiceWork>
{
	private final ArrayList<ServiceWork> _serviceWorks;
	private final Context _context;
	
	public ServiceWorkListAdapter(Context context, 
			int textViewResourceID, 
			List<ServiceWork> works)
	{
		super(context, R.layout.rowlayout, works);
		_context = context;
		_serviceWorks = (ArrayList<ServiceWork>)works;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		LayoutInflater inflater = (LayoutInflater)_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.rowlayout, parent, false);
		
		TextView textView1 = (TextView)rowView.findViewById(R.id.firstline);
		String text1 = "ID: " + ((ServiceWork)_serviceWorks.toArray()[position]).getID();
		textView1.setText(text1);
		
		TextView textView2 = (TextView)rowView.findViewById(R.id.secondline);
		textView2.setText("Name: " + ((ServiceWork)_serviceWorks.toArray()[position]).getName());
		
		TextView textViewID = (TextView)rowView.findViewById(R.id.serviceWorkID);
		textViewID.setText(((ServiceWork)_serviceWorks.toArray()[position]).getID() + "");
		textViewID.setVisibility(View.GONE);
		
		return rowView;
	}
}
