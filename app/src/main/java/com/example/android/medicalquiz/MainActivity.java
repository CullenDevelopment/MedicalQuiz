package com.example.android.medicalquiz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /**
     *
     *@param  Score counter as a global variable
     */
    int score = 0;
    /**
     *
     * @param Checkbox counter as a global variable
     */

    int numberCheckedCheckbox = 0;

    public static final String SCORE = "SCORE_KEY";
    /**
     * @param Declaration of variables
     *
     */
    RadioGroup BonesGroup;
    RadioGroup SpineGroup;
    RadioGroup BreathingGroup;
    RadioGroup HeartGroup;
    EditText enterAnswer;
    RadioButton Femur;
    RadioButton Ulna;
    RadioButton Tibia;
    RadioButton Humorous;
    RadioButton Scapula;
    CheckBox Metatarsus;
    CheckBox Metacarpus;
    CheckBox Calyx;
    CheckBox Hallux;
    CheckBox Scaphoid;
    RadioButton Skull;
    RadioButton Neck;
    RadioButton UpperBack;
    RadioButton LowerBack;
    RadioButton Tachycardia;
    RadioButton Tachyphasia;
    RadioButton Tachyphrenia;
    RadioButton Tachypnoea;
    RadioButton macula;
    RadioButton caecum;
    RadioButton SinoatrialNode;
    RadioButton IsletsOfLangerhans;
    RadioButton SphincterOfOddi;


    /**
     *
     *When app assembled
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /**
         *
         * @param Assigns RadioButtons CheckBoxes and EditTexts to corresponding variables
         */
        BonesGroup = findViewById(R.id.bones_group);
        SpineGroup = findViewById(R.id.spine_group);
        BreathingGroup = findViewById(R.id.breathing_group);
        HeartGroup = findViewById(R.id.heart_group);
        enterAnswer = findViewById(R.id.eye_answer);
        Femur = findViewById(R.id.femur);
        Ulna = findViewById(R.id.ulna);
        Tibia = findViewById(R.id.tibia);
        Humorous = findViewById(R.id.humorous);
        Scapula = findViewById(R.id.scapula);
        Metatarsus = findViewById(R.id.metatarsus);
        Metacarpus = findViewById(R.id.metacarpus);
        Calyx = findViewById(R.id.calyx);
        Hallux = findViewById(R.id.hallux);
        Scaphoid = findViewById(R.id.scaphoid);
        Skull = findViewById(R.id.skull);
        Neck = findViewById(R.id.neck);
        UpperBack = findViewById(R.id.upper_back);
        LowerBack = findViewById(R.id.lower_back);
        Tachycardia = findViewById(R.id.tachycardia);
        Tachyphasia = findViewById(R.id.tachyphasia);
        Tachyphrenia = findViewById(R.id.tachyphrenia);
        Tachypnoea = findViewById(R.id.tachypnoea);
        caecum = findViewById(R.id.caecum);
        macula = findViewById(R.id.macula);
        SinoatrialNode = findViewById(R.id.Sinoatrial_node);
        SphincterOfOddi = findViewById(R.id.Sphincter_of_oddi);
        IsletsOfLangerhans = findViewById(R.id.Islets_of_langerhans);
    }

    /**
     *keeping score and other info when state changes
     */




    @Override
    public void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        outState.putInt(SCORE, score);
    }

    /**
     * Saves scores if screen rewritten
     *
     */
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);

        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.

        score = savedInstanceState.getInt(SCORE);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View view = getCurrentFocus();
        if (view != null && (ev.getAction() == MotionEvent.ACTION_UP || ev.getAction() == MotionEvent.ACTION_MOVE) && view instanceof EditText && !view.getClass().getName().startsWith("android.webkit.")) {
            int scrcoords[] = new int[2];
            view.getLocationOnScreen(scrcoords);
            float x = ev.getRawX() + view.getLeft() - scrcoords[0];
            float y = ev.getRawY() + view.getTop() - scrcoords[1];
            if (x < view.getLeft() || x > view.getRight() || y < view.getTop() || y > view.getBottom())
                ((InputMethodManager)this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow((this.getWindow().getDecorView().getApplicationWindowToken()), 0);
        }
        return super.dispatchTouchEvent(ev);
    }


    /**
     * Checks which Bones Group Radio button is clicked
     */

    public void bonesGroupClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.femur:
                if (checked)
                    // if femur is checked
                    break;
            case R.id.ulna:
                if (checked)
                    // if Ulna is checked
                    break;

            case R.id.tibia:
                if (checked)
                    //if Tibia is checked
                    break;
            case R.id.humorous:
                if (checked)
                    //if humorous is checked
                    break;
            case R.id.scapula:
                if (checked)
                    //if scapula is checked
                    break;
        }
    }

    /**
     * Metatarsus checkbox click handler
     */

    public void metatarsusClick(View view) {
        //Checks if checkbox has been been clicked

        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        if (checked && (numberCheckedCheckbox >= 2))
            Metatarsus.setChecked(false);


        else
            // the checkbox either got unchecked
            // or there are less than 2 other checkboxes checked
            // change your counter accordingly
            if (checked)
                numberCheckedCheckbox++;
        // Metatarsus clicked

            else if (!checked)
                numberCheckedCheckbox--;
        //needs to be in as doesn't allow changing selection otherwise.


        //Show pop-up message if number of checkboxes checked exceeds two
        if (numberCheckedCheckbox >= 2) {
            Toast.makeText(this, "You can check two boxes at most", Toast.LENGTH_SHORT).show();

        }

    }
    //Metacarpus checkbox click handler
    public void metacarpusClick(View view) {
        //Checks if checkbox has been been clicked

        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        if (checked && (numberCheckedCheckbox >= 2))
            Metacarpus.setChecked(false);


        else
            // the checkbox either got unchecked
            // or there are less than 2 other checkboxes checked
            // change your counter accordingly
            if (checked)
                numberCheckedCheckbox++;
            // Metacarpus clicked

            else if (!checked)
                numberCheckedCheckbox--;
        //needs to be in as doesn't allow changing selection otherwise.


        //Show pop-up message if number of checkboxes checked exceeds two
        if (numberCheckedCheckbox >= 2) {
            Toast.makeText(this, "You can check two boxes at most", Toast.LENGTH_SHORT).show();

        }

    }
    //Calyx checkbox click handler
    public void calyxClick(View view) {
        //Checks if checkbox has been been clicked

        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        if (checked && (numberCheckedCheckbox >= 2))
            Calyx.setChecked(false);


        else
            // the checkbox either got unchecked
            // or there are less than 2 other checkboxes checked
            // change your counter accordingly
            if (checked)
                numberCheckedCheckbox++;
        // Calyx clicked


            else if (!checked)
                numberCheckedCheckbox--;
            //needs to be in as doesn't allow changing selection otherwise.


        //Show pop-up message if number of checkboxes checked exceeds two
        if (numberCheckedCheckbox >= 2) {
            Toast.makeText(this, "You can check two boxes at most", Toast.LENGTH_SHORT).show();

        }

    }
    //Hallux checkbox click handler
    public void halluxClick(View view) {
        //Checks if checkbox has been been clicked

        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        if (checked && (numberCheckedCheckbox >= 2))
            Hallux.setChecked(false);


        else
            // the checkbox either got unchecked
            // or there are less than 2 other checkboxes checked
            // change your counter accordingly
            if (checked)
                numberCheckedCheckbox++;
        // Hallux clicked

            else if (!checked)
                numberCheckedCheckbox--;
        //needs to be in as doesn't allow changing selection otherwise.


        //Show pop-up message if number of checkboxes checked exceeds two
        if (numberCheckedCheckbox >= 2) {
            Toast.makeText(this, "You can check two boxes at most", Toast.LENGTH_SHORT).show();

        }

    }
    //Scaphoid checkbox click handler
    public void scaphoidClick(View view) {
        //Checks if checkbox has been been clicked

        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        if (checked && (numberCheckedCheckbox >= 2))
            Scaphoid.setChecked(false);


        else
            // the checkbox either got unchecked
            // or there are less than 2 other checkboxes checked
            // change your counter accordingly
            if (checked)
                numberCheckedCheckbox++;
        // Scaphoid clicked

            else if (!checked)
                numberCheckedCheckbox--;
        //needs to be in as doesn't allow changing selection otherwise.


        //Show pop-up message if number of checkboxes checked exceeds two
        if (numberCheckedCheckbox >= 2) {
            Toast.makeText(this, "You can check two boxes at most", Toast.LENGTH_SHORT).show();

        }

    }

    /**
     * Checks which Spine Group Radio button is clicked
     */

    public void spineGroupClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.skull:
                if (checked)
                    // skull is checked
                    break;
            case R.id.neck:
                if (checked)
                    // neck is checked
                    break;
            case R.id.lower_back:
                if (checked)
                    //lower back is checked
                    break;
            case R.id.upper_back:
                if (checked)
                    //upper back is checked
                    break;

        }
    }

    // Checks which Fast (Tachy) Group Radio button is clicked
    public void fastGroupClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.tachycardia:
                if (checked)
                    // if tachycardia is checked
                    break;
            case R.id.tachyphasia:
                if (checked)
                    //if tachyphasia is checked
                    break;
            case R.id.tachyphrenia:
                if (checked)
                    //if tachyphrenia is checked
                    break;
            case R.id.tachypnoea:
                if (checked)
                    //if tachypnoea is checked
                    break;

        }
    }

    // Checks which Heart Group Radio button is clicked
    public void heartGroupClicked(View view) {
        // Is the view now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which Radio Button was clicked
        switch (view.getId()) {
            case R.id.Islets_of_langerhans:
                if (checked)
                    // if Islets of Langerhans clicked
                    break;
            case R.id.Sphincter_of_oddi:
                if (checked)
                    // if Sphincter of Oddi checked
                    break;

            case R.id.Sinoatrial_node:
                if (checked)
                    // if Sinoatrial node checked
                    break;

            case R.id.caecum:
                if (checked)
                    // if caecum checked
                    break;

            case R.id.macula:
                if (checked)
                    // if macula checked
                    break;
        }
    }


    //Checks correct answers and adds scores
    public void submitAnswers(View view) {
        if (Ulna.isChecked()) {
            score += 2;
            //adds two points for a correct answer
        }

        if (Metacarpus.isChecked()) {
            score += 2;
            //adds two points for a correct answer
        }

        if (Scaphoid.isChecked()) {
            score += 2;
            //adds two points for a correct answer
        }

        if (Neck.isChecked()) {
            score += 2;
            //adds two points for a correct answer
        }

        if (Tachypnoea.isChecked()) {
            score += 2;
            //adds two points for a correct answer
        }


        if (SinoatrialNode.isChecked()) {
            score += 2;
            //adds two points for a correct answer
        }
        //gets you the contents of edit text
        EditText enterAnswer = findViewById(R.id.eye_answer);
        String inputAnswer = enterAnswer.getText().toString();
        //Checks to see if EditText answer was correct
        if (inputAnswer.equals("Iris")) {
            score += 2;
            //adds two points for a correct answer
        }


        /**
         * Pops up score as toast message out of fourteen - 2 points for each correct answer.
         */
        if (score == 14) {
            Toast.makeText(this, "Congratulations you have scored a maximum fourteen points!", Toast.LENGTH_LONG).show();
            score = 0;//Zeros score so that extra presses of the submit answers button doesn't multiply score.

        }
        /**
         *  Pops up score if less than fourteen
         */
        else {
            Toast.makeText(this, "You have scored " + score + " points!", Toast.LENGTH_LONG).show();
            score = 0;//Zeros score so that extra presses of the submit answers button doesn't multiply score if score less than maximum.
        }
    }

    //Resets all Check boxes, Radio Buttons and Text input answers and resets integer variables.
    public void reset_quiz(View view) {
        score = 0;
        //zeros score
        numberCheckedCheckbox = 0;
        //zeros number of check boxes clicked variable.

        //clears radiobuttons
        BonesGroup.clearCheck();
        SpineGroup.clearCheck();
        BreathingGroup.clearCheck();
        HeartGroup.clearCheck();


        //clears checkboxes
        if (Metatarsus.isChecked()) {
            Metatarsus.setChecked(false);
        }

        if (Metacarpus.isChecked()) {
            Metacarpus.setChecked(false);
        }

        if (Calyx.isChecked()) {
            Calyx.setChecked(false);
        }

        if (Hallux.isChecked()) {
            Hallux.setChecked(false);
        }

        if (Scaphoid.isChecked()) {
            Scaphoid.setChecked(false);
        }
        //clears edit text field
        enterAnswer.setText("");


    }


}



