#include <iostream>
using namespace std;

long long num = 1, N;
long long result = 0;

int main()
{
	cin >> N;
	for (long long  i = 1; i < N; i++)
	{
		result += (N*i + i);
	}

	cout << result << endl;
	return 0;
}