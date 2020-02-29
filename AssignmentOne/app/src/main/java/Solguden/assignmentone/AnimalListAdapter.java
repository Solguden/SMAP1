package Solguden.assignmentone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/*Code inspired by following video:
https://www.youtube.com/watch?v=E6vE8fqQPTE
*/


import java.util.ArrayList;
import java.util.List;

public class AnimalListAdapter extends ArrayAdapter<Animal> {
    private static final String TAG = "AnimalListAdapter";

    private Context mContext;
    int mResource;

    public AnimalListAdapter( Context context, int resource, ArrayList<Animal> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        //Get the animals info
        String name = getItem(position).getName();
        String pronounced = getItem(position).getPronounced();
        String description = getItem(position).getDescription();
        String note = getItem(position).getNote();
        Double score = getItem(position).getScore();
        int image = getItem(position).getImage();
        int id = getItem(position).getId();

        //create the animal
        Animal animal = new Animal(name,pronounced,description,note,score,image,id);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource,parent,false);

        TextView tvName = (TextView) convertView.findViewById(R.id.listTextName);
        TextView tvPronunce = (TextView) convertView.findViewById(R.id.listTextPronounce);
        TextView tvScore = (TextView) convertView.findViewById(R.id.listTextScore);
        ImageView ivImage = (ImageView) convertView.findViewById(R.id.listImageView);

        tvName.setText(name);
        tvPronunce.setText(pronounced);
        tvScore.setText("" + score);
        ivImage.setImageResource(image);

        return convertView;
    }
}
