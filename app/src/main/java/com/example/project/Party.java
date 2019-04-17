package com.example.project;

public class Party {

    String Balloons,Cake,PartyColors, PartyDate,PartyLocation, PartyName, PartyNumGuests,
    PartyTheme, PartyTime;

    public Party(String Balloons, String Cake, String PartyColors, String PartyDate, String PartyLocation, String PartyName, String PartyNumGuests, String PartyTheme, String PartyTime) {
        this.Balloons =Balloons;
        this.Cake = Cake;
        PartyColors = PartyColors;
        PartyDate = PartyDate;
        PartyLocation = PartyLocation;
        PartyName = PartyName;
        PartyNumGuests = PartyNumGuests;
        PartyTheme = PartyTheme;
        PartyTime = PartyTime;
    }

    public Party(){ }

    public String getBalloons() {
        return Balloons;
    }

    public void setBalloons(String balloons) {
        this.Balloons = balloons;
    }

    public String getCake() {
        return Cake;
    }

    public void setCake(String Cake) {
        this.Cake = Cake;
    }

    public String getPartyColors() {
        return PartyColors;
    }

    public void setPartyColors(String partyColors) {
        PartyColors = partyColors;
    }

    public String getPartyDate() {
        return PartyDate;
    }

    public void setPartyDate(String partyDate) {
        PartyDate = partyDate;
    }

    public String getPartyLocation() {
        return PartyLocation;
    }

    public void setPartyLocation(String partyLocation) {
        PartyLocation = partyLocation;
    }

    public String getPartyName() {
        return PartyName;
    }

    public void setPartyName(String partyName) {
        PartyName = partyName;
    }

    public String getPartyNumGuests() {
        return PartyNumGuests;
    }

    public void setPartyNumGuests(String partyNumGuests) {
        PartyNumGuests = partyNumGuests;
    }

    public String getPartyTheme() {
        return PartyTheme;
    }

    public void setPartyTheme(String partyTheme) {
        PartyTheme = partyTheme;
    }

    public String getPartyTime() {
        return PartyTime;
    }

    public void setPartyTime(String partyTime) {
        PartyTime = partyTime;
    }
}
