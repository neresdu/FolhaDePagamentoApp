package com.example.folhadepagamento;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.folhadepagamento.model.EmployeeAdapter;
import com.example.folhadepagamento.model.EmployeeDAO;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvEmployees;
    Button bNovo;
    EmployeeDAO dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rvEmployees = findViewById(R.id.rvEmployees);
        bNovo = findViewById(R.id.bNovo);
        dao = new EmployeeDAO();


        bNovo.setOnClickListener( v -> {
            startActivity(new Intent(this, RegisterActivity.class));
        });
        RecyclerView.LayoutManager empLayout = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,
                false
        );
        rvEmployees.setLayoutManager(empLayout);



        // setar ação de clique nos itens da lista
//        rvEmployees.setOnItemClickListener((parent, view, position, id) -> {
//            Intent intent = new Intent(this, DetailsActivity.class);
//            intent.putExtra("position", position);
//            startActivity(intent);
//
//        });

        // excluir item da lista
//        rvEmployees.setOnItemLongClickListener((parent, view, position, id) ->{
//            new AlertDialog.Builder(this)
//                    .setTitle("Excluir cadastro")
//                    .setMessage("Tem certeza que deseka excluir este cadastro? ")
//                    .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//                            dao.delete(position);
//                            onResume();
//                        }
//                    })
//                    .setNegativeButton("Não", null).show();
//
//
//
//
//            return false;
//        });
        
    }
    @Override
    protected void onResume(){
        super.onResume();

        EmployeeAdapter employeeAdapter = new EmployeeAdapter(this, dao);
        rvEmployees.setAdapter(employeeAdapter);
    }
}