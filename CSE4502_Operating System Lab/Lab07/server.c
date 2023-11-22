#include <stdio.h>
#include <stdlib.h>
#include <sys/ipc.h>
#include <sys/shm.h>

void quickSort(int arr[], int low, int high) {
    if (low < high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        int pi = i + 1;

        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}

int main() {
    int shmid;
    key_t key = ftok("shared_memory_key", SHARED_MEMORY_KEY);

    if ((shmid = shmget(key, SHM_SIZE, IPC_CREAT | 0666)) < 0) {
        perror("shmget");
        exit(1);
    }

    int *shm_array = (int *)shmat(shmid, NULL, 0);

    printf("Enter five integers:\n");
    for (int i = 0; i < 5; i++) {
        scanf("%d", &shm_array[i]);
    }

    quickSort(shm_array, 0, 4);

    printf("Sorted array using QuickSort:\n");
    for (int i = 0; i < 5; i++) {
        printf("%d ", shm_array[i]);
    }
    printf("\n");

    shmdt(shm_array);

    return 0;
}
