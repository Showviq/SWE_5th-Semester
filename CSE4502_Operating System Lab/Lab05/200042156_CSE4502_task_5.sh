#!/bin/bash

# 'grep' ---> identify empty lines
# 'sed' ---> remove empty lines

find "." -type f -name "*.txt" -exec grep -q -E '^\s*$' {} \; -exec sed -i '/^\s*$/d' {} \;
