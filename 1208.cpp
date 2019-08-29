#include <stdio.h>

int nArr[1 << 21], mArr[1 << 21], N, S, input[41];

void quickSort(int *arr, const int left, const int right)
{
	int leftIndex = left;
	int rightIndex = right;
	int pivot = arr[(left + right) / 2];

	while (leftIndex <= rightIndex)
	{
		while (arr[leftIndex] < pivot) {
			if (leftIndex == right) break;
			leftIndex++;
		}
		while (arr[rightIndex] > pivot) {
			if (rightIndex == left) break;
			rightIndex--;
		}
		
		if (leftIndex <= rightIndex) {
			int temp = arr[leftIndex];
			arr[leftIndex] = arr[rightIndex];
			arr[rightIndex] = temp;

			leftIndex++;
			rightIndex--;
		}
	}

	if (leftIndex < right) quickSort(arr, leftIndex, right);
	if (left < rightIndex) quickSort(arr, left, rightIndex);
}

int main()
{
	scanf("%d %d", &N, &S);
	for (register int i = 0; i < N; i++) scanf("%d", &input[i]);
	int m = N / 2;
	N -= m;

	for (register int i = 0; i < (1 << N); i++) {
		for (register int j = 0; j < N; j++) {
			if (i & (1 << j)) {
				nArr[i] += input[j];
			}
		}
	}

	for (register int i = 0; i < (1 << m); i++) {
		for (register int j = 0; j < m; j++) {
			if (i & (1 << j)) {
				mArr[i] += input[N + j];
			}
		}
	}

	quickSort(nArr, 0, (1 << N) -1);
	quickSort(mArr, 0, (1 << m) - 1);

	N = (1 << N);
	m = (1 << m);

	register int i = 0, j = m - 1;

	long long res = 0;
	while (i < N && j >= 0)
	{
		if (nArr[i] + mArr[j] == S) {
			long long nCnt = 1;
			long long mCnt = 1;
			i++;
			j--;

			while (i < N && nArr[i] == nArr[i - 1]) {
				nCnt++;
				i++;
			}

			while (j >= 0 && mArr[j] == mArr[j + 1]) {
				mCnt++;
				j--;
			}

			res += nCnt * mCnt;
		}
		else if (nArr[i] + mArr[j] < S) {
			i++;
		}
		else j--;
	}

	if (S == 0) res -= 1;
	printf("%lld\n", res);
	return 0;
}