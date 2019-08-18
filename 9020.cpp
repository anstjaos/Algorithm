#include <iostream>
using namespace std;

bool primeNum[10001], check[10001];
int result[10001][2], testCase, num;

void init()
{
	for (int i = 2; i < 10001; i++) primeNum[i] = true;

	for (int i = 2; i < 10001; i++)
	{
		if (primeNum[i] == true)
		{
			for (int j = i * 2; j < 10001; j = j+ i)
			{
				primeNum[j] = false;
			}
		}
	}

	for (int i = 2; i < 10001; i++)
	{
		if (primeNum[i] == true)
		{
			for (int j = i; j < 10001; j++)
			{
				if (primeNum[j] == true && i+j < 10001)
				{
					if (check[i + j] == true)
					{
						if (result[i + j][1] - result[i + j][0] > j - i)
						{
							result[i + j][0] = i;
							result[i + j][1] = j;
						}
					}
					else
					{
						result[i + j][0] = i;
						result[i + j][1] = j;
					}
					
					check[i + j] = true;
				}
			}
		}
	}
}

int main()
{
	init();
	cin >> testCase;
	for (int i = 0; i < testCase; i++)
	{
		cin >> num;
		cout << result[num][0] << " " << result[num][1] << '\n';
	}
	return 0;
}