package com.example.android.lithuanianquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Counts correct answers given by a player
    private int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Allow to click only one radio button in the third question
    public void questionThreeRadioButtons(View view){
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.question_3_radio_button_1:
                if (checked)
                    break;
            case R.id.question_3_radio_button_2:
                if (checked)
                    break;
            case R.id.question_3_radio_button_3:
                if (checked)
                    break;
            case R.id.question_3_radio_button_4:
                if (checked)
                    break;
        }
    }

    // Allow to click only one radio button in the fourth question
    public void questionFourRadioButtons(View view){
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.question_4_radio_button_1:
                if (checked)
                    // Incorrect answer
                    break;
            case R.id.question_4_radio_button_2:
                if (checked)
                    // Correct answer, add one point
                    break;
            case R.id.question_4_radio_button_3:
                if (checked)
                    // Incorrect answer
                    break;
            case R.id.question_4_radio_button_4:
                if (checked)
                    // Incorrect answer
                    break;
        }
    }

    // Check answers and add one point for each correct answer
    public void submitAnswers(View view) {

        // Question one
        // Get String given in the first EditText field and turn it into lower case
        EditText firstAnswerField = (EditText) findViewById(R.id.answer_one);
        Editable firstAnswerEditable = firstAnswerField.getText();
        String firstAnswer = firstAnswerEditable.toString().toLowerCase();

        // Check if the answer given in the first EditText field is correct and if it is, add one
        // point
        if (firstAnswer.contains("baltic")) {
            points++;
        }

        // Question two
        // Get String given in the second EditText field and turn it into lower case
        EditText secondAnswerField = (EditText) findViewById(R.id.answer_two);
        Editable secondAnswerEditable = secondAnswerField.getText();
        String secondAnswer = secondAnswerEditable.toString().toLowerCase();

        // Check if the answer given in the second EditText field is correct and if it is, add one
        // point
        if (secondAnswer.contains("basketball")) {
            points++;
        }

        // Question three
        // Check if the correct answer is given
        RadioButton thirdQuestionCorrectAnswer = (RadioButton)
                findViewById(R.id.question_3_radio_button_3);
        boolean isThirdQuestionCorrectAnswer = thirdQuestionCorrectAnswer.isChecked();
        // If the correct answer is given, add one point
        if (isThirdQuestionCorrectAnswer) {
            points++;
        }

        // Question four
        // Check if the correct answer is given
        RadioButton fourthQuestionCorrectAnswer = (RadioButton)
                findViewById(R.id.question_4_radio_button_2);
        boolean isFourthQuestionCorrectAnswer = fourthQuestionCorrectAnswer.isChecked();

        // If the correct answer is given, add one point
        if (isFourthQuestionCorrectAnswer) {
            points++;
        }

        // Question five
        // Find check boxes
        CheckBox fifthQuestionCheckBoxOne = (CheckBox) findViewById(R.id.question_5_check_box_1);

        CheckBox fifthQuestionCheckBoxTwo = (CheckBox) findViewById(R.id.question_5_check_box_2);

        CheckBox fifthQuestionCheckBoxThree = (CheckBox) findViewById(R.id.question_5_check_box_3);

        CheckBox fifthQuestionCheckBoxFour = (CheckBox) findViewById(R.id.question_5_check_box_4);

        // If correct answers are given, add one point,
        // if incorrect answers are given, do not add points

        if (fifthQuestionCheckBoxThree.isChecked() && fifthQuestionCheckBoxFour.isChecked()
                && !fifthQuestionCheckBoxOne.isChecked() && !fifthQuestionCheckBoxTwo.isChecked()){
            points++;
        }

        // Question six
        // Find check boxes
        CheckBox sixthQuestionCheckBoxOne = (CheckBox) findViewById(R.id.question_6_check_box_1);

        CheckBox sixthQuestionCheckBoxTwo = (CheckBox) findViewById(R.id.question_6_check_box_2);

        CheckBox sixthQuestionCheckBoxThree = (CheckBox) findViewById(R.id.question_6_check_box_3);

        CheckBox sixthQuestionCheckBoxFour = (CheckBox) findViewById(R.id.question_6_check_box_4);

        // If correct answers are given, add one point,
        // if incorrect answers are given, do not add points
        if (sixthQuestionCheckBoxOne.isChecked() && sixthQuestionCheckBoxTwo.isChecked()
                && sixthQuestionCheckBoxFour.isChecked() && !sixthQuestionCheckBoxThree.isChecked()){
            points++;
        }

        // If the user answers all questions correctly, show toast message with congratulations
        if (points == 6){
            Toast.makeText(this, "Congratulations! You have earned 6 points." +
                    "\n" + "It is the maximum number of points in this quiz.",
                    Toast.LENGTH_SHORT).show();
        }

        // If the user does not answer all questions correctly, show users's points, total points
        // possible and advise to check answers
        else {
            Toast.makeText(this, "Your points: " + points + "\n" + "Total points possible: 6" +
                    "\n" + "Check your answers or spelling again.", Toast.LENGTH_SHORT).show();
        }

        // Reset points to 0
        points = 0;
    }
}
