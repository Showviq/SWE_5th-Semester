if [ $# -eq 0 ]; then
    echo "Please provide the correct input in the below format.
Usage: $0 number"
    exit 1
fi
for num in "$@"; do
    number=$num
    reverse=""
    while [ $num -gt 0 ]; do
        digit=$((num % 10))
        reverse="${reverse}${digit}"
        num=$((num / 10))
    done
    echo "Reverse of $number is $reverse"
done

