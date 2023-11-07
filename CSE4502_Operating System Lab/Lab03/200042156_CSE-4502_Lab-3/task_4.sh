#!/bin/bash

# Function to create directories and files recursively
create_structure() {
    local dir_path="$1"
   
    echo "Creating directory: $dir_path"
    mkdir -p "$dir_path"

    while true; do
        read -p "Do you want to create a file in this directory? (yes/no): " choice
        case "$choice" in
            [Yy]* )
                read -p "Enter the file name: " file_name
                touch "$dir_path/$file_name"
                ;;
            [Nn]* ) break;;
            * ) echo "Please answer yes or no.";;
        esac
    done

    while true; do
        read -p "Do you want to create a subdirectory in this directory? (yes/no): " choice
        case "$choice" in
            [Yy]* )
                read -p "Enter the subdirectory name: " sub_dir_name
                create_structure "$dir_path/$sub_dir_name"
                ;;
            [Nn]* ) break;;
            * ) echo "Please answer yes or no.";;
        esac
    done
}

# Ask the user for the root directory name
read -p "Enter the root directory name: " root_dir_name

# Call the function to create the directory structure
create_structure "$root_dir_name"

echo "Directory structure creation completed."
