package com.paper.papertask.other;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Checkable;

import com.paper.papertask.R;
import com.paper.papertask.models.Element;


public class GridElementsAdapter extends BaseAdapter {
	
	public List<Element> list;
	private Context mContext;
	
	// Gets the context so it can be used later
		public GridElementsAdapter(Context c, List<Element> list, Activity instance) {
			mContext = c;
			this.list = list;
		}

	@Override
	public int getCount() {
		System.out.println(list.size());
		if(list == null)
				return 0;
		else
				return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		 View v;
		 final Checkable l;
		 LayoutInflater li = LayoutInflater.from(mContext);
		 v = li.inflate(R.layout.element_grid, null);
		return v;
	}

}
