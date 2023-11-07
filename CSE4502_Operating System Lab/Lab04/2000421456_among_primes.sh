if [ "$#" -ne 2 ]; then
  echo "Usage: among_primes.sh <lower_limit> <upper_limit>"
  exit 1
fi

lower_limit="$1"
upper_limit="$2"

is_prime() {
  local num="$1"
  if [ "$num" -le 1 ]; then
    return 1
  fi
  for ((i = 2; i * i <= num; i++)); do
    if [ "$((num % i))" -eq 0 ]; then
      return 1
    fi
  done
  return 0
}

echo "List of Primes: [$lower_limit to $upper_limit]:"
for ((num = lower_limit; num <= upper_limit; num++)); do
  if is_prime "$num"; then
    echo "$num"
  fi
done

echo "List of Non-Primes [$lower_limit to $upper_limit]:"
for ((num = lower_limit; num <= upper_limit; num++)); do
  if ! is_prime "$num"; then
    echo "$num"
  fi
done
