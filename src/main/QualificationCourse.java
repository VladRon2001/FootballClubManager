package main;

public class QualificationCourse implements IQualificationCourse {
    @Override
    public void levelUpTrainer(Trainer trainer) {
        trainer.setSkillLevel(trainer.getSkillLevel()+1);
    }
}
