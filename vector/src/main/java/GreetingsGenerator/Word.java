package GreetingsGenerator;
public class Word
{
    String value;
    Word_Types type;

    public Word(String value, Word_Types type)
    {
        this.value = value;
        this.type = type;
    }

    public String getValue()
    {
        return this.value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    public Word_Types getType()
    {
        return this.type;
    }

    public void setType(Word_Types type)
    {
        this.type = type;
    }

    public String toString()
    {
        return this.value;
    }
}
