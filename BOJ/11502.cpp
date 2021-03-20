#include <iostream>
using namespace std;

bool prime[1001];
int testCase, K;
int result[3];

void init()
{
	for (int i = 2; i < 1001; i++) prime[i] = true;

	for (int i = 2; i *i < 1001; i++)
	{
		if (prime[i] == true)
		{
			for (int j = i * i; j < 1001; j += i) prime[j] = false;
		}
	}
}

bool dfs(int num, int cnt)
{
	if (cnt == 3)
	{
		int temp = 0;
		for (int i = 0; i < 3; i++) temp += result[i];

		if (temp == K) return true;

		return false;
	}

	for (int i = num ; i >= 2; i--)
	{
		if (prime[i] == true)
		{
			result[cnt] = i;
			if(dfs(num - i, cnt + 1) == true) return true;
		}
	}
	return false;
}

int main()
{
	init();
	scanf("%d", &testCase);

	for (int i = 0; i < testCase; i++)
	{
		scanf("%d", &K);
		if (dfs(K,0) == true)
		{
			for (int j = 2; j >= 0; j--) printf("%d ", result[j]);
		} 
		else printf("0");
		printf("\n");
	}
}