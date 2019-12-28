package com.bridgelaz;

public class MoodException extends RuntimeException
{
    enum Exceptiontype{
        ENTERED_NULL,ENTERED_EMPTY;
    }
    Exceptiontype type;
     public MoodException( Exceptiontype type,String message)
    {
        super(message);
        this.type = type;
    }
}
