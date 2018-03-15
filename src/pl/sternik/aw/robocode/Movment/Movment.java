package pl.sternik.aw.robocode.Movment;

import robocode.BulletMissedEvent;
import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;

public interface Movment {
    void move();

    void onHitRobot(HitRobotEvent e);

    void onHitByBullet(HitByBulletEvent e);

    void onBulletMissed(BulletMissedEvent e);

}
