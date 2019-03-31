#include <iostream>
using namespace std;

int N, x, y;
int arr[1000001];
int rnd, cnt;

bool solve(int count)
{
	int temp = 1;
	for (int i = 1; i <= N; i++)
	{
		arr[i] = temp;
		if (i % count == 0) temp++;
	}

	if (arr[x] == arr[y]) return true;
	return false;
}

int main()
{
	cin >> N >> x >> y;
	rnd = 0;
	cnt = 2;
	while (1)
	{
		rnd++;
		if (solve(cnt) == true)break;

		cnt *= 2;
	}

	cout << rnd << endl;
	return 0;
}