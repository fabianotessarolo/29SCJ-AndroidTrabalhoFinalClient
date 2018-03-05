package com.fabianotessarolo.todo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.fabianotessarolo.todo.R;
import com.fabianotessarolo.todo.model.Todo;

import java.util.ArrayList;

/**
 * Created by fabiano.tessarolo on 05/03/18.
 */

public class TodoArrayAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Todo> todos;

    public TodoArrayAdapter(Context context, ArrayList<Todo> todoList) {
        super();

        this.context = context;
        this.todos = todoList;
    }

    @Override
    public int getCount() {
        if (todos == null) return 0;
        return todos.size();    }

    @Override
    public Object getItem(final int position) {
        if (todos == null || todos.size() == 0) return null;
        return todos.get(position);    }

    @Override
    public long getItemId(final int position) {
        //return getItem(position).getId();
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {



        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            convertView = inflater.inflate(R.layout.activity_main, null);


            TextView todoDescription = (TextView) convertView.findViewById(R.id.etDescricao);
            todoDescription.setText((CharSequence) todos.get(position));


        }


        return convertView;

    }


}