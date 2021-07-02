public class Application {

  public static void main(String[] args) {
    Data data = new Data(1);
    System.out.println("Printing Data: " + data);
    System.out.println("Some processing");
    System.out.println("Some more processing");
    System.out.println("Application Completed ");
  }
}


class Data {
  int id;

  Data(int id) {
    id = this.id;
  }
}

