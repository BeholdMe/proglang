#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

//Prototypes for the functions add, multiply, subtract, and divide
double add(double num1, double num2);
double multiply(double num1, double num2);
double subtract(double num1, double num2);
double divide(double num1, double num2);

double getNum();
char getOp();


int main()
{
    double num1, num2, answer = 0;
    char operator, choice;
    int cont = 1; //use for the do-while loop

    do
    {
        //ask user for the numbers and the operators
        printf("Enter a mathematical expression (i.e. 1 + 1): ");
        if(scanf("%lf %c %lf", &num1, &operator, &num2) != 3) //make sure there is at least three
        {
            printf("WRONG! Type a MATH expression (2 numbers separated by an operator).\n");
            continue; //if they didn't write an expression using exactly three elements -> redo the loop
        }
        
        while ( getchar() != '\n' ); // clear scanf buffer. Putting this here as check cause it keeps not reading the scanf for choice later on.

        //perform the calculator depending on the operator
        switch (operator)
        {
            case '+':
                answer = add(num1, num2);
                break;
            case '-':
                answer = subtract(num1, num2);
                break;
            case '*':
                answer = multiply(num1, num2);
                break;
            case '/':
                if(num2 == 0)
                {
                    printf("You can't divide by 0 in this universe!\n");
                    continue; //break out of the matrix
                }
                answer = divide(num1, num2);
                break;
            default:
                printf("Operator is INVALID");
                break;
        }

        //print answer
        printf("%.2lf %c %.2lf = %.2lf\n", num1, operator, num2, answer);

        //ask if the user wants to do another calculation
        printf("Would you like to calculate another expression? (Y/n): ");
        scanf("%c", &choice);
        if(choice == 'n' || choice == 'N')
        {
            cont = 0;
            break;
        }else
        {
            printf("\n");
        }
    } while (1);

    printf("Exiting...\n");
    
    
    

    return 0;
}

double add(double num1, double num2)
{
    return num1 + num2;
}

double subtract(double num1, double num2)
{
    return num1 - num2;
}

double multiply(double num1, double num2)
{
    return num1 * num2;
}

double divide(double num1, double num2)
{
    if(num2 == 0)
    {
        return 0;
    }
    return num1 / num2;
}