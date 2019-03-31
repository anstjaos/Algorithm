#include <iostream>
#include <string>
using namespace std;

string scroll, bridge[2];
int dp[2][101][21];

int numOfWay(int col, int row, int index)
{
	if (index == scroll.length()) return 1;

	int &result = dp[col][row][index];
	
	if (result != -1) return result;

	result = 0;
	int len = bridge[0].length();
	for (int i = row; i < len; i++)
	{
		if (bridge[col][i] == scroll[index])
		{
			result += numOfWay(1 - col, i + 1, index + 1);
		}
	}
	return result;
}

int main()
{
	cin >> scroll;

	for (int i = 0; i < 2; i++) cin >> bridge[i];

	for (int i = 0; i < 2; i++)
	{
		for (int j = 0; j < 101; j++)
		{
			for (int k = 0; k < 21; k++) dp[i][j][k] = -1;
		}
	}

	int result = 0;

	result += numOfWay(0, 0, 0);
	result += numOfWay(1, 0, 0);

	cout << result << endl;
	return 0;
}
