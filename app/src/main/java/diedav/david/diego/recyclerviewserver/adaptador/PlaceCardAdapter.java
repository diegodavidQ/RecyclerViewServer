package diedav.david.diego.recyclerviewserver.adaptador;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import diedav.david.diego.recyclerviewserver.R;
import diedav.david.diego.recyclerviewserver.imageCache.PicassoCache;
import diedav.david.diego.recyclerviewserver.model.Place;

/**
 * Created by root on 31/07/16.
 */
public class PlaceCardAdapter extends RecyclerView.Adapter<PlaceCardAdapter.CardViewHolder> {

    private final Context mainContext;
    private final List<Place> items;

    public PlaceCardAdapter(List<Place> items, Context mainContext) {
        this.mainContext = mainContext;
        this.items = items;
    }


    //class static
    static class CardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @Bind(R.id.txtName) TextView name;
        @Bind(R.id.txtCountry) TextView country;
        @Bind(R.id.imgPlace)  ImageView image;
        //for click
        Context context;
        List<Place> items= new ArrayList<Place>();
        //
        public CardViewHolder(View v, Context context, List<Place> items){
            super(v);
            //for click
            this.context=context;
            this.items=items;
            ButterKnife.bind(this, v); //with butterKnife
            v.setOnClickListener(this); //click
        }

        //click within RecyclerView
        @Override
        public void onClick(View v) {
            int position= getAdapterPosition();
            Place place = this.items.get(position);

            Toast.makeText(this.context,"Name: "+place.getName(),Toast.LENGTH_SHORT).show();
         /*   Intent intent = new Intent(this.context, PlaceActivity.class);
            intent.putExtra("imgId",place.getImage());
            intent.putExtra("name",place.getName());
            intent.putExtra("country",place.getCountry());
            this.context.startActivity(intent);*/
        }


    }


    //===============================METHOD RECYCLERVIEW========================================//
    /*
     *   method that create the cardView
     */
    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        //create view that load my layout
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cardview_layout,viewGroup,false);
        return new CardViewHolder(v,mainContext,items); //inflate the CardViewHolder's constructor
    }
    /*
     * update ReclycerView.ViewHolder
     */
    @Override
    public void onBindViewHolder(CardViewHolder viewHolder, int position) {
        Place item = items.get(position); //get item from my List<Place>
        viewHolder.itemView.setTag(item); //save items in Tag

        //set item in cardview respect the position
        viewHolder.name.setText(item.getName());
        viewHolder.country.setText(item.getCountry());

        PicassoCache.getPicassoInstance(this.mainContext).load(items.get(position).
                getImage_url())
                .resize(375, 200)
                .into(viewHolder.image);

        /*Picasso.with(this.mainContext).load(items.get(position).
                                            getImage_url())
                                            .resize(375, 200)
                                            .into(viewHolder.image);
        */
        //viewHolder.image.setImageResource(item.getImage()); //for image from drawable
    }


    @Override
    public int getItemCount() {
        return items.size();
    }
    //===========================================================================//


}

