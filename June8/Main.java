abstract class Car{
    protected String color, model;
    Car(String color, String model){
        this.color=color;
        this.model=model;
    }
    public void carType(){
        System.out.println("It's a simple Car. Which color is "+ this.color + " Model is "+ this.model);
    };
    abstract public void Status();
}

abstract class Toyota extends Car{
    protected String madeIn, madeYear;



    Toyota(String madeIn, String madeYear, String color, String model){
        super(color,model);
        this.madeIn=madeIn;
        this.madeYear=madeYear;
    }

    @Override
    public void carType(){
        System.out.println("It's a Toyota Car. Which color is "+ super.color + " Model is "+ super.model
        +" Made in "+ this.madeIn+" Made year "+ this.madeYear);
    }

}

class ToyotaPremio extends Toyota{
    private String bodyType;

    ToyotaPremio(String color,String model, String madeIn, String madeYear, String bodyType){
        super(madeIn, madeYear, color,model );
        this.bodyType=bodyType;

    }
    @Override
    public void Status() {
        System.out.println("Status: Running");

    }

    @Override
    public void carType(){
        System.out.println("Color: "+ super.color + "\nModel : "+ super.model
                +"\nMade In: "+ super.madeIn+"\nMade year: "+ super.madeYear+"\nBody:"+ this.bodyType);
    }
}

public class Main {
    public static void main (String[] args){
    Toyota t = new ToyotaPremio("White","Premo Go X","Japan","2024","Sedan");
        System.out.println("Car Information: ");
    t.carType();
   t.Status();

    }
}
