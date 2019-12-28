package com.bridgelaz;

public class MoodException extends RuntimeException
{

    public enum Exceptiontype {
        ENTERED_NULL, ENTERED_EMPTY, NO_SUCH_CLASS
    }

    Exceptiontype type;
     public MoodException( Exceptiontype type,String message)
    {
        super(message);
        this.type = type;
    }
}
