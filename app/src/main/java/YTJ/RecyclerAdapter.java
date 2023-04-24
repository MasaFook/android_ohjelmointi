package YTJ;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.helloworld.MainActivity;
import com.example.helloworld.R;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private ArrayList<Item> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textBusinessId;
        TextView textRegistrationDate;
        TextView textCompanyForm;


        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            this.textBusinessId = (TextView) itemView.findViewById(R.id.textBusinessId);
            this.textRegistrationDate = (TextView) itemView.findViewById(R.id.textRegistrationDate);
            this.textCompanyForm = (TextView) itemView.findViewById(R.id.textCompanyForm);

        }
    }

    public RecyclerAdapter(ArrayList<Item> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);

//        view.setOnClickListener(MainActivity.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView textViewName = holder.textViewName;
        TextView textBusinessId = holder.textBusinessId;
        TextView textCompanyForm = holder.textCompanyForm;
        TextView textRegistrationDate = holder.textRegistrationDate;


        textViewName.setText(dataSet.get(listPosition).getName());
        textBusinessId.setText(dataSet.get(listPosition).getBusinessId());
        textCompanyForm.setText(dataSet.get(listPosition).getCompanyForm());
        textRegistrationDate.setText(dataSet.get(listPosition).getRegistrationDate());

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}

