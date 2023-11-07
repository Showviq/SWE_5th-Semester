if [ $# -ne 1 ]; then
    echo "Usage: $0 <password>"
    exit 1
fi

password=$1


if [ ${#password} -lt 8 ]; then
    echo "Week Password -> Password length should have at least 8 characters."
    exit 0
fi

if ! [[ "$password" =~ [[:alpha:]] ]]; then
    echo "Week Password -> Should use an alphabet."
    exit 0
fi

if ! [[ "$password" =~ [[:digit:]] ]]; then
    echo "Week Password -> Should use a number."
    exit 0
fi

if ! [[ "$password" =~ [[:lower:]] ]]; then
    echo "Week Password -> Should include a lower-case letter."
    exit 0
fi 

if ! [[ "$password" =~ [[:upper:]] ]]; then
    echo "Week Password -> Should include an upper-case letter."
    exit 0
fi

echo "Strong Password"

