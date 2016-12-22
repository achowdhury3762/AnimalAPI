package nyc.c4q.ashiquechowdhury.animalapplication;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import nyc.c4q.ashiquechowdhury.animalapplication.model.Animal;

/**
 * Created by ashiquechowdhury on 12/21/16.
 */
public class AnimalViewHolder extends RecyclerView.ViewHolder{
    private TextView animalTView;

    public AnimalViewHolder(View itemView) {
        super(itemView);

        animalTView = (TextView) itemView.findViewById(R.id.tv_animal_name);
    }

    public void bind(Animal animal) {
        animalTView.setText(animal.getName());
        int nameColor = Color.parseColor(animal.getTextColor());

        setNameColor(nameColor);
    }

    public void setNameColor(int nameColor) {
        animalTView.setTextColor(nameColor);

    }
}
