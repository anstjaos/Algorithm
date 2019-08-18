#include <iostream>
#include <string>
using namespace std;

int numCnt, numArr[10], tc, result;
string input;
bool isPrime[10000001], visit[10], check[10000001];

void setPrime()
{
	for (int i = 2; i < 10000001; i++)
	{
		isPrime[i] = true;
	}

	for (int i = 2; i *i < 10000001; i++)
	{
		if (isPrime[i] == true)
		{
			for (int j = i * i; j < 10000001; j += i)
			{
				isPrime[j] = false;
			}
		}
	}
}

void init()
{
	cin >> input;
	numCnt = 0;
	result = 0;
	for (int i = 0; i < 10; i++) visit[i] = false;
	for (int i = 0; i < 10000001; i++) check[i] = false;
}

void dfs(int cnt, int num,int size)
{
	if (isPrime[num] == true) result++;
	if (cnt == size)
	{
		return;
	}

	for (int i = 0; i < size; i++)
	{
		if (cnt == 0 && input[i]-'0' == 0) continue;

		if (visit[i] == true) continue;

		if (check[num * 10 + (input[i] -'0')] == false)
		{
			check[num * 10 + (input[i]-'0')] = true;
			visit[i] = true;
			dfs(cnt + 1, num * 10 + (input[i] - '0'), size);
			visit[i] = false;
		}
		
	}
}

int main()
{
	scanf("%d", &tc);
	setPrime();
	for(int i = 0 ; i < tc; i++)
	{
		init();
		int size = input.size();
		dfs(0, 0,size);

		printf("%d\n", result);
	}

	return 0;
}