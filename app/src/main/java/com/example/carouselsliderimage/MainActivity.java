package com.example.carouselsliderimage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText editText;

    IconModelClass iconModelClass;
   IconAdapter iconAdapter;
   ArrayList<IconModelClass> List;

   PlayerAdapter playerAdapter;
   ArrayList<PlayerModelClass> playerModelClassArrayList;

   TeamAdapter teamAdapter;
   ArrayList<TeamModelClass> teamModelClassArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView1=findViewById(R.id.recyclerview1);
        RecyclerView recyclerView2=findViewById(R.id.recyclerview2);
        RecyclerView recyclerView3=findViewById(R.id.recyclerview3);
         editText=findViewById(R.id.et_search);
        recyclerView1.setHasFixedSize(true);
        recyclerView2.setHasFixedSize(true);
        recyclerView3.setHasFixedSize(true);

LinearLayoutManager linearLayoutManager1=new LinearLayoutManager(this);
linearLayoutManager1.setOrientation(RecyclerView.HORIZONTAL);
recyclerView1.setLayoutManager(linearLayoutManager1);

        LinearLayoutManager linearLayoutManager2=new LinearLayoutManager(this);
        linearLayoutManager2.setOrientation(RecyclerView.HORIZONTAL);
recyclerView2.setLayoutManager(linearLayoutManager2);

        LinearLayoutManager linearLayoutManager3=new LinearLayoutManager(this);
        linearLayoutManager3.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView3.setLayoutManager(linearLayoutManager3);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                filters(editable.toString());
                filters2(editable.toString());
                filters3(editable.toString());


            }
        });


        List=new ArrayList<>();
        List.add(new IconModelClass(R.drawable.ic_setting,"Setting"));
        List.add(new IconModelClass(R.drawable.ic_cricket,"Cricket"));
        List.add(new IconModelClass(R.drawable.ic_basketball,"Basketball"));
        List.add(new IconModelClass(R.drawable.ic_watch_later,"Watch later"));
        List.add(new IconModelClass(R.drawable.ic_ball,"Ball"));
        List.add(new IconModelClass(R.drawable.ic_vpn_key,"VPN"));
        List.add(new IconModelClass(R.drawable.ic_games,"Games"));
        List.add(new IconModelClass(R.drawable.ic_grain,"Grain"));
      iconAdapter=new IconAdapter(List,MainActivity.this);
recyclerView1.setAdapter(iconAdapter);


        teamModelClassArrayList=new ArrayList<>();
       teamModelClassArrayList.add( new TeamModelClass(R.drawable.image," James Dean","#3F51B5"));
        teamModelClassArrayList.add(   new TeamModelClass(R.drawable.friends," Maya Angelou","#FA6B3E"));
        teamModelClassArrayList.add(    new TeamModelClass(R.drawable.kitty1," Mark Twain","#673AB7"));
        teamModelClassArrayList.add(     new TeamModelClass(R.drawable.one," Oprah Winfrey","#be4d25"));
        teamModelClassArrayList.add(    new TeamModelClass(R.drawable.onw," Aristotle","#bea925"));
        teamModelClassArrayList.add(      new TeamModelClass(R.drawable.two," William Gibson","#2587be"));
        teamModelClassArrayList.add(      new TeamModelClass(R.drawable.kitty2," Oliver Wendell Holmes","#145369"));
        teamModelClassArrayList.add(     new TeamModelClass(R.drawable.pic1," Camilla Eyring Kimball","#35be25"));
        teamModelClassArrayList.add(    new TeamModelClass(R.drawable.kitty3," Richard Whately","#ae25be"));
        teamModelClassArrayList.add(    new TeamModelClass(R.drawable.pic2," Bil Keane","#25beae"));
        teamModelClassArrayList.add(    new TeamModelClass(R.drawable.pic3,"Winston Churchill","#981e31"));

        teamAdapter=new TeamAdapter(teamModelClassArrayList,MainActivity.this);
        recyclerView2.setAdapter(teamAdapter);

playerModelClassArrayList=new ArrayList<>();
playerModelClassArrayList.add( new PlayerModelClass(R.drawable.imran," Imran Khan","#FFFEFE"));
playerModelClassArrayList.add(new PlayerModelClass(R.drawable.babr," Babar Azam","#FFFEFE"));
playerModelClassArrayList.add( new PlayerModelClass(R.drawable.ronaldo," Cristiano Ronaldo","#FFFEFE"));
playerModelClassArrayList.add( new PlayerModelClass(R.drawable.messi," Lionel Messi","#FFFEFE"));
playerModelClassArrayList.add( new PlayerModelClass(R.drawable.rizwan," Mohammad Rizwan","#FFFEFE"));
playerModelClassArrayList.add(new PlayerModelClass(R.drawable.robert," Robert Lewandowski","#FFFEFE"));
playerModelClassArrayList.add( new PlayerModelClass(R.drawable.two," William Gibson","#FFFEFE"));
playerModelClassArrayList.add( new PlayerModelClass(R.drawable.kitty2," Oliver Wendell Holmes","#FFFEFE"));
playerModelClassArrayList.add( new PlayerModelClass(R.drawable.pic1," Camilla Eyring Kimball","#FFFEFE"));
playerModelClassArrayList.add( new PlayerModelClass(R.drawable.kitty3," Richard Whately","#FFFEFE"));
playerModelClassArrayList.add( new PlayerModelClass(R.drawable.pic2," Bil Keane","#FFFEFE"));
        playerAdapter=new PlayerAdapter(playerModelClassArrayList,MainActivity.this);
        recyclerView3.setAdapter(playerAdapter);



    }



    private void filters3(String text) {
        ArrayList<PlayerModelClass>filtered3List=new ArrayList<>();
        for (PlayerModelClass item2 : playerModelClassArrayList){
            if (item2.getText().contains(text.toLowerCase()))
            {
                filtered3List.add(item2);
            }
        }
        playerAdapter.filter3List(filtered3List);
    }

    private void filters2(String text) {
        ArrayList<TeamModelClass> filtered2List=new ArrayList<>();
        for (TeamModelClass item1 : teamModelClassArrayList)
        {
            if (item1.getTeamtext().contains(text.toLowerCase()))
            {
                filtered2List.add(item1);
            }
        }
        teamAdapter.filter2List(filtered2List);
    }

    private void filters(String text) {

        ArrayList<IconModelClass> filteredList=new ArrayList<>();

        for (IconModelClass item : List)
        {
            if (item.getIcontext().contains(text.toLowerCase()))
            {
                filteredList.add(item);
            }
        }
        iconAdapter.filterList(filteredList);
    }
}