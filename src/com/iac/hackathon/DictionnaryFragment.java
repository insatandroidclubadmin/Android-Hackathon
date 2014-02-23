package com.iac.hackathon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.iac.hackathon.domain.Letter;
import com.iac.hackathon.domain.Word;
import com.iac.hackathon.manager.MessageManager;

public class DictionnaryFragment extends ListFragment {

	MessageManager manager = new MessageManager();
	
	public DictionnaryFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_main_dictionary,container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		LinkedList<String> wordNames = new LinkedList<String>();
		
		for (Word word : manager.getWords()) {
			wordNames.add(word.getName());
		}
		for (Letter letter : manager.getLetters()) {
			wordNames.add(letter.getName());
		}
		Collections.sort(wordNames);
		//TODO: sort alphabetically
		setListAdapter(new MyListAdapter(getActivity(), wordNames));
		
		ListView lv = getListView();
		lv.setFastScrollEnabled(true);

		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// When clicked, show a toast with the TextView text
				Bundle bundle = new Bundle();
				bundle.putString("gesture", ((TextView) view).getText().toString());
				Intent intent = new Intent(getActivity(), WordDialogActivity.class);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
	}
	
	class MyListAdapter extends ArrayAdapter<String> implements SectionIndexer {

		HashMap<String, Integer> alphaIndexer;
		String[] sections;

		public MyListAdapter(Context context, LinkedList<String> items) {
			super(context, R.layout.list_item, items);

			alphaIndexer = new HashMap<String, Integer>();
			int size = items.size();

			for (int x = 0; x < size; x++) {
				String s = items.get(x);
				// get the first letter of the store
				String ch = s.substring(0, 1);
				// convert to uppercase otherwise lowercase a -z will be sorted
				// after upper A-Z
				ch = ch.toUpperCase();
				// put only if the key does not exist
				if (!alphaIndexer.containsKey(ch))
					alphaIndexer.put(ch, x);
			}

			Set<String> sectionLetters = alphaIndexer.keySet();
			// create a list from the set to sort
			ArrayList<String> sectionList = new ArrayList<String>(
					sectionLetters);
			Collections.sort(sectionList);
			sections = new String[sectionList.size()];
			sections = sectionList.toArray(sections);
		}

		@Override
		public int getPositionForSection(int section) {
			return alphaIndexer.get(sections[section]);
		}

		@Override
		public int getSectionForPosition(int position) {
			return 0;
		}

		@Override
		public Object[] getSections() {
			return sections;
		}
	}
}
