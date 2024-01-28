package com.example.expandable_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;
    private CustomAdapter customAdapter;

    List<String> listDataHeader;
    HashMap<String,List<String>> listDataChild;

    private int lastExpandedPositon = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prepareListData();

        expandableListView = findViewById(R.id.expandableListView_Id);

        customAdapter = new CustomAdapter(this,listDataHeader,listDataChild);
        expandableListView.setAdapter(customAdapter);

//Header Listener
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                String groupName = listDataHeader.get(groupPosition);
                Toast.makeText(getApplicationContext(),groupName,Toast.LENGTH_SHORT).show();

                return false;
            }
        });
//Header Collapse Listener
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {

                String groupName = listDataHeader.get(groupPosition);
                Toast.makeText(getApplicationContext(),groupName+" is collapsed",Toast.LENGTH_SHORT).show();

            }
        });

//Child Listener
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                String childString = listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);
                Toast.makeText(getApplicationContext(),childString,Toast.LENGTH_SHORT).show();

                return false;
            }
        });

//........................
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {

                if (lastExpandedPositon != -1 && lastExpandedPositon != groupPosition){

                    expandableListView.collapseGroup(lastExpandedPositon);
                }
                lastExpandedPositon = groupPosition;


            }
        });


    }



//.....................  preparingListData ...................
    private void prepareListData(){
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        //Adding child data

        listDataHeader.add("1. Overview");
        listDataHeader.add("2. Environment setup");
        listDataHeader.add("3. Program structure");
        listDataHeader.add("4. printf scanf");
        listDataHeader.add("5. Keywords");
        listDataHeader.add("6. Data types");
        listDataHeader.add("7. Variable");
        listDataHeader.add("8. Operator");
        listDataHeader.add("9. Comments");
        listDataHeader.add("10. Math.h");
        listDataHeader.add("11. Control Statements");
        listDataHeader.add("12. Array");
        listDataHeader.add("13. String");
        listDataHeader.add("14. Function");
        listDataHeader.add("15. Pointer");
        listDataHeader.add("16. Structure");
        listDataHeader.add("17. Files");

// Adding child data to the overview
        List<String> overView = new ArrayList<>();
        overView.add("1.1 What is C language");
        overView.add("1.2 History of C");
        overView.add("1.3 Features of C");
        overView.add("1.4 Advantages of C");

// Adding child data to the environmentSetup
        List<String> environmentSetup = new ArrayList<>();
        environmentSetup.add("2.1 How to install Codeblock");

// Adding child data to the programStructure
        List<String> programStructure = new ArrayList<>();
        programStructure.add("3.1 Program Structure");


// Adding child data to the printfScanf
        List<String> printfScanf = new ArrayList<>();
        printfScanf.add("4.1 printf scanf in C");

// Adding child data to the keywords
        List<String> keywords = new ArrayList<>();
        keywords.add("5.1 keywords in C");

// Adding child data to the dataType
        List<String> dataType = new ArrayList<>();
        dataType.add("6.1 Data type in C");


// Adding child data to the variables
        List<String> variables = new ArrayList<>();
        variables.add("7.1 Variables in C");
        variables.add("7.2 Variables Test");

// Adding child data to the operator
        List<String> operator = new ArrayList<>();
        operator.add("8.1 What is operator");


// Adding child data to the comment group
        List<String> comment = new ArrayList<>();
        comment.add("9.1 Comments in C");

// Adding child data to the math group
        List<String> math = new ArrayList<>();
        math.add("10.1 Math Function in C");

// Adding child data to the controlStatements group
        List<String> controlStatements = new ArrayList<>();
        controlStatements.add("11.1 if-else");
        controlStatements.add("11.2 Loop");

// Adding child data to the array group
        List<String> array = new ArrayList<>();
        array.add("12.1 One dimensional Array");
        array.add("12.2 Two dimensional Array");


// Adding child data to the string group
        List<String> string = new ArrayList<>();
        string.add("13.1 String in C");



// Adding child data to the function group
        List<String> function = new ArrayList<>();
        function.add("14.1 Function in C");


// Adding child data to the pointer group
        List<String> pointer = new ArrayList<>();
        pointer.add("15.1 Pointer in C");
        pointer.add("15.2 Pointer Test");


// Adding child data to the structure_union group
        List<String> structure_union = new ArrayList<>();
        structure_union.add("16.1 Structure union in C");
        structure_union.add("16.2 Structure Test");


// Adding child data to the files group
        List<String> files = new ArrayList<>();
        files.add("17.1 File Handling in C");
        files.add("17.2 fprintf() fscanf()");


        //Header , Chile Data

        listDataChild.put(listDataHeader.get(0),overView);
        listDataChild.put(listDataHeader.get(1),environmentSetup);
        listDataChild.put(listDataHeader.get(2),programStructure);
        listDataChild.put(listDataHeader.get(3),printfScanf);
        listDataChild.put(listDataHeader.get(4),keywords);
        listDataChild.put(listDataHeader.get(5),dataType);
        listDataChild.put(listDataHeader.get(6),variables);
        listDataChild.put(listDataHeader.get(7),operator);
        listDataChild.put(listDataHeader.get(8),comment);
        listDataChild.put(listDataHeader.get(9),math);
        listDataChild.put(listDataHeader.get(10),controlStatements);
        listDataChild.put(listDataHeader.get(11),array);
        listDataChild.put(listDataHeader.get(12),string);
        listDataChild.put(listDataHeader.get(13),function);
        listDataChild.put(listDataHeader.get(14),pointer);
        listDataChild.put(listDataHeader.get(15),structure_union);
        listDataChild.put(listDataHeader.get(16),files);






    }






//.........................................................

    /*   This is a use in by 1 chile use in header


    public void prepareListData(){

        String[] headerString = getResources().getStringArray(R.array.network_abbreviation_list_header);
        String[] childString = getResources().getStringArray(R.array.network_abbreviation_list_child);

        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();


        for (int i=0;i<headerString.length;i++){

            //Adding header data
            listDataHeader.add(headerString[i]);

            List<String> child = new ArrayList<String>();
            child.add(childString[i]);

            listDataChild.put(listDataHeader.get(i),child);

        }


    }



    */



}