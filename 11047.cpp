#include <iostream>
using namespace std;

int coinCnt, K;
int coin[11];
int result = 0;

int main()
{
	int start = 0;
	cin >> coinCnt>> K;
	for (int i = 0; i < coinCnt; i++)
	{
		cin >> coin[i];
		if (coin[i] <= K) start = i;
	}

	while (K != 0)
	{
		if (start == -1) break;
		if (coin[start] <= K)
		{
			result += K / coin[start];
			K = K - (K/coin[start] * coin[start]);
		}

		start--;
	}

	cout << result << endl;
	return 0;
}