/**
 * This class is the tester class of Date

 * @author Divyesh Nemam Baskaran, Viraj Patel
 *
 */

package src;

import org.junit.Assert;
import org.junit.Test;


public class RosterTest {
    private Roster roster;
    @Test
    public void add() {
        Roster roster = new Roster();
        Student one = new Student("Dan",Student.Major.BA);
        roster.add(one);
        Assert.assertEquals(0,roster.inRoster(one),0.001);
        Student two = new Resident("Jack",Student.Major.BA,12);
        roster.add(two);
        Assert.assertEquals(1,roster.inRoster(two),0.001);
        Student three = new TriState("Jackson",Student.Major.BA,12,Student.Tri.NY);
        roster.add(three);
        Assert.assertEquals(2,roster.inRoster(three),0.001);
        Student four = new International("Ksi",Student.Major.BA,12,true);
        roster.add(four);
        Assert.assertEquals(3,roster.inRoster(four),0.001);

    }

    @Test
    public void remove() {
        Roster roster = new Roster();
        Student one = new Student("Dan",Student.Major.BA);
        roster.add(one);
        Student two = new Resident("Jack",Student.Major.BA,12);
        roster.add(two);
        Student three = new TriState("Jackson",Student.Major.BA,12,Student.Tri.NY);
        roster.add(three);
        Student four = new International("Ksi",Student.Major.BA,12,true);
        roster.add(four);
        roster.remove(one);
        Assert.assertEquals(-1,roster.inRoster(one),0.001);
        roster.remove(two);
        Assert.assertEquals(-1,roster.inRoster(two),0.001);
        roster.remove(three);
        Assert.assertEquals(-1,roster.inRoster(three),0.001);
        roster.remove(four);
        Assert.assertEquals(-1,roster.inRoster(four),0.001);

    }
}