package zw.co.tansoft.budget.fragment;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import zw.co.tansoft.budget.R;
import zw.co.tansoft.budget.adapter.MessageAdapter;
import zw.co.tansoft.budget.model.ListMessage;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MessageFragment extends Fragment {

    private View contentView;
    private ListView message_listview;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        List<ListMessage> smsList = new ArrayList<>();
        Uri uri = Uri.parse("content://sms/inbox");
        Cursor c = getActivity().getContentResolver().query(uri, new String[]{"_id", "address", "date", "body"}, null, null, null);
        getActivity().startManagingCursor(c);



        if (c.moveToFirst()) {
            for (int i = 0; i < c.getCount(); i++) {


                String body = c.getString(c.getColumnIndexOrThrow("address"));
                if(body.equals("+263164")) {
                    System.out.println("============================" + body);
                }


//                Pattern p = Pattern.compile("-?\\d+");
//                Matcher m = p.matcher(body);
//                while (m.find()) {
//                    System.out.println("============================================="+m.group());
//                }

                   ListMessage sms = new ListMessage();
                   sms.setBody(c.getString(c.getColumnIndexOrThrow("body")));
                   sms.setNumber(c.getString(c.getColumnIndexOrThrow("address")));
                   sms.setDate_recievied(c.getString(c.getColumnIndexOrThrow("date")));
                   smsList.add(sms);
                   c.moveToNext();



           }
        }


        // Inflate the layout for this fragment
        contentView = inflater.inflate(R.layout.fragment_message, container, false);
        message_listview = contentView.findViewById(R.id.message_View);

        MessageAdapter adapter = new MessageAdapter(getActivity().getApplicationContext(), smsList);
        message_listview.setAdapter(adapter);
        message_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        return contentView;
    }


}
