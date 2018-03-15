package pl.sternik.aw.robocode.Movment;

import pl.sternik.aw.robocode.Kaiser;
import robocode.BulletMissedEvent;
import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;

public class MovmentTactics implements Movment {
    Movment tactic;

    public MovmentTactics(Kaiser kaiser) {
        this.tactic = new MovmentTacticsOne(kaiser);
    }

    @Override
    public void move() {
        tactic.move();
    }

    @Override
    public void onHitRobot(HitRobotEvent e) {
        tactic.onHitRobot(e);
    }

    @Override
    public void onHitByBullet(HitByBulletEvent e) {
        tactic.onHitByBullet(e);
    }

    @Override
    public void onBulletMissed(BulletMissedEvent e) {
        tactic.onBulletMissed(e);
    }
}
