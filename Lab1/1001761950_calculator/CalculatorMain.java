package Lab1;
import java.util.Scanner;

public class CalculatorMain
{
    public static void main(String args[])
    {
        Calculator calculator;
        float num1 = 0, num2 = 0, answer = 0;
        String operator;

        Scanner kb = new Scanner(System.in);
        boolean isNotFloat = true;
        //keep asking until a proper number 1 is given
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
                kb.next();
            }
        }while(isNotFloat);

        //keep asking until a proper number 2 is given
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
                kb.next();
            }
        }while(isNotFloat);

        //keep asking until a proper operator is given
        do
        {
            System.out.println("Please enter operator: ");
            operator = kb.next();
            //make sure the input is +, -, *, or /
            //if not, repeat question until it is
        }while( !(operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/") ) );

        //construct the calculator object with the given inputs
        calculator = new Calculator(num1, num2, operator);

        //calc and return
        answer = calculator.calc();
        String answerAsString = calculator.answerToString();
        System.out.println(answerAsString);
        kb.close();
    }
}
