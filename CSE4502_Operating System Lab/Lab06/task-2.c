#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>

int main() {
    int variable = 0;
    int studentID = 156;
    pid_t pid;

    pid = fork();

    if (pid < 0) {
        fprintf(stderr, "Fork failed");
        return 1;
    } else if (pid == 0) {
        // Child process
        variable += studentID;
        printf("Child Process - Updated Variable Value: %d\n", variable);
    } else {
        // Parent process
        wait(NULL); // Wait for the child process to finish
        variable += studentID;
        printf("Parent Process - Updated Variable Value: %d\n", variable);
    }

    return 0;
}

