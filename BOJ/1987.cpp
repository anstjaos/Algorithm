#include <iostream>
using namespace std;

int row, col, result = 0;
char map[22][22];
int dirX[4] = { -1,0,1,0 }, dirY[4] = { 0,1,0,-1 };
bool alpha[26];

void dfs(int cnt, bool arr[26],int x, int y)
{
	if (cnt > result) result = cnt;

	bool temp[26];
	for (int i = 0; i < 26; i++) temp[i] = arr[i];

	for (int i = 0; i < 4; i++)
	{
		int nextX = x + dirX[i];
		int nextY = y + dirY[i];

		if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) continue;

		if (temp[map[nextX][nextY] - 'A'] == false)
		{
			temp[map[nextX][nextY] - 'A'] = true;
			dfs(cnt + 1, temp, nextX, nextY);
			temp[map[nextX][nextY] - 'A'] = false;
		}
	}
}

int main()
{
	cin >> row >> col;
	for (int i = 0; i < row; i++) cin >> map[i];
	alpha[map[0][0] - 'A'] = true;
	dfs(1, alpha, 0, 0);
	cout << result << '\n';
	return 0;
}