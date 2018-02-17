package pl.sternik.aw.robocode;

import robocode.AdvancedRobot;
import robocode.Robot;
import robocode.ScannedRobotEvent;

public class Kaiser extends AdvancedRobot {
    public void run() {
        double dystansPrzebyty = 0;
        int kierunek = 1;
        while (true) {
            while (dystansPrzebyty != 300) {
                ahead(100);
                turnGunRight(360 * kierunek);
                dystansPrzebyty += 100;
                kierunek *= -1;
            }
            dystansPrzebyty = 0;
            while (dystansPrzebyty != 300) {
                back(100);
                turnGunRight(360 * kierunek);
                dystansPrzebyty += 100;
                kierunek *= -1;
            }
            dystansPrzebyty = 0;
        }
    }

    public void onScannedRobot(ScannedRobotEvent e) {
        stop();
        fire_alt(e.getDistance());
        resume();

    }

    public void fire_alt(double odleglosc){
        if(odleglosc > 150 || getEnergy() < 13) {
            fire(1);
        } else if (odleglosc > 100){
            fire(2);
        } else {
            fire(3);
        }
    }

}
