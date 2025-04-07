'''
Name:       Balaputradewa Ratuwina
StudentID:  1001761950
Date:       04.06.2025
OS:         Windows

o Create a simple Python calculator that accepts Reverse Polish Notation (RPN) expressions
o The calculator should only support the following operators: +, -, *, and /.
o Input numbers must be single digits.
o The input file will be named input_RPN.txt and will contain one RPN expression per line.
o Each digit and operator in the input file will be space-delimited.
o The program should read the input file from the same directory (without hardcoding the file path) and output the result for each RPN expression on a new line.
o The input format is postfix notation; for example:
    ▪ Input: 4 2 +
    ▪ Output: 6
    ▪ Example with a more complex expression:
    ▪ Infix: (4 + 2 * 5) / (1 + 3 * 2)
    ▪ RPN: 4 2 5 * + 1 3 2 * + /
'''

import os

def rpn(xprs):
    # create a stack to hold the expression in first-in,last-out order
    stack = []
    answer = 0
    # split the expression using whitespace
    tokens = xprs.strip().split()

    for token in tokens:
        if token.isdigit():
            stack.append(int(token)) # turn itno int mannually to make sure os knpws and prevent future issues
        elif token in '+-*/':
            # make sure there is only two number tokens before this
            if len(stack) < 2:
                raise ValueError("Invalid! You put too many stuffing")
            
            # pop the last two and place in 'b' and 'a' respectively
            # use values to add/mult/div/sub
            # append the answer to stack
            # eventually in the final loop, each expression parts will be popped and operated on
            # answer in the first element of stack
            b = stack.pop()
            a = stack.pop()
            if token == '+':
                stack.append(a + b)
            elif token == '-':
                stack.append(a - b)
            elif token == '*':
                stack.append(a * b)
            elif token == '/':
                # check if the divisor (b) is 0
                # if so, make it undefined, otherwise integer division
                if b == 0:
                    raise ZeroDivisionError("You're trying to divide by 0, numbnut! ERROR!")
                stack.append(a / b)
        else:
            # if there is a non-supported token
            raise ValueError("WRONG!!! Must be supported operator (+, -, *, /) or integer!")
        
    if len(stack) != 1:
        # in case the loop messes up
        raise ValueError("something went wrong with the calculation")
    
    return stack[0]

def main():
    # find the current directory using the os module
    directory = os.getcwd()
    # join the directory with the filename input_RPN.txt
    # hopefully yall didn't mistype the name
    filename = os.path.join(directory, 'input_RPN.txt')

    with open(filename, 'r', newline=None) as file:
        for line in file:
            try:
                ans = rpn(line)
                print(ans)
            except Exception as e:
                # in case soemthing went wrong with the program
                print(f"Error: {e}")

if __name__ == "__main__":
    main()