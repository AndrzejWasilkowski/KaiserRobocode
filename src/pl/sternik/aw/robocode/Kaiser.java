package pl.sternik.aw.robocode;

import pl.sternik.aw.robocode.Fire.Shoot;
import pl.sternik.aw.robocode.Fire.ShootBasic;
import pl.sternik.aw.robocode.Movment.Movment;
import pl.sternik.aw.robocode.Movment.MovmentTactics;
import pl.sternik.aw.robocode.Scanner.Scanner;
import pl.sternik.aw.robocode.Scanner.ScannerBasic;
import robocode.*;

public class Kaiser extends AdvancedRobot{
    Shoot shoot = new ShootBasic(this);
    Movment movement = new MovmentTactics(this);
    Scanner scanner = new ScannerBasic(this);

    public void run() {
        setAdjustRadarForGunTurn(true);
        setAdjustRadarForRobotTurn(true);
        turnRadarRightRadians(Double.POSITIVE_INFINITY);
    }

    public void onScannedRobot(ScannedRobotEvent e) {
        scanner.onScannedRobot(e);

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
