package com.bridgelaz;


import java.util.Objects;

public class ToMoodAnalyses
{
    public String message;

    public ToMoodAnalyses(){

    }
    public ToMoodAnalyses(String message){

        this.message=message;
    }

    public String analyser(String message)
    {
        this.message=message;
        return analyse();
    }

    public String analyse(){
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToMoodAnalyses that = (ToMoodAnalyses) o;
        return Objects.equals(message, that.message);
    }


}
