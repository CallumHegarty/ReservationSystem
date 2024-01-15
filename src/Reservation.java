public class Reservation {

    private String name;
    private int size;
    private double timePlaced;
    private double timeFor;

    String[] nameArray = new String[]{"Callum","Max","Abhi","Darren","Lucas","Julie","Susie","Gus","Seyla","Elijah","Ms. K","Mr. Hussein","Ms. Lockwood","Mr. Hales","Mx. Bradford"};
    private int nameNum;

    public Reservation(){
        nameNum = (int)(Math.random()*11);
        name = nameArray[nameNum];
        size = (int)(Math.random()*10+1);
        timeFor = (Math.random()*5+16);
        timePlaced = (Math.random()*24+1);
    }

    public String getName(){
        return name;
    }
    public int getSize(){
        return size;
    }
    public double getTimePlaced(){
        return timePlaced;
    }
    public double getTimeFor(){
        return timeFor;
    }
}