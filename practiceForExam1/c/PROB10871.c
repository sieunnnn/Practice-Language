#include <stdio.h>

int main() {
    int N;
    int X;
    scanf("%d %d", &N, &X);

    int numbers[N];
    for (int i = 0; i < N; i ++) {
        scanf("%d", &numbers[i]);
        if ( numbers[i] < X)
            printf("%d ", numbers[i]);
    }

    return 0;
}