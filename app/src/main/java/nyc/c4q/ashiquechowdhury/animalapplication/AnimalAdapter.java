package nyc.c4q.ashiquechowdhury.animalapplication;

import android.graphics.Color;
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
    private List<Animal> myAnimalList;
    private Listener listener;

    public AnimalAdapter(List<Animal> myResponseAnimalList, Listener listener) {
        myAnimalList = myResponseAnimalList;
        this.listener = listener;
    }

    @Override
    public AnimalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View childView = inflater.inflate(R.layout.animal_row, parent, false);
        return new AnimalViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(final AnimalViewHolder holder, int position) {
        String backgroundString = myAnimalList.get(position).getBackground();
        final int backgroundColor = Color.parseColor(backgroundString);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClickedBackground(backgroundColor);
            }
        });
        holder.bind(myAnimalList.get(position));
    }

    @Override
    public int getItemCount() {
        return myAnimalList.size();
    }

    interface Listener {
        void onClickedBackground(int backgroundColor);
    }
}

