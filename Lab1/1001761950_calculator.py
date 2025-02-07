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
        return "You can't divide by 0 yet!"
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
            break


        try:
            inStrAsSeparate = inStr.split(" ") # split by spaces
        except IndexError:
            print("Something went wrong with your expression")
            continue

        # Check that first and last elements in inStrAsSeparate are numbers (specifically floats)
        # Check that the second element is one of +, -, *, /
        # 