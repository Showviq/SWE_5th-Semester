try:
    input_string = input("Enter a string (max length 5): ").strip()
    
    if not input_string:
        print("String is empty.")
    elif len(input_string) > 5:
        print("String length is more than 5 characters.")
    else:
        with open("top-100k-password-list.txt", 'r') as file:
            passwords = []
            for line in file:
                line = line.strip()  
                if input_string not in line:
                    passwords.append(line)

            if passwords:
                print("Passwords that do not contain '{}' as a substring:".format(input_string))
                for password in passwords:
                    print(password)
            else:
                print(f"No password contains '{input_string}'.")

except FileNotFoundError:
    print("File not found.")
except Exception as e:
    print(f"An error occurred: {str(e)}")