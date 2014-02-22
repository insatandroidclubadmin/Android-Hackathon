package com.iac.hackathon;

/*
 import com.udinic.expand_animation_example.ExpandAnimation;
 import com.udinic.expand_animation_example.R;
 import com.udinic.expand_animation_example.ExpandAnimationDemo.CustomListAdapter;
 */
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class EmergencyCalls extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.emergency);

		ListView list = (ListView) findViewById(R.id.udiniList);

		// Creating the list adapter and populating the list
		ArrayAdapter<String> listAdapter = new CustomListAdapter(this,
				R.layout.list_item);

		listAdapter.add("Police");
		listAdapter.add("Fireman");
		listAdapter.add("Ambumlance");

		list.setAdapter(listAdapter);

		// Creating an item click listener, to open/close our toolbar for each
		// item

		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, final View view,
					int position, long id) {

				View toolbar = view.findViewById(R.id.toolbar);

				// Creating the expand animation for the item
				ExpandAnimation expandAni = new ExpandAnimation(toolbar, 500);

				// Start the animation on the toolbar
				toolbar.startAnimation(expandAni);
				Toast.makeText(getApplicationContext(),
						"" + position + " / " + id,
						Toast.LENGTH_SHORT).show();
			}
		});

	}

	/**
	 * A simple implementation of list adapter.
	 */
	class CustomListAdapter extends ArrayAdapter<String> {

		public CustomListAdapter(Context context, int textViewResourceId) {
			super(context, textViewResourceId);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			if (convertView == null) {
				convertView = getLayoutInflater().inflate(R.layout.list_item,
						null);
			}

			((TextView) convertView.findViewById(R.id.title))
					.setText(getItem(position));

			// Resets the toolbar to be closed
			View toolbar = convertView.findViewById(R.id.toolbar);
			((LinearLayout.LayoutParams) toolbar.getLayoutParams()).bottomMargin = -50;
			toolbar.setVisibility(View.GONE);

			return convertView;
		}
	}
}
