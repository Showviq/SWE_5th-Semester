#!/bin/bash

# Check for the correct number of arguments
if [ "$#" -ne 3 ]; then
    echo "Usage: $0 <directory> <size> <large_files_directory>"
    exit 1
fi

# Assign script arguments to variables
search_dir="$1"
min_size="$2"
large_files_dir="$3"

# Create the "large_files" directory if it doesn't exist
mkdir -p "$large_files_dir"

# Use find to locate files larger than the specified size and move them
find "$search_dir" -type f -size +"$min_size"c -exec mv {} "$large_files_dir" \;

echo "Files larger than $min_size bytes have been moved to $large_files_dir."
