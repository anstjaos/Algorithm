#include <iostream>
#include <algorithm>
using namespace std;

int tc, arr[100001], N;
int result;

int max(int a, int b) { return (a > b ? a : b); }

bool comp(const int &a, const int &b)
{
	return a > b;
}

int main()
{
	scanf("%d", &tc);
	while (tc--)
	{
		scanf("%d", &N);
		for (int i = 0; i < N; i++) scanf("%d", &arr[i]);
		sort(arr, arr + N, comp);
		result = max(arr[0] - arr[1], arr[0] - arr[2]);
		for (int i = 1; i < N-2; i++)
		{
			result = max(result, arr[i] - arr[i + 2]);
		}

		printf("%d\n", result);
	}

	return 0;
}