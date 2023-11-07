#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

void fibonacci(int n) {
    int first = 0, second = 1, next, i;
    printf("Fibonacci Series: ");
    for (i = 0; i < n; i++) {
        if (i <= 1)
            next = i;
        else {
            next = first + second;
            first = second;
            second = next;
        }
        printf("%d ", next);
    }
    printf("\n");
}

int main(int argc, char *argv[]) {
    if (argc != 2) {
        fprintf(stderr, "Usage: %s <non-negative number>\n", argv[0]);
        return -1;
    }

    int n = atoi(argv[1]);
    if (n < 0) {
        fprintf(stderr, "Please provide a non-negative number.\n");
        return -1;
    }

    pid_t pid = fork();

    if (pid < 0) {
        fprintf(stderr, "Fork failed.\n");
        return 1;
    } else if (pid == 0) {
        // Child process
        fibonacci(n);
    } else {
        // Parent process
        wait(NULL);
        printf("Child process completed.\n");
    }

    return 0;
}
