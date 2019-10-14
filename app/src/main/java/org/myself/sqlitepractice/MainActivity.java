package org.myself.sqlitepractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=findViewById(R.id.tv);

        DatabaseHandler dh=new DatabaseHandler(getApplicationContext());
        Log.d("Insert","Inserting..");
        dh.addPerson(new Person("Ravi","1234"));
        dh.addPerson(new Person("Khan","12345"));
        Log.d("Reading","All..");
        List<Person> pList=dh.gerAll();
        String s2="";
        for (Person p: pList){
            String s="Id: "+p.get_id()+", Name: "+p.get_name()+", Password: "+p.get_password();
            Log.d("Person",s);
            s2=s;
        }
        tv.setText(s2);

    }
}
