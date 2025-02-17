package Lab1;
import java.util.Scanner;

public class Calculator
{
    //attributes for the two numbers, operator, and answer
    private float num1;
    private float num2;
    private String operator;
    private float answer;

    //constructors
    public Calculator()
    {
        this.num1 = 0;
        this.num2 = 0;
        this.operator = "";
        this.answer = 0;
    }

    public Calculator(float num1, float num2, String operator)
    {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
        this.answer = 0;
    }

    //getters and setters
    //made to keep the attributes private but allow limited access
    public float getNum1()
    {
        return this.num1;
    }

    public float getNum2()
    {
        return this.num2;
    }

    public String getOperator()
    {
        return this.operator;
    }

    public float getAnswer()
    {
        return this.answer;
    }

    //The setters methods below allow the changing of private variables
    //This is an example of encapsulation
    public void setNum1(float num1)
    {
        this.num1 = num1;
    }

    public void setNum2(float num2)
    {
        this.num2 = num2;
    }

    public void setOperator(String operator)
    {
        this.operator = operator;
    }

    public void setAnswer(float answer)
    {
        this.answer = answer;
    }

    //The main method use to perform the operation
    //Uses the getter methods to get the private variables (num1, num2, and operator)
    //Uses the setter methods to set the answer then returns it
    public float calc()
    {
        if(getOperator().equals("+"))
        {
            setAnswer(getNum1() + getNum2());
        }else if(getOperator().equals("-"))
        {
            setAnswer(getNum1() - getNum2());
        }else if(getOperator().equals("*"))
        {
            setAnswer(getNum1() * getNum2());
        }else if(getOperator().equals("/"))
        {
            if(getNum2() == 0)
            {
                System.out.println("You cannot divide by 0 in this universe!");
                setAnswer(0);
            }else
            {
                setAnswer(getNum1() / getNum2());
            }
        }

        return getAnswer();
    }

    //use toString in order to print out the answer properly
    public String answerToString()
    {
        String num1String = Float.toString(this.num1);
        String num2String = Float.toString(this.num2);
        String ansString = Float.toString(this.answer);

        String fullString = num1String + " " + this.operator + " " + num2String + " = " + ansString;

        return fullString;
    }
}