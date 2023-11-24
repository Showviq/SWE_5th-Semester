#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

struct ThreadArg
{
    int *primes;  // Dynamic array to store prime numbers
    int count;    // Number of primes found
    int max;      // Maximum value to check for primes
};

void *PrimeGenerator(void *threadArg);

int main(int argc, char *argv[])
{
    if (argc != 2)
    {
        printf("Usage: %s <number>\n", argv[0]);
        exit(EXIT_FAILURE);
    }

    int n = atoi(argv[1]);

    // Create a dynamic array to store prime numbers
    int *primes = (int *)malloc(n * sizeof(int));

    // Initialize the ThreadArg structure
    struct ThreadArg threadArg;
    threadArg.primes = primes;
    threadArg.count = 0;
    threadArg.max = n;

    pthread_t tid;

    pthread_create(&tid, NULL, PrimeGenerator, &threadArg);

    pthread_join(tid, NULL);

    // Print the prime numbers
    for (int i = 0; i < threadArg.count; i++)
    {
        printf("%d is a Prime\n", primes[i]);
    }

    // Free the allocated memory
    free(primes);

    return 0;
}

void *PrimeGenerator(void *threadArg)
{
    struct ThreadArg *args = (struct ThreadArg *)threadArg;

    for (int i = 2; i <= args->max; i++)
    {
        int isPrime = 1;

        // Check if i is prime
        for (int j = 2; j <= sqrt(i); j++)
        {
            if (i % j == 0)
            {
                isPrime = 0;
                break;
            }
        }

        // If i is prime, add it to the array
        if (isPrime)
        {
            args->primes[args->count++] = i;
        }
    }

    pthread_exit(NULL);
}
