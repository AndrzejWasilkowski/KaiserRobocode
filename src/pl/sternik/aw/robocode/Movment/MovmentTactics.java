package pl.sternik.aw.robocode.Movment;


import pl.sternik.aw.robocode.Kaiser;
import robocode.BulletMissedEvent;
import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;

public class MovmentTactics implements Movment {
    Kaiser kaiser;

    //kierunek
    // 1 - prawo (0-25) stopnie
    // 2 - lewo (360-335) stopnie
    private int kierunek = 1;
    private boolean reverse = false;

    public double battlefieldWidth;
    public double battlefieldHeight;
    private final int wall = 100;
    private final int maxTurn = 60;

    public MovmentTactics(Kaiser kaiser) {
        this.kaiser = kaiser;
    }

    @Override
    public void move() {
        battlefieldWidth = kaiser.getBattleFieldWidth();
        battlefieldHeight = kaiser.getBattleFieldHeight();
        kaiser.setAhead(20);
        //moja ściana

//ustalanie kierunku do skrętu DODAĆ JESZCZE W ZALEŻNOŚCI NA KTÓRĄ ŚCIANĘ I JAKI JEST KĄT, TO MA INACZEJ SKRĘCAĆ
        if (reverse == false) {
            if (kaiser.getHeading() >= 0 && kaiser.getHeading() <= 45) {
                kierunek = 1;
            } else if (kaiser.getHeading() > 45 && kaiser.getHeading() <= 90) {
                kierunek = 2;
            } else if (kaiser.getHeading() > 90 && kaiser.getHeading() <= 135) {
                kierunek = 1;
            } else if (kaiser.getHeading() > 135 && kaiser.getHeading() <= 180) {
                kierunek = 2;
            } else if (kaiser.getHeading() > 180 && kaiser.getHeading() <= 225) {
                kierunek = 1;
            } else if (kaiser.getHeading() > 225 && kaiser.getHeading() <= 270) {
                kierunek = 2;
            } else if (kaiser.getHeading() > 270 && kaiser.getHeading() <= 315) {
                kierunek = 1;
            } else if (kaiser.getHeading() > 315 && kaiser.getHeading() <= 360) {
                kierunek = 2;
            }
        }

        if (kaiser.getTurnRemaining() == 0 ) {
            if (reverse == false) {
    //Nowe skręcanie Prawo
                if (kaiser.getHeading() >= 0 && kaiser.getHeading() <= 25) {
                    kaiser.setTurnRight(4);
                }
                if (kaiser.getHeading() >= 90 && kaiser.getHeading() <= 115) {
                    kaiser.setTurnRight(4);
                }
                if (kaiser.getHeading() >= 180 && kaiser.getHeading() <= 205) {
                    kaiser.setTurnRight(4);
                }
                if (kaiser.getHeading() >= 270 && kaiser.getHeading() <= 295) {
                    kaiser.setTurnRight(4);
                }

    //Nowe skręcanie lweo
                if (kaiser.getHeading() >= 335 && kaiser.getHeading() <= 360) {
                    kaiser.setTurnLeft(4);
                }
                if (kaiser.getHeading() >= 245 && kaiser.getHeading() <= 270) {
                    kaiser.setTurnLeft(4);
                }
                if (kaiser.getHeading() >= 155 && kaiser.getHeading() <= 180) {
                    kaiser.setTurnLeft(4);
                }
                if (kaiser.getHeading() >= 65 && kaiser.getHeading() <= 90) {
                    kaiser.setTurnLeft(4);
                }
            }

            if (kierunek == 1) {
                if (kaiser.getX() <= wall) {
                    kaiser.setTurnRight(maxTurn);
                    reverse = true;
                } else if (kaiser.getX() >= battlefieldWidth - wall) {
                    kaiser.setTurnRight(maxTurn);
                    reverse = true;
                } else if (kaiser.getY() <= wall) {
                    kaiser.setTurnRight(maxTurn);
                    reverse = true;
                } else if (kaiser.getY() >= battlefieldHeight - wall) {
                    kaiser.setTurnRight(maxTurn);
                    reverse = true;
                } else {
                    reverse = false;
                }
            } else if(kierunek == 2) {
                if (kaiser.getX() <= wall) {
                    kaiser.setTurnLeft(maxTurn);
                    reverse = true;
                } else if (kaiser.getX() >= battlefieldWidth - wall) {
                    kaiser.setTurnLeft(maxTurn);
                    reverse = true;
                } else if (kaiser.getY() <= wall) {
                    kaiser.setTurnLeft(maxTurn);
                    reverse = true;
                } else if (kaiser.getY() >= battlefieldHeight - wall) {
                    kaiser.setTurnLeft(maxTurn);
                    reverse = true;
                } else {
                    reverse = false;
                }
            }
        }
        kaiser.execute();
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
