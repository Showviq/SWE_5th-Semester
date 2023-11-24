#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>

#define M 2
#define K 3
#define N 4

int a[M][K] = {{1, 4, 1}, {3, 6, 8}};
int b[K][N] = {{13, 4, 56, 3}, {5, 9, 3, 5}, {3, 1, 4, 9}};
int c[M][N];

struct ThreadArg {
    int row;
    int col;
};

void *MatrixMultiplication(void *params);

int main() {
    pthread_t t[M * N];

    for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
            struct ThreadArg *threadarg = (struct ThreadArg *)malloc(sizeof(struct ThreadArg));
            threadarg->row = i;
            threadarg->col = j;
            printf("i, j = %d, %d\n", i, j);
            pthread_create(&t[i * N + j], NULL, MatrixMultiplication, (void *)threadarg);
        }
    }

    for (int i = 0; i < M * N; i++) {
        pthread_join(t[i], NULL);
    }

    // Print the result matrix
    printf("Result Matrix:\n");
    for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
            printf("%d ", c[i][j]);
        }
        printf("\n");
    }

    return 0;
}

void *MatrixMultiplication(void *params) {
    struct ThreadArg *thread_data = (struct ThreadArg *)params;
    int row = thread_data->row;
    int col = thread_data->col;

    int sum = 0;
    for (int k = 0; k < K; k++) {
        sum += a[row][k] * b[k][col];
    }

    c[row][col] = sum;
    printf("c[%d][%d] = %d\n", row, col, c[row][col]);

    free(params);
    pthread_exit(NULL);
}
