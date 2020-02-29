package Solguden.assignmentone;

public class Animal {
    private String Name;
    private String Pronounced;
    private String Description;
    private String Note;
    private double Score;
    private int Image;
    private int Id;
    private String IntentAction;

    public Animal()
    {
        Name = "Name";
        Pronounced = "Pronunciation";
        Description = "Description";
        Note = "Note";
        Score = 5.0;
        Image = R.drawable.mrpbh; //Cuz why not? :)
        Id = -1;
    }

    public Animal(String name, String pronounced, String description,
                  String note, double score, int image, int id/*, String intentAction*/) {
        Name = name;
        Pronounced = pronounced;
        Description = description;
        Note = note;
        Score = score;
        Image = image;
        Id = id;
        /*IntentAction = intentAction;*/
    }

    public String getIntentAction() {
        return IntentAction;
    }

    public void setIntentAction(String intentAction) {
        IntentAction = intentAction;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPronounced() {
        return Pronounced;
    }

    public void setPronounced(String pronounced) {
        Pronounced = pronounced;
    }

    public double getScore() {
        return Score;
    }

    public void setScore(double score) {
        Score = score;
    }

    public Integer getImage() {
        return Image;
    }

    public void setImage(Integer image) {
        Image = image;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
