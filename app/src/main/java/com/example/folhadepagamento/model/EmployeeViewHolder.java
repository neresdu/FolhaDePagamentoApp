package com.example.folhadepagamento.model;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.folhadepagamento.R;

public class EmployeeViewHolder extends RecyclerView.ViewHolder {
    TextView tvEmployeeName;
    TextView tvGrossSalary;
    TextView tvIR;
    TextView tvINSS;
    TextView tvFGTS;
    TextView tvNetSalary;

    public EmployeeViewHolder(@NonNull View itemView) {
        super(itemView);
        tvEmployeeName = itemView.findViewById(R.id.tvEmployeeName);
        tvGrossSalary = itemView.findViewById(R.id.tvGrossSalary);
        tvIR = itemView.findViewById(R.id.tvIR);
        tvINSS = itemView.findViewById(R.id.tvINSS);
        tvFGTS = itemView.findViewById(R.id.tvFGTS);
        tvNetSalary = itemView.findViewById(R.id.tvNetSalary);


    }
}
