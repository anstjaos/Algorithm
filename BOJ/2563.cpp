#include <stdio.h>

#define MAX_SIZE 101

int cnt, row, col, arr[MAX_SIZE][MAX_SIZE], res;

int main()
{
	scanf("%d", &cnt);
	for (register int i = 0; i < cnt; i++) {
		scanf("%d %d", &row, &col);
		for (register int i = 0; i < 10; i++) {
			for (register int j = 0; j < 10; j++) {
				arr[row+i][col+j] = 1;
			}
		}
	}

	for (register int i = 0; i < MAX_SIZE; i++) {
		for (register int j = 0; j < MAX_SIZE; j++) {
			res += arr[i][j];
		}
	}

	printf("%d\n", res);
	return 0;
}