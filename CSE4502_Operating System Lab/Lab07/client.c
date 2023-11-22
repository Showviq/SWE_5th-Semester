#include <stdio.h>
#include <stdlib.h>
#include <sys/ipc.h>
#include <sys/shm.h>


int linearSearch(int arr[], int size, int key) {
    for (int i = 0; i < size; i++) {
        if (arr[i] == key) {
            return i;
        }
    }
    return -1;
}

int main() {
    int shmid;
    key_t key = ftok("shared_memory_key", SHARED_MEMORY_KEY);

    if ((shmid = shmget(key, SHM_SIZE, 0666)) < 0) {
        perror("shmget");
        exit(1);
    }

    int *shm_array = (int *)shmat(shmid, NULL, 0);

    printf("Enter a value to search in the sorted array: ");
    int searchValue;
    scanf("%d", &searchValue);

    int result = linearSearch(shm_array, SHM_SIZE / sizeof(int), searchValue);

    if (result != -1) {
        printf("Value %d found at index %d in the sorted array.\n", searchValue, result);
    } else {
        printf("Value %d not found in the sorted array.\n", searchValue);
    }

    shmdt(shm_array);

    return 0;
}
