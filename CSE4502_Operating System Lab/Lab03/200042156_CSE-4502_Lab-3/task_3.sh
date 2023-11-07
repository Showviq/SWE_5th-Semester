#!/bin/bash

# Check if an argument (the directory path) is provided
if [ $# -ne 1 ]; then
    echo "Usage: $0 <directory>"
    exit 1
fi

directory="$1"
extension=".txt"  # Change this to your desired file extension

# Check if the directory exists
if [ ! -d "$directory" ]; then
    echo "Error: Directory not found."
    exit 1
fi

# Iterate through files with the specified extension in the directory
for file in "$directory"/*"$extension"; do
    if [ -f "$file" ]; then
        # Get the current date and time as a prefix
        timestamp=$(date "+%Y%m%d%H%M%S")
       
        # Extract the original file name and extension
        filename=$(basename "$file")
        file_extension="${filename##*.}"
        filename_noext="${filename%.*}"
       
        # Rename the file with the timestamp prefix
        new_filename="${timestamp}_${filename_noext}.${file_extension}"
       
        # Perform the rename
        mv "$file" "$directory/$new_filename"
       
        echo "Renamed: $filename to $new_filename"
    fi
done

echo "Renaming completed."


