#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>

#define MAX_SIZE 100

struct ThreadArg {
    int *arr;
    int n;
    pthread_mutex_t mutex;
};

void *FibonacciGenerator(void *arg);
void Print_array(int arr[], int len);

int main(int argc, char *argv[]) {
    if (argc != 2) {
        printf("Usage: %s <number>\n", argv[0]);
        exit(EXIT_FAILURE);
    }

    int n = atoi(argv[1]);
    int arr[MAX_SIZE];

    struct ThreadArg threadarg1;
    threadarg1.arr = arr;
    threadarg1.n = n;
    pthread_mutex_init(&threadarg1.mutex, NULL);

    struct ThreadArg threadarg2;
    threadarg2.arr = arr;
    threadarg2.n = n;
    pthread_mutex_init(&threadarg2.mutex, NULL);

    pthread_t tid1;
    pthread_t tid2;

    pthread_create(&tid1, NULL, FibonacciGenerator, &threadarg1);
    pthread_create(&tid2, NULL, FibonacciGenerator, &threadarg2);

    pthread_join(tid1, NULL);
    pthread_join(tid2, NULL);

    printf("Ans = %d\n", arr[n - 1]);
    printf("Array: ");
    Print_array(arr, n);

    pthread_mutex_destroy(&threadarg1.mutex);
    pthread_mutex_destroy(&threadarg2.mutex);

    return 0;
}

void *FibonacciGenerator(void *arg) {
    struct ThreadArg *thread_data = (struct ThreadArg *)arg;
    int *arr = thread_data->arr;

    pthread_mutex_lock(&thread_data->mutex);

    for (int i = 2; i < thread_data->n; i++) {
        arr[i] = arr[i - 1] + arr[i - 2];
    }

    pthread_mutex_unlock(&thread_data->mutex);

    pthread_exit(NULL);
}

void Print_array(int arr[], int len) {
    for (int i = 0; i < len; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}
