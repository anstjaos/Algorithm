#include <stdio.h>

char input[8];
int arr[8], res;

int max(int a, int b) { return (a > b ? a : b); }

int main()
{
	for (int t = 0; t < 3; t++) {
		res = 0;
		scanf("%s", input);
		arr[0] = 1;
		for (register int i = 1; i < 8; i++) {
			arr[i] = 1;
			if (input[i - 1] == input[i]) {
				arr[i] = arr[i - 1] + 1;
			}
		}

		for (register int i = 0; i < 8; i++) {
			res = max(res, arr[i]);
		}
		printf("%d\n", res);
	}
	return 0;
}