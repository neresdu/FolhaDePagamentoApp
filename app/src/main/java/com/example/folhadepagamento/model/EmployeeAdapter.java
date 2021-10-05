package com.example.folhadepagamento.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.folhadepagamento.R;
import com.example.folhadepagamento.model.Employee;
import com.example.folhadepagamento.model.EmployeeDAO;
import com.example.folhadepagamento.model.EmployeeViewHolder;

public class EmployeeAdapter extends RecyclerView.Adapter {
    private Context context;
    private EmployeeDAO employeeDAO;

    public EmployeeAdapter(Context context, EmployeeDAO employeeDAO) {
        this.context = context;
        this.employeeDAO = employeeDAO;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.activity_main, parent, false);
        EmployeeViewHolder employeeViewHolder = new EmployeeViewHolder(view);
        return employeeViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        EmployeeViewHolder employeeViewHolder = (EmployeeViewHolder) holder;
        Employee emp = employeeDAO.getEmployee(position);

        employeeViewHolder.tvEmployeeName.setText(emp.getEmployeeName());
        employeeViewHolder.tvGrossSalary.setText(("Salario Bruto: "+emp.getGrossSalary()));
        employeeViewHolder.tvINSS.setText("INSS: "+emp.getINSS());
        employeeViewHolder.tvIR.setText("IR: "+emp.getIR());
        employeeViewHolder.tvFGTS.setText("FGTS: "+emp.getFGTS());
        employeeViewHolder.tvNetSalary.setText("Salario Liquido: "+emp.getNetSalary());

    }

    @Override
    public int getItemCount() {
        return employeeDAO.getEmployeeList().size();
    }
}
