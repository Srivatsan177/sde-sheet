import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NMeeting {
    static class Meeting {
        int meetingId;
        int meetStart;
        int meetEnd;
    }
    public static void main(String[] args) {
        int[] start = {1,3,0,5,8,5}, end = {2,4,5,7,9,9};
        Meeting[] meetings = new Meeting[start.length];
        for(int i=0; i<start.length; i++) {
            meetings[i] = new Meeting();
            meetings[i].meetingId = i;
            meetings[i].meetStart = start[i];
            meetings[i].meetEnd = end[i];
        }
        Arrays.sort(meetings, Comparator.comparingInt(a -> a.meetEnd));
        List<Integer> answers = new ArrayList<>(meetings.length);
        answers.add(meetings[0].meetingId + 1);
        int limit = meetings[0].meetEnd;
        for(int i=1; i<meetings.length; i++) {
            if(meetings[i].meetStart > limit) {
                limit = meetings[i].meetEnd;
                answers.add(meetings[i].meetingId + 1);
            }
        }
        System.out.println(answers);
    }
}
