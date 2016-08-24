package diedav.david.diego.recyclerviewserver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import diedav.david.diego.recyclerviewserver.adaptador.PlaceCardAdapter;
import diedav.david.diego.recyclerviewserver.model.Place;

public class MainActivity extends AppCompatActivity {

    //variables
    private RecyclerView recycler;
    private PlaceCardAdapter adapter;
    private RecyclerView.LayoutManager lManager;
    private List<Place> listItemsPlaces;

    private final String Listnames[] = {"Venecia","Egyptian pyramids","Houses of Parliamen","Machu Picchu","Galapagos","Eiffel Tower","Roman Coliseum","Golden Gate Bridge","taj_Mahal"};
    private final String Listcountries[] = {"Italy","Egypt","England","Perú","Ecuador","France","Italy","United States","India"};
    private final String Listurl_images[] = {
                                            "https://archive.org/download/recycler_201608/venecia.jpg",
                                            "https://ia601508.us.archive.org/23/items/recycler_201608/egipto.jpg",
                                            "https://ia801508.us.archive.org/23/items/recycler_201608/london.jpg",
                                            "https://archive.org/download/recycler_201608/machu_picchu.jpg",
                                            "https://archive.org/download/recycler_201608/galapagos.jpg",
                                            "https://archive.org/download/recycler_201608/paris.jpg",
                                            "https://archive.org/download/recycler_201608/roma.jpg",
                                            "https://archive.org/download/recycler_201608/san_francisco.jpg",
                                            "https://archive.org/download/recycler_201608/taj_mahal.jpg",
                                            };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListPlaces();
        startRecycler();
        if (BuildConfig.DEBUG) {
            Picasso.with(this).setIndicatorsEnabled(true);
            Picasso.with(this).setLoggingEnabled(true);
        }

    }

    private void addListPlaces(){
        listItemsPlaces = new ArrayList<Place>();
        for(int i=0;i<Listurl_images.length;i++){
            Place place = new Place();
            place.setName(Listnames[i]);
            place.setCountry(Listcountries[i]);
            place.setImage_url(Listurl_images[i]);
            listItemsPlaces.add(place);
        }
    }

    private void startRecycler() {
        recycler = (RecyclerView) findViewById(R.id.id_recyclerView);
        recycler.setHasFixedSize(true);

        //administrator for LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        //create new adapter
        adapter = new PlaceCardAdapter(listItemsPlaces,this);
        //add adapter
        recycler.setAdapter(adapter);

        recycler.setItemAnimator(new DefaultItemAnimator());
    }


}
