package nyc.c4q.ashiquechowdhury.animalapplication.model;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ashiquechowdhury on 12/21/16.
 */

public interface AnimalAPI {
    @GET("cgi-bin/12_21_2016_exam.pl")
    Call<AllAnimals> getAllAnimals();
}
