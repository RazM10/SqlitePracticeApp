package org.myself.sqlitepractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Button save_btn,deleteAll_btn,showAll_btn;
    EditText name_et, pass_et;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DatabaseHandler dh=new DatabaseHandler(getApplicationContext());

        tv=findViewById(R.id.tv);
        save_btn=findViewById(R.id.save_btn);
        name_et=findViewById(R.id.name_et);
        pass_et=findViewById(R.id.pass_et);
        deleteAll_btn=findViewById(R.id.deleteAll_btn);
        showAll_btn=findViewById(R.id.showAll_btn);

        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=name_et.getText().toString();
                String pass=pass_et.getText().toString();

                if(name.length()==0){
                    name_et.setError("Please Enter Name");
                }
                else if(pass.length()==0){
                    pass_et.setError("Please Enter Password");
                }
                else {
                    Person person=new Person(name,pass);
                    dh.addPerson(person);
                    Toast.makeText(getApplicationContext(),"Saved Successful",Toast.LENGTH_SHORT).show();
                    name_et.setText("");
                    pass_et.setText("");
                }

            }
        });

        deleteAll_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dh.deleteAll();
                Toast.makeText(getApplicationContext(),"Delete All data Successfully",Toast.LENGTH_SHORT).show();
            }
        });

        showAll_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Displaying all data",Toast.LENGTH_SHORT).show();
                showData();
            }
        });


        //DatabaseHandler dh=new DatabaseHandler(getApplicationContext());
//        Log.d("Insert","Inserting..");
//        dh.addPerson(new Person("Ravi","1234"));
//        dh.addPerson(new Person("Khan","12345"));
//        Log.d("Reading","All..");
//        List<Person> pList=dh.gerAll();
//        String s2="";
//        for (Person p: pList){
//            String s="Id: "+p.get_id()+", Name: "+p.get_name()+", Password: "+p.get_password();
//            Log.d("Person",s);
//            s2=s;
//        }
//        tv.setText(s2);
    }
    private void showData(){
        DatabaseHandler dh2=new DatabaseHandler(getApplicationContext());
        List<Person> pList=dh2.gerAll();
        String s2="";
        for (Person p: pList){
            String s="Id: "+p.get_id()+", Name: "+p.get_name()+", Password: "+p.get_password();
            Log.d("Person",s);
            s2=s2+s+"\n";
        }
        tv.setText(s2);
    }
}
