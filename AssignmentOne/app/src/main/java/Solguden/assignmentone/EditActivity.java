package Solguden.assignmentone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.SeekBar;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {

    private TextView wordName;
    private TextView wordScore;
    private TextView wordNote;
    private Button cancelButton;
    private Button okButton;
    private SeekBar slider;

    private static final int REQUEST_RESULT = 103;

    private Animal animalDetail = new Animal();

    private int sliderProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        wordName = findViewById(R.id.editTextName);
        wordScore = findViewById(R.id.editTextScore);
        wordNote = findViewById(R.id.editNoteEdit);

        //Get intent data
        Intent detailsIntent = getIntent();

        //Setting intent data
        animalDetail.setName(detailsIntent.getStringExtra("thisNameEdit"));
        animalDetail.setScore(detailsIntent.getDoubleExtra("thisScoreEdit",0));
        animalDetail.setNote(detailsIntent.getStringExtra("thisNoteEdit"));

        //Setting widgets
        wordName.setText(animalDetail.getName());
        wordScore.setText("" +animalDetail.getScore());
        wordNote.setText(animalDetail.getNote());

        slider = findViewById(R.id.editSlider);
        slider.setProgress(sliderProgress);// change plzzzz
        slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sliderProgress = progress;
                slider.setProgress(sliderProgress);
                wordScore.setText(""+progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        cancelButton = findViewById(R.id.EditCancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancel();
            }
        });

        okButton = findViewById(R.id.EditOkButton);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ok();
            }
        });

    }

    private void cancel(){
        setResult(RESULT_CANCELED);
        finish();
    }

    private void ok(){
        animalDetail.setNote(wordNote.getText().toString());
        animalDetail.setScore(sliderProgress);

        Intent data = new Intent();
        data.putExtra("noteResult",animalDetail.getNote());
        data.putExtra("scoreResult",animalDetail.getScore());

        setResult(REQUEST_RESULT,data);
        finish();
    }
}
