#include <iostream>
using namespace std;

int testCase;
int a, b;
bool primeNum[INT_MAX];
int aArr[1000001], bArr[1000001], aCnt, bCnt;


void init()
{
	aCnt = bCnt = 0;
	for (int i = 2; i * i <= INT_MAX; i++)
	{
		if (primeNum[i] == false)
		{
			for (int j = i * 2; j < INT_MAX; j += i) primeNum[j] = true;
		}
	}
}

bool solve()
{
	int tempA = a;
	int tempB = b;
	if (a < 0) tempA = tempA * -1;
	if (b < 0) tempB = tempB * -1;

	while (tempA != 1)
	{

	}
}

int main()
{
	cin >> testCase;

	for (int i = 0; i < testCase; i++)
	{
		cin >> a >> b;
	}
}