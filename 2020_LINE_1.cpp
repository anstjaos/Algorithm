#include <stdio.h>

int m, c, messageArr[100], consumer[100];
int min(int a, int b) { return (a < b ? a : b); }

int main()
{
	scanf("%d %d", &m, &c);
	for (register int i = 0; i < m; i++) scanf("%d", messageArr + i);

	int idx = 0;
	
	for (register int i = 0; i < m; i++)
	{
		int curTime = messageArr[i];
		int minVal = 5000;
		for (register int j = 0; j < c; j++) {
			if (consumer[j] < minVal) {
				minVal = consumer[j];
				idx = j;
			}
		}
		consumer[idx] += curTime;
	}

	int maxVal = -1;
	for (register int i = 0; i < c; i++) {
		if (consumer[i] > maxVal) {
			maxVal = consumer[i];
		}
	}

	printf("%d\n", maxVal);
	return 0;
}