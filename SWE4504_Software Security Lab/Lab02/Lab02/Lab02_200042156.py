import sys

def is_valid_argument(arg):
    return len(arg) <= 5 and arg.isalnum()

def print_usage_and_error():
    print("Usage: ./solve.py <first_argument> <second_argument>")
    print("Both arguments must be alphanumeric strings highest length of 5.")

if len(sys.argv) != 3:
    print_usage_and_error()
    sys.exit(1)

first_argument = sys.argv[1]
second_argument = sys.argv[2]

if not is_valid_argument(first_argument) or not is_valid_argument(second_argument):
    print("Invalid string as first or second argument.")
    print_usage_and_error()
    sys.exit(1)

try:
    with open("top-100k-password-list.txt", 'r') as file:
        passwords = []
        for line in file:
            line = line.strip() 
            if line.startswith(first_argument) and line.endswith(second_argument):
                passwords.append(line)

        if passwords:
            with open("passwords.txt", 'w') as output_file:
                for password in passwords:
                    output_file.write(password + "\n")
            print("Found passwords:")
            for password in passwords:
                print(password)
        else:
            print(f"No passwords found that start with '{first_argument}' and end with '{second_argument}'.")

except FileNotFoundError:
    print("File not found.")
except Exception as e:
    print(f"An error occurred: {str(e)}")