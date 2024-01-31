#include <stdio.h>

void main() {
    int number, i, j;
    scanf("%d", &number);

    for (i = 1; i <= number; i ++) {
        for (j = 1; j <= i; j ++)
            printf("*");
        printf("\n");
    }
}