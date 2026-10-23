package mutants;

public class Survived {
    public static String check(int targetScore, int maxPlays, boolean allowTwoPointPlay) {
        if ((targetScore < 1) || (targetScore >= 500)) {
            return "Scorul nu este valid";
        } else if ((maxPlays < 1) || (maxPlays > 100)) {
            return "Numărul de jocuri nu este valid";
        }

        int[] scoringOptions;
        if (allowTwoPointPlay) {
            scoringOptions = new int[]{2, 3, 5};
        } else {
            scoringOptions = new int[]{3, 5};
        }

        /*
         * reachable[p][s] = scorul `s` poate fi atins
         * în maxim `p` jocuri.
         * */

        boolean[][] reachable =
                new boolean[maxPlays + 1][targetScore + 1];

        reachable[0][0] = true;
        int plays = 1;

        while (plays <= maxPlays) {
            for (int score = 0; score <= targetScore; score++) {
                if (reachable[plays - 1][score]) {
                    reachable[plays][score] = true;
                }

                for (int points : scoringOptions) {
                    int previousScore = score - points;
                    if ((previousScore < 0) || !reachable[plays - 1][previousScore]) {
                        continue;
                    }

                    reachable[plays][score] = true;
                    if (score == targetScore) {
                        break;
                    }
                }
            }

            if (reachable[plays][targetScore]) {
                return "Da";
            } else {
                plays++;
            }
        }

        return "Nu";
    }
}
