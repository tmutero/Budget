package zw.co.tansoft.budget.adapter;

import android.support.v7.widget.RecyclerView;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import zw.co.tansoft.budget.R;
import zw.co.tansoft.budget.model.ListMessage;

import java.util.List;

public class MessageAdapter extends ArrayAdapter<ListMessage> {

    // List context
    private final Context context;
    // List values
    private final List<ListMessage> smsList;

    public MessageAdapter(Context context, List<ListMessage> smsList) {
        super(context, R.layout.message_list, smsList);
        this.context = context;
        this.smsList = smsList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.message_list, parent, false);

        TextView senderMessage = rowView.findViewById(R.id.msg);
        senderMessage.setText(smsList.get(position).getBody());
        TextView phoneNumber=rowView.findViewById(R.id.ph_no);
        phoneNumber.setText(smsList.get(position).getNumber());


        return rowView;
    }
}