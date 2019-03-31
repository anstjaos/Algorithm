#include <iostream>
using namespace std;

int row, col;
char board[51][51];
int result = 2123456789;
char pattern[2][8] = { {'W','B','W','B', 'W','B', 'W','B'},
						{ 'B','W','B','W','B','W','B','W'} };

void solve(int x, int y, int patternNum)
{
	int temp = patternNum;
	int cnt = 0;
	for (int i = 0; i < 8; i++)
	{
		for (int j = 0; j < 8; j++)
		{
			if (board[x + i][y + j] != pattern[temp][j])
			{
				cnt++;
			}
		}
		temp = (temp + 1) % 2;
		if (cnt > result) break;
	}

	if (cnt < result) result = cnt;
	if(patternNum == 0) solve(x, y, 1);
}

int main()
{
	cin >> row >> col;

	for (int i = 0; i < row; i++) cin >> board[i];

	for (int i = 0; i <= row - 8; i++)
	{
		for (int j = 0; j <= col - 8; j++) solve(i, j, 0);
	}

	cout << result << '\n';
	return 0;
}