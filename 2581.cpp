#include <iostream>
using namespace std;

bool primeNum[10001];
int M, N, minPrime;

void init()
{
	for (int i = 2; i < 10001; i++) primeNum[i] = true;

	for (int i = 2; i *i < 10001; i++)
	{
		if (primeNum[i] == true)
		{
			for (int j = i * i; j < 10001; j += i) primeNum[j] = false;
		}
	}
}

int primeSum()
{
	int sum = 0;
	for (int i = M; i <= N; i++)
	{
		if (primeNum[i] == true)
		{
			sum += i;
			if (minPrime == 2123456789) minPrime = i;
		}
	}

	return sum;
}

int main()
{
	init();
	minPrime = 2123456789;
	cin >> M >> N;

	int result = primeSum();
	if (result == 0)
	{
		cout << "-1" << endl;
		return 0;
	}
	cout << result << endl << minPrime << endl;
	return 0;
}