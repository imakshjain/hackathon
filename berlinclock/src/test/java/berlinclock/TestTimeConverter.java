package berlinclock;

import org.junit.Assert;
import org.junit.Test;

import com.ubs.opsit.interviews.service.impl.TimeConverterImpl;

public class TestTimeConverter {

	private TimeConverterImpl timeConverter = new TimeConverterImpl();
	
	 /*Yellow lamp should blink on/off every two seconds*/
    @Test
    public void testTopLamp() {
        Assert.assertEquals("Y", timeConverter.getTimeForTopLamp(0));
        Assert.assertEquals("O", timeConverter.getTimeForTopLamp(1));
    }

    /*First Lamp should have 4 lamps and should light red lamp for each 5 hours*/
    @Test
    public void testTimeForFirstLamp() {
        Assert.assertEquals(4, timeConverter.getTimeForFirstLamp(9).length());
        Assert.assertEquals("OOOO", timeConverter.getTimeForFirstLamp(0));
        Assert.assertEquals("RROO", timeConverter.getTimeForFirstLamp(13));
        Assert.assertEquals("RRRR", timeConverter.getTimeForFirstLamp(23));
        Assert.assertEquals("RRRR", timeConverter.getTimeForFirstLamp(24));
    }

    /* Second Lamp should have 4 lamps and should light a red lamp 
    for every hour left from top hours */
    @Test
    public void testTimeForSecondLamp() {
        Assert.assertEquals(4, timeConverter.getTimeForSecondLamp(5).length());
        Assert.assertEquals("OOOO", timeConverter.getTimeForSecondLamp(0));
        Assert.assertEquals("RRRO", timeConverter.getTimeForSecondLamp(13));
        Assert.assertEquals("RRRO", timeConverter.getTimeForSecondLamp(23));
        Assert.assertEquals("RRRR", timeConverter.getTimeForSecondLamp(24));
    }

    // Third Lamp should have 11 lamps
    // Third Lamp should light a yellow lamp for every 5minutes and red light for each quarter
    @Test
    public void testTimeForThirdLamp() {
        Assert.assertEquals(11, timeConverter.getTimeForThirdLamp(34).length());
        String minutes32 = timeConverter.getTimeForThirdLamp(32);
        Assert.assertEquals("R", minutes32.substring(2, 3));
        Assert.assertEquals("R", minutes32.substring(5, 6));
        Assert.assertEquals("O", minutes32.substring(8, 9));
        Assert.assertEquals("OOOOOOOOOOO", timeConverter.getTimeForThirdLamp(0));
        Assert.assertEquals("YYROOOOOOOO", timeConverter.getTimeForThirdLamp(17));
        Assert.assertEquals("YYRYYRYYRYY", timeConverter.getTimeForThirdLamp(59));
    }

    // Fourth Lamp should have 4 lamps
    @Test
    public void testTimeForFourthLamp() {
        Assert.assertEquals(4, timeConverter.getTimeForFourthLamp(0).length());
        Assert.assertEquals("OOOO", timeConverter.getTimeForFourthLamp(0));
        Assert.assertEquals("YYOO", timeConverter.getTimeForFourthLamp(17));
        Assert.assertEquals("YYYY", timeConverter.getTimeForFourthLamp(59));
    }

   // Berlin Clock it should "result in correct seconds, hours and minutes"
    @Test
    public void testBerlinClockShouldResultInCorrectSecondsHoursAndMinutes() {
        String berlinTime = timeConverter.convertTime("13:17:01");
        Assert.assertTrue(berlinTime.contains("YYROOOOOOOO"));
    }
}
