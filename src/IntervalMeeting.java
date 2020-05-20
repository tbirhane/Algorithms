import java.util.*;

public class IntervalMeeting {
    // Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
// determine if a person could attend all meetings.

// Input: [[0,30],[5,10],[15,20]]
// Output: false
// Input: [[7,10],[2,4]]
// Output: true
public static void main(String[] args) {

    List<Interval> interval1 = Arrays.asList(new Interval(0,10),
            new Interval(5,10),
            new Interval(15,20),
            new Interval(13, 30));
    List<Interval> interval2 = Arrays.asList(new Interval(7,10),
            new Interval(2,4));
    List<Interval> interval3 = Arrays.asList(new Interval(0,30),
            new Interval(5,10),
            new Interval(15,20));
    System.out.println(canAttendMetting(interval1));
    System.out.println(canAttendMetting(interval2));

    System.out.println(canAttendMeetingPQ(interval1));
    System.out.println(canAttendMeetingPQ(interval2));
    //Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...]
    // find the minimum number of conference rooms require
    System.out.println("Min. number of rooms: "+minimumNumberOfRooms(interval3));
}
//Minimum number of rooms for list of meeting intervals
    //Time: O(nlogn + nlogn) = O(nlogn)
    // nlogn for sorting the intervals using Collections.sort.

    // n for traversing through the list of intervals
// and logn for adding  and polling each interval to the priorityQueue which results nlogn
static int minimumNumberOfRooms(List<Interval> list){
    Comparator<Interval> startComparator = Comparator.comparing(Interval::getStart);
    Comparator<Interval> endComparator = Comparator.comparing(Interval::getEnd);
    Collections.sort(list,startComparator);
    PriorityQueue<Interval> priorityQueue = new PriorityQueue<>(endComparator);
    Iterator<Interval> iterator = list.iterator();
    Interval a = iterator.hasNext()?iterator.next():null;
    int rooms = 0;

    for(Interval i:list){
        priorityQueue.add(i);
        if(i.start < priorityQueue.peek().end){
            rooms++;
        } else{
            priorityQueue.poll();
        }
    }
        return rooms;
}
//Using Collections.sort
    // TIme Complexity: O(nlogn + n) = O(nlogn)
static boolean canAttendMetting(List<Interval> list){
   // Collections.sort(list, new IntervalComparator());
    Comparator<Interval> comparator = Comparator.comparing(Interval::getStart);
    Collections.sort(list, comparator);

    Iterator<Interval> iterator = list.iterator();
    Interval a = iterator.hasNext()?iterator.next():null;
    if(a != null){
        while (iterator.hasNext()){
            Interval b = iterator.next();
            if(b.start < a.end){
                return false;
            }
            a = b;
        }
    }
    return true;
}
//Using PriorityQueue
    //Time: O(nlogn + nlogn) = O(nlogn)
static boolean canAttendMeetingPQ(List<Interval> list){
 //   Comparator<Interval> comparator = Comparator.comparing(Interval::getStart).thenComparing(Interval::getEnd).reversed();
    Comparator<Interval> comparator = Comparator.comparing(Interval::getStart);
    PriorityQueue<Interval> priorityQueue = new PriorityQueue<>(comparator);
//    for (Interval i : list){
//        priorityQueue.add(i);
//    }
    priorityQueue.addAll(list);
    Interval e1 = !priorityQueue.isEmpty()?priorityQueue.poll():null;
    while (!priorityQueue.isEmpty()){
        Interval e2 = priorityQueue.poll();
        if(e2.start < e1.end){
            return false;
        }
        e1 = e2;
    }
    return true;
}
/*
static class Interval implements Comparable<Interval> {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }

    @Override
    public int compareTo(Interval a) {
        return this.start - a.start;
    }
    @Override
    public String toString(){
        return this.start + " "+this.end;
    }
}

 */
static class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
    @Override
    public String toString(){
        return this.start + " "+this.end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}

static class IntervalComparator implements Comparator<Interval>{

    @Override
    public  int compare(Interval a, Interval b){
        return a.start - b.start;
    }
}
}

