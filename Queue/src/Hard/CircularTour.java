package Hard;

/*
 * Suppose there is a circle. There are n petrol pumps on that circle. You are given two sets of
 * data. The amount of petrol that every petrol pump has. Distance from that petrol pump to the next
 * petrol pump. Calculate the first point from where a truck will be able to complete the circle
 * (The truck will stop at each petrol pump and it has infinite capacity) Assume for 1-litre petrol,
 * the truck can go 1 unit of distance.
 * 
 * For example, let there be 4 petrol pumps with amount of petrol and distance to next petrol pump
 * value pairs as {4, 6}, {6, 5}, {7, 3} and {4, 5}. The first point from where the truck can make a
 * circular tour is 2nd petrol pump. Output should be “start = 1”
 */
public class CircularTour {

  public static void main(String[] args) {

    PetrolPump[] arr = {new PetrolPump(6, 4), 
        new PetrolPump(3, 6), 
        new PetrolPump(7, 3)};

    int start = printTour(arr, arr.length);

    System.out.println(start == -1 ? "No Solution" : "Start = " + start);
  }

  static int printTour(PetrolPump arr[], int n) {

    int start = 0, end = 1;
    int curr_petrol = arr[start].petrol - arr[start].distance;

    while (start != end || curr_petrol < 0) {
      while (curr_petrol < 0 && start != end) {
        curr_petrol -= arr[start].petrol - arr[start].distance;
        start = (start + 1) % n;

        // No such tour exists as index 0 is considered again
        if (start == 0) {
          return -1;
        }
      }
      curr_petrol += arr[end].petrol - arr[end].distance;
      end = (end + 1) % n;
    }

    return start;

  }

  static class PetrolPump {
    int petrol;
    int distance;

    public PetrolPump(int petrol, int distance) {
      this.petrol = petrol;
      this.distance = distance;
    }
  }
}
