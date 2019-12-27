import ToMoodAnalyses.ToMoodAnalyses;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Constructor;

public class MoodAnalyser{
    @Test
    public void whenGivenSadMessage_ShouldReturnSad() {
        ToMoodAnalyses Analyses = new ToMoodAnalyses("i am sad Right now");
        String message = Analyses.analyse();
        Assert.assertEquals( "sad", message);
    }

    @Test
    public void whenGivenHappyMessage_ShouldReturnHapply() {
        ToMoodAnalyses Analyses = new ToMoodAnalyses("i am happy now");
        String message = Analyses.analyse();
        Assert.assertEquals("happy",message);
    }

    @Test
    public void whenGivennullMessage_ShouldReturnInvalid() {
        ToMoodAnalyses Analyses = new ToMoodAnalyses(null);
        try {
            String message = Analyses.analyse();
        }
        catch (Exception e){
            Assert.assertEquals("Please Enter Valid Input", e.getMessage());
        }
    }

    @Test
    public void whenGivenEmptyMessage_ShouldReturnIvalid() {
        ToMoodAnalyses Analyses = new ToMoodAnalyses("");
        try {
            String message = Analyses.analyse();
        }
        catch (Exception e){
            Assert.assertEquals("Please Enter Valid Input", e.getMessage());
        }
    }


}