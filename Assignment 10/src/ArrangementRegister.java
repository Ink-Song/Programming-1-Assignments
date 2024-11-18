import java.util.ArrayList;

public class ArrangementRegister {
    ArrayList<Arrangement> arrangements;
    public ArrangementRegister() {
        arrangements = new ArrayList<>();
    }
    public void addArrangement(Arrangement arrangement) {
        arrangements.add(arrangement);
    }

    public void findArrangementsByLocation(String location) {
        for (Arrangement arrangement : arrangements) {
            if (arrangement.getLocation().equals(location)) {
                System.out.println(arrangement);
            }
        }
    }

    public void findArrangementsByDate(String date){
        ArrayList<Arrangement> foundArrangements = new ArrayList<>();
        int checkDate = Integer.parseInt(date);
        for (Arrangement arrangement : arrangements) {
            if(arrangement.getDateWithoutTime() == checkDate){
                foundArrangements.add(arrangement);
            }
        }
        if(!foundArrangements.isEmpty()){
            for (Arrangement arrangement : foundArrangements) {
                System.out.println(arrangement);
            }
        }
        else{
            System.out.println("No arrangements found");
        }

    }
    public void findArrangementsByDate(int firstDate, int lastDate) {
        ArrayList<Arrangement> foundArrangements = new ArrayList<>();
        for (Arrangement arrangement : arrangements) {
            if(arrangement.getDateWithoutTime() > firstDate && arrangement.getDateWithoutTime() < lastDate) {
                foundArrangements.add(arrangement);
            }
        }
        foundArrangements.sort((a,b) -> Long.compare(a.getTimestamp(), b.getTimestamp()));
        System.out.println("Here are a list of arrangements on that day: ");
        for (Arrangement arrangement : foundArrangements) {
            System.out.println(arrangement);
        }
    }

    public void sortListByLocation() {

    }

    public void sortListByDate() {

    }

    public void sortListByEventType(){

    }

}
