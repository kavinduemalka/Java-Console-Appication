public class Student {
    String id;
    String name;
    double PFmarks;
    double DBmarks; 
    double Total;

    
    Student(String id, String name, double PFmarks, double DBmarks ){
        this.id = id;
        this.name = name;
        this.PFmarks = PFmarks;
        this.DBmarks = DBmarks;
        this.Total = PFmarks + DBmarks;
    }
      
}
