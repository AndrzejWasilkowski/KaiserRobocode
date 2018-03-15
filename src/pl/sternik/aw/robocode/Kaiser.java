package pl.sternik.aw.robocode;

import pl.sternik.aw.robocode.Fire.Shoot;
import pl.sternik.aw.robocode.Fire.ShootBasic;
import pl.sternik.aw.robocode.Movment.Movment;
import pl.sternik.aw.robocode.Movment.MovmentTactics;
import robocode.*;

public class Kaiser extends AdvancedRobot{
    Shoot shoot = new ShootBasic(this);
    Movment movement = new MovmentTactics(this);

    public void run() {
        setAdjustRadarForGunTurn(true);
        setAdjustRadarForRobotTurn(true);
        turnRadarRightRadians(Double.POSITIVE_INFINITY);
    }

    public void onScannedRobot(ScannedRobotEvent e) {
        setTurnRadarLeft(getRadarTurnRemainingRadians());
        double bearing=e.getBearingRadians() + getHeadingRadians();
        double enemyLaterPosition=e.getVelocity() * Math.sin(e.getHeadingRadians() - bearing);
        double weaponTurn;
        weaponTurn = robocode.util.Utils.normalRelativeAngle(bearing - getGunHeadingRadians() + enemyLaterPosition);
        setTurnGunRightRadians(weaponTurn);

        movement.move();
        shoot.shoot(e.getDistance());
    }

    @Override
    public void onHitRobot(HitRobotEvent e) {
        movement.onHitRobot(e);
    }

    @Override
    public void onHitByBullet(HitByBulletEvent e) {
        movement.onHitByBullet(e);
    }

    @Override
    public void onBulletMissed(BulletMissedEvent e) {
        movement.onBulletMissed(e);
    }
}
