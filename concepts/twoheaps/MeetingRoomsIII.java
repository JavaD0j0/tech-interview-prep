package concepts.twoheaps;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
    You have an integer rooms, representing room numbers from 0 to rooms−1. Additionally, you are given an 2D integer 
    array called meetings, where each element meetings[i] = [start[i], end[i]] indicates that a meeting will be 
    held in the half-closed interval [start[i], end[i]). Each startistarti​​ is unique.

    Meetings are allocated to rooms in the following manner:
        - Each meeting will take place in the unused room with the lowest number.
        - If there are no available rooms, the meeting will be delayed until a room becomes free, maintaining the same duration as the original meeting.
        - When a room is vacated, the meeting with the earliest original start time is given priority for that room.

    Your task is to determine the room number that hosted the highest number of meetings. If there are multiple rooms, return the room with the lowest number.

    Note: A half-closed interval [a, b) is the interval between a and b including a and not including b.

    Constraints:
        1) 1 ≤ rooms ≤ 100
        2) 1 ≤ meetings.length ≤ 1000
        3) meetings[i].length == 2
        4) 0 ≤ start[i] < end[i] ≤ 10000
 */
public class MeetingRoomsIII {
    /*
     * Time Complexity: O(mlogm + mlogn), where n is the number of meetings and m is the number of rooms.
     * Space Complexity: O(n)
     */
    public static int mostBooked(int[][] meetings, int rooms) {

        int[] count = new int[rooms]; // count of meetings in each room

        PriorityQueue<Integer> available = new PriorityQueue<>();  
        PriorityQueue<long[]> usedRooms = new PriorityQueue<>((a, b) -> a[0] != b[0] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1]));  

        // intilize the available rooms heap
        for (int i = 0; i < rooms; i++) {
            available.offer(i);
        }

        // Sort the meetings by start time
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        for (int[] meeting : meetings) {
            long startTime = meeting[0];
            long endTime = meeting[1];

            // Free up the rooms that have ended by the current start time
            while (!usedRooms.isEmpty() && usedRooms.peek()[0] <= startTime) {
                int room = (int) usedRooms.poll()[1];
                available.offer(room);
            }

            // If no rooms are available, delay the meeting until a room becomes free
            if (available.isEmpty()) {
                long end = usedRooms.peek()[0];
                int room = (int) usedRooms.poll()[1];
                endTime = end + (endTime - startTime);
                available.offer(room);
            }

            // Allocate the meeting to the available room with the lowest number
            int room = available.poll();
            usedRooms.offer(new long[]{endTime, room});
            count[room]++;
        }

        // Room that held the most meetings
        int maxMeetingsRoom = 0;
        for (int i = 1; i < rooms; i++) {
            if (count[i] > count[maxMeetingsRoom]) {
                maxMeetingsRoom = i;
            }
        }

        return maxMeetingsRoom;
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        int[][] meetings = {{1, 20}, {2, 10}, {3, 5}, {4, 9}, {6, 8}};
        int rooms = 3;
        System.out.println(mostBooked(meetings, rooms));
    }
}
