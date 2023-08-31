if [ $# -ne 1 ]; then
    echo "Usage: $0 <n>"
    exit 1
fi

n=$1

fibonacci() {
    local n=$1
    a=1
    b=1
    echo "Fibonacci Series starting from 1 up to $n digits:"
    for ((i = 1; i <= n; i++)); do
        if [ "$i" -eq 1 ]; then
            echo -n "$a "
        else
            echo -n "$\nb "
            fn=$((a + b))
            a=$b
            b=$fn
        fi
    done
    echo
}

fibonacci "$n"

