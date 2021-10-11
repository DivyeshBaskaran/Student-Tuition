/**
 * This class is the tester class of Date

 * @author Divyesh Nemam Baskaran, Viraj Patel
 *
 */

package src;

import org.junit.Test;
import org.junit.Assert;
import src.Student.Major;

public class InternationalTest {

    @Test
    public void tuitionDue() {

        International t1 = new International("Bob Ross", Major.IT,12,false);
        t1.setTuition(0);
        t1.tuitionDue();
        Assert.assertEquals(35655.00,t1.getTuition(),0.001);

        International t2 = new International("Bob Ross", Major.IT,20,false);
        t2.setTuition(0);
        t2.tuitionDue();
        Assert.assertEquals(39519.00,t2.getTuition(),0.001);

        International t3 = new International("Bob Ross", Major.IT,12,true);
        t3.setTuition(0);
        t3.tuitionDue();
        Assert.assertEquals(5918.00,t3.getTuition(),0.001);

        /*
        International t4 = new International("Bob Ross", Major.IT,12,false);
        t4.setTuition(0);
        t4.tuitionDue();
        Assert.assertEquals(35655.00,t4.getTuition(),0.001);
        */
    }
}