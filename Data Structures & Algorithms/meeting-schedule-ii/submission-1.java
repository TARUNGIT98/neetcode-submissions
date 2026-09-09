/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals == null || intervals.isEmpty()) {
            return 0;
        }

        intervals.sort(Comparator.comparingInt(i -> i.start));

        // Min heap to track the end times
        PriorityQueue<Integer> roomEndTimes = new PriorityQueue<>();

        roomEndTimes.add(intervals.get(0).end);

        for(int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);

            if (current.start >= roomEndTimes.peek()) {
                roomEndTimes.poll();
            }

            roomEndTimes.add(current.end);
        }

        return roomEndTimes.size();

    }
}
