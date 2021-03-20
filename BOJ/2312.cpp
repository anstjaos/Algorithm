#include <iostream>
#include <vector>
using namespace std;

bool isPrime[100001];
vector<int> primeNum;
int tc, num, result[100001], vecLen;

int main()
{
	for (register int i = 0; i < 100001; i++)
	{
		isPrime[i] = true;
	}

	for (register int i = 2; i *i< 100001; i++) {
		if (isPrime[i] == true)
		{
			for (register int j = i * i; j < 100001; j+=i) {
				isPrime[j] = false;
			}
		}
	}

	for (register int i = 2; i < 100001; i++) primeNum.push_back(i);
	vecLen = primeNum.size();
	scanf("%d", &tc);
	while (tc--)
	{
		scanf("%d", &num);
		for (register int i = 2; i < 100001; i++) result[i] = 0;

		int index = 0;
		while (num > 1)
		{
			if (num % primeNum[index] == 0) {
				num = num / primeNum[index];
				result[primeNum[index]]++;
			}
			else index++;
		}

		for (register int i = 0; i < vecLen; i++)
		{
			if (result[primeNum[i]] != 0)
			{
				printf("%d %d\n", primeNum[i], result[primeNum[i]]);
			}
		}
	}
	return 0;
}