#include <iostream>
using namespace std;

int N, arr[10001], num, maxNum;

int max(int a, int b) { return (a > b ? a : b); }

int main()
{
	scanf("%d", &N);
	for (register int i = 0; i < N; i++) {
		scanf("%d", &num);
		arr[num]++;
		maxNum = max(maxNum, num);
	}

	for (register int i = 0; i <= maxNum; i++) {
		while (arr[i] != 0) {
			printf("%d\n", i);
			arr[i]--;
		}
	}
	return 0;
}