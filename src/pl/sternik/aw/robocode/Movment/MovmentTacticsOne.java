package pl.sternik.aw.robocode.Movment;

import pl.sternik.aw.robocode.Kaiser;
import robocode.BulletMissedEvent;
import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;

public class MovmentTacticsOne implements Movment {
    Kaiser kaiser;

    public double battlefieldWidth;
    public double battlefieldHeight;
    private final int wall = 100;
    private final int maxTurn = 25;

    public MovmentTacticsOne(Kaiser kaiser) {
        this.kaiser = kaiser;
    }

    @Override
    public void move() {
        battlefieldWidth = kaiser.getBattleFieldWidth();
        battlefieldHeight = kaiser.getBattleFieldHeight();
        kaiser.setAhead(30);
        //moja ściana
        if (kaiser.getTurnRemaining() == 0 ) {
            if (kaiser.getX() <= wall) {
                kaiser.setTurnRight(maxTurn);
            } else if (kaiser.getX() >= battlefieldWidth - wall) {
                kaiser.setTurnRight(maxTurn);
            } else if (kaiser.getY() <= wall) {
                kaiser.setTurnRight(maxTurn);
            } else if (kaiser.getY() >= battlefieldHeight - wall) {
                kaiser.setTurnRight(maxTurn);
            }

            //ustawienie kierunku mniej więcej w okolice 45 stopni, żeby płynniej skręcał, do ulepszenie (skręt lewo/prawo w zależności jak będzie łatwiej skręcić)
            if (kaiser.getHeading() >=340 || kaiser.getHeading() <= 20){
                kaiser.setTurnRight(10);
            } else if (kaiser.getHeading() >=70 && kaiser.getHeading() <= 110) {
                kaiser.setTurnRight(10);
            } else if (kaiser.getHeading() >=160 && kaiser.getHeading() <= 200) {
                kaiser.setTurnRight(10);
            } else if (kaiser.getHeading() >=250 && kaiser.getHeading() <= 300) {
                kaiser.setTurnRight(10);
            }
        }

    }

    @Override
    public void onHitRobot(HitRobotEvent e) {
        kaiser.setBack(40);
    }

    @Override
    public void onHitByBullet(HitByBulletEvent e) {

    }

    @Override
    public void onBulletMissed(BulletMissedEvent e) {

    }
}
