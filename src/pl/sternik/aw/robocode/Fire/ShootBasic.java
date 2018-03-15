package pl.sternik.aw.robocode.Fire;

import pl.sternik.aw.robocode.Kaiser;
import robocode.BulletHitEvent;
import robocode.HitByBulletEvent;

import java.io.Serializable;

public class ShootBasic implements Shoot {
    private Kaiser kaiser;

    public ShootBasic(Kaiser kaiser) {
        this.kaiser = kaiser;
    }

    @Override
    public void shoot(double distance) {
        if(kaiser.getRadarTurnRemaining() < 5) {
            if (distance > 150 || kaiser.getEnergy() < 13) {
                kaiser.setFireBullet(1);
            } else if (distance > 100) {
                kaiser.setFireBullet(2);
            } else {
                kaiser.setFireBullet(3);
            }
        }
    }

    @Override
    public void onBulletHit(BulletHitEvent e) {

    }


}
