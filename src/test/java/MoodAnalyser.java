import com.bridgelaz.MoodException;
import com.bridgelaz.ToMoodAnalyses;
import com.bridgelaz.MoodAnalyserReflection;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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

    @Test
    public void givenMoodAnalyzerObject_WhenProper_ShouldReturnObject() {
        Constructor<?> constructor = null;
        try {
            constructor = Class.forName("com.bridgelaz.ToMoodAnalyses").getConstructor(String.class);
            Object myobj = constructor.newInstance("i am a happy");
            ToMoodAnalyses myobj1 = (ToMoodAnalyses) myobj;
                String mood= myobj1.analyse();
                Assert.assertEquals("happy",mood);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void givenMoodAnalyser_WhenProper_ShouldReturnObject() {
        ToMoodAnalyses moodAnalyses = MoodAnalyserReflection.createMoodAnalyser("I am happy");
        String mood = moodAnalyses.analyse();
        Assert.assertEquals("happy",mood);
    }

    @Test
    public void compareObject() {
        ToMoodAnalyses obj=new ToMoodAnalyses("I am happy");
        ToMoodAnalyses obj1 = MoodAnalyserReflection.createMoodAnalyser("I am happy");
        Assert.assertEquals(true,obj.equals(obj1));
    }

    @Test
    public void givenWrongClassName_WhenImproper_ShouldReturnNotFoundException() throws ClassNotFoundException {
        Constructor<?> constructor = null;
        try {
            constructor = Class.forName("com.bridgelaz.Mood").getConstructor(String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            try {
                throw new MoodException(MoodException.Exceptiontype.NO_SUCH_CLASS, "Enter valid class Name");
            } catch (MoodException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Test
    public void givenWrongConstructor_WhenImproper_ShouldReturnNoSuchMethod(){
        Constructor<?> constructor = null;
        try {
            constructor = Class.forName("com.bridgelaz.ToMoodAnalyses").getConstructor(int.class);
            Object myobj = constructor.newInstance("i am a happy");
            ToMoodAnalyses myobj1 = (ToMoodAnalyses) myobj;
            String mood= myobj1.analyse();
            Assert.assertEquals("happy",mood);
        } catch (NoSuchMethodException e) {
            try {
                throw new MoodException(MoodException.Exceptiontype.NO_SUCH_METHOD,"Enter valid Method Name");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenGivenConstructorwithObject_shouldReturnObject() {
        Constructor constructor = MoodAnalyserReflection.getConstructor(String.class);
        Object object = MoodAnalyserReflection.getObject(constructor, "i am happy");
        ToMoodAnalyses object1 = (ToMoodAnalyses) object;
        Assert.assertEquals(true,object1.equals(new ToMoodAnalyses("i am happy")));

    }

    @Test
    public void whenGivenConstructorwithNoparameter_shouldRetrunObject() {
        Constructor constructor = MoodAnalyserReflection.getConstructor();
        Object object = MoodAnalyserReflection.getObject(constructor);
        ToMoodAnalyses object1 = (ToMoodAnalyses) object;
        Assert.assertEquals(true,object1.equals(new ToMoodAnalyses()));
    }

    @Test
    public void whenGivenMood_usingInvokeMethod_shouldReturnProperMessage() throws NoSuchMethodException {

        Object object = MoodAnalyserReflection.getMethod("analyser");
        String mood = null;
        try {
            mood = (String) ((Method) object).invoke(new ToMoodAnalyses(), "i am sad");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("sad",mood);

    }
}

