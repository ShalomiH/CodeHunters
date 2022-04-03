package com.cmput301w22t36.codehunters.Fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.cmput301w22t36.codehunters.Data.DataMappers.QRCodeMapper;
import com.cmput301w22t36.codehunters.Data.DataMappers.UserMapper;
import com.cmput301w22t36.codehunters.Data.DataTypes.QRCodeData;
import com.cmput301w22t36.codehunters.Data.DataTypes.User;
import com.cmput301w22t36.codehunters.MainActivity;
import com.cmput301w22t36.codehunters.QRCode;
import com.cmput301w22t36.codehunters.QRCodeAdapter;
import com.cmput301w22t36.codehunters.R;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class: SearchNearbyCodesFragment, a {@link Fragment} subclass.
 *
 * Take in the users prompts to search for QR codes by geolocation.
 */
public class SearchNearbyCodesFragment extends Fragment {

    // Initialize views to manage them within a fragment
    private ListView codeList;
    private EditText latInput;
    private EditText lonInput;
    private Button search;
    private ArrayList<QRCode> codeArrayList;
    private ArrayAdapter<QRCode> codeArrayAdapter;

    /**
     * Required empty public constructor
     */
    public SearchNearbyCodesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment SearchNearbyCodesFragment.
     */
    public static SearchNearbyCodesFragment newInstance() {
        SearchNearbyCodesFragment fragment = new SearchNearbyCodesFragment();
        return fragment;
    }

    /**
     * This initializes the fragment
     * @param savedInstanceState: this is the bundle that will be called through the superclass
     */
    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); }

    /**
     * This inflates the fragment's layout
     * @param inflater: the LayoutInflator for the view
     * @param container: the ViewGroup of the view
     * @param savedInstanceState: this is the bundle that will be called through the superclass
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_nearby_codes, container, false);
    }

    /**
     * Obtain a latitude and longitude as user input and compute the list of nearby QR codes.
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Obtain the views within the fragment
        codeList = view.findViewById(R.id.code_list);
        latInput = (EditText)view.findViewById(R.id.lat);
        lonInput = (EditText)view.findViewById(R.id.lon);
        search = (Button)view.findViewById(R.id.searchCode);

        // Set the search button to respond to user clicks
        search.setOnClickListener(new View.OnClickListener() {
            /**
             * Search for codes near the lat and lon specified by the user
             * @param view: the current view
             */
            @Override
            public void onClick(View view) {
                // Obtain the lat and lon values
                String latValue = latInput.getText().toString();
                String lonValue = lonInput.getText().toString();

                // Convert the values for searching
                int latInteger = Integer.parseInt(latValue);
                int lonInteger = Integer.parseInt(lonValue);

                displayList(latInteger, lonInteger, codeArrayList);
            }
        });
    }

    // Obtain the nearby QR codes and display them with the ListView
    private void displayList(int latInteger, int lonInteger, ArrayList<QRCode> codeArrayList) {

        // TODO: obtain the QR codes
        // Obtain the list of codes with respect to the user input
        //searchCodes(lat, lon, codeArrayList);

        /*// TODO: remove the placeholder examples
        QRCode code1 = new QRCode("BFG5DGW54");
        QRCode code2 = new QRCode("W4GAF75A7");
        QRCode code3 = new QRCode("Z56SJHGF76");
        codeArrayList.add(code1);
        codeArrayList.add(code2);
        codeArrayList.add(code3);*/

        /*codeArrayAdapter = new QRCodeAdapter(this.getContext(), codeArrayList);
        codeList.setAdapter(codeArrayAdapter);

        codeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            *//**
         * When a QRCode in the ListView is clicked, a dialog fragment will appear with the code's photo and location
         * @param adapterView
         * @param view
         * @param i
         * @param l
         *//*
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                QRCode qrCodeClicked = (QRCode) codeList.getItemAtPosition(i);
                new Geolocation_PhotosFragment(qrCodeClicked).show(getActivity().getSupportFragmentManager(), "ADD_GEO");
            }
        });*/
    }

    // TODO: comments
    public void notifyCodesAdapter() {
        codeArrayAdapter.notifyDataSetChanged();
    }
}