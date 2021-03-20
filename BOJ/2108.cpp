#include <stdio.h>
#include <math.h>
#include <vector>
#include <algorithm>
using namespace std;

int N, arr[500001], cnt[8100], most;
double sum;
vector<int> mostVal;

void quickSort(int left, int right)
{
	int leftIndex = left;
	int rightIndex = right;
	int pivot = arr[(left + right) / 2];

	while (leftIndex <= rightIndex)
	{
		while (arr[leftIndex] < pivot) leftIndex++;
		while (arr[rightIndex] > pivot) rightIndex--;

		if (leftIndex <= rightIndex)
		{
			int temp = arr[leftIndex];
			arr[leftIndex] = arr[rightIndex];
			arr[rightIndex] = temp;

			leftIndex++;
			rightIndex--;
		}
	}

	if (leftIndex < right) quickSort(leftIndex, right);
	if (left < rightIndex) quickSort(left, rightIndex);
}

int main()
{
	scanf("%d", &N);
	for (register int i = 0; i < N; i++) {
		scanf("%d", arr + i);
		sum += arr[i];
		cnt[arr[i] + 4000]++;
	}
	double temp = round(sum / N);
	int t = (int)temp;
	printf("%d\n", t);

	quickSort(0, N - 1);
	printf("%d\n", arr[N / 2]);
	for (register int i = 0; i < 8050; i++) {
		if (cnt[i] > cnt[most]) {
			most = i;
			mostVal.clear();
			mostVal.push_back(i);
		}
		else if (cnt[i] == cnt[most]) {
			mostVal.push_back(i);
		}
	}

	if (mostVal.size() > 1) {
		sort(mostVal.begin(), mostVal.end());
		printf("%d\n", mostVal[1] - 4000);
	}
	else printf("%d\n", mostVal[0] - 4000);

	printf("%d\n", arr[N - 1] - arr[0]);
	return 0;
}