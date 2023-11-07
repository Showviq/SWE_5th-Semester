#!/bin/bash

# 'find' ---> locate files 
# 'sed' --->  extract file extensions
# 'sort' || 'uniq' ---> count && summarize file types

find . -type f | sed -n 's/.*\.\([^.]*\)$/\1/p' | sort | uniq -c
