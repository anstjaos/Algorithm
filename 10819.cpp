#include <iostream>
using namespace std;

int N;
int arr[9];
bool check[9];
int maxNum = -21234567;

void solve(int sum, int cnt, int from)
{
	if (cnt == N-1 )
	{
		if (sum > maxNum) maxNum = sum;
		return;
	}

	for (int i = 0; i < N; i++)
	{
		if (check[i] == false)
		{
			check[i] = true;
			int temp = abs(arr[from] - arr[i]);
			solve(sum + temp, cnt + 1,i);
			check[i] = false;
		}
	}
}

int main()
{
	cin >> N;
	for (int i = 0; i < N; i++) cin >> arr[i];

	for (int i = 0; i < N; i++)
	{
		check[i] = true;
		solve(0, 0, i);
		check[i] = false;
	}

	cout << maxNum << endl;
}