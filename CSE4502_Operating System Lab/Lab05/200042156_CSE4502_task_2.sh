#!/bin/bash

# Specify the root directory

dir="."


mkdir -p "$dir/last7days"
mkdir -p "$dir/last30days"

# 'mv' ---> move them to the respective subdirectories
find "$dir" -type f -mtime -7 -exec mv {} "$dir/last7days" \;
find "$dir" -type f -mtime +7 -mtime -30 -exec mv {} "$dir/last30days" \;

