package com.paper.papertask.fragment;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;

import com.paper.papertask.R;
import com.paper.papertask.data.Constants;
import com.paper.papertask.models.Element;
import com.paper.papertask.models.Note;
import com.paper.papertask.other.GridElementsAdapter;

public class GridFragment extends Fragment implements OnClickListener{
	
	private GridView gridview;
	private Button new_note_button;
	private Button new_task_button;
	
	public GridFragment() {
        // Empty constructor required for fragment subclasses
    }
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_grid, container, false);
        int i = getArguments().getInt(Constants.ARG_ALL_ELEMENTS);
        
        new_note_button =(Button ) this.getActivity().findViewById(R.id.buttonNewNote);
        new_task_button =(Button ) this.getActivity().findViewById(R.id.buttonNewTask);
        
        gridview = (GridView) rootView.findViewById(R.id.gridElements);
        List<Element> array = new ArrayList<Element>() ;
        array.add(new Note());
        array.add(new Note());
        array.add(new Note());
        updateInfoGRID( array );
        
        new_note_button.setOnClickListener( this );
        new_task_button.setOnClickListener( this );
        return rootView;
	}
	
	/**
	 * Method to cherge the info of the grid
	 * @param list
	 */
	private void updateInfoGRID(List<Element> list){
		if(list!=null){
			GridElementsAdapter adapter = new GridElementsAdapter(
				getActivity(), list,
				getActivity());
			if (gridview != null) gridview.setAdapter(adapter);
		}
	}

	@Override
	public void onClick(View arg0) {
		if (arg0.equals( new_note_button)){
			
		}
	}
}