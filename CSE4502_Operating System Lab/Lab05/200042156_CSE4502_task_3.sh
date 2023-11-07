#!/bin/bash

# 'find' ---> locate files 
# 'sed' ---> perform text replacements

find "." -type f -exec sed -i 's/text_1/text_2/g' {} \;
