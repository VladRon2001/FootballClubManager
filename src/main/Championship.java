package main;

import java.util.Random;
import java.util.Vector;

public class Championship {
    private final Vector<ChampionshipFootballClub> participants;

    Championship(Vector<FootballClub> footballClubs) {
        participants = new Vector<>();
        for(FootballClub footballClub:footballClubs) {
            ChampionshipFootballClub newParticipant = new ChampionshipFootballClub(footballClub);
            participants.add(newParticipant);
        }
    }

    private void playGame(ChampionshipFootballClub participantOne, ChampionshipFootballClub participantTwo) {
        final Random random = new Random();
        int diffrenceFootballClub = participantOne.getFootballClub().calculateStrongTeam()
                - participantTwo.getFootballClub().calculateStrongTeam();

        int resultGame = diffrenceFootballClub + random.nextInt(30) - random.nextInt(30);

        if (resultGame > 10) {
            participantOne.setScorePoint(participantOne.getScorePoint() + 3);
        }
        else if (resultGame < -10) {
            participantTwo.setScorePoint(participantTwo.getScorePoint() + 3);
        }
        else {
            participantOne.setScorePoint(participantOne.getScorePoint()+1);
            participantTwo.setScorePoint(participantTwo.getScorePoint()+1);
        }
    }

    public void playRound() {
        for(int i = 0; i < participants.size(); ++i) {
            for(int j = i + 1; j < participants.size(); ++j) {
                playGame(participants.elementAt(i), participants.elementAt(j));
            }
        }
    }

    @Override
    public String toString() {
        String participantsToString = "";

        for (ChampionshipFootballClub championshipFootballClub:participants) {
            participantsToString += championshipFootballClub.toString() + "\n";
        }

        return participantsToString;
    }
}
