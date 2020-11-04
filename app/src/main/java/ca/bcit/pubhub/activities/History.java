package ca.bcit.pubhub.activities;

import java.util.Date;

public class History implements Comparable<History>{
    int matchID;
    String matchName;
    String matchTime;
    Object historyTime;

    public int getMatchID() {
        return matchID;
    }

    public void setMatchID(int matchID) {
        this.matchID = matchID;
    }

    public String getMatchName() {
        return matchName;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }

    public String getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(String matchTime) {
        this.matchTime = matchTime;
    }

    public Object getHistoryTime() {
        return historyTime;
    }

    public void setHistoryTime(Object historyTime) {
        this.historyTime = historyTime;
    }

    @Override
    public int compareTo(History o) {
        long left = (long) this.getHistoryTime();
        long right = (long) o.getHistoryTime();
        return (int) (right - left);
    }

}
