package com.mazroid.mvvm.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mazroid.mvvm.MainActivity;
import com.mazroid.mvvm.R;
import com.mazroid.mvvm.database.EmpTable;
import com.mazroid.mvvm.model.EmpResponse;

import java.util.List;

/**
 * Created by MazRoid on 5/2/2019.
 */
public class EmpAdapter extends RecyclerView.Adapter<EmpAdapter.EmpViewHolder> {
    Context context;
    List <EmpResponse > empResponses;


    public EmpAdapter(Context context , List<EmpResponse> empResponses) {
    this.context= context;
    this.empResponses = empResponses;
    }

    @NonNull
    @Override
    public EmpViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_item, viewGroup, false);
        return new EmpViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmpViewHolder holder, int i) {
            holder.name.setText(empResponses.get(i).getName());
            holder.company.setText(empResponses.get(i).getCompany().getName() + ":-" +empResponses.get(i).getCompany().getCatchPhrase() );
            holder.email.setText(empResponses.get(i).getEmail());
            holder.phone.setText(empResponses.get(i).getPhone());
            holder.address.setText(empResponses.get(i).getAddress().getStreet()+", "+
                    empResponses.get(i).getAddress().getSuite()+", "+
                    empResponses.get(i).getAddress().getCity()+", "+
                    empResponses.get(i).getAddress().getZipcode()+", "+
                    empResponses.get(i).getAddress().getGeo().getLat()+", "+
                    empResponses.get(i).getAddress().getGeo().getLng());

        EmpTable empTable = new EmpTable();
        empTable.setId(empResponses.get(i).getId());
        empTable.setName(empResponses.get(i).getName());
        empTable.setEmail(empResponses.get(i).getEmail());
        empTable.setPhone(empResponses.get(i).getPhone());
        empTable.setCompany(empResponses.get(i).getAddress().getStreet()+", "+
                empResponses.get(i).getAddress().getSuite()+", "+
                empResponses.get(i).getAddress().getCity()+", "+
                empResponses.get(i).getAddress().getZipcode()+", "+
                empResponses.get(i).getAddress().getGeo().getLat()+", "+
                empResponses.get(i).getAddress().getGeo().getLng());

        MainActivity.myDatabase.myDao().addEmp(empTable);

    }

    @Override
    public int getItemCount() {
        return empResponses.size();
    }

    class EmpViewHolder extends RecyclerView.ViewHolder {
            TextView name,email,phone,address,company;

        public EmpViewHolder(View itemView) {
            super(itemView);
            name= itemView.findViewById(R.id.name);
            email= itemView.findViewById(R.id.email);
            phone= itemView.findViewById(R.id.phone);
            address= itemView.findViewById(R.id.address);
            company= itemView.findViewById(R.id.company);

        }
    }
}

