if [ $# -ne 1 ]; then
    echo "Usage: $0 <input_string>"
    exit 1
fi

input_string="$1"
consonants="bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ"
output_string=""

for (( i=0; i<${#input_string}; i++ )); do
    char="${input_string:i:1}"
    if [[ $consonants == *"$char"* ]]; then
        output_string="${output_string}${char}"
    fi
done

echo "$output_string"
