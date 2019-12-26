package ToMoodAnalyses;


public class ToMoodAnalyses
{
    public String analyse(String messgae) throws MoodException {
        try {
            if (messgae.length() == 0)
                throw new MoodException( MoodException.Exceptiontype.ENTERED_EMPTY,"Please Valid Input" );
            if (messgae.contains("sad") || messgae.contains("Sad"))
                return "sad";
            else
                return "happy";
        }
        catch (Exception ex){
             throw new MoodException( MoodException.Exceptiontype.ENTERED_NULL,"Please Enter Valid Input");
        }
    }
}
