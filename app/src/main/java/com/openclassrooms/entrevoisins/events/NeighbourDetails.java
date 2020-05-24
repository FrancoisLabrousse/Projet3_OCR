package com.openclassrooms.entrevoisins.events;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;


import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * New activity to display a neighbor's profile
 */
public class NeighbourDetails extends AppCompatActivity {

    @BindView(R.id.neighbour_image)
    ImageView neighbour_image;
    @BindView(R.id.neighbor_name_bis)
    TextView neighbor_name_bis;
    @BindView(R.id.neighbor_name)
    TextView neighborName;
    @BindView(R.id.neighbor_address)
    TextView neighbor_address;
    @BindView(R.id.neighbor_phone)
    TextView neighbor_phone;
    @BindView(R.id.neighbor_facebook)
    TextView neighbor_facebook;
    @BindView(R.id.neighbor_about_me)
    TextView neighbor_about_me;
    @BindView(R.id.fab)
    FloatingActionButton favorite_button;

    private NeighbourApiService mNeighbourApiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.neighbour_details);
        ButterKnife.bind(this);
        mNeighbourApiService = DI.getNeighbourApiService();

        /**
         * Retrieving profile elements via MyNeighbourRecyclerViewAdapter
         */
        Intent intent = getIntent();

        long idNeighbour = intent.getLongExtra("id", 0);

        String photo = intent.getStringExtra("photo");
        Glide.with(this).load(photo).into(neighbour_image);

        String name = intent.getStringExtra("name");
        neighborName.setText(name);
        neighbor_name_bis.setText(name);
        neighbor_facebook.setText("www.facebook.fr/" + name.substring(0).toLowerCase());

        String address = intent.getStringExtra("address");
        neighbor_address.setText(address.replaceAll(";", "à"));

        String phone = intent.getStringExtra("phone");
        neighbor_phone.setText(phone);

        String aboutMe = intent.getStringExtra("aboutMe");
        neighbor_about_me.setText(aboutMe);

        /**
         * Adding a neighbor in the favorites list at the click of the button
         * Creation of a new neighbor
         * Which is transmitted in AddFavoriteNeighbour
         */
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Neighbour neighbour = new Neighbour(idNeighbour, name, photo, address, phone, aboutMe);

                mNeighbourApiService.addNeighbourFavorite(neighbour);

                EventBus.getDefault().post(new AddFavoriteNeighbour(neighbour));

                Toast.makeText(getApplicationContext(),
                        "Ce voisin a été ajouté dans vos favoris", Toast.LENGTH_SHORT).show();

            }
        });
        /**
         * Back button
         */
        ImageButton backButton = (ImageButton) findViewById(R.id.back_button);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ListNeighbourActivity.class);
                startActivity(intent);
            }
        });

    }

}



