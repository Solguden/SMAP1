package Solguden.assignmentone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private static final int REQUEST_WORD_DETAILS = 101;
    private static final int REQUEST_WORD_EDIT = 102;

    private ArrayList<Animal> animalList;
    private int currentPosition;
    private   AnimalListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView list = (ListView) findViewById(R.id.listView);


        //region Seeding
        Animal lion = new Animal("Lion","ˈlīən",
                "a large tawny-coloured cat that lives in prides, found in Africa and NW India. The male has a flowing shaggy mane and takes little part in hunting, which is done cooperatively by the females.",
                "",5.0,R.drawable.lion,1);
        Animal leopard = new Animal("Leopard","ˈlepərd\n",
                "a large solitary cat that has a fawn or brown coat with black spots, native to the forests of Africa and southern Asia.\n",
                "",5.0,R.drawable.leopard,2);
        Animal cheetah = new Animal("Cheetah","ˈCHēdə\n",
                "a large slender spotted cat found in Africa and parts of Asia. It is the fastest animal on land.\n",
                "",5.0,R.drawable.cheetah,3);
        Animal elephant = new Animal("Elephant","ˈeləfənt\n",
                "a very large plant-eating mammal with a prehensile trunk, long curved ivory tusks, and large ears, native to Africa and southern Asia. It is the largest living land animal.\n",
                "",5.0,R.drawable.elephant,4);
        Animal giraffe = new Animal("Giraffe","jəˈraf\n",
                "a large African mammal with a very long neck and forelegs, having a coat patterned with brown patches separated by lighter lines. It is the tallest living animal.\n",
                "",5.0,R.drawable.giraffe,5);
        Animal kudo = new Animal("Kudo","ˈko͞odo͞o\n",
                "an African antelope that has a greyish or brownish coat with white vertical stripes, and a short bushy tail. The male has long spirally curved horns.\n",
                "",5.0,R.drawable.kudo,6);
        Animal gnu = new Animal("Gnu","n(y)o͞o\n",
                "a large dark antelope with a long head, a beard and mane, and a sloping back.\n",
                "",5.0,R.drawable.gnu,7);

        Animal oryx = new Animal("Oryx","null\n",
                "a large antelope living in arid regions of Africa and Arabia, having dark markings on the face and long horns.\n",
                "",5.0,R.drawable.oryx,8);

        Animal camel = new Animal("Camel","ˈkaməl\n",
                "a large, long-necked ungulate mammal of arid country, with long slender legs, broad cushioned feet, and either one or two humps on the back. Camels can survive for long periods without food or drink, chiefly by using up the fat reserves in their humps.\n",
                "",5.0,R.drawable.camel,9);

        Animal shark = new Animal("Shark","SHärk\n",
                "a long-bodied chiefly marine fish with a cartilaginous skeleton, a prominent dorsal fin, and tooth-like scales. Most sharks are predatory, though the largest kinds feed on plankton, and some can grow to a large size.\n",
                "",5.0,R.drawable.shark,10);

        Animal crocodile = new Animal("Crocodile","ˈkräkəˌdīl\n",
                "a large predatory semiaquatic reptile with long jaws, long tail, short legs, and a horny textured skin.\n",
                "",5.0,R.drawable.crocodile,11);

        Animal snake = new Animal("Snake","snāk\n",
                "a long limbless reptile which has no eyelids, a short tail, and jaws that are capable of considerable extension. Some snakes have a venomous bite.\n",
                "",5.0,R.drawable.snake,12);

        Animal buffalo = new Animal("Buffalo","ˈbəf(ə)ˌlō\n",
                "a heavily built wild ox with backward-curving horns, found mainly in the Old World tropics:\n",
                "",5.0,R.drawable.buffalo,13);

        Animal ostrich = new Animal("Ostrich","ˈbəf(ə)ˌlō\n",
                "a heavily built wild ox with backward-curving horns, found mainly in the Old World tropics:\n",
                "",5.0,R.drawable.ostrich,14);
        //endregion
        animalList = new ArrayList<>();

        //Adding the animals to an  arraylist

        animalList.add(lion);
        animalList.add(leopard);
        animalList.add(cheetah);
        animalList.add(elephant);
        animalList.add(giraffe);
        animalList.add(kudo);
        animalList.add(gnu);
        animalList.add(oryx);
        animalList.add(camel);
        animalList.add(shark);
        animalList.add(crocodile);
        animalList.add(snake);
        animalList.add(buffalo);
        animalList.add(ostrich);

        adapter = new AnimalListAdapter(this, R.layout.adapter_view_layout,animalList);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
                Animal thisAnimal = animalList.get(position);
                intent.putExtra("thisImage", thisAnimal.getImage());
                intent.putExtra("thisName", thisAnimal.getName());
                intent.putExtra("thisPronounce", thisAnimal.getPronounced());
                intent.putExtra("thisScore", thisAnimal.getScore());
                intent.putExtra("thisDescription", thisAnimal.getDescription());
                intent.putExtra("thisNote", thisAnimal.getNote());
                currentPosition = position;
                startActivityForResult(intent,REQUEST_WORD_DETAILS);
            }
        });


    }

    @Override
    protected void onActivityResult(int req, int res, Intent data)
    {
        super.onActivityResult(req,res,data);

           if (res == REQUEST_WORD_EDIT)
           {
               animalList.get(currentPosition).setScore(data.getDoubleExtra("finalScore",3));
               animalList.get(currentPosition).setNote(data.getStringExtra("finalNote"));
               adapter.notifyDataSetChanged();
           }

    }
}
