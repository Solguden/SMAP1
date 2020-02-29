package Solguden.assignmentone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailsActivity extends AppCompatActivity {

    private ImageView wordImage;
    private TextView wordName;
    private TextView wordPronounce;
    private TextView wordScore;
    private TextView wordDescription;
    private TextView wordNote;
    private Button cancelButton;
    private Button editBUtton;

    private static final int REQUEST_WORD_EDIT = 102;
    private static final int REQUEST_RESULT= 103;


    private Animal animalDetail = new Animal();

    private String editName;
    private String editNote;
    private double editScore;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //Get widgets
        wordImage = findViewById(R.id.detailsImageView);
        wordName = findViewById(R.id.detailsTextName);
        wordPronounce = findViewById(R.id.detailsTextPronounce);
        wordScore = findViewById(R.id.detailsTextScore);
        wordDescription = findViewById(R.id.detailsDescri);
        wordNote = findViewById(R.id.detailsNoteEdit);

        cancelButton = findViewById(R.id.detailsCancelButton);
        editBUtton = findViewById(R.id.detailsEditButton);

        //Get intent data
            Intent detailsIntent = getIntent();

            //Setting intent data
            animalDetail.setImage(detailsIntent.getIntExtra("thisImage",0));
            animalDetail.setName(detailsIntent.getStringExtra("thisName"));
            animalDetail.setPronounced(detailsIntent.getStringExtra("thisPronounce"));
            animalDetail.setScore(detailsIntent.getDoubleExtra("thisScore",0));
            animalDetail.setDescription(detailsIntent.getStringExtra("thisDescription"));
            animalDetail.setNote(detailsIntent.getStringExtra("thisNote"));

            editName = detailsIntent.getStringExtra("thisName");


            //Setting widgets
            wordImage.setImageResource(animalDetail.getImage());
            wordName.setText(animalDetail.getName());
            wordPronounce.setText(animalDetail.getPronounced());
            wordScore.setText("" +animalDetail.getScore());
            wordDescription.setText(animalDetail.getDescription());
            wordNote.setText(animalDetail.getNote());

            cancelButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    cancel();
                }
            });

            editBUtton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    edit();
                }
            });

    }

    private void cancel(){
        setResult(RESULT_CANCELED);
        finish();
    }

    private void edit(){
        Intent editData = new Intent(DetailsActivity.this,EditActivity.class);
        editData.putExtra("thisNameEdit", editName);
        editData.putExtra("thisScoreEdit", animalDetail.getScore());
        editData.putExtra("thisNoteEdit", animalDetail.getNote());
        startActivityForResult(editData,REQUEST_WORD_EDIT);
    }

    @Override
    protected void onActivityResult(int req, int res, Intent data)
    {
        super.onActivityResult(req,res,data);

        if (res == REQUEST_RESULT)
        {
            String noteResult = data.getStringExtra("noteResult");
            animalDetail.setNote(noteResult);
            double scoreResult = data.getDoubleExtra("scoreResult",4);
            animalDetail.setScore(scoreResult);

            Intent resultIntent = new Intent();
            resultIntent.putExtra("finalNote",animalDetail.getNote());
            resultIntent.putExtra("finalScore",animalDetail.getScore());
            setResult(REQUEST_WORD_EDIT,resultIntent);
            finish();
        }

    }
}
