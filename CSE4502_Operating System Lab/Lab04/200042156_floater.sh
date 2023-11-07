if [[ $1 = "-h"]]; then
    echo *- ./floater.sh prints the string representation of the floating-point quotient of two numbers that are not divisible by one another, up to n-significant digits.*
    echo *- Syntax: ./floater.sh <number_1> <number_2> <number_3>*
    echo *-- Parameter 1 <number_1>: Dividend.*
    echo *-- Parameter 2 <number_2>: Divisor must be greater than zero*
    echo *-- Parameter 3 <number_3>: Number of significant digits after tbe decimal point.*
    exit 1
fi
if [ "$#" -ne 3 ]; then
  echo "Usage: floater.sh <dividend> <divisor> <significant_digits>"
  exit 1
fi

dividend="$1"
divisor="$2"
significant_digits="$3"

if [ "$divisor" -eq 0 ]; then
  echo "Error: Division by zero Error !!. For more information type: ./floater.sh -h" 
  exit 1
fi


quotient=$(echo "scale=$significant_digits; $dividend / $divisor" | bc)


rounded_quotient=$(printf "%.${significant_digits}f" "$quotient")

echo "Result: $rounded_quotient"
