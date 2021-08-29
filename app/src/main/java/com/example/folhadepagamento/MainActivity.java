package com.example.folhadepagamento;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.folhadepagamento.model.EmployeeDAO;

public class MainActivity extends AppCompatActivity {

    ListView lvEmployees;
    Button bNovo;
    EmployeeDAO dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lvEmployees = findViewById(R.id.lvEmployees);
        bNovo = findViewById(R.id.bNovo);



        bNovo.setOnClickListener( v -> {
            startActivity(new Intent(this, RegisterActivity.class));
        });

        // setar ação de clique nos itens da lista
        lvEmployees.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra("position", position);
            startActivity(intent);

        });

        // excluir item da lista
        lvEmployees.setOnItemLongClickListener((parent, view, position, id) ->{
            new AlertDialog.Builder(this)
                    .setTitle("Excluir cadastro")
                    .setMessage("Tem certeza que deseka excluir este cadastro? ")
                    .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dao.delete(position);
                            onResume();
                        }
                    })
                    .setNegativeButton("Não", null).show();




            return false;
        });
        
    }
    @Override
    protected void onResume(){
        super.onResume();
        dao = new EmployeeDAO();
        lvEmployees.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dao.getEmployeeList()
        ));
    }
}