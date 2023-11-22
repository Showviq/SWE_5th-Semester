#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>
#include <sys/wait.h>

void generateFibonacci(int n) {
    unsigned long long first = 0, second = 1, next;

    for (int i = 0; i < n; i++) {
        printf("%llu ", first);
        next = first + second;
        first = second;
        second = next;
    }

    printf("\n");
}

int main(int argc, char *argv[]) {
    if (argc != 2) {
        fprintf(stderr, "Usage: %s <number_of_fibonacci_numbers>\n", argv[0]);
        exit(EXIT_FAILURE);
    }

    int n = atoi(argv[1]);

    if (n <= 0) {
        fprintf(stderr, "Please enter a positive number.\n");
        exit(EXIT_FAILURE);
    }

    pid_t child_pid = fork();

    if (child_pid < 0) {
        perror("fork");
        exit(EXIT_FAILURE);
    }

    if (child_pid == 0) {
        // Child process
        generateFibonacci(n);
        exit(EXIT_SUCCESS);
    } else {
        // Parent process
        waitpid(child_pid, NULL, 0);
    }

    return 0;
}
