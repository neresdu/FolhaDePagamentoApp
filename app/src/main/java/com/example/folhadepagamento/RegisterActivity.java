package com.example.folhadepagamento;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.folhadepagamento.model.Employee;
import com.example.folhadepagamento.model.EmployeeDAO;

public class RegisterActivity extends AppCompatActivity {
    EditText etEmployeeName;
    EditText etHoursWorked;
    EditText etHourValue;

    EditText etGrossSalary;
    EditText etIR;
    EditText etINSS;
    EditText etFGTS;
    EditText etNetSalary;
    EmployeeDAO dao;
    Button bSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etEmployeeName = findViewById(R.id.etEmployeeName);
        etHoursWorked = findViewById(R.id.etHoursWorked);
        etHourValue = findViewById(R.id.etHourValue);
        bSalvar = findViewById(R.id.bSalvar);
        dao = new EmployeeDAO();


        bSalvar.setOnClickListener(view -> {
            if (etEmployeeName.getText().toString().isEmpty() ||
                etHoursWorked.getText().toString().isEmpty() ||
                etHourValue.getText().toString().isEmpty()){
                Toast.makeText(this, "Por favor preencha todos os campos", Toast.LENGTH_SHORT).show();
            }
            else{
                Employee emp = new Employee(
                        etEmployeeName.getText().toString(),
                        Double.parseDouble(etHoursWorked.getText().toString()),
                        Double.parseDouble(etHourValue.getText().toString())
                );
                dao.save(emp);
                Toast.makeText(this, "Funcionario registrado com sucesso", Toast.LENGTH_SHORT).show();
                finish();
            }
        });


























    }
}