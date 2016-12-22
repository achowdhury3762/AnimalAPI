package nyc.c4q.ashiquechowdhury.animalapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.ashiquechowdhury.animalapplication.model.Animal;

/**
 * Created by ashiquechowdhury on 12/21/16.
 */
public class AnimalAdapter extends RecyclerView.Adapter<AnimalViewHolder> {
    List<Animal> myAnimalList;

    public AnimalAdapter(List<Animal> myResponseAnimalList) {
        myAnimalList = myResponseAnimalList;
    }

    @Override
    public AnimalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View childView = inflater.inflate(R.layout.animal_row, parent, false);
        return new AnimalViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(AnimalViewHolder holder, int position) {
        holder.bind(myAnimalList.get(position));
    }

    @Override
    public int getItemCount() {
        return myAnimalList.size();
    }
}
