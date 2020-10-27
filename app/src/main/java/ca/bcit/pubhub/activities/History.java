package ca.bcit.pubhub.activities;

import java.util.Date;

public class History {
    String matchID;
    String matchName;
    Object matchTime;
    Object historyTime;

    public String getMatchID() {
        return matchID;
    }

    public void setMatchID(String matchID) {
        this.matchID = matchID;
    }

    public String getMatchName() {
        return matchName;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }

    public Object getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(Object matchTime) {
        this.matchTime = matchTime;
    }

    public Object getHistoryTime() {
        return historyTime;
    }

    public void setHistoryTime(Object historyTime) {
        this.historyTime = historyTime;
    }
}
