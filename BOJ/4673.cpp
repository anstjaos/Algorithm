#include <stdio.h>

bool check[20000];

int main()
{
	for (register int i = 1; i <= 10000; i++) {
		int temp = i;
		int sum = i;
		while (temp != 0) {
			sum += temp % 10;
			temp = temp / 10;
		}
		check[sum] = true;
	}

	for (register int i = 1; i <= 10000; i++) {
		if (!check[i]) {
			printf("%d\n", i);
		}
	}

	return 0;
}