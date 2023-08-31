read -p "First Name: " first_name

read -p "Middle Name: " middle_name

read -p "Last Name: " last_name

read -p "Hi $last_name, do you want to display your full name? (y/n): " choice

if [ "$choice" = "y" ]; then
    full_name="$first_name $middle_name $last_name"
    echo "Your full name is $full_name"
elif [ "$choice" = "n" ]; then
    echo "Thank you, $last_name, for your time."
else
    echo "Invalid choice. Please enter 'y' or 'n'."
fi
