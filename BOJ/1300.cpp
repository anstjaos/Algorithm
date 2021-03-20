#include <iostream>
using namespace std;

int N, K, answer;

int min(int a, int b) { return (a < b ? a : b); }

int main()
{
	scanf("%d %d", &N, &K);
	int left = 1, right = K;

	while (left <= right)
	{
		int mid = (left + right) / 2;

		long long sum = 0;
		for (int i = 1; i <= N; i++)
		{
			sum += min(N, mid / i);
		}

		if (sum >= K) {
			right = mid - 1;
			answer = mid;
		}
		else left = mid + 1;
	}

	printf("%d\n", answer);
	return 0;
}