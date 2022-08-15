package main;

import java.util.Timer;
import java.util.TimerTask;

import entity.Player;

/**
 * Reminder that's used for counting
 * 15 seconds that gift lasts for
 */

public class Reminder {
    Timer timer;
    Player player;
    int change;

    public Reminder(int seconds, Player player, int change) {
        timer = new Timer();
        timer.schedule(new RemindTask(), seconds*1000);
        this.player = player;
        this.change = change;
        player.speed += change;
	}

    class RemindTask extends TimerTask {
        public void run() {
        	player.speed -= change;
            timer.cancel(); //Terminate the timer thread
        }
    }
}
