#include <iostream>
using namespace std;

int N;
int result = 0;
void solve(int num,int cnt)
{
	if (cnt == N)
	{
		if (num % 3 == 0) result++;

		return;
	}

	for (int i = 0; i < 3; i++)
	{
		if (cnt == 0 && i == 0) continue;

		solve(num + i, cnt + 1);
	}
}

int main()
{
	cin >> N;
	solve(0, 0);

	cout << result << endl;
	return 0;
}