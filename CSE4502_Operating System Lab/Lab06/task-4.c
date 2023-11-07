#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int main(int argc, char *argv[]) {
    pid_t pid = fork();

    if (pid < 0) {
        fprintf(stderr, "Fork failed.\n");
        return 1;
    } else if (pid == 0) {
        // Child process
        printf("Hi, I am a Child Process\n");
        return 0;
    } else {
        // Parent process
        wait(NULL);
        printf("Child process completed.\n");
        if (argc < 2) {
            fprintf(stderr, "Usage: %s <command> [arg1] [arg2] ...\n", argv[0]);
            return -1;
        }
        execvp(argv[1], &argv[1]);
    }

    return 0;
}

