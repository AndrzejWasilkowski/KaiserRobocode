package pl.sternik.aw.robocode.Fire;

import robocode.BulletHitEvent;

public interface Shoot {
    void shoot(double distance);

    void onBulletHit(BulletHitEvent e);
}
