import ToMoodAnalyses.ToMoodAnalyses;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MoodAnalyser{
    @Test
    public void whenGivenSadMessage_ShouldReturnSad() {
        ToMoodAnalyses Analyses = new ToMoodAnalyses();
        String message = Analyses.analyse("i am sad Right now");
        Assert.assertEquals( "sad", message);
    }

    @Test
    public void whenGivenHappyMessage_ShouldReturnHapply() {
        ToMoodAnalyses Analyses = new ToMoodAnalyses();
        String message = Analyses.analyse("i am happy now");
        Assert.assertEquals("happy", message);
    }

    @Test
    public void whenGivennullMessage_ShouldReturnInvalid() {
        ToMoodAnalyses Analyses = new ToMoodAnalyses();
        try {
            String message = Analyses.analyse(null);
        }
        catch (Exception e){
            Assert.assertEquals("Please Enter Valid Input", e.getMessage());
        }
    }

    @Test
    public void whenGivenEmptyMessage_ShouldReturnIvalid() {
        ToMoodAnalyses Analyses = new ToMoodAnalyses();
        try {
            String message = Analyses.analyse(" ");
        }
        catch (Exception e){
            Assert.assertEquals("Please Enter Valid Input", e.getMessage());
        }
    }
}