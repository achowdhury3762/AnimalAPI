package nyc.c4q.ashiquechowdhury.animalapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.ashiquechowdhury.animalapplication.model.AllAnimals;
import nyc.c4q.ashiquechowdhury.animalapplication.model.Animal;
import nyc.c4q.ashiquechowdhury.animalapplication.model.AnimalAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ashiquechowdhury on 12/21/16.
 */
public class AnimalListFragment extends Fragment  implements AnimalAdapter.Listener{
    private static final String BASE_URL = "http://jsjrobotics.nyc/";
    private RecyclerView animalList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_animal_list, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        animalList = (RecyclerView) view.findViewById(R.id.rv_animallist);
        animalList.setLayoutManager(new LinearLayoutManager(view.getContext()));
        getAllHouses();
    }

    public void getAllHouses() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        AnimalAPI houseAPI = retrofit.create(AnimalAPI.class);

        Call<AllAnimals> myHousesCall = houseAPI.getAllAnimals();
        myHousesCall.enqueue(new Callback<AllAnimals>() {
            @Override
            public void onResponse(Call<AllAnimals> call, Response<AllAnimals> response) {
                AllAnimals myAnimals = response.body();
                List<Animal> myResponseAnimalList = myAnimals.getAnimalList();
                animalList.setAdapter(new AnimalAdapter(myResponseAnimalList, AnimalListFragment.this));
            }

            @Override
            public void onFailure(Call<AllAnimals> call, Throwable t) {

            }
        });
    }

    @Override
    public void onClickedBackground( int backGroundColor) {
        animalList.setBackgroundColor(backGroundColor);
    }
}
