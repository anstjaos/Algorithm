#include <iostream>
using namespace std;

int N, M, cube[1003], goNext[1003];

int solve()
{
	int count = 0;
	int cur = 1;

	while (cur < N)
	{
		cur = cur + goNext[count];
		count++;
		cur = cur + cube[cur];
	}
	return count;
}

int main()
{
	cin >> N >> M;

	for (int i = 1; i <= N; i++) cin >> cube[i];
	for (int j = 0; j < M; j++) cin >> goNext[j];

	int result = solve();
	cout << result << '\n';
	return 0;
}