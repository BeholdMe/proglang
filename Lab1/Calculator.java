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
        if(getOperator() == "+")
        {
            setAnswer(getNum1() + getNum2());
        }else if(getOperator() == "-")
        {
            setAnswer(getNum1() - getNum2());
        }else if(getOperator() == "*")
        {
            setAnswer(getNum1() * getNum2());
        }else if(getOperator() == "/")
        {
            setAnswer(getNum1() / getNum2());
        }

        return getAnswer();
    }
}

public static void main(String args[])
{
    Calculator calculator;
    float num1, num2;
    String operator;

    //if the java program was executed with additional arguments, then use the arguments for the numbers & operators
    if(args.length == 3)
    {
        calculator = new Calculator(Float.parseFloat(args[1]), Float.parseFloat(args[2]), args[3]);
    }

    Scanner kb = new Scanner(System.in);
    boolean isNotFloat = true;

    do
    {
        System.out.print("\nPlease enter first number: ");
        //make sure the input is a float, make the user retype if not a float data type
        if(kb.hasNextFloat())
        {
            isNotFloat = false;
            num1 = kb.nextFloat();
        }else
        {
            isNotFloat = true;
            System.out.println("Oops! You wrote something that isn't a number. Please retype when prompted.");
        }
    }while(isNotFloat);

    do
    {
        System.out.print("\nPlease enter second number: ");
        //make sure the input is a float, make the user retype if not a float data type
        if(kb.hasNextFloat())
        {
            isNotFloat = false;
            num2 = kb.nextFloat();
        }else
        {
            isNotFloat = true;
            System.out.println("Oops! You wrote something that isn't a number. Please retype when prompted.");
        }
    }while(isNotFloat);

    do
    {
        System.out.println("Please enter operator: ");
        operator = kb.next();
        //make sure the input is +, -, *, or /
        //if not, repeat question until it is
    }while(operator.length() != 1 && (operator != "+" || operator != "-" || operator != "*" || operator != "/") );

    //construct the calculator object with the given inputs
    calculator = new Calculator(num1, num2, operator);
}