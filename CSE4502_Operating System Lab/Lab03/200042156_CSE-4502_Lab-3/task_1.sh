#!/bin/bash

# Check if two arguments are provided
if [ $# -ne 2 ]; then
    echo "Usage: $0 <directory1> <directory2>"
    exit 1
fi

dir1="$1"
dir2="$2"

# Check if both directories exist
if [ ! -d "$dir1" ] || [ ! -d "$dir2" ]; then
    echo "Error: Both directories must exist."
    exit 1
fi

# Compare files in directory1 with directory2
echo "Files present in $dir1 but not in $dir2:"
find "$dir1" -type f | while read -r file; do
    file_rel_path="${file#$dir1/}" # Get relative path of the file in dir1
    if [ ! -e "$dir2/$file_rel_path" ]; then
        echo "$file_rel_path"
    fi
done

# Compare files in directory2 with directory1
echo "Files present in $dir2 but not in $dir1:"
find "$dir2" -type f | while read -r file; do
    file_rel_path="${file#$dir2/}" # Get relative path of the file in dir2
    if [ ! -e "$dir1/$file_rel_path" ]; then
        echo "$file_rel_path"
    fi
done
