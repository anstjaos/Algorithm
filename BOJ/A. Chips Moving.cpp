#include <stdio.h>
#include <math.h>
using namespace std;

int N, arr[101], num[101], numSize;
int res = 2123456789;

int min(int a, int b) { return (a < b ? a : b); }

int main()
{
	scanf("%d", &N);
	for (register int i = 0; i < N; i++) {
		scanf("%d", &arr[i]);
		
		bool isFind = false;
		for (register int j = 0; j < numSize; j++) {
			if (num[j] == arr[i]) {
				isFind = true;
				break;
			}
		}

		if (!isFind) num[numSize++] = arr[i];
	}

	for (register int i = 0; i < numSize; i++) {
		int sum = 0;
		for (register int j = 0; j < N; j++) {
			if (abs(num[i] - arr[j]) & 1) sum += 1;
		}

		res = min(res, sum);
	}

	printf("%d\n", res);
	return 0;
}