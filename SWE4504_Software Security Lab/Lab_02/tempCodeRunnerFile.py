def main():
    input_file = "top-100k-password-list.txt"
    output_file = "passwords_for_dummies.txt"

    try:
        with open(input_file, "r") as input_file:
            passwords = input_file.read().splitlines()

        filtered_passwords = [password for password in passwords if not any(char.isdigit() for char in password)]
        passwords_count = len(filtered_passwords)

        if passwords_count > 0:
            with open(output_file, "w") as output_file:
                for password in filtered_passwords:
                    output_file.write(password + "\n")
            print(f"Total passwords without digits: {passwords_count}")
        else:
            with open(output_file, "w") as output_file:
                output_file.write("No password starts with 'pass'")
            print("No password without digits found.")

    except FileNotFoundError:
        print("Input file not found.")
    except Exception as e:
        print(f"An error occurred: {e}")

if __name__ == "__main__":
    main()