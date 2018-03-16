package pl.sternik.aw.robocode.Scanner;

import pl.sternik.aw.robocode.Kaiser;
import robocode.ScannedRobotEvent;

public class ScannerBasic implements Scanner {
    private Kaiser kaiser;

    public ScannerBasic(Kaiser kaiser) {
        this.kaiser = kaiser;
    }

    @Override
    public void onScannedRobot(ScannedRobotEvent e) {
        kaiser.setTurnRadarLeft(kaiser.getRadarTurnRemainingRadians());
        double bearing=e.getBearingRadians() + kaiser.getHeadingRadians();
        double enemyLaterPosition=e.getVelocity() * Math.sin(e.getHeadingRadians() - bearing);
        double weaponTurn;
        weaponTurn = robocode.util.Utils.normalRelativeAngle(bearing - kaiser.getGunHeadingRadians() + enemyLaterPosition);
        kaiser.setTurnGunRightRadians(weaponTurn);
    }
}
