#include <iostream>
using namespace std;

int bitCnt[101][101][2];
int testCase, n, k;


void init()
{
	bitCnt[1][0][0] = 1;
	bitCnt[1][1][1] = 1;
	bitCnt[2][0][0] = 2;
	bitCnt[2][0][1] = 1;
	bitCnt[2][1][0] = 0;
	bitCnt[2][1][1] = 1;

	for (int i = 3; i < 101; i++)
	{
		for (int j = 0; j < i; j++)
		{
			for (int k = 0; k < 2; k++)
			{
				if (k == 0) bitCnt[i][j][k] = bitCnt[i - 1][j][0] + bitCnt[i - 1][j][1];
				else
				{
					if (j == 0) bitCnt[i][j][k] = bitCnt[i - 1][j][0];
					else bitCnt[i][j][k] = bitCnt[i - 1][j][0] + bitCnt[i - 1][j - 1][1];
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
		cin >> n >> k;
		int result = bitCnt[n][k][0] + bitCnt[n][k][1];

		cout << result << endl;
	}
}