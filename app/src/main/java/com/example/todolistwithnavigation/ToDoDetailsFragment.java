package com.example.todolistwithnavigation;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class ToDoDetailsFragment extends Fragment {
    private TaskList tasks;
    private Task task;
    private EditText tvTitle;
    private EditText tvDescription;
    private TextView tvDueDate;
    private Switch tvCompleted;
    private Button btnRemove;
    private Button btnSave;
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
        View view = inflater.inflate(R.layout.fragment_todo_details, container, false);
        int taskId = getArguments().getInt("taskId");
        task=tasks.getTask(taskId+1);
        tvTitle = view.findViewById(R.id.title);
        tvDescription = view.findViewById(R.id.description);
        tvDueDate = view.findViewById(R.id.date);
        tvCompleted = view.findViewById(R.id.complited);
        btnRemove = view.findViewById(R.id.delete);
        btnSave = view.findViewById(R.id.save);


        tvTitle.setText(task.getTitle());
        tvDueDate.setText(task.getDueDate());
        tvDescription.setText(task.getDescription());
        tvCompleted.setChecked(task.getComplete());

        btnRemove.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             tasks.deleteTask(task.getId());
                                             Navigation.findNavController(view).navigate(R.id.toDoListFragment);

                                         }
                                     });


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                task.setTitle(tvTitle.getText().toString());
                task.setDescription(tvDescription.getText().toString());
                task.setComplete(tvCompleted.isChecked());
                //task.setDueDate(tvDueDate.getText().toString());
                Navigation.findNavController(view).navigate(R.id.toDoListFragment);

            }
        });


        return view;


    }
}