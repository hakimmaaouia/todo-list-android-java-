package com.example.todolistwithnavigation;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.navigation.Navigation;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


public class ToDoListFragment extends Fragment {

    private EditText edtTask;
    private Button btnAddTask;
    private ListView lvTasks;
    private TaskList tasks;
    private ArrayAdapter<String> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity != null) {
            tasks = mainActivity.getTaskList();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_todo_list, container, false);

        edtTask = view.findViewById(R.id.edtTask);
        btnAddTask = view.findViewById(R.id.btnAddTask);
        lvTasks = view.findViewById(R.id.lvTasks);

        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,tasks.getListToString());
        lvTasks.setAdapter(adapter);

        btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = edtTask.getText().toString();
                if (!task.isEmpty()) {
                    tasks.addTask(new Task(task, ""));
                    adapter.clear();
                    adapter.addAll(tasks.getListToString());
                    adapter.notifyDataSetChanged();
                    edtTask.setText("");
                }
            }
        });
        // handel item click to ba ot details
        lvTasks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Bundle bundle = new Bundle();
                bundle.putInt("taskId", position);
                Navigation.findNavController(view).navigate(R.id.action_toDoListFragment_to_toDoDetailsFragment, bundle);
            }
        });

        return view;
    }


}

