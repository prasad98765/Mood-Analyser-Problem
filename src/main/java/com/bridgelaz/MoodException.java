package com.bridgelaz;

public class MoodException extends RuntimeException
{

    public MoodException(String enter_valid_method_name) {

    }

    public enum Exceptiontype {
        ENTERED_NULL, ENTERED_EMPTY, NO_SUCH_CLASS, NO_SUCH_METHOD,NO_FLELD_FOUND;
    }

    Exceptiontype type;
     public MoodException( Exceptiontype type,String message)
    {
        super(message);
        this.type = type;
    }
}
