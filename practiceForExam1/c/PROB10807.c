#include <stdio.h>

int main() {
    int N;
    int v;
    scanf("%d", &N); // N 입력 받기

    int numbers[N];
    int count = 0;

    for (int i = 0; i < N; i ++) { // 배열 입력 받기
        scanf("%d", &numbers[i]);
    }

    scanf("%d", &v); // v 입력 받기

    for (int j = 0; j < N; j ++) { // 비교
        if (v == numbers[j])
            count ++;
    }
    printf ("%d", count);
}