package com.quickbite.connector2;

/**
 * Created by Paha on 5/2/2016.
 * Where game stats are held like average time, reason we messed up, etc...
 */
public class GameStats {
    public enum RoundOver {HitShape, HitLine, OutOfTime, Won}

    public static int currRound=0, maxRounds=10, successfulRounds, currScore, winCounter;
    public static float roundTimeLeft;
    public static float roundTimeDecreaseAmount = 1, getRoundTimeDecreaseAmountBelow5 = 0.5f;
    public static float roundTimeStart = 10;
    public static double startTime, endTime, bestTime, avgTime;
    public static boolean failedLastRound;
    public static RoundOver roundOverReason;
    public static int numberTimesWentBackToMainMenu = 1, numberTimesMainMenuBetweenInterAd = 2;
}
