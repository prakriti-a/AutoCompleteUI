package com.prakriti.autocompleteui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ArrayAdapter<String> breed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AutoCompleteTextView autoAnimal = findViewById(R.id.autoAnimal);
        MultiAutoCompleteTextView multiAutoBreed = findViewById(R.id.multiAutoBreed);
        Button btnBuy = findViewById(R.id.btnBuy);
        Button btnGetBreeds = findViewById(R.id.btnGetBreeds);

        String[] animals = new String[] {"Dog", "Cat", "Rabbit", "Bird", "Fish"};
        ArrayAdapter<String> animalAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, animals);
        autoAnimal.setAdapter(animalAdapter);

        String[] dogBreeds = new String[] { "Alaskan Husky", "American Bulldog", "Beagle", "Border Collie", "Dalmation", "German Shepherd", "Golden Retriever", "Pomeranian", "Poodle", "Pug", "Samoyed", "Shiba Inu"};
        String[] catBreeds = new String[] { "Bambino", "American Bobtail", "European Shorthair", "Maine Coon", "Persian", "Scottish Fold", "Siberian Cat"};
        String[] rabbitBreeds = new String[] { "American Fuzzy Lop", "Cashmere Lop", "Chinchilla", "Himalayan", "Holland Lop", "Jersey Wooly", "Lionhead", "Mini Lop", "Polish", "Teddy Dwarf"};
        String[] birdBreeds = new String[] { "Amazon Parrot", "Blue and Gold Macaw", "Canary", "Cockatiel", "Dove", "Eclectus", "Lovebird", "Owl Finch", "Song Canary"};
        String[] fishBreeds = new String[] { "Betta", "Goldfish", "Angelfish", "Catfish", "Mollies", "Neon Tetras", "Swordtails", "Zebra Danios"};

        btnGetBreeds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedAnimal = autoAnimal.getText().toString().trim();
                switch (selectedAnimal) {
                    case "Dog":
                        breed = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, dogBreeds);
                        break;
                    case "Cat":
                        breed = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, catBreeds);
                        break;
                    case "Rabbit":
                        breed = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, rabbitBreeds);
                        break;
                    case "Bird":
                        breed = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, birdBreeds);
                        break;
                    case "Fish":
                        breed = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, fishBreeds);
                        break;
                }
                multiAutoBreed.setAdapter(breed);
                multiAutoBreed.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
            }
        });

        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Viewing Appointment is booked!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}