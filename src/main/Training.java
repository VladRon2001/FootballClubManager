package main;

import java.util.Vector;

public class Training implements ITraining {
    @Override
    public void train(Vector<FootballPlayer> footballTeam, int trainerSkillLevel) {
        for (FootballPlayer footballPlayer:footballTeam) {
            double newRatingScore = footballPlayer.getRatingScore() + (30-footballPlayer.getAge())*0.1 * trainerSkillLevel;
            footballPlayer.setRatingScore((int)newRatingScore);
        }
    }
}
