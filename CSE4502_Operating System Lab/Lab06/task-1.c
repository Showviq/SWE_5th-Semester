#include <stdio.h>
#include <unistd.h>

int main() {
    int i;
    pid_t pid;

    for (i = 0; i < 3; i++) {
        pid = fork();

        if (pid < 0) {
            printf("Fork failed");
            return 1;
        } else if (pid == 0) {
            printf("Child Process ID: %d. Parent's Process ID: %d\n", getpid(), getppid());
            break;
        } else {
            
        }
    }

    return 0;
}

