#include <iostream>
using namespace std;

int N;
long long arr[33334];

int main()
{
	cin >> N;
	arr[1] = 0;
	arr[2] = 2;

	for (int i = 3; i <= N; i++) arr[i] = (arr[i - 1] * 3) % 1000000009;

	cout << arr[N] % 1000000009 << endl;
	return 0;
}