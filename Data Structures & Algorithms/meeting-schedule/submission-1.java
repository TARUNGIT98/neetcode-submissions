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
    public boolean canAttendMeetings(List<Interval> intervals) {

        if (intervals == null || intervals.size() <= 1) {
            return true;
        }

        intervals.sort(Comparator.comparingInt(i -> i.start));

        int prevEnd = intervals.get(0).end;

        for(int i = 1; i< intervals.size(); i++) {
            Interval current = intervals.get(i);
            if(prevEnd > current.start) return false;
            prevEnd = current.end;
        }

        return true;
    }
}
