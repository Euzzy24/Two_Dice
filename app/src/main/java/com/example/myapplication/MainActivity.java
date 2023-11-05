package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button roll;

    ImageView first_dice;

    ImageView second_dice;

    Random random = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first_dice = findViewById(R.id.first_dice);
        second_dice = findViewById(R.id.second_dice);
        roll = findViewById(R.id.roll);
        roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { roll_dice();

            }
        });

    }
    private void roll_dice() {
        int rand1 = random.nextInt(6) + 1; // Generate a random number for the first dice
        int rand2 = random.nextInt(6) + 1; // Generate a random number for the second dice

        // Create animations for each die
        Animation firstDiceAnim = AnimationUtils.loadAnimation(this, R.anim.rotate);
        Animation secondDiceAnim = AnimationUtils.loadAnimation(this, R.anim.rotate);

        // Apply the animations to each die
        first_dice.startAnimation(firstDiceAnim);
        second_dice.startAnimation(secondDiceAnim);

        // Generate a random tint color for each die
        int tint1 = getRandomTintColor();
        int tint2 = getRandomTintColor();

        // Set the tint color for each die
        setTint(first_dice, tint1);
        setTint(second_dice, tint2);

        // Set the appropriate images for each die based on the random numbers
        setDiceImage(first_dice, rand1);
        setDiceImage(second_dice, rand2);
    }

    private int getRandomTintColor() {
        // Define an array of possible tint colors
        int[] tintColors = {
                R.color.sky,
                R.color.red,
                R.color.violet,
                R.color.pinkish,
        };

        // Generate a random index to select a tint color from the array
        int randomIndex = random.nextInt(tintColors.length);

        // Get the selected tint color resource ID
        int selectedTintColor = tintColors[randomIndex];

        // Get the actual color value for the selected tint color
        return getResources().getColor(selectedTintColor);
    }

    private void setTint(ImageView imageView, int tintColor) {
        // Apply the tint color to the ImageView
        imageView.setColorFilter(tintColor);
    }

    private void setDiceImage(ImageView imageView, int number) {
        // Set the image resource for the ImageView based on the random number
        switch (number) {
            case 1:
                imageView.setImageResource(R.drawable.d1);
                break;
            case 2:
                imageView.setImageResource(R.drawable.d2);
                break;
            case 3:
                imageView.setImageResource(R.drawable.d3);
                break;
            case 4:
                imageView.setImageResource(R.drawable.d4);
                break;
            case 5:
                imageView.setImageResource(R.drawable.d5);
                break;
            case 6:
                imageView.setImageResource(R.drawable.d6);
                break;
        }
    }

}