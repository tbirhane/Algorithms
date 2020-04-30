import java.util.*;

public class KclosestPointsToVertex {
    static Point vert = new Point(0,0);
    public static void main(String[] args) {
        List<Point> list = Arrays.asList(new Point(-1,1), new Point(-2,-2),
                new Point(1,1), new Point(2,2), new Point(1,2), new Point(3,2));
        System.out.println(new KclosestPointsToVertex().kClosestPoints(list, new Point(0,0), 3));
          }

    public List<Point> kClosestPoints(List<Point> points, Point vertex, int k){

//       Comparator<Point> comparator = (p1, p2) -> { return (int) (p2.distance(vertex) - p1.distance(vertex));};
        PriorityQueue<Point> pointPriorityQueue = new PriorityQueue<>(k, (p1, p2) -> {return (int)(p2.distance(vertex) - p1.distance(vertex));});
      //  PriorityQueue<Point> pointPriorityQueue = new PriorityQueue<>(k, new PointComparator());
        for(Point point:points){
            pointPriorityQueue.add(point);
            if(pointPriorityQueue.size() > k){
                pointPriorityQueue.poll();
            }
        }
        List<Point> kpoints = new ArrayList<>();
        while ((!pointPriorityQueue.isEmpty())) {
            kpoints.add(pointPriorityQueue.poll());
        }
        Collections.reverse(kpoints);
        return kpoints;
    }
  static  class Point {
      double x;
      double y;

      Point(double x, double y) {
          this.x = x;
          this.y = y;
      }

      public double distance(Point vertex) {
          return Math.sqrt(Math.pow(Math.abs(vertex.x) - Math.abs(this.x), 2) + Math.pow(Math.abs(vertex.y) - Math.abs(this.y), 2));
      }

      public String toString() {
          return "(" + x + "," + y + ")";

      }
  }
  class PointComparator implements Comparator<Point>{
      @Override
      public int compare(Point p1, Point p2){
          double result = p2.distance(vert) - p2.distance(vert);
          if(result>0) return -1;
          if(result<0) return 1;
          return 0;
      }
        }
  }

