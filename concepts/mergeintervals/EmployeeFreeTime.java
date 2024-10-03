package concepts.mergeintervals;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
    You’re given a list containing the schedules of multiple employees. Each person’s schedule is a list of non-overlapping 
    intervals in sorted order. An interval is specified with the start and end time, both being positive integers. 
    Your task is to find the list of finite intervals representing the free time for all the employees.

    Note: The common free intervals are calculated between the earliest start time and the latest end time of all meetings across all employees.

    Constraints:
        1) 1 ≤ schedule.length , schedule[i].length ≤ 50
        2) 0 ≤ interval.start < interval.end ≤ 10^8, where interval is any interval in the list of schedules.
 */
public class EmployeeFreeTime {
    /*
     * Time Complexity: O(mlogn), where n is the number of employees and m is the total number of intervals across all employees.
     * Space Complexity: O(n)
     */
    public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        // add the first interval of each employee to the heap
        for (int i = 0; i < schedule.size(); i++) {
            List<Interval> employeeSchedule = schedule.get(i);
            Interval interval = employeeSchedule.get(0);
            heap.offer(new int[]{interval.start, i, 0});
        }
        
        List<Interval> freeTime = new ArrayList<>();
        int previous = schedule.get(heap.peek()[1]).get(heap.peek()[2]).start;
        
        while (!heap.isEmpty()) {
            int[] tuple = heap.poll();
            int i = tuple[1];
            int j = tuple[2];
            
            Interval interval = schedule.get(i).get(j);
            
            if (interval.start > previous) {
                freeTime.add(new Interval(previous, interval.start));
            }
            
            previous = Math.max(previous, interval.end);
        
            if (j + 1 < schedule.get(i).size()) {
                Interval nextInterval = schedule.get(i).get(j + 1);
                heap.offer(new int[]{nextInterval.start, i, j + 1});
            }
        }
        return freeTime;
    }

    public static class Interval {
        int start;
        int end;
    
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        List<List<Interval>> schedule = new ArrayList<>();
        schedule.add(new ArrayList<Interval>(){{
            add(new Interval(1, 3));
            add(new Interval(5, 6));
            add(new Interval(7, 9));
        }});
        schedule.add(new ArrayList<Interval>(){{
            add(new Interval(2, 3));
            add(new Interval(9, 12));
        }});
        schedule.add(new ArrayList<Interval>(){{
            add(new Interval(6, 7));
        }});
        List<Interval> result = employeeFreeTime(schedule);
        for (Interval interval : result) {
            System.out.println(interval.start + " " + interval.end);
        }
    }
}
