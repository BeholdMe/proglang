# create the functions to add two numbers and return sum
def add(num1, num2):
    return num1 + num2

# create the functions to subtract number 2 from number 1 and return difference
def subtract(num1, num2):
    return num1 - num2

# create the functions to multiply two numbers and return sum
def multiply(num1, num2):
    return num1 * num2

# create the functions to divide number 1 by number 2 and return result
def divide(num1, num2):
    #make sure y is not 0 b/c that will cause an error
    if num2 == 0.0:
        return "You can't divide by 0 in this universe!"
    else:
        return num1 / num2


def calculator():
    #create the number variables and operators to
    #make sure the computer know it is the right daata type (float and String)
    num1 = 0.0
    num2 = 0.0
    operator = ""
    answer = 0.0
    inStr = ""

    # keep asking user until either user quits or 
    while True:
        # ask the user for inputs (num1, num2)
        inStr = input("Enter expression (or Q to quit): ")
        if inStr == 'q' or inStr == 'Q':
            print("Exiting...")
            break


        try:
            inStrAsSeparate = inStr.split(" ") # split by spaces
            if len(inStrAsSeparate) != 3:
                print("There is NOT exactly two numbers with an operator in the middle, and the three are separated by spaces.")
                continue
            # Set the three separate strings into num1, operator, and num2 respectively
            num1, operator, num2 = inStrAsSeparate
            num1 = float(num1)
            num2 = float(num2)
        except IndexError:
            print("Something went wrong with your expression")
            continue
        except ValueError:
            print("Numbers are not floating point numbers. Please enter NUMBERS!")
            continue

        # Use operator to choose the function
        if operator == '+':
            answer = add(num1, num2)
        elif operator == '-':
            answer = subtract(num1, num2)
        elif operator == '-':
            answer = subtract(num1, num2)
        elif operator == '-':
            answer = subtract(num1, num2)
        else:
            print("You did not type an OPERATOR (+, -. *, /)! Please type one of those operators")
            continue

        print("Result: " answer)