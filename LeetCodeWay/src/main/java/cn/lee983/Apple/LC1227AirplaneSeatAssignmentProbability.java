package cn.lee983.Apple;

/**
 * @Auther: 62458
 * @Date: 2020/4/28 22:14
 * @Description:
 *  n passengers board an airplane with exactly n seats. The first passenger has lost the ticket and picks a seat randomly.
 *  But after that, the rest of passengers will:
 *      Take their own seat if it is still available,
 *      Pick other seats randomly when they find their seat occupied
 *      What is the probability that the n-th person can get his own seat?
 *
 *
 */
public class LC1227AirplaneSeatAssignmentProbability {

    public double nthPersonGetsNthSeat(int n) {
        if (n == 1) {
            return 1.0d;
        }
        return  1d / n + (n - 2d) / n * nthPersonGetsNthSeat(n - 1);
    }
}
