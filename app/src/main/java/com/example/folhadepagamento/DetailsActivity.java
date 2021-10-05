package com.example.folhadepagamento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.folhadepagamento.model.Employee;
import com.example.folhadepagamento.model.EmployeeDAO;

public class DetailsActivity extends AppCompatActivity {
    TextView tvEmployeeName;
    TextView tvGrossSalary;
    TextView tvIR;
    TextView tvINSS;
    TextView tvFGTS;
    TextView tvNetSalary;
    EmployeeDAO dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        tvEmployeeName = findViewById(R.id.tvEmployeeName);
        tvGrossSalary = findViewById(R.id.tvGrossSalary);
        tvIR = findViewById(R.id.tvIR);
        tvINSS = findViewById(R.id.tvINSS);
        tvFGTS = findViewById(R.id.tvFGTS);
        tvNetSalary = findViewById(R.id.tvNetSalary);

        dao = new EmployeeDAO();

        Intent intent = getIntent();
        //tenta armazenar o valor inteiro chamado 'position' da intent recebida
        int position = intent.getIntExtra("position", -1);

        // se for -1, mata a actitivy atual para previnir erros
        if(position == -1) { finish(); }



        Employee employee = dao.getEmployee(position);
        tvEmployeeName.setText(employee.getEmployeeName());
        tvGrossSalary.setText("Gross Salary: "+employee.getGrossSalary());
        tvIR.setText("IR: "+employee.getIR());
        tvINSS.setText("INSS: "+employee.getINSS());
        tvFGTS.setText("FGTS: "+employee.getFGTS());
        tvNetSalary.setText("Net Salary: "+employee.getNetSalary());
        //
        //
        //

    }


}