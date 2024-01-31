#include <stdio.h>

int main() {
    char str[1000];
    int index = 0;

    scanf("%s", str);
    scanf("%d", &index);

    printf("%c", str[index - 1]);

    return 0;
}