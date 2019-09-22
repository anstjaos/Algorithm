#include <stdio.h>

int N, seat[20005], maxVal;

int max(int a, int b) { return (a > b ? a : b); }
int min(int a, int b) { return (a < b ? a : b); }

int main()
{
	scanf("%d", &N);
	for (register int i = 0; i < N; i++) scanf("%d", seat + i);

	for (register int i = 0; i < N; i++) {
		if (seat[i] == 0) {
			int left = 20000;
			int right = 20000;
			for (register int j = 1; i - j >= 0; j++) {
				if (seat[i - j] == 1) {
					left = j;
					break;
				}
			}

			for (register int j = 1; i + j < N; j++) {
				if (seat[i + j] == 1) {
					right = j;
					break;
				}
			}
			maxVal = max(maxVal, min(left, right));
		}
	}

	printf("%d\n", maxVal);
	return 0;
}