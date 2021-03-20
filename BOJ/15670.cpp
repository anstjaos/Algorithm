#include <iostream>
using namespace std;

int N, M, start, desti;
int arr[100001];

int solve()
{
	int before = 2123456789;
	int result = 0;
	for (int i = 0; i < N; i++)
	{
		if (i == start - 1)
		{
			for (int j = desti - 1; j >= start - 1; j--)
			{
				if (before > arr[j]) result++;

				before = arr[j];
			}
			i = desti - 1;
			continue;
		}

		if (before > arr[i]) result++;
		before = arr[i];
	}

	return result;
}

int main()
{
	cin >> N >> M;

	for (int i = 0; i < N; i++)
	{
		cin >> arr[i];
	}

	for (int i = 0; i < M; i++)
	{
		cin >> start >> desti;

		cout << solve() << endl;
	}
}