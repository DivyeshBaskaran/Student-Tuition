/**
 * This class is the tester class of Date

 * @author Divyesh Nemam Baskaran, Viraj Patel
 *
 */

package src;

import org.junit.Test;
import org.junit.Assert;

public class DateTest {

    @Test
    public void isValid() {

        //Invalid month
        Date t1 = new Date("13/1/2021");//false
        Assert.assertEquals(false,t1.isValid());

        //Future date
        Date t2 = new Date("12/2/2021");//false
        Assert.assertEquals(false,t2.isValid());

        //Invalid day
        Date t3 = new Date("12/32/2021");//false
        Assert.assertEquals(false,t3.isValid());

        //Invalid month
        Date t4 = new Date("0/2/2021");//false
        Assert.assertEquals(false,t4.isValid());

        //Valid date
        Date t5 = new Date("3/12/2021");//true
        Assert.assertEquals(true,t5.isValid());

        //Invalid day in non-leap year
        Date t6 = new Date("2/29/2021");//false
        Assert.assertEquals(false,t6.isValid());

        //Valid day in non-leap year
        Date t7 = new Date("2/28/2021");//true
        Assert.assertEquals(true,t7.isValid());

        //Year before 2021
        Date t8 = new Date("2/28/1979");//false
        Assert.assertEquals(false,t8.isValid());

        //Valid date
        Date t9 = new Date("2/28/2021");//true
        Assert.assertEquals(true,t9.isValid());

    }
}