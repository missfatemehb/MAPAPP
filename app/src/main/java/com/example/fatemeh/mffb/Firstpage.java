package com.example.fatemeh.mffb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;
import android.app.Activity;

import java.util.ArrayList;


public class Firstpage extends Activity {
    public String name1 ="grandma";
    public String name2 ="grandpa";
    public String name3 ="mom";
    public String name4 ="dad";
    ListView list;
    ListView list1;

    String[] wb;
// = {"","","","",""};
//    new String[100];
    String[] web = {
            name1,
            name2,
            name3,
            name4

    } ;



    Integer[] imageId1;
//    = {0,0,0,0};
    Integer[] imageId = {
            R.drawable.grandma,
            R.drawable.grandpa,
            R.drawable.mom,
            R.drawable.dad

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainroot);

        final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        Button menu=(Button)findViewById(R.id.button11);
        final ListView menuthing=(ListView)findViewById(R.id.lst);
        final Button searchbtn=(Button )findViewById(R.id.searchbtn);
        final EditText search=(EditText) findViewById(R.id.search) ;

        searchbtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String y=search.getText().toString();
                Log.e("hi",y);
                int x=web.length;
                int r=0;
                int counter=0;
                for(int i=0;i<x;i++){
                    if(web[i].contains(y)) {
                        counter++;
                        Log.e("hi",String.valueOf(counter));
                    }
                    }
                    wb=new String[counter];
                    imageId1=new Integer[counter];
                for(int i=0;i<x;i++){
                    if(web[i].contains(y)){
                        Log.e("hi",web[i]);
                        wb[r]=web[i];
                        imageId1[r]=imageId[i];
                        Log.e("hi",String.valueOf(imageId[i]));
                        r++;
                        Log.e("hi",String.valueOf(r));
                    }
                    Mylist1 adapter1 = new
                            Mylist1(Firstpage.this, wb, imageId1);
                    list1=(ListView)findViewById(R.id.list);
                    list1.setAdapter(adapter1);
                    list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view,
                                                int position, long id) {
                            Toast.makeText(Firstpage.this, "You choose " +wb[+ position], Toast.LENGTH_SHORT).show();
                            String name=wb[+ position];
                            Intent intent = new Intent(Firstpage.this, Profilepage.class);
                            intent.putExtra("DataName" , name);
                            startActivity(intent);


                        }
                    });

                }

            }

        });


        Mylist adapter = new
                Mylist(Firstpage.this, web, imageId);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(Firstpage.this, "You choose " +web[+ position], Toast.LENGTH_SHORT).show();
                String name=web[+ position];
                Intent intent = new Intent(Firstpage.this, Profilepage.class);
                intent.putExtra("DataName" , name);
                startActivity(intent);


            }
        });



        menu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(drawerLayout.isDrawerOpen(Gravity.LEFT)){
                    drawerLayout.closeDrawers();
                }else {
                    drawerLayout.openDrawer(Gravity.LEFT);
                }
            }
        });

        menuthing.setOnItemClickListener(onMenuthingClickListener);

    }

    AdapterView.OnItemClickListener onMenuthingClickListener=new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?>av,View v ,int position,long id){
            String X=av.getItemAtPosition(position).toString();
            if(position==1){
                Intent gotoaboutus = new Intent(Firstpage.this, Aboutus.class);
                startActivity(gotoaboutus);

            }
        }


    };

}
