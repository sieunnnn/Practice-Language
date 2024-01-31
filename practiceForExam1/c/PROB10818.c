#include <stdio.h>

int main() {
    int N;
    scanf("%d", &N);

    int numbers[N];
    for (int i = 0; i < N; i ++) {
        scanf("%d", &numbers[i]);
    }

    int min = numbers[0];
    int max = numbers[0];
    for (int j = 0; j < N; j ++) {
        if (numbers[j] < min) {
            min = numbers[j];
        }
        if (numbers[j] > max) {
            max = numbers[j];
        }
    }

    printf("%d %d", min, max);
}