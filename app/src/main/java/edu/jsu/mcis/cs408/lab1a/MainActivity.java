package edu.jsu.mcis.cs408.lab1a;

import android.os.Bundle;
import android.util.Log;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import java.sql.Wrapper;
import java.util.Random;

import edu.jsu.mcis.cs408.lab1a.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private Weapon humanWeapon, computerWeapon;
    private int humanWins = 0, computerWins = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.banner.setText("Welcome to Rock-Paper-Scissors!\nPlease choose your Weapon!");
    }
    public void GenerateComputerChoice(){

        Random random = new Random();
        int randomNumber;
        randomNumber = random.nextInt(3);
        switch(randomNumber){
            case 0:
                computerWeapon = Weapon.ROCK;
                break;
            case 1:
                computerWeapon = Weapon.PAPER;
                break;
            case 2:
                computerWeapon = Weapon.SCISSORS;
                break;
        }
        binding.computerChoice.setText(getString(R.string.computer_chose, computerWeapon.getDescription()));

    }
    private boolean CheckIfPlayerWins() {
        return (humanWeapon.equals(Weapon.ROCK) && computerWeapon.equals(Weapon.SCISSORS))
                || (humanWeapon.equals(Weapon.PAPER) && computerWeapon.equals(Weapon.ROCK))
                ||  (humanWeapon.equals(Weapon.SCISSORS) && computerWeapon.equals(Weapon.PAPER));
    }
    public void DetermineWinner(){
        if(humanWeapon.equals(computerWeapon)){
            binding.winner.setText(R.string.it_was_a_tie);
        }
        else if(CheckIfPlayerWins()){

            switch(humanWeapon.ordinal()){
                case 0:
                    binding.winner.setText(getString(R.string.player_wins_rock,humanWeapon.getDescription(), computerWeapon.getDescription()));
                    break;
                case 1:
                    binding.winner.setText(getString(R.string.player_wins_paper, humanWeapon.getDescription(), computerWeapon.getDescription()));
                    break;
                case 2:
                    binding.winner.setText(getString(R.string.player_wins_scissors, humanWeapon.getDescription(), computerWeapon.getDescription()));
                    break;

            }
            humanWins++;
        }
        else{

            switch(computerWeapon.ordinal()){
                case 0:
                    binding.winner.setText(getString(R.string.player_loses_rock, computerWeapon.getDescription(), humanWeapon.getDescription()));
                    break;
                case 1:
                    binding.winner.setText(getString(R.string.player_loses_paper, computerWeapon.getDescription(), humanWeapon.getDescription()));
                    break;
                case 2:
                    binding.winner.setText(getString(R.string.player_loses_scissors, computerWeapon.getDescription(), humanWeapon.getDescription()));
                    break;

            }
            computerWins++;
        }
        binding.totalwins.setText(getString(R.string.totalwins, humanWins, computerWins));

    }
    public void onClickRock(View v){
        GenerateComputerChoice();
        binding.playerChoice.setText(R.string.you_chose_rock);
        humanWeapon = Weapon.ROCK;
        DetermineWinner();
    }
    public void onClickPaper(View v){
        GenerateComputerChoice();
        binding.playerChoice.setText(R.string.you_chose_paper);
        humanWeapon = Weapon.PAPER;
        DetermineWinner();
    }
    public void onClickScissors(View v){
        GenerateComputerChoice();
        binding.playerChoice.setText(R.string.you_chose_scissors);
        humanWeapon = Weapon.SCISSORS;
        DetermineWinner();
    }
    public void onStart(){
        super.onStart();
        Log.i("MainActivity", "onStart() invoked ");
    }
    public void onStop(){
        super.onStop();
        Log.i("MainActivity", "onStop() invoked");
    }
}