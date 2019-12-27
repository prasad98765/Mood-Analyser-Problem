package ToMoodAnalyses;


public class ToMoodAnalyses
{
    public String message;

    public ToMoodAnalyses(String message) {
        this.message = message;
    }

    public ToMoodAnalyses(){
    }


    public String analyse() throws MoodException {
        try {
            if (message.length() == 0)
                throw new MoodException( MoodException.Exceptiontype.ENTERED_EMPTY,"Please Valid Input" );
            if (message.contains("sad") || message.contains("Sad"))
                return "sad";
            else
                return "happy";
        }
        catch (Exception ex){
             throw new MoodException( MoodException.Exceptiontype.ENTERED_NULL,"Please Enter Valid Input");
        }
    }
}
