#!/bin/bash

# Function to calculate the size of a directory and its subdirectories
calculate_size() {
    local dir_path="$1"
    local total_size=0

    # Use find to get a list of all files in the directory and its subdirectories
    # Calculate the size of each file and sum them up
    while IFS= read -r -d '' file; do
        if [ -f "$file" ]; then
            file_size=$(stat -c %s "$file")
            total_size=$((total_size + file_size))
        fi
    done < <(find "$dir_path" -type f -print0)

    echo "$total_size"
}

# Ask the user for the directory path
read -p "Enter the directory path: " directory_path

# Call the function to calculate the size
total_size_bytes=$(calculate_size "$directory_path")

# Convert the size to human-readable format
if [ "$total_size_bytes" -ge 1000000000 ]; then
    total_size=$(echo "scale=2; $total_size_bytes / 1000000000" | bc)
    size_unit="GB"
elif [ "$total_size_bytes" -ge 1000000 ]; then
    total_size=$(echo "scale=2; $total_size_bytes / 1000000" | bc)
    size_unit="MB"
elif [ "$total_size_bytes" -ge 1000 ]; then
    total_size=$(echo "scale=2; $total_size_bytes / 1000" | bc)
    size_unit="KB"
else
    total_size="$total_size_bytes"
    size_unit="bytes"
fi

echo "Total size of files in $directory_path: $total_size $size_unit"

