if [[ $1 = "-h"]]; then
    echo *- ./reverse_integer.sh prints numbers in reverse order, each in a new line.*
    echo *- Syntax: ./reverse_integer.sh <number_1> <number_2> ... <number_N>*
    echo *-- Parameter 1 <number_1>: First number to be printed in reverse.*
    echo *-- Parameter 2 <number_2>: Second number to be printed in reverse.*
    exit 1
fi
if [ $# -eq 0 ]; then
    echo "Please provide the correct input in the below format.
Usage: $0 number"
    exit 1
fi
for num in "$@"; do
    number=$num
    rev=""
    while [ $num -gt 0]; do
        digit=$((num % 10))
        rev = "${rev}${digit}"
        num=$((num / 10))
    done
    echo "Reverse of $number is $rev"
done
